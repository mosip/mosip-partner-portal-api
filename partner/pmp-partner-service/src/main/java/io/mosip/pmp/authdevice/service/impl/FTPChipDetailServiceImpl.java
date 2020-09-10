package io.mosip.pmp.authdevice.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import io.mosip.kernel.core.util.EmptyCheckUtils;
import io.mosip.pmp.authdevice.constants.FoundationalTrustProviderErrorMessages;
import io.mosip.pmp.authdevice.dto.FTPChipDetailDto;
import io.mosip.pmp.authdevice.dto.FTPChipDetailStatusDto;
import io.mosip.pmp.authdevice.dto.FTPChipDetailUpdateDto;
import io.mosip.pmp.authdevice.dto.IdDto;
import io.mosip.pmp.authdevice.entity.FTPChipDetail;
import io.mosip.pmp.authdevice.entity.FoundationalTrustProvider;
import io.mosip.pmp.authdevice.exception.RequestException;
import io.mosip.pmp.authdevice.repository.FTPChipDetailRepository;
import io.mosip.pmp.authdevice.repository.FoundationalTrustProviderRepository;
import io.mosip.pmp.authdevice.service.FTPChipDetailService;
import io.mosip.pmp.authdevice.util.AuditUtil;
import io.mosip.pmp.authdevice.util.AuthDeviceConstant;
import io.mosip.pmp.partner.entity.Partner;
import io.mosip.pmp.partner.repository.PartnerServiceRepository;


@Component
@Transactional
public class FTPChipDetailServiceImpl implements FTPChipDetailService {
	
	@Autowired
	AuditUtil auditUtil;
	
	@Autowired
	FTPChipDetailRepository ftpChipDetailRepository;
	
	@Autowired
	FoundationalTrustProviderRepository foundationalTrustProviderRepository; 
	
	@Autowired
	PartnerServiceRepository partnerServiceRepository; 

	@Override
	public IdDto createFtpChipDetails(FTPChipDetailDto chipDetails) {
		Partner partnerFromDb = partnerServiceRepository.findByIdAndIsDeletedFalseorIsDeletedIsNullAndIsActiveTrue(chipDetails.getFtpProviderId());
		if(partnerFromDb == null) {
			auditUtil.auditRequest(
					String.format(
							AuthDeviceConstant.FAILURE_CREATE, FTPChipDetailDto.class.getCanonicalName()),
					AuthDeviceConstant.AUDIT_SYSTEM,
					String.format(AuthDeviceConstant.FAILURE_DESC,
							FoundationalTrustProviderErrorMessages.FTP_PROVIDER_NOT_EXISTS.getErrorCode(),
							FoundationalTrustProviderErrorMessages.FTP_PROVIDER_NOT_EXISTS.getErrorMessage()),
					"AUT-003");
			throw new RequestException(FoundationalTrustProviderErrorMessages.FTP_PROVIDER_NOT_EXISTS.getErrorCode(),
					FoundationalTrustProviderErrorMessages.FTP_PROVIDER_NOT_EXISTS.getErrorMessage());

		}
		FoundationalTrustProvider entity = new FoundationalTrustProvider();
		entity.setActive(true);
		Authentication authN = SecurityContextHolder.getContext().getAuthentication();
		if (!EmptyCheckUtils.isNullEmpty(authN)) {
			entity.setCrBy(authN.getName());
		}
		entity.setCrDtimes(LocalDateTime.now());
		entity.setId(partnerFromDb.getId());
		entity.setPartnerOrganizationName(partnerFromDb.getName());
		foundationalTrustProviderRepository.save(entity);
		
		FTPChipDetail chipDetail = new FTPChipDetail();
		chipDetail.setActive(false);
		chipDetail.setCrBy(authN.getName());
		chipDetail.setCrDtimes(LocalDateTime.now());
		chipDetail.setFoundationalTPId(chipDetails.getFtpProviderId());
		chipDetail.setId(chipDetails.getId());
		chipDetail.setMake(chipDetails.getMake());
		chipDetail.setModel(chipDetails.getModel());
		chipDetail.setPartnerOrganizationName(partnerFromDb.getName());
		ftpChipDetailRepository.save(chipDetail);
		IdDto response = new IdDto();
		response.setId(chipDetail.getId());
		return response;
	}

