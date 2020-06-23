package com.example.controller;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.HotelSearch;
import com.example.service.HotelSearchService;

/**
 * ホテル検索を行うコントローラクラス.
 * 
 * @author yoko.higuchi
 *
 */
@Controller
@RequestMapping("/ex02")
public class HotelSearchController {
	@Autowired
	private HotelSearchService service;
	
	/**
	 * ホテル検索画面を表示する.
	 * 
	 * @return ホテル検索画面
	 */
	@RequestMapping("")
	public String index() {
		return "ex02/hotel-search";
	}
	
	/**
	 * ホテル検索を行う.
	 * 
	 * @param price 上限の値段
	 * @param model リクエストスコープ
	 * @return ホテル一覧付き画面
	 */
	@RequestMapping("/search")
	public String search(String price, Model model) {
		Integer priceInt;
		// 数値の場合：数値に変換、数値以外：null
		if (Pattern.matches("^([0-9]+)$", price)) {
			priceInt = Integer.parseInt(price);
		} else {
			priceInt = null;
		}
		
		List<HotelSearch> hotelList = service.searchByLessThanPrice(priceInt);
		model.addAttribute("hotelList", hotelList);
		
		return "ex02/hotel-search";
	}
	
}
