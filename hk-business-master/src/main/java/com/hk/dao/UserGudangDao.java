package com.hk.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hk.entities.Gudang;
import com.hk.entities.UserGudang;

@Repository("UserGudangDao")
public interface UserGudangDao extends PagingAndSortingRepository<UserGudang, String> {

	@Query("select ug from UserGudang ug where ug.userId =:userId and ug.gudangId = :gudangId ")
	UserGudang findByUserIdGudangId(@Param("userId") String userId,@Param("gudangId") String gudangId);
	
	@Query("select g from UserGudang ug left join ug.gudang g where ug.userId =:userId and g.isActive = true ")
	List<Gudang> findGudangByUserId(@Param("userId") String userId);
}
