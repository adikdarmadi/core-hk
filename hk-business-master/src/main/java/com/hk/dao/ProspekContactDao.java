package com.hk.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hk.entities.ProspekContact;

@Repository("ProspekContactDao")
public interface ProspekContactDao extends PagingAndSortingRepository<ProspekContact, String> {

	@Query("select new map (m.id as id,m.pic as pic,m.divisi as divisi,m.department as department,m.telepon as telepon,"
			+ "m.hp as hp,m.fax as fax,m.email as email ,m.isActive as isActive, m.version as version, m.createBy as createBy, "
			+ "m.createDate as createDate) from ProspekContact m where m.prospekId = :prospekId ")
	List<Map<String,Object>> findByProspekId(@Param("prospekId") String prospekId);
	
	ProspekContact findById(String id);

}
