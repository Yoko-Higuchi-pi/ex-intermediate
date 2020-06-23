package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.BaseballTeam;

/**
 * 野球チームのデータを扱うリポジトリ.
 * 
 * @author yoko.higuchi
 *
 */
@Repository
public class BaseballTeamRepository {
	// ROW_MAPPER
	private static final RowMapper<BaseballTeam> BASEBALL_ROW_MAPPER = (rs, i) -> {
		BaseballTeam baseballTeam = new BaseballTeam();
		baseballTeam.setId(rs.getInt("id"));
		baseballTeam.setInauguration(rs.getString("inauguration"));
		baseballTeam.setLeagueName(rs.getString("league_name"));
		baseballTeam.setTeamName(rs.getString("team_name"));
		baseballTeam.setHeadquarters(rs.getString("headquarters"));
		baseballTeam.setHistory(rs.getString("history"));
		
		return baseballTeam;
	};
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	
	/**
	 * チーム一覧を取得する.
	 * 
	 * @return チーム一覧の情報
	 */
	public List<BaseballTeam> showList() {
		String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history FROM teams;";
		//SqlParameterSource param = new MapSqlParameterSource();
		List<BaseballTeam> teamList = template.query(sql, BASEBALL_ROW_MAPPER);
		return teamList;
	}
	
	/**
	 * 1チーム分のチームの情報を取得する.
	 * 
	 * @param id 検索するid(主キー)
	 * @return チーム情報
	 * @throws Exception
	 */
	public BaseballTeam load(Integer id) {
		String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history FROM teams WHERE id=:id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		BaseballTeam team = template.queryForObject(sql, param, BASEBALL_ROW_MAPPER);
//		if (team == null) {
//			throw new IllegalArgumentException("値なし");
//		}
		return team;
		
	}
	
}
