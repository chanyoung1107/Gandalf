package with_god.model.vo;

import java.util.HashMap;
import java.util.Map;

public class YH_Quiz {

	private String key;
	private String key2;
	private String value;
	private String value2;
	private char ch;
	private int num;
	public Map<String, String> keyAndValue = new HashMap<>();

	public YH_Quiz() {}

	public YH_Quiz(String key, String key2, String value, String value2, char ch, int num) {
		super();
		this.key = key;
		this.key2 = key2;
		this.value = value;
		this.value2 = value2;
		this.ch = ch;
		
	}

	public String getKey() {
		return key;
	}

	public String getKey2() {
		return key2;
	}

	public String getValue() {
		return value;
	}

	public char getCh() {
		return ch;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setKey2(String key2) {
		this.key2 = key2;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setCh(char ch) {
		this.ch = ch;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public Map<String, String> getKeyAndValue() {
		return keyAndValue;
	}

	public void setKeyAndValue(Map<String, String> keyAndValue) {
		this.keyAndValue = keyAndValue;
	}
	
	

	
}