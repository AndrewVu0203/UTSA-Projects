package application.controller;

import application.model.Dinosaur;
import application.model.Park;
import application.model.Zone;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZoneController {
    String currentZone;
    String currentNoDinosaur;
    String currentThreatLevel;
    ArrayList<Dinosaur> dinosaurs = new ArrayList<Dinosaur>();
    ArrayList<Zone> zones = new ArrayList<Zone>();
    HashMap<Zone, ArrayList<Dinosaur>> hashMap;
    Park park;
    ObservableList<String> names = FXCollections.observableArrayList("");

    @FXML Label labelZone;
    @FXML Label labelNoDinosaur;
    @FXML Label labelThreatLevel;

    @FXML TextField fieldAddName;
    @FXML TextField fieldAddType;
    @FXML TextField fieldRelocateName;
    @FXML TextField fieldRelocateZone;
    @FXML Label labelResult;

    @FXML ListView<String> listViewDinosaur;
    @FXML RadioButton radioYes;
    @FXML RadioButton radioNo;
    ToggleGroup toggleGroup = new ToggleGroup();

    public String getCurrentZone() {
        return currentZone;
    }

    public void setCurrentZone(String currentZone) {
        this.currentZone = currentZone;
    }

    public String getCurrentNoDinosaur() {
        return currentNoDinosaur;
    }

    public void setCurrentNoDinosaur(String currentNoDinosaur) {
        this.currentNoDinosaur = currentNoDinosaur;
    }

    public String getCurrentThreatLevel() {
        return currentThreatLevel;
    }

    public void setCurrentThreatLevel(String currentThreatLevel) {
        this.currentThreatLevel = currentThreatLevel;
    }

    public void setPark(Park park) {
        this.park = park;
    }

    int checkCurrentZoneNoDinosaurs(){
        int noDinosaurs = 0;
        for(Zone zn : hashMap.keySet()){
            for (Dinosaur dino : hashMap.get(zn)) {
                if(dino.getZone().equals(currentZone)) noDinosaurs++;
            }
        }
        return noDinosaurs;
    }

    Dinosaur getCurrentDinosaurObject(){
        for(int i = 0; i < this.dinosaurs.size(); i++){
            if(this.dinosaurs.get(i).getZone().equals(currentZone))
                return this.dinosaurs.get(i);
        }
        return null;
    }

    Zone getCurrentZoneObject(){
        for(int i = 0; i < this.zones.size(); i++){
            if(this.zones.get(i).getZodeCode().equals(currentZone))
                return this.zones.get(i);
        }
        return null;
    }

    @FXML public void handleHome(ActionEvent event) throws IOException {
        changeScene(event);
    }

    public void changeScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../view/Main.fxml"));
        Stage secondaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        secondaryStage.setScene(new Scene(root, 800 , 800));
        secondaryStage.show();
    }

    public void loadZoneController() throws FileNotFoundException {
        Zone zone = new Zone();
        this.zones = zone.readInfo();

        loadListView();

        labelZone.setText("T-Rez Zone is: " + currentZone);
        labelNoDinosaur.setText("# Dinosaurs : " + checkCurrentZoneNoDinosaurs());
        labelThreatLevel.setText("Threat : " + getCurrentZoneObject().getThreatLevel());
        radioYes.setToggleGroup(toggleGroup);
        radioNo.setToggleGroup(toggleGroup);
    }

    public void loadListView() throws FileNotFoundException {
        hashMap = park.getHashMap();

        for(Zone zn : hashMap.keySet()){
            for (Dinosaur dino : hashMap.get(zn)) {
                if(zn.getZodeCode().equals(currentZone) && dino.getZone().equals(currentZone)){
                    names.addAll(dino.toString());
                }
            }
        }

        listViewDinosaur.setItems(names);
    }

    @FXML void buttonAdd() throws IOException {
        RadioButton selectedRadio = (RadioButton) toggleGroup.getSelectedToggle();
        boolean value = false;

        try{
            if(selectedRadio.getText().equals("Yes")) value = true;
            if(selectedRadio.getText().equals("No")) value = false;
        }
        catch(NullPointerException error){
            System.out.println(error);
        }

        File file = new File("src/application/data/dinos.csv");
        try {
            FileWriter csvWriter = new FileWriter(file, true);
            csvWriter.append("\n" + fieldAddName.getText() + ","
                            + fieldAddType.getText() + ","
                            + value + ","
                            + this.currentZone);

            csvWriter.flush();
            csvWriter.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Vu, File Error is: " + e);
        }

        names.addAll(fieldAddName.getText()
                + "-" + fieldAddType.getText()
                + "-" + (value? "carnivore" : "no carnivore"));

        fieldAddName.setText("");
        fieldAddType.setText("");

    }

    @FXML void buttonRelocate() throws IOException {
        boolean result = this.park.relocate(currentZone, fieldRelocateName.getText(), fieldRelocateZone.getText(), names);

        fieldRelocateName.setText("");
        fieldRelocateZone.setText("");
        labelResult.setText(Boolean.toString(result));

    }
}
