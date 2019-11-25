package with_god.model.vo;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class User implements Serializable{
	//회원 아이디
	private String id;
	//회원 비밀번호
	private String pw = "";
	//회원 이름
	private String name;
	//회원 닉네임
	private String nickName;
	//회원 이메일
	private String email;
	//회원 장래희망
	private String dream;
	//회원의 보유 코인
	private int coin = 1000;
	//회원의 경기 전적
	private int playcount;
	//회원의 승리 횟수
	private int win = 0;
	//회원의 패배 횟수
	private int lose = 0;
	//회원의 랭킹
	private int rank = 0;
	//강림 아이템 보유 갯수
	private int itemCountK = 0;
	//해원맥 아이템 보유 갯수
	private int itemCountH = 0;
	//덕춘 아이템 보유 갯수
	private int itemCountD = 0;
	
	private int score = 0;
	
	private String ImageLoad = "images/프로필.jpg";

	
	public User() {}
	public User(String name, String id, String pw, String nickName, String email) {
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.nickName = nickName;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDream() {
		return dream;
	}
	public void setDream(String dream) {
		this.dream = dream;
	}
	public int getCoin() {
		return coin;
	}
	public void setCoin(int coin) {
		this.coin = coin;
	}
	public int getPlaycount() {
		return playcount;
	}
	public void setPlaycount(int playcount) {
		this.playcount = playcount;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getLose() {
		return lose;
	}
	public void setLose(int lose) {
		this.lose = lose;
	}
	public String getImageLoad() {
		return ImageLoad;
	}
	public void setImageLoad(String ImageLoad) {
		this.ImageLoad = ImageLoad;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getItemCountK() {
		return itemCountK;
	}
	public void setItemCountK(int itemCountK) {
		this.itemCountK = itemCountK;
	}
	public int getItemCountH() {
		return itemCountH;
	}
	public void setItemCountH(int itemCountH) {
		this.itemCountH = itemCountH;
	}
	public int getItemCountD() {
		return itemCountD;
	}
	public void setItemCountD(int itemCountD) {
		this.itemCountD = itemCountD;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "아이디 /" + id + "패스워드 /" + pw + "name / " + name + "nickName / " + nickName + "email / " + email + "dream /" + dream + 
				"coin" + coin + "playcount" + playcount + "win" + win + "lose" + lose + "rank" + rank + "itemCountK" + itemCountK +
				"itemCointH" + itemCountH + "itemCointD" + itemCountD;
	}
	public void setPw(char[] password) {
		// TODO Auto-generated method stub
		
	}
}














