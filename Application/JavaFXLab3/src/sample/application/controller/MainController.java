package sample.application.controller;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.application.model.Fleet;

import java.io.FileNotFoundException;
import javafx.scene.control.TextArea;

public class MainController {
    // connect between FXML <-> Data, View <-> Model

    @FXML TextField myTextField;
    @FXML TextArea myTextArea;
    @FXML
    public void handleSubmit() throws FileNotFoundException {
        Fleet fleet = new Fleet();
        fleet.readDataFromFile();

        // declare var paragraph for setText()
        String paragraph = "";

        // paragraph = input from myTextField
        String input = myTextField.getText();

        // check input with Starship Name so that I can output correctly
        // i don't use normal variable getter, but multiple UI getter
        // get all important info into var paragraph
        for(int i = 0; i < fleet.getVarNumberOfStarships() ; i++){
            if(fleet.getVarStarshipName(i).equals(input) || fleet.getVarStarshipName(i).contains(input)){
                paragraph += fleet.getStarshipName(i);
                paragraph += fleet.getRegisry(i);
                paragraph += fleet.getStarshipClass(i);
                paragraph += fleet.getCrewNumber(i);
                paragraph += fleet.getAllCrews(i);
            }
        }
        paragraph += "\n";
        myTextArea.setText(paragraph);
        System.out.println(fleet.getVarNumberOfStarships());
    }
}
