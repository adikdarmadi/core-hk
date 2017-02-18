package com.hk.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hk.entities.Produk;

@Repository("ProdukDao")
public interface ProdukDao extends PagingAndSortingRepository<Produk, Integer> {

	@Query("select new map (p.id as id,p.namaProduk as namaProduk,d.detailJenisProduk as detailJenisProduk,j.jenisProduk as jenisProduk) from Produk p left join p.detailJenisProduk d left join d.jenisProduk j ")
	List<Map<String,Object>> findAllProduk();

	Produk findById(Integer id);


}
