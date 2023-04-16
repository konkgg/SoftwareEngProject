import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.layout.AnchorPane;

public class ChessMasterMain extends Application
{
   public void start(Stage stage)
   {
      try
      {
      Parent root = FXMLLoader.load(getClass().getResource("ChessMasterFXML.fxml"));
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.setTitle("Chess Master");
      stage.show();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }
   public static void main(String[] args) 
   {
      launch(args);
   }
}

