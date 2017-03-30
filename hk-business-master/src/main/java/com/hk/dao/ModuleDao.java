package com.hk.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hk.entities.Module;

@Repository("ModuleDao")
public interface ModuleDao extends PagingAndSortingRepository<Module, String> {

	@Query("select new map (m.id as id,m.nama as nama,m.state as state,m.icon as icon,m.status as status,m.urutan as urutan,m.pathMap as pathMap, "
			+ "n.id as moduleParentId,n.nama as moduleParentNama, m.isActive as isActive, m.version as version, m.createBy as createBy, "
			+ "m.createDate as createDate) "
			+ "from Module m left join m.moduleParent n ")
	List<Map<String,Object>> findAllModule();
	
	Module findById(String id);
	
	Module findByState(String state);

	@Query("select x from Module x where x.status = '0' and x.moduleParentId is null and x.isActive =true order by x.urutan asc")
	List<Module> parentNode();

	@Query("select x from Module x where x.moduleParentId =:moduleParentId and x.isActive =true order by x.urutan asc ")
	List<Module> childNode(@Param("moduleParentId") String moduleParentId);
	
	@Query("select x from Module x where x.status = '0' and x.isActive =true order by x.urutan asc")
	List<Module> findParent();
	
	@Query("select m from Module m where m.pathMap = :pathMap ")
	Module findByPathMap(@Param("pathMap") String pathMap);
}
