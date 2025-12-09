package com.odin.core_ref_data.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "core_form_metadata")
@NoArgsConstructor
@AllArgsConstructor
public class CoreFormMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "module")
    private String module;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "placeholder")
    private String placeholder;

    @Column(name = "field_name")
    private String fieldName;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "admin_editable")
    private Boolean adminEditable;

    @Column(name = "user_editable")
    private Boolean userEditable;

    @Column(name = "creation_timestamp", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp creationTimestamp;

    @Column(name = "update_timestamp", nullable = false, columnDefinition = "TIMESTAMP DEFAULT '0000-00-00 00:00:00'")
    private Timestamp updateTimestamp;

    @Column(name = "data_type")
    private String dataType;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "submodule")
    private String submodule;

    @Column(name = "sequence")
    private Long sequence;
    
    @Column(name = "is_display")
    private Boolean isDisplay;
    
    @Column(name = "is_dropdown")
    private Boolean isDropdown;
    
    @Column(name = "regex")
    private String regex;
    
    @Column(name = "input_type")
    private String inputType;
    
    @Column(name = "resource")
    private String resource;
}
