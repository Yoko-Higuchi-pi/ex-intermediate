package com.example.domain;

/**
 * 服のデータを格納するドメインクラス.
 * 
 * @author yoko.higuchi
 *
 */
public class Cloth {
	/** id(主キー) */
	private Integer id;
	/** 服のカテゴリ(洋服等) */
	private String category;
	/** ジャンル(Tシャツ等) */
	private String genre;
	/** 性別(1:女性 or 0:男性) */
	private String gender;
	/** 色 */
	private String color;
	/** 値段 */
	private Integer price;
	/** 服のサイズ */
	private String size;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "Cloth [id=" + id + ", category=" + category + ", genre=" + genre + ", gender=" + gender + ", color="
				+ color + ", price=" + price + ", size=" + size + "]";
	}
	
}

