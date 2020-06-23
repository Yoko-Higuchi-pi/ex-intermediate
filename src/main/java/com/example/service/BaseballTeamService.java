package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.BaseballTeam;
import com.example.repository.BaseballTeamRepository;

/**
 * 野球チームのデータを取り扱うサービスクラス.
 * 
 * @author yoko.higuchi
 *
 */
@Service
@Transactional
public class BaseballTeamService {
	@Autowired
	private BaseballTeamRepository repository;
	
	/**
	 * 全チームのデータ取得.
	 * 
	 * @return 全チームの情報
	 */
	public List<BaseballTeam> showList() {
		return repository.showList();
	}
	
	/**
	 * 1チーム分のデータを取得.
	 * 
	 * @param id 検索id(主キー)
	 * @return チーム情報
	 */
	public BaseballTeam showDetail(Integer id) {
		return repository.load(id);
	}
}
