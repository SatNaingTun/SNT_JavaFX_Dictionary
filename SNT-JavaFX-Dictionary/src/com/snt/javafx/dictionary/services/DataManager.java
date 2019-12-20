package com.snt.javafx.dictionary.services;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.snt.javafx.dictionary.model.Dict;
import com.snt.javafx.dictionary.model.Dict_Data;

public class DataManager {
	Dict_Data data;
	public void build() {
		data=new Dict_Data();
	}
	 public Dict_Data getData() {
		return data;
	}
	public void setData(Dict_Data data) {
		this.data = data;
	}
	public void add(String Keyword,String Speech,String Definition) {
		   
		   data.add(new Dict(Keyword,Speech,Definition));
	   }
	 
	
	
	 
	  public int Size() {
		  // System.out.println(data.getsize());
		   return data.getsize();
	   }
	
	
	 public void WriteData() {
	    	
		 try(     
			   	  FileOutputStream fileOutputStream = new FileOutputStream("src/com/snt/javafx/dictionary/data/data.dat");

		          ObjectOutputStream output = new ObjectOutputStream(fileOutputStream)) {
			 
	           
	           
	     
	            
	            output.writeObject(data);
	           
	           
	 
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } 
	    }
	
	
	    public void ReadData() {
	    	try( FileInputStream fileInputStream = new FileInputStream(
	                    "src/com/snt/javafx/dictionary/data/data.dat");
	            ObjectInputStream input = new ObjectInputStream(fileInputStream)) {
	    		 
	            //Read from the stored file
	           
	          data=(Dict_Data) input.readObject();
	           
	 
	        } catch (FileNotFoundException e) {
	           
	        	System.out.println("File Not Found");
	        	 e.printStackTrace();
	        	 CreateNewData();
	        	 ReadData();
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        } 
	    	  catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    }
	    public void CreateNewData() {
	    	data=new Dict_Data();
	    	WriteData();
	    	
	    }
}
