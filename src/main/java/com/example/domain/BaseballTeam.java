package com.example.domain;

/**
 * チームの詳細を格納するドメインクラス.
 * 
 * @author yoko.higuchi
 *
 */
public class BaseballTeam {
	/** 主キー */
	private Integer id;
	/** リーグ名(セリーグ or パリーグ) */
	private String leagueName;
	/** チーム名 */
	private String teamName;
	/** ホーム球場 */
	private String headquarters;
	/** 結成日 */
	private String inauguration;
	/** 歴史 */
	private String history;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLeagueName() {
		return leagueName;
	}
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getHeadquarters() {
		return headquarters;
	}
	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}
	public String getInauguration() {
		return inauguration;
	}
	public void setInauguration(String inauguration) {
		this.inauguration = inauguration;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	@Override
	public String toString() {
		return "BaseballTeam [id=" + id + ", leagueName=" + leagueName + ", teamName=" + teamName + ", headquarters="
				+ headquarters + ", inauguration=" + inauguration + ", history=" + history + "]";
	}
	
}
