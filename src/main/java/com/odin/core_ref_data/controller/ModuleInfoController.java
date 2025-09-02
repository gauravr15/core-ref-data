package com.odin.core_ref_data.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odin.core_ref_data.constants.APIConstants;




@RestController
@RequestMapping(value = APIConstants.API_VERSION)
public class ModuleInfoController {
	
//	@Autowired
//	ResponseObject response;
//	
//	@Autowired
//	private ModuleDataInfo moduleInfo;
//	
//	@PostMapping(ApplicationConstants.FETCH + ApplicationConstants.MODULES)
//    public ResponseEntity<ResponseDTO> searchProfiles(@RequestBody List<SearchCriteria> searchCriteriaList) {
//		ResponseDTO response = moduleInfo.fetchModuleDropDown(searchCriteriaList);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
}