	@Override
	public IdDto updateFtpChipDetails(FTPChipDetailUpdateDto chipDetails) {
		Partner partnerFromDb = partnerServiceRepository.findByIdAndIsDeletedFalseorIsDeletedIsNullAndIsActiveTrue(chipDetails.getFtpProviderId());
		if(partnerFromDb == null) {
			auditUtil.auditRequest(
					String.format(
							AuthDeviceConstant.FAILURE_CREATE, FTPChipDetailUpdateDto.class.getCanonicalName()),
					AuthDeviceConstant.AUDIT_SYSTEM,
					String.format(AuthDeviceConstant.FAILURE_DESC,
							FoundationalTrustProviderErrorMessages.FTP_PROVIDER_NOT_EXISTS.getErrorCode(),
							FoundationalTrustProviderErrorMessages.FTP_PROVIDER_NOT_EXISTS.getErrorMessage()),
					"AUT-003");
			throw new RequestException(FoundationalTrustProviderErrorMessages.FTP_PROVIDER_NOT_EXISTS.getErrorCode(),
					FoundationalTrustProviderErrorMessages.FTP_PROVIDER_NOT_EXISTS.getErrorMessage());
		}
		Optional<FTPChipDetail> chipDetail = ftpChipDetailRepository.findById(chipDetails.getFtpChipDetailId());
		if(chipDetail.isEmpty()) {
			auditUtil.auditRequest(
					String.format(
							AuthDeviceConstant.FAILURE_CREATE, FTPChipDetailUpdateDto.class.getCanonicalName()),
					AuthDeviceConstant.AUDIT_SYSTEM,
					String.format(AuthDeviceConstant.FAILURE_DESC,
							FoundationalTrustProviderErrorMessages.FTP_CHIP_ID_NOT_EXISTS.getErrorCode(),
							FoundationalTrustProviderErrorMessages.FTP_CHIP_ID_NOT_EXISTS.getErrorMessage()),
					"AUT-003");
			throw new RequestException(FoundationalTrustProviderErrorMessages.FTP_CHIP_ID_NOT_EXISTS.getErrorCode(),
					FoundationalTrustProviderErrorMessages.FTP_CHIP_ID_NOT_EXISTS.getErrorMessage());			
		}
		FTPChipDetail uniqueChipDetail = ftpChipDetailRepository.findByUniqueKey(chipDetails.getFtpProviderId(),
				chipDetails.getMake(), chipDetails.getModel());
		if(uniqueChipDetail != null && !chipDetail.get().getId().equals(uniqueChipDetail.getId())){
			auditUtil.auditRequest(
					String.format(
							AuthDeviceConstant.FAILURE_CREATE, FTPChipDetailUpdateDto.class.getCanonicalName()),
					AuthDeviceConstant.AUDIT_SYSTEM,
					String.format(AuthDeviceConstant.FAILURE_DESC,
							FoundationalTrustProviderErrorMessages.FTP_PROVIDER_MAKE_MODEL_EXISTS.getErrorCode(),
							FoundationalTrustProviderErrorMessages.FTP_PROVIDER_MAKE_MODEL_EXISTS.getErrorMessage()),
					"AUT-003");
			throw new RequestException(FoundationalTrustProviderErrorMessages.FTP_PROVIDER_MAKE_MODEL_EXISTS.getErrorCode(),
					FoundationalTrustProviderErrorMessages.FTP_PROVIDER_MAKE_MODEL_EXISTS.getErrorMessage());		
			
		}
		FTPChipDetail updateObject = chipDetail.get();
		Authentication authN = SecurityContextHolder.getContext().getAuthentication();
		if (!EmptyCheckUtils.isNullEmpty(authN)) {
			updateObject.setUpdBy(authN.getName());
		}
		updateObject.setUpdDtimes(LocalDateTime.now());
		updateObject.setMake(chipDetails.getMake());
		updateObject.setModel(chipDetails.getModel());
		updateObject.setFoundationalTPId(chipDetails.getFtpProviderId());
		ftpChipDetailRepository.save(updateObject);
		IdDto response = new IdDto();
		response.setId(updateObject.getId());
		return response;
	}

	@Override
	public String updateFtpChipDetailStatus(FTPChipDetailStatusDto chipDetails) {
		Optional<FTPChipDetail> chipDetail = ftpChipDetailRepository.findById(chipDetails.getFtpChipDetailId());
		if(chipDetail.isEmpty()) {
			auditUtil.auditRequest(
					String.format(
							AuthDeviceConstant.FAILURE_CREATE, FTPChipDetailStatusDto.class.getCanonicalName()),
					AuthDeviceConstant.AUDIT_SYSTEM,
					String.format(AuthDeviceConstant.FAILURE_DESC,
							FoundationalTrustProviderErrorMessages.FTP_CHIP_ID_NOT_EXISTS.getErrorCode(),
							FoundationalTrustProviderErrorMessages.FTP_CHIP_ID_NOT_EXISTS.getErrorMessage()),
					"AUT-003");
			throw new RequestException(FoundationalTrustProviderErrorMessages.FTP_CHIP_ID_NOT_EXISTS.getErrorCode(),
					FoundationalTrustProviderErrorMessages.FTP_CHIP_ID_NOT_EXISTS.getErrorMessage());
		}
		FTPChipDetail updateObject = chipDetail.get();
		Authentication authN = SecurityContextHolder.getContext().getAuthentication();
		if (!EmptyCheckUtils.isNullEmpty(authN)) {
			updateObject.setUpdBy(authN.getName());
		}
		updateObject.setUpdDtimes(LocalDateTime.now());
		updateObject.setActive(chipDetails.getApprovalStatus());
		ftpChipDetailRepository.save(updateObject);
		return "Status updated successfully.";
	}
	
}
