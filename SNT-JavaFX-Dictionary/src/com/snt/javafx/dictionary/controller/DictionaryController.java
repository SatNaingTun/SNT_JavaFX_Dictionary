package com.snt.javafx.dictionary.controller;




import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.snt.javafx.dictionary.model.Dict_Data;

import com.snt.javafx.dictionary.services.DataManager;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DictionaryController implements Initializable {

	DataManager manager=new DataManager();
	

	@FXML
    private TextField tx_input;

    @FXML
    private Button btn_search;
   
    
    @FXML
    private ListView<String> listview;
    
    @FXML
    private Text txt_Keyword;

    @FXML
    private Text txt_speech;

    @FXML
    private TextArea txt_def;


    
    
    @FXML
    public void search() {
    	
    	//System.out.println("Search Enter");
    	
    	
    	if(tx_input.getText()!=null)
    	{   listview.getItems().clear();
    		for(int i=0;i<manager.Size();i++) {
    			if(manager.getData().isEqualKeyword(i, tx_input.getText())) 
    			{
    				listview.getItems().add(manager.getData().getKeyword(i));
    				
    			}
    			
    			else if(manager.getData().isContainKeyword(i, tx_input.getText())) 
     		   {
     			  System.out.println(tx_input.getText());
     			
     			
     		    listview.getItems().add(manager.getData().getKeyword(i));
     		
     		}
     		
    	  }
    	if(listview.getItems().size()>0) {
 			show(listview.getItems().get(0));
 			
 		}
    	
     	}
    	else { 
    		listview.getItems().clear();
    	}
    	
    }
    
   

   
    @FXML
    void listclick() {
    	System.out.println(listview.getSelectionModel()
                .getSelectedItem());
    	String key=listview.getSelectionModel().getSelectedItem();
    	
       show(key);
          
         
    	
    }
   
    
    void show(String key) {
    	
    	
       
    	 int index=manager.getData().getindex(key);
         //manager.getDefinition(index);
        txt_Keyword.setText(manager.getData().getKeyword(index));
      
         txt_def.setText(manager.getData().getDef(index));
       txt_speech.setText(manager.getData().getSpeech(index));
         
    	
    }
    void read() {
    	
    	
    	//Dict_Data data2=manager.ReadData();
    	
    	//System.out.println("Reading data ");
    	manager.ReadData();
        for(int i=0;i<manager.Size();i++) {
    		
    		listview.getItems().add(manager.getData().getKeyword(i));
    		
    		
    	}
      	
    }
    @FXML
    void KeyPress(KeyEvent event) {
    if(event.getCode()==KeyCode.ENTER) {
    	System.out.println("Enter create");
    	search();
    }
    }
    
    @FXML
    void addDict(ActionEvent event)  {
    	//System.out.println("Create form");
    	CreateDictionary f1=new CreateDictionary();
    	f1.showForm();
		
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//add_toList();
		read();
		
		
	}

}