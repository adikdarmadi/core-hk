package com.hk.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hk.entities.Sales;

@Repository("SalesDao")
public interface SalesDao extends PagingAndSortingRepository<Sales, String> {

	@Query("select new map (m.id as id,m.nama as nama,m.grupId as grupId,n.id as userId,n.nama as userNama,s.id as salesParentId,"
			+ "s.nama as salesParentNama, m.isActive as isActive, "
			+ "m.version as version, m.createBy as createBy, m.createDate as createDate) "
			+ "from Sales m left join m.user n left join m.salesParent s ")
	List<Map<String,Object>> findAllSales();
	
	Sales findById(String id);

}
