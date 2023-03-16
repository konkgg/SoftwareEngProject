import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class GuestViewController {

   @FXML
   private VBox LeaderboardVBox;
   private Label[] leaderboard;
       
   public void initialize() {
      try {
         Database data = new Database();
         System.out.println(data.getTeamsList());
         this.leaderboard = new Label[data.teams.size()];
         
         System.out.println(data.teams.get(1).getPoints()); //Don't mind this, was checking something
         //Add sort for points
         
         for(int i = 0; i < data.teams.size(); i++) {
            leaderboard[i] = new Label();
            leaderboard[i].setFont(new Font("Jokerman", 13));
            leaderboard[i].setText("Rank #" + (i+1) + " " + data.teams.get(i).getName() + " | Score: " + data.teams.get(i).getPoints() + "\n\n");
            LeaderboardVBox.getChildren().add(leaderboard[i]);
         }
      }
      catch(Exception e) {
         e.printStackTrace();
      }   
   }
}
