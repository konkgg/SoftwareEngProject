import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class TeamRankingsController {

    @FXML
    private VBox LeaderboardVBox;
    private Label[] leaderboard;

   public void initialize() {
      try {
         Database data = new Database();
         this.leaderboard = new Label[data.getTeamsList().size()];
         
         //Sorting Teams by Score
         for(int i = 0; i < data.getTeamsList().size(); i++) {
            for(int j = 0; j < data.getTeamsList().size(); j++) {
               TeamObject newt;
               TeamObject oldt;
               if (data.getTeamsList().get(i).getPoints() > data.getTeamsList().get(j).getPoints()) {
                  newt = data.getTeamsList().get(j);
                  oldt = data.getTeamsList().get(i);
                  
                  data.getTeamsList().set(j, oldt);
                  data.getTeamsList().set(i, newt);
                  
                  System.out.println("Swap");
               }
               else
                  System.out.println("Stay");  
            }
         }
         
         //Adding Teams to VBox
         for(int i = 0; i < data.getTeamsList().size(); i++) {
            leaderboard[i] = new Label();
            leaderboard[i].setFont(new Font("Georgia", 15));
            leaderboard[i].setText("\n      " + data.getTeamsList().get(i).getName() + " | Score: " + data.getTeamsList().get(i).getPoints() + "\n");
            LeaderboardVBox.getChildren().add(leaderboard[i]);
         }
         
      }
      catch(Exception e) {
         e.printStackTrace();
      }   
   }


}
