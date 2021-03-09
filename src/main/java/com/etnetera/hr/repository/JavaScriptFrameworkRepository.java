package com.etnetera.hr.repository;

import com.etnetera.hr.data.JavaScriptFramework;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Spring data repository interface used for accessing the data in database.
 * 
 * @author Etnetera
 *
 */


public interface JavaScriptFrameworkRepository extends PagingAndSortingRepository<JavaScriptFramework, Long> {

    List<JavaScriptFramework> findByName(@Param("name") String name);

}
