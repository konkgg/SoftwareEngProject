import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;

public class GuestViewController {

   @FXML
   private VBox LeaderboardVBox;
   private Label[] leaderboard;
    
   public void initialize() {
      try {
         Database data = new Database();
         System.out.println(data.getTeamsList());
         this.leaderboard = new Label[data.teams.size()];
         
         //Add sort for point
         
         for(int i = 0; i < data.teams.size(); i++) {
            leaderboard[i] = new Label();
            leaderboard[i].setText(data.teams.get(i).getName() + " " + data.teams.get(i).getPoints());
            LeaderboardVBox.getChildren().add(leaderboard[i]);
         }
      }
      catch(Exception e) {
         e.printStackTrace();
      }   
   }
}
