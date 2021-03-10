package com.etnetera.hr.repository;

import com.etnetera.hr.data.FrameworkVersion;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FrameworkVersionRepository extends PagingAndSortingRepository<FrameworkVersion,Long> {

    List<FrameworkVersion> findByVersion(@Param("version") String version);

}
