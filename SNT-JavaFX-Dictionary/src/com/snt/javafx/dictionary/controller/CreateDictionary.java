package com.snt.javafx.dictionary.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import com.snt.javafx.dictionary.model.Dict_Data;

import com.snt.javafx.dictionary.services.DataManager;

public class CreateDictionary {

	  @FXML
	    private TextField txt_keyword;

	    @FXML
	    private TextField txt_Def;

	    @FXML
	    private TextField txt_Speech;
		DataManager manager=new DataManager();
    
    public void showForm() {
    	try {
    		FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("view/CreateDictionary.fxml"));
			Parent parent=(Parent)fxmlloader.load();
			Scene scene = new Scene(parent);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    	
    }
    
    @FXML
    void addData(ActionEvent event) {
    	System.out.println("Data Writing");
      try {
    
    
    	manager.ReadData();
    	
    	manager.add(txt_keyword.getText(),txt_Speech.getText(),txt_Def.getText());
    	
       manager.WriteData();
    	//manager.CreateNewData();
        }
      catch(Exception ex) {
    	  ex.printStackTrace();
      }
    }

   

}

