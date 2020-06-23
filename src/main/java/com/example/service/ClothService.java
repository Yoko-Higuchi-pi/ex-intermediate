package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Cloth;
import com.example.repository.ClothRepository;

/**
 * 衣類検索の業務処理を行うサービスクラス.
 * 
 * @author yoko.higuchi
 *
 */
@Service
@Transactional
public class ClothService {
	@Autowired
	private ClothRepository repository;
	
	/**
	 * 衣類検索を行う.
	 * 
	 * @param gender 性別(0 or 1)
	 * @param color 色
	 * @return 衣類情報
	 */
	public List<Cloth> searchByColorAndGender(Integer gender, String color) {
		return repository.searchByColorAndGender(gender, color);
	}

}
