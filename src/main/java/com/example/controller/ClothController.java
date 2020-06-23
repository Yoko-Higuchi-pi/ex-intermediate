package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Cloth;
import com.example.service.ClothService;

/**
 * 衣類関係の処理を行うコントローラクラス.
 * 
 * @author yoko.higuchi
 *
 */
@Controller
@RequestMapping("/ex03")
public class ClothController {
	@Autowired
	private ClothService service;
	
	/**
	 * 検索画面を表示する.
	 * 
	 * @return 検索画面
	 */
	@RequestMapping("")
	public String index(Model model) {
		
		return "ex03/cloth-search";
	}
	
	/**
	 * 検索結果と検索画面を表示する.
	 * 
	 * @param gender 性別(0 or 1)
	 * @param color 色情報(英語)
	 * @param model リクエストスコープ
	 * @return
	 */
	@RequestMapping("/search")
	public String search(String gender, String color, Model model) {
		// 色情報変更 (文字化け防止)
		String colorInfo = "";
		switch (color) {
		case "red":
			colorInfo = "赤";
			break;
		case "blue":
			colorInfo = "青";
			break;
		case "white":
			colorInfo = "白";
			break;
		case "yellow":
			colorInfo = "緑";
			break;

		default:
			break;
		}
		
		Integer genderInt = Integer.parseInt(gender);
		
		List<Cloth> clothList = service.searchByColorAndGender(genderInt, colorInfo);
		model.addAttribute(clothList);
		model.addAttribute("gender", genderInt);
		model.addAttribute("color", color);
		
		return "ex03/cloth-search";
	}
}
