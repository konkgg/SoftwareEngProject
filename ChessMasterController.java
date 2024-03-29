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
import java.util.Timer;
import java.util.TimerTask;
import javafx.stage.Stage;


public class ChessMasterController {

   //Variables to change
   private String view;
   private static String user;
   private static Account account;
   
   //used
   private AnchorPane loginPane;
   private AnchorPane TeamRankingsPane;
   private AnchorPane SchedulePane;
   private AnchorPane TeamsPane;
   private AnchorPane TeamsAdminPane;
   private AnchorPane ScheduleAdmin;
   private AnchorPane Home;
   
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
    private AnchorPane masterPane;
    
    @FXML
public void exitApplication(ActionEvent event) {
   System.exit(0);
    ((Stage)masterPane.getScene().getWindow()).close();
    
}
    
    @FXML
    void HomeEntered(MouseEvent event) {
      String bgColor = "#f20d43";
      String bstyle=String.format("-fx-background-color: %s;",bgColor);
      HomeButton.setStyle(bstyle);
      updateGreeting();

    }

    @FXML
    void HomeExited(MouseEvent event) {
      String bgColor = "#9D0628";
      String bstyle=String.format("-fx-background-color: %s;",bgColor);
      HomeButton.setStyle(bstyle);
updateGreeting();
    }
    @FXML
    void AccountEntered(MouseEvent event) {
String bgColor = "#f20d43";
      String bstyle=String.format("-fx-background-color: %s;",bgColor);
      AccountButton.setStyle(bstyle);
      updateGreeting();
    }

    @FXML
    void AccountExited(MouseEvent event) {
String bgColor = "#9D0628";
      String bstyle=String.format("-fx-background-color: %s;",bgColor);
      AccountButton.setStyle(bstyle);
      updateGreeting();
    }
    @FXML
    void RankingsEntered(MouseEvent event) {
String bgColor = "#f20d43";
      String bstyle=String.format("-fx-background-color: %s;",bgColor);
      RankingButton.setStyle(bstyle);
      updateGreeting();
    }

    @FXML
    void RankingsExited(MouseEvent event) {
String bgColor = "#9D0628";
      String bstyle=String.format("-fx-background-color: %s;",bgColor);
      RankingButton.setStyle(bstyle);
      updateGreeting();
    }
    @FXML
    void ScheduleEntered(MouseEvent event) {
String bgColor = "#f20d43";
      String bstyle=String.format("-fx-background-color: %s;",bgColor);
      ScheduleButton.setStyle(bstyle);
      updateGreeting();
    }

    @FXML
    void ScheduleExited(MouseEvent event) {
String bgColor = "#9D0628";
      String bstyle=String.format("-fx-background-color: %s;",bgColor);
      ScheduleButton.setStyle(bstyle);
      updateGreeting();
    }
    @FXML
    void TeamsEntered(MouseEvent event) {
String bgColor = "#f20d43";
      String bstyle=String.format("-fx-background-color: %s;",bgColor);
      TeamsButton.setStyle(bstyle);
      updateGreeting();
    }

    @FXML
    void TeamsExited(MouseEvent event) {
String bgColor = "#9D0628";
      String bstyle=String.format("-fx-background-color: %s;",bgColor);
      TeamsButton.setStyle(bstyle);
      updateGreeting();
    }
    
    @FXML
    void AccountButtonPressed(ActionEvent event) {
    updateDB();
      StackPaneView.getChildren().get(StackPaneView.getChildren().indexOf(loginPane)).toFront();
      view = "Account";
      ViewLabel.setText(view);
    }

    @FXML
    void HomeButtonPressed(ActionEvent event) {
    updateDB();
      StackPaneView.getChildren().get(StackPaneView.getChildren().indexOf(Home)).toFront();
      view = "Home";
      ViewLabel.setText(view);
    }

    @FXML
    void RankingButtonPressed(ActionEvent event) {
    updateDB();
      StackPaneView.getChildren().get(StackPaneView.getChildren().indexOf(TeamRankingsPane)).toFront();
      view = "Rankings";
      ViewLabel.setText(view);
    }

    @FXML
    void ScheduleButtonPressed(ActionEvent event) {
    updateDB();
    if(account.checkAdmin())
    {
      StackPaneView.getChildren().get(StackPaneView.getChildren().indexOf(ScheduleAdmin)).toFront();
      view = "Schedule";
      ViewLabel.setText(view);
      }
    else
    {
    StackPaneView.getChildren().get(StackPaneView.getChildren().indexOf(SchedulePane)).toFront();
      view = "Schedule";
      ViewLabel.setText(view);
    }
    }

    @FXML
    void TeamsButtonPressed(ActionEvent event) {
    updateDB();
      if(account.checkAdmin())
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
    @FXML
    void mouseMoved(MouseEvent event) {
      updateGreeting();
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
      loader = new FXMLLoader(getClass().getResource("ScheduleAdminFXML.fxml"));
      ScheduleAdmin = (AnchorPane)loader.load();
      loader = new FXMLLoader(getClass().getResource("HomeFXML.fxml"));
      Home = (AnchorPane)loader.load();
      
      StackPaneView.getChildren().addAll(ScheduleAdmin,TeamsAdminPane,TeamRankingsPane,SchedulePane,TeamsPane,loginPane,Home);
      view = "Account";
      account = new Account("Guest","");
      
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
   }
   public void updateGreeting()
   {
       GreetingLabel.setText("Welcome " + user);
   }
   
   public static void setUser()
   {
      user = account.getUsername();
      
   }
   public static void updateAccount(Account in)
   {
      account = in;
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

