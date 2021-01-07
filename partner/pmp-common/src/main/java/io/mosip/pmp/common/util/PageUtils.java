package io.mosip.pmp.common.util;

import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import io.mosip.pmp.common.constant.SearchErrorCode;
import io.mosip.pmp.common.dto.PageResponseDto;
import io.mosip.pmp.common.dto.Pagination;
import io.mosip.pmp.common.dto.SearchSort;
import io.mosip.pmp.common.entity.BaseEntity;
import io.mosip.pmp.common.exception.RequestException;


/**
 * Utility class to calculate the page details* 
 * 
 *
 */
@Component
public class PageUtils {

	private SortUtils sortUtils;

	public PageUtils() {
		sortUtils = new SortUtils();
	}

	/**
	 * Method to create page metadata
	 * 
	 * @param <D>
	 * 
	 * @param page request to be
	 * @return {@link PageResponseDto}
	 */
	public static <T, D> PageResponseDto<D> pageResponse(Page<T> page) {
		PageResponseDto<D> pageResponse = new PageResponseDto<>();
		if (page != null) {
			long totalItem = page.getTotalElements();
			int pageSize = page.getSize();
			int start = (page.getNumber() * pageSize) + 1;
			pageResponse.setFromRecord(start);
			pageResponse.setToRecord((long) (start - 1) + page.getNumberOfElements());
			pageResponse.setTotalRecord(totalItem);
		}
		return pageResponse;
	}

	public <T extends BaseEntity> void validateSortField(Class<T> clazz, List<SearchSort> searchSorts) {
		sortUtils.validateSortField(clazz, searchSorts);
	}

	public <T extends BaseEntity, E> void validateSortField(Class<E> class1, Class<T> class2, List<SearchSort> list) {
		sortUtils.validateSortField(class1, class2, list);
	}

	public <D> PageResponseDto<D> sortPage(List<D> content, List<SearchSort> sort, Pagination page,long totalNumberOfRecords) {
		PageResponseDto<D> pageResponse = new PageResponseDto<>();
		page.setPageFetch(page.getPageFetch());
		List<D> sortedList = sortUtils.sort(content, sort);
		List<D> pageList = Collections.emptyList();
		if (validate(page)) {
			pageList = getPage(sortedList, page);
		}
		if (!pageList.isEmpty()) {
			pageResponse = pageResponse(
					new PageImpl<>(pageList, PageRequest.of(page.getPageStart(), page.getPageFetch()), content.size()));
			pageResponse.setData(pageList);
		}
		return pageResponse;
	}

	public <D> PageResponseDto<D> applyPagination(List<D> list, Pagination page) {
		return sortPage(list, Collections.emptyList(), page,list.size());
	}

	private boolean validate(Pagination page) {
		if (page != null) {
			if (page.getPageStart() < 0 || page.getPageFetch() < 1) {
				throw new RequestException(SearchErrorCode.INVALID_PAGINATION_VALUE.getErrorCode(),
						String.format(SearchErrorCode.INVALID_PAGINATION_VALUE.getErrorMessage(),
								page.getPageStart(), page.getPageFetch()));
			} else {
				return true;
			}
		} else {
			throw new RequestException(SearchErrorCode.INVALID_PAGINATION.getErrorCode(),
					SearchErrorCode.INVALID_PAGINATION.getErrorMessage());
		}
	}

	public <T> List<T> getPage(List<T> list, Pagination page) {
		int fromIndex = (page.getPageStart()) * page.getPageFetch();
		if (list == null || list.size() < fromIndex) {
			return Collections.emptyList();
		}
		int endIndex = Math.min(fromIndex + page.getPageFetch(), list.size());
		return list.subList(fromIndex, endIndex);
	}

}
