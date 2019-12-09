package application.controller;

import application.model.Dinosaur;
import application.model.Park;
import application.model.Zone;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML public void handleZoneB(ActionEvent event) throws IOException {
        changeScene(event, "B");
    }

    @FXML public void handleZoneD(ActionEvent event) throws IOException {
        changeScene(event, "D");
    }

    @FXML public void handleZoneG(ActionEvent event) throws IOException {
        changeScene(event, "G");
    }

    @FXML public void handleZoneR(ActionEvent event) throws IOException {
        changeScene(event, "R");
    }

    @FXML public void handleZoneTR(ActionEvent event) throws IOException {
        changeScene(event, "TR");
    }

    @FXML public void handleZoneTY(ActionEvent event) throws IOException {
        changeScene(event, "TY");
    }

    @FXML public void handleZoneX(ActionEvent event) throws IOException {
        changeScene(event, "X");
    }

    public void changeScene(ActionEvent event, String currentZone) throws IOException {
        Stage secondaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Zone.fxml"));
        Parent root = loader.load();
        ZoneController controller = loader.getController();
        Park park = new Park(); // hashMap get a refill, not from cvs, but old hashmap
        park.loadZones();
        park.loadDinosaurs();
        controller.setPark(park);
        controller.setCurrentZone(currentZone);
        controller.loadZoneController(); // this one load corresponding zone controller data, so change something in this

        secondaryStage.setScene(new Scene(root, 800 , 800));
        secondaryStage.show();
    }
}
