package com.snt.javafx.dictionary.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Dict_Data implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Dict> lstdata=new ArrayList<>();
	
public	void add(Dict d) {
		lstdata.add(d);
	}


public Dict get(int index) {
		return lstdata.get(index);
		
	}
public boolean isEqualKeyword(int index,String string) {
	return lstdata.get(index).equalKeyWord(string);
}
public boolean isContainKeyword(int index,String string) {
	return lstdata.get(index).isContainKeyword(string);
}

public int getindex(String keyword) {
	int index=-1;
	for(int i=0;i<lstdata.size();i++) {
	  if(	lstdata.get(i).equalKeyWord(keyword))
	  {   index=i;
	      break;
		  
	  }
		
	}

	 return  index;
	
}
public String getDef(int index) {
	return lstdata.get(index).getDefinition();
}
public String getSpeech(int index) {
	return lstdata.get(index).getPartofSpeech();
	
}
public String getKeyword(int index) {
	
	return lstdata.get(index).getKeyword();
}
public int getsize() {
	
	return lstdata.size();
	
}



}
