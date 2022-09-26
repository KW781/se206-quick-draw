package nz.ac.auckland.se206;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import nz.ac.auckland.se206.userutils.Database;

public class MainMenuController {

  private Scene scene;
  private Stage stage;

  @FXML Button switchProfile;
  @FXML Button createProfile;
  private final Database data = new Database();

  @FXML
  private void onSwitchProfile(ActionEvent event) throws IOException {
    // Create the FXML loader with the profile scene

    if (data.getAllUsers().length == 0) {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setHeaderText("No users found, please create a profile!");
      alert.setTitle("No Users");
      alert.show();
      return;
    }
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/profile.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    // Set the scene and show the stage
    stage.setScene(scene);
    stage.show();
  }

  @FXML
  private void onCreateProfile(ActionEvent event) throws IOException {
    if (data.getAllUsers().length == 6) {
      Alert maxUsers = new Alert(Alert.AlertType.INFORMATION);
      maxUsers.setHeaderText("Sorry but only 6 user accounts or less are allowed");
      maxUsers.setTitle("Unable to Create Profile");
      maxUsers.show();
      return;
    }
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/createprofile.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    // Set the scene and show the stage
    stage.setScene(scene);
    stage.show();
  }
}