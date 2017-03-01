package com.hk.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hk.entities.KasBank;
import com.hk.entities.UserKasBank;

@Repository("UserKasBankDao")
public interface UserKasBankDao extends PagingAndSortingRepository<UserKasBank, String> {

	@Query("select uk from UserKasBank uk where uk.userId =:userId and uk.kasBankId = :kasBankId ")
	UserKasBank findByUserIdKasBankId(@Param("userId") String userId,@Param("kasBankId") String kasBankId);
	
	@Query("select g from UserKasBank uk left join uk.kasBank g where uk.userId =:userId and g.isActive = true ")
	List<KasBank> findKasBankByUserId(@Param("userId") String userId);
}
