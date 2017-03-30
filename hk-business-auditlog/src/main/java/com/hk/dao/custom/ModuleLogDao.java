package com.hk.dao.custom;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hk.entities.Module;


/**
 * 
 * 
 * @author Adhityarismawan
 */
@Repository("ModuleLogDao")
public interface ModuleLogDao extends PagingAndSortingRepository<Module, String> {

	@Query("select m from Module m where m.pathMap = :pathMap ")
	Module findByPathMap(@Param("pathMap") String pathMap);

}
