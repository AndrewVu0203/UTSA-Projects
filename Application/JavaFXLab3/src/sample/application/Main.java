package sample.application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.Stage;
public class Main extends Application {
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
        Parent root = loader.load();
        Scene myScene = new Scene(root,800,800);
        primaryStage.setScene(myScene);
        primaryStage.show();

//        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
//        primaryStage.setTitle("Lab 3");
//        primaryStage.setScene(new Scene(root, 800, 800));
//        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    } }