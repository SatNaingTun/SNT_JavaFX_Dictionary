package com.snt.javafx.dictionary.model;

import java.io.Serializable;
import java.util.Comparator;

public class Dict implements Serializable,Comparable<Dict>{
	public Dict() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String keyword;
	
	String PartofSpeech;
	String definition;
	
	public Dict(String keyword, String partofSpeech, String definition) {
		super();
		this.keyword = keyword;
		this.PartofSpeech = partofSpeech;
		this.definition = definition;
	}
	
	public String getKeyword() {
		return keyword;
	}
	public boolean isContainKeyword(String string) {
		return keyword.contains(string);
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getPartofSpeech() {
		return PartofSpeech;
	}
	public void setPartofSpeech(String partofSpeech) {
		PartofSpeech = partofSpeech;
	}
	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	public boolean equalKeyWord(String key) {
	  return keyword.equalsIgnoreCase(key);
		
	}

	@Override
	public int compareTo(Dict o) {
		// TODO Auto-generated method stub
		return this.keyword.compareTo(o.keyword);
	}
	
}
