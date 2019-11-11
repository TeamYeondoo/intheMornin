package com.inthemornin.ootd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inthemornin.ootd.repository.IRepository;

@Service
public class ClothService implements IService {

	@Autowired
	IRepository clothRepository;
	
	@Override
	public int getClothCount() {
		return clothRepository.getClothCount();
	}

	@Override
	public int getClothCount(int deptid) {
		return clothRepository.getClothCount(deptid);
	}
	
}
