package com.odin.core_ref_data.service;

import java.util.List;

import com.odin.core_ref_data.dto.ResponseDTO;
import com.odin.core_ref_data.utility.SearchCriteria;

public interface ModuleDataInfo {

	ResponseDTO fetchModuleDropDown(List<SearchCriteria> searchCriteriaList);
}
