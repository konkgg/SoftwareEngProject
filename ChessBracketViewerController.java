import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Node;

public class ChessBracketViewerController {

    @FXML
    private Button guestButton;

    @FXML
    private Button loginButton;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    void guestPressed(ActionEvent event) {
    try
    {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("GuestViewFXML.fxml")); // change the fxml to the second scene
      AnchorPane root = (AnchorPane)loader.load();
      Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
      Scene scene = new Scene(root);
      stage.setScene(scene);
      System.out.println("new scene");
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

    }

    @FXML
    void loginPressed(ActionEvent event)
    {
    }
}
