package com.hk.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hk.entities.UserMRU;

@Repository("UserMRUDao")
public interface UserMRUDao extends PagingAndSortingRepository<UserMRU, String> {

	@Query("select new map (m.id as id,m.tanggalAkses as tanggalAkses , n.id as moduleId, n.nama as moduleNama,n.state as state,"
			+ "o.id as userId, o.nama as userNama) from UserMRU m left join m.module n left join m.user o "
			+ "where m.userId =:userId order by m.tanggalAkses desc ")
	List<Map<String,Object>> findByUserId(@Param("userId") String userId, Pageable pageable);
}
