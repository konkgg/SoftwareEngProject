import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ScrollPane;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

public class ChessMasterController {

   //Variables to change
   private String view;
   private String user;
   
   //used
   private AnchorPane loginPane;
   private AnchorPane TeamRankingsPane;
   private AnchorPane SchedulePane;
   private AnchorPane TeamsPane;
   private AnchorPane TeamsAdminPane;
   
   protected static Database db;
   

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
    void HomeEntered(MouseEvent event) {
      String bgColor = "#f20d43";
      String bstyle=String.format("-fx-background-color: %s;",bgColor);
      HomeButton.setStyle(bstyle);

    }

    @FXML
    void HomeExited(MouseEvent event) {
      String bgColor = "#9D0628";
      String bstyle=String.format("-fx-background-color: %s;",bgColor);
      HomeButton.setStyle(bstyle);

    }
    @FXML
    void AccountEntered(MouseEvent event) {
String bgColor = "#f20d43";
      String bstyle=String.format("-fx-background-color: %s;",bgColor);
      AccountButton.setStyle(bstyle);
    }

    @FXML
    void AccountExited(MouseEvent event) {
String bgColor = "#9D0628";
      String bstyle=String.format("-fx-background-color: %s;",bgColor);
      AccountButton.setStyle(bstyle);
    }
    @FXML
    void RankingsEntered(MouseEvent event) {
String bgColor = "#f20d43";
      String bstyle=String.format("-fx-background-color: %s;",bgColor);
      RankingButton.setStyle(bstyle);
    }

    @FXML
    void RankingsExited(MouseEvent event) {
String bgColor = "#9D0628";
      String bstyle=String.format("-fx-background-color: %s;",bgColor);
      RankingButton.setStyle(bstyle);
    }
    @FXML
    void ScheduleEntered(MouseEvent event) {
String bgColor = "#f20d43";
      String bstyle=String.format("-fx-background-color: %s;",bgColor);
      ScheduleButton.setStyle(bstyle);
    }

    @FXML
    void ScheduleExited(MouseEvent event) {
String bgColor = "#9D0628";
      String bstyle=String.format("-fx-background-color: %s;",bgColor);
      ScheduleButton.setStyle(bstyle);
    }
    @FXML
    void TeamsEntered(MouseEvent event) {
String bgColor = "#f20d43";
      String bstyle=String.format("-fx-background-color: %s;",bgColor);
      TeamsButton.setStyle(bstyle);
    }

    @FXML
    void TeamsExited(MouseEvent event) {
String bgColor = "#9D0628";
      String bstyle=String.format("-fx-background-color: %s;",bgColor);
      TeamsButton.setStyle(bstyle);
    }
    
    @FXML
    void AccountButtonPressed(ActionEvent event) {
      StackPaneView.getChildren().get(StackPaneView.getChildren().indexOf(loginPane)).toFront();
      view = "Account";
      ViewLabel.setText(view);
    }

    @FXML
    void HomeButtonPressed(ActionEvent event) {
    }

    @FXML
    void RankingButtonPressed(ActionEvent event) {
      StackPaneView.getChildren().get(StackPaneView.getChildren().indexOf(TeamRankingsPane)).toFront();
      view = "Rankings";
      ViewLabel.setText(view);
    }

    @FXML
    void ScheduleButtonPressed(ActionEvent event) {
      StackPaneView.getChildren().get(StackPaneView.getChildren().indexOf(SchedulePane)).toFront();
      view = "Schedule";
      ViewLabel.setText(view);
    }

    @FXML
    void TeamsButtonPressed(ActionEvent event) {
      if(user == "admin")
      {
          StackPaneView.getChildren().get(StackPaneView.getChildren().indexOf(TeamsAdminPane)).toFront();
      view = "Rankings";
      ViewLabel.setText(view);
      }
      else
      {
      StackPaneView.getChildren().get(StackPaneView.getChildren().indexOf(TeamsPane)).toFront();
      view = "Teams";
      ViewLabel.setText(view);
      }
      
    }
    
   public void initialize()
   {
   user = "Guest";
   try
   {
      db = new Database();
      FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginFXML.fxml"));
      loginPane = (AnchorPane)loader.load();
      loader = new FXMLLoader(getClass().getResource("TeamRankingsFXML.fxml"));
      TeamRankingsPane = (AnchorPane)loader.load();
      loader = new FXMLLoader(getClass().getResource("ScheduleFXML.fxml"));
      SchedulePane = (AnchorPane)loader.load();
      loader = new FXMLLoader(getClass().getResource("TeamsFXML.fxml"));
      TeamsPane = (AnchorPane)loader.load();
      loader = new FXMLLoader(getClass().getResource("TeamsAdminFXML.fxml"));
      TeamsAdminPane = (AnchorPane)loader.load();
      
      StackPaneView.getChildren().addAll(TeamsAdminPane,TeamRankingsPane,SchedulePane,TeamsPane,loginPane);
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    GreetingLabel.setText("Welcome " + user);
   
   }
   
   public static Database getDB()
   {
      return db;
   }
   public void updateDB()
   {
   try
   {
      db = new Database();
      FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginFXML.fxml"));
      loginPane = (AnchorPane)loader.load();
      loader = new FXMLLoader(getClass().getResource("TeamRankingsFXML.fxml"));
      TeamRankingsPane = (AnchorPane)loader.load();
      loader = new FXMLLoader(getClass().getResource("ScheduleFXML.fxml"));
      SchedulePane = (AnchorPane)loader.load();
      loader = new FXMLLoader(getClass().getResource("TeamsFXML.fxml"));
      TeamsPane = (AnchorPane)loader.load();
      loader = new FXMLLoader(getClass().getResource("TeamsAdminFXML.fxml"));
      TeamsAdminPane = (AnchorPane)loader.load();
      
      StackPaneView.getChildren().addAll(loginPane,TeamRankingsPane,SchedulePane,TeamsPane,TeamsAdminPane);
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
   }

}

