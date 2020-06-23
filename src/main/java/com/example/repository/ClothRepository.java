package com.example.repository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Cloth;

/**
 * 服のデータを取得するリポジトリクラス.
 * 
 * @author yoko.higuchi
 *
 */
@Repository
public class ClothRepository {
	/** ROW_MAPPER の簡易バージョン */
	private static final RowMapper<Cloth> CLOTH_ROW_MAPPER = new BeanPropertyRowMapper<>(Cloth.class);
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * 衣類の検索を行う.
	 * 
	 * @param gender 性別(0 or 1)
	 * @param color 色
	 * @return 検索してヒットした衣類情報
	 */
	public List<Cloth> searchByColorAndGender(Integer gender, String color) {
		String sql = "SELECT id, category, genre, gender, color, price, size FROM clothes WHERE gender = :gender AND color=:color ORDER BY price DESC;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("color", color).addValue("gender", gender);
		
		try {
			List<Cloth> clothList = template.query(sql, param, CLOTH_ROW_MAPPER);
			return clothList;
		} catch (Exception e) {
			return null;
		}
	}
	
}
