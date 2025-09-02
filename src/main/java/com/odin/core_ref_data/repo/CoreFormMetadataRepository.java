package com.odin.core_ref_data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.odin.core_ref_data.entity.CoreFormMetadata;

public interface CoreFormMetadataRepository extends JpaRepository<CoreFormMetadata, Integer>, JpaSpecificationExecutor<CoreFormMetadata>{

}
