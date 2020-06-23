package com.example.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.domain.BaseballTeam;
import com.example.service.BaseballTeamService;

/**
 * 野球チームのデータ処理を行うコントローラ.
 * 
 * @author yoko.higuchi
 *
 */
@Controller
@RequestMapping("/ex01")
public class BaseballTeamController {
	@Autowired
	private BaseballTeamService service;
	
	/**
	 * チーム一覧を表示する.
	 * 
	 * @param model リクエストスコープ
	 * @return チーム一覧画面
	 */
	@RequestMapping("")
	public String index(Model model) {
		List<BaseballTeam> teamList = service.showList();
		// application.setAttribute("teamList", teamList);
		model.addAttribute("teamList", teamList);
		
		return "ex01/teamlist";
	}
	
	/**
	 * １チーム分のデータ情報を表示する.
	 * 
	 * @param id 検索id(主キー)
	 * @param model リクエストスコープ
	 * @return チーム詳細ページ
	 */
	@RequestMapping("/showDetail")
	public String showDetail(@RequestParam String id, Model model) {
		BaseballTeam team = service.showDetail(Integer.parseInt(id));
		model.addAttribute("team", team);
		
		return "ex01/team-detail";
	}
}
