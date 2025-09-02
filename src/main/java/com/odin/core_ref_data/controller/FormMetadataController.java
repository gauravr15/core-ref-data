package com.odin.core_ref_data.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odin.core_ref_data.constants.APIConstants;
import com.odin.core_ref_data.constants.ApplicationConstants;
import com.odin.core_ref_data.dto.ResponseDTO;
import com.odin.core_ref_data.factory.FormFactory;
import com.odin.core_ref_data.utility.SearchCriteria;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = APIConstants.API_VERSION)
public class FormMetadataController {
	
	@Autowired
	private FormFactory formFactory;
	
	@PostMapping(APIConstants.CUSTOMER + APIConstants.FORM)
    public ResponseEntity<ResponseDTO> searchProfiles(@RequestBody List<SearchCriteria> searchCriteriaList) { 
		ResponseDTO response = formFactory.getInstance(ApplicationConstants.CUSTOMER).searchFormMetadata(searchCriteriaList);
		log.info(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
