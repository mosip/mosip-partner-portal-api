package io.mosip.pmp.authdevice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.mosip.kernel.core.http.ResponseFilter;
import io.mosip.pmp.authdevice.dto.DeviceDetailDto;
import io.mosip.pmp.authdevice.dto.IdDto;
import io.mosip.pmp.authdevice.dto.SecureBiometricInterfaceCreateDto;
import io.mosip.pmp.authdevice.dto.SecureBiometricInterfaceUpdateDto;
import io.mosip.pmp.authdevice.service.SecureBiometricInterfaceService;
import io.mosip.pmp.authdevice.util.AuditUtil;
import io.mosip.pmp.authdevice.util.AuthDeviceConstant;
import io.mosip.pmp.partner.core.RequestWrapper;
import io.mosip.pmp.partner.core.ResponseWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/securebiometricinterface")
@Api(tags = { "SecureBiometricInterface" })
public class SecureBiometricInterfaceController {
	@Autowired
	SecureBiometricInterfaceService secureBiometricInterface;
	@Autowired
	AuditUtil auditUtil;
	@PreAuthorize("hasRole('ZONAL_ADMIN')")
	@ResponseFilter
	@PostMapping
	@ApiOperation(value = "Service to save SecureBiometricInterfaceCreateDto", notes = "Saves SecureBiometricInterfaceCreateDto and return DeviceDetail id")
	@ApiResponses({ @ApiResponse(code = 201, message = "When SecureBiometricInterfaceCreateDto successfully created"),
			@ApiResponse(code = 400, message = "When Request body passed  is null or invalid"),
			@ApiResponse(code = 500, message = "While creating SecureBiometricInterfaceCreateDto any error occured") })
	public ResponseWrapper<IdDto> SecureBiometricInterface(
			@Valid @RequestBody RequestWrapper<SecureBiometricInterfaceCreateDto> secureBiometricInterfaceCreateDto) {
		auditUtil.auditRequest(
				AuthDeviceConstant.CREATE_API_IS_CALLED + SecureBiometricInterfaceCreateDto.class.getCanonicalName(),
				AuthDeviceConstant.AUDIT_SYSTEM,
				AuthDeviceConstant.CREATE_API_IS_CALLED + SecureBiometricInterfaceCreateDto.class.getCanonicalName(),
				"AUT-011");
		ResponseWrapper<IdDto> responseWrapper = new ResponseWrapper<>();
		responseWrapper
				.setResponse(secureBiometricInterface.createSecureBiometricInterface(secureBiometricInterfaceCreateDto.getRequest()));
		auditUtil.auditRequest(
				String.format(AuthDeviceConstant.SUCCESSFUL_CREATE , SecureBiometricInterfaceCreateDto.class.getCanonicalName()),
				AuthDeviceConstant.AUDIT_SYSTEM,
				String.format(AuthDeviceConstant.SUCCESSFUL_CREATE , SecureBiometricInterfaceCreateDto.class.getCanonicalName()),
				"AUT-012");
		return responseWrapper;

	}
	
	@PreAuthorize("hasRole('ZONAL_ADMIN')")
	@ResponseFilter
	@PutMapping
	@ApiOperation(value = "Service to update SecureBiometricInterface", notes = "Updates SecureBiometricInterface and returns success message")
	@ApiResponses({ @ApiResponse(code = 201, message = "When SecureBiometricInterface successfully updated"),
			@ApiResponse(code = 400, message = "When Request body passed  is null or invalid"),
			@ApiResponse(code = 500, message = "While updating SecureBiometricInterface any error occured") })
	public ResponseWrapper<IdDto> updateSecureBiometricInterface(
			@Valid @RequestBody RequestWrapper<SecureBiometricInterfaceUpdateDto> secureBiometricInterfaceUpdateDto) {
		auditUtil.auditRequest(
				AuthDeviceConstant.UPDATE_API_IS_CALLED + SecureBiometricInterfaceUpdateDto.class.getCanonicalName(),
				AuthDeviceConstant.AUDIT_SYSTEM,
				AuthDeviceConstant.UPDATE_API_IS_CALLED + SecureBiometricInterfaceUpdateDto.class.getCanonicalName(),
				"AUT-013");
		ResponseWrapper<IdDto> responseWrapper = new ResponseWrapper<>();
		responseWrapper
				.setResponse(secureBiometricInterface.updateSecureBiometricInterface(secureBiometricInterfaceUpdateDto.getRequest()));
		auditUtil.auditRequest(
				String.format(AuthDeviceConstant.SUCCESSFUL_UPDATE , SecureBiometricInterfaceUpdateDto.class.getCanonicalName()),
				AuthDeviceConstant.AUDIT_SYSTEM,
				String.format(AuthDeviceConstant.SUCCESSFUL_UPDATE , SecureBiometricInterfaceUpdateDto.class.getCanonicalName()),
				"AUT-012");
		return responseWrapper;

	}
}
