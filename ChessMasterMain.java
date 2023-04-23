import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.Timer;

public class ChessMasterMain extends Application
{
   public void start(Stage stage)
   {
      try
      {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("ChessMasterFXML.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.setTitle("Chess Master");
      stage.setResizable(false);
      stage.show();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      Timer timer = new Timer();
      stage.setOnCloseRequest(event -> 
      {
    System.out.println("Stage is closing");
    System.exit(0);
    }
    );
   }
   public static void main(String[] args) 
   {
      launch(args);
   }
   
}

