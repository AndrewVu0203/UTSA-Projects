package application.controller;

import application.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.FileNotFoundException;
import java.io.IOException;

// handle LoginController
public class LoginController {
    @FXML
    TextField fieldUsername;
    @FXML
    TextField fieldPassword;
    @FXML
    Label labelAccess; // showing whether the username and password matched

    // FXML handleButton
    @FXML
    public void handleButton(ActionEvent event) throws FileNotFoundException {
        User user = new User();
        user.readInfo();

        if(user.validate(fieldUsername.getText(), fieldPassword.getText())){
            try {
                changeScene(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            labelAccess.setText("Access Not Granted");
        }
    }


    // Login.fxml to Personnel.fxml
    public void changeScene(ActionEvent event) throws IOException {
        Stage secondaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Personnel.fxml"));
        Parent root = loader.load();

        PersonnelController controller = loader.getController();
        controller.setCurrentUser(fieldUsername.getText());
        controller.loadImages();

        secondaryStage.setScene(new Scene(root, 800 , 800));
        secondaryStage.show();
    }
}
