package com.odin.core_ref_data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.odin.core_ref_data.constants.LanguageConstants;
import com.odin.core_ref_data.constants.ResponseCodes;
import com.odin.core_ref_data.dto.ResponseDTO;
import com.odin.core_ref_data.entity.CoreFormMetadata;
import com.odin.core_ref_data.repo.CoreFormMetadataRepository;
import com.odin.core_ref_data.service.FormService;
import com.odin.core_ref_data.utility.GenericSpecification;
import com.odin.core_ref_data.utility.ResponseObject;
import com.odin.core_ref_data.utility.SearchCriteria;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerFormServiceImpl implements FormService {
	
	@Autowired
	private CoreFormMetadataRepository formRepo;
	
	@Autowired
	private ResponseObject responseObj;
	
	@Override
	public ResponseDTO searchFormMetadata(List<SearchCriteria> searchCriteriaList) {
		searchCriteriaList.add(new SearchCriteria("isActive", ":", 1, "AND"));
		Specification<CoreFormMetadata> resultSpecification = null;

	    for (SearchCriteria criteria : searchCriteriaList) {
	    	log.info(
	    			"Processing criteria: key=" + criteria.getKey() + ", operation={}," + criteria.getOperation()
	    					+ " value=" + criteria.getValue() + ", condition=" + criteria.getCondition());

	        // Ensure criteria are processed even if value is empty, since the condition (OR) is important
	        GenericSpecification<CoreFormMetadata> spec = new GenericSpecification<>(criteria);

	        if (resultSpecification == null) {
	            resultSpecification = spec;
	        } else {
	            // Apply condition (AND/OR) between criteria
	            if ("OR".equalsIgnoreCase(criteria.getCondition())) {
	                resultSpecification = Specification.where(resultSpecification).or(spec);
	            } else {
	                resultSpecification = Specification.where(resultSpecification).and(spec); // Default to AND
	            }
	        }
	    }

	    if (resultSpecification == null) {
	        throw new IllegalArgumentException("No valid search criteria provided.");
	    }

	    // Execute the query using the OR logic for mobile and email
	    List<CoreFormMetadata> form = formRepo.findAll(resultSpecification);
	    if (form.isEmpty()) {
	        return responseObj.buildResponse(LanguageConstants.EN, ResponseCodes.NO_DATA_FOUND);
	    }
	    return responseObj.buildResponse(LanguageConstants.EN, ResponseCodes.SUCCESS_CODE, form);
	}

}
