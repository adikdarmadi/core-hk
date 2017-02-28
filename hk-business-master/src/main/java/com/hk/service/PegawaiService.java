package com.hk.service;

import java.util.Map;

import com.hk.vo.PegawaiVO;

/**
 * Pegawai Service
 * 
 * @author Adhityarismawan
 */
public interface PegawaiService {

	Map<String, Object> findAllPegawai();

	Map<String, Object> savePegawai(PegawaiVO p);

	Map<String, Object> findById(String id);

	Map<String, Object> deletePegawai(String id);

	Map<String, Object> editPegawai(PegawaiVO p, Integer version);

	Map<String, Object> isActivePegawai(String id, Integer version);

}
