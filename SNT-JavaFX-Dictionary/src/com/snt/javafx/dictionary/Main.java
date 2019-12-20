package com.snt.javafx.dictionary;
	
import java.io.File;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;





public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Parent parent=FXMLLoader.load(getClass().getResource("controller/view/Dictionary.fxml"));
			Scene scene = new Scene(parent);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
