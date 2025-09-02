package com.odin.core_ref_data.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@JsonInclude(Include.NON_NULL)
public class ResponseDTO {
	
	private Integer statusCode;
    private String status;
    private String message;
    private Object data;
}
