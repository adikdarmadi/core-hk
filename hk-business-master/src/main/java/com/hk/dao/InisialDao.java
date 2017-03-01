package com.hk.dao;


import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hk.entities.Inisial;

@Repository("InisialDao")
public interface InisialDao extends PagingAndSortingRepository<Inisial, String> {

	List<Inisial> findAll();

}
