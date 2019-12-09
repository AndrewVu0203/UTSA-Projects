package application.controller;

import application.model.CrewMember;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class PersonnelController {

    @FXML ImageView imageFirst;
    @FXML ImageView imageSecond;
    @FXML ImageView imageThird;
    @FXML ImageView imageFourth;
    @FXML ImageView imageFifth;
    @FXML ImageView imageSixth;
    @FXML ImageView imageSeventh;
    @FXML ImageView imageEighth;
    @FXML Label labelFirst;
    @FXML Label labelSecond;
    @FXML Label labelThird;
    @FXML Label labelFourth;
    @FXML Label labelFifth;
    @FXML Label labelSixth;
    @FXML Label labelSeventh;
    @FXML Label labelEighth;
    @FXML Label labelCaptain;
    @FXML Label labelFleet;
    String currentUser;
    ArrayList<CrewMember> crewMembers;

    public void setCurrentUser(String a) {
        this.currentUser = a;
    }
    public String getCurrenUser() {
        return this.currentUser;
    }

    // load images and also load everything else needed such as labels
    public void loadImages() throws FileNotFoundException {
        ArrayList<CrewMember> crewMembers = new ArrayList<CrewMember>();
        CrewMember crewMember = new CrewMember();
        crewMembers = crewMember.readInfo();
        this.crewMembers = crewMembers;

        ArrayList<CrewMember> crewMembersNew = new ArrayList<CrewMember>();

        String currentUserRegistry = "" ;

        for(int i = 0 ; i < crewMembers.size(); i++){

            if(crewMembers.get(i).getLastName().toLowerCase().equals(getCurrenUser())){
                currentUserRegistry = crewMembers.get(i).getRegistry();
            }
        }

        crewMembersNew = checkRegistry(currentUserRegistry, crewMembers);
        
        if(crewMembersNew.size() > 0) {
            ArrayList<Label> labels = new ArrayList<Label>();
            labels = getALLabel();

            setLabels(crewMembersNew, labels);

            ArrayList<ImageView> imageViews = new ArrayList<ImageView>();
            imageViews = getALImageView();
            setImages(crewMembersNew, imageViews);
        }

        setLabelCaptain();
        setLabelFleet();
    }

    // set Label to current user's name
    void setLabelCaptain(){
        labelCaptain.setText("Welcome" + currentUser);
        for(int i = 0; i < crewMembers.size(); i++){
            if(crewMembers.get(i).getLastName().toLowerCase().equals(getCurrenUser())){
                labelCaptain.setText(crewMembers.get(i).getLastName());
            }
        }
    }

    // set Label to current user's starship, but since fleet.csv is not in package i only present registry
    void setLabelFleet(){
        for(int i = 0; i < crewMembers.size(); i++){
            if(crewMembers.get(i).getLastName().toLowerCase().equals(getCurrenUser())){
                labelFleet.setText("Fleet with serial: " + crewMembers.get(i).getRegistry());
            }
        }
    }

    // put all Label into an ArrayList
    public ArrayList<Label> getALLabel(){
        ArrayList<Label> labels = new ArrayList<Label>();
        labels.add(labelFirst);
        labels.add(labelSecond);
        labels.add(labelThird);
        labels.add(labelFourth);
        labels.add(labelFifth);
        labels.add(labelSixth);
        labels.add(labelSeventh);
        labels.add(labelEighth);
        return labels;
    }

    // put all ImageView into an ArrayList
    public ArrayList<ImageView> getALImageView(){
        ArrayList<ImageView> imageViews = new ArrayList<ImageView>();
        imageViews.add(imageFirst);
        imageViews.add(imageSecond);
        imageViews.add(imageThird);
        imageViews.add(imageFourth);
        imageViews.add(imageFifth);
        imageViews.add(imageSixth);
        imageViews.add(imageSeventh);
        imageViews.add(imageEighth);
        return imageViews;
    }


    // set all labels of crewmembers
    public void setLabels(ArrayList<CrewMember> crewMembers, ArrayList<Label> labels){
        for(int i = 0; i < labels.size(); i++){
            labels.get(i).setText(crewMembers.get(i).getName() + "\n" + crewMembers.get(i).getPosition());
        }
    }
    // set all images of crewmembers
    public void setImages(ArrayList<CrewMember> crewMembers, ArrayList<ImageView> imageViews) throws FileNotFoundException {
        for(int i = 0; i < imageViews.size(); i++){
            imageViews.get(i).setImage(new Image(crewMembers.get(i).getUrlImage()));
        }
    }

    // helper function to check if same registry, and return only those who match
    public ArrayList<CrewMember> checkRegistry(String registry, ArrayList<CrewMember> crewMembers){
        ArrayList<CrewMember> crewMembersNew = new ArrayList<CrewMember>();

        int j = 0;
        for(int i = 0; i < crewMembers.size(); i++){
            if(crewMembers.get(i).getRegistry().equals(registry)){
                CrewMember crewMember = crewMembers.get(i);
                crewMembersNew.add(crewMember);
                j++;
            }
        }
        return crewMembersNew;
    }

    // change to LoginController scene
    public void changeScene(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource(("../Login.fxml")));

        Stage secondaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();

        secondaryStage.setScene(new Scene(root1, 800 , 800));
        secondaryStage.show();
    }

    // handle log out button
    @FXML public void ButtonLogOut(ActionEvent event) {
        try {
            changeScene(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
