import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.layout.AnchorPane;

public class ChessBracketViewer extends Application
{
   public void start(Stage stage)
   {
      try
      {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("ChessBracketViewerFXML.fxml"));
      AnchorPane root = (AnchorPane)loader.load();
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.setTitle("Chess Bracket Viewer");
      stage.show();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }  
}