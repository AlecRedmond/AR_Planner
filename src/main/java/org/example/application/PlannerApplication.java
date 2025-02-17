package org.example.application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PlannerApplication extends Application {

    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception{
        Text text = new Text("Hello World!");
        StackPane stackPane = new StackPane(text);
        Scene scene = new Scene(stackPane,640,480);
        stage.setScene(scene);
        stage.show();
    }
}
