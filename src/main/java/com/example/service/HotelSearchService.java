package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.HotelSearch;
import com.example.repository.HotelSearchRepository;

/**
 * ホテル検索の業務処理を行うサービスクラス.
 * 
 * @author yoko.higuchi
 *
 */
@Service
@Transactional
public class HotelSearchService {
	@Autowired
	private HotelSearchRepository repository;
	
	/**
	 * ホテルの検索を行う.
	 * 
	 * @param price
	 * @return
	 */
	public List<HotelSearch> searchByLessThanPrice(Integer price) {
		// 何も入力されていない場合は全探索
		if (price == null) {
			return repository.searchAll();
		}
		return repository.searchByLessThanPrice(price);
	}
}
