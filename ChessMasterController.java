import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;

public class ChessMasterController {

   //Variables to change
   private String user;
   
   //used
   private AnchorPane loginPane;
   private AnchorPane TeamRankings;
   

    @FXML
    private Button AccountButton;

    @FXML
    private Label GreetingLabel;

    @FXML
    private Button HomeButton;

    @FXML
    private Button RankingButton;

    @FXML
    private Button ScheduleButton;

    @FXML
    private StackPane StackPaneView;

    @FXML
    private Button TeamsButton;

    @FXML
    private Label ViewLabel;
    
    @FXML
    void AccountButtonPressed(ActionEvent event) {
      StackPaneView.getChildren().get(StackPaneView.getChildren().indexOf(loginPane)).toFront();
    }

    @FXML
    void HomeButtonPressed(ActionEvent event) {

    }

    @FXML
    void RankingButtonPressed(ActionEvent event) {
      StackPaneView.getChildren().get(StackPaneView.getChildren().indexOf(TeamRankings)).toFront();
    }

    @FXML
    void ScheduleButtonPressed(ActionEvent event) {

    }

    @FXML
    void TeamsButtonPressed(ActionEvent event) {

    }
    
   public void initialize()
   {
   try
   {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginFXML.fxml"));
      loginPane = (AnchorPane)loader.load();
      loader = new FXMLLoader(getClass().getResource("TeamRankingsFXML.fxml"));
      TeamRankings = (AnchorPane)loader.load();
      
      StackPaneView.getChildren().addAll(loginPane,TeamRankings);
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
   
   }

}

