package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.HotelSearch;

/**
 * ホテル検索を行うリポジトリクラス.
 * 
 * @author yoko.higuchi
 *
 */
@Repository
public class HotelSearchRepository {
	/** ROW_MAPPERの簡単バージョン */
	private static final RowMapper<HotelSearch> HOTEL_ROW_MAPPER = new BeanPropertyRowMapper<>(HotelSearch.class);
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * ある値段以下のホテルの検索を行う.
	 * 
	 * @param price 値段
	 * @return ホテルリスト
	 */
	public List<HotelSearch> searchByLessThanPrice(Integer price) {
		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking from hotels WHERE price <= :price ORDER BY price DESC;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		
		return template.query(sql, param, HOTEL_ROW_MAPPER);
	}
	
	/**
	 * ホテル一覧を検索する.
	 * 
	 * @return 全ホテルのリスト
	 */
	public List<HotelSearch> searchAll() {
		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking from hotels ORDER BY price DESC;";
		
		return template.query(sql, HOTEL_ROW_MAPPER);
	}
}
