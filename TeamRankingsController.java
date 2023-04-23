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
         LeaderboardVBox.setSpacing(10);
         this.leaderboard = new Label[ChessMasterController.getDB().getTeamsList().size()];
         
         //Sorting Teams by Score
         for(int i = 0; i < ChessMasterController.getDB().getTeamsList().size(); i++) {
            for(int j = 0; j < ChessMasterController.getDB().getTeamsList().size(); j++) {
               TeamObject newt;
               TeamObject oldt;
               if (ChessMasterController.getDB().getTeamsList().get(i).getPoints() > ChessMasterController.getDB().getTeamsList().get(j).getPoints()) {
                  newt = ChessMasterController.getDB().getTeamsList().get(j);
                  oldt = ChessMasterController.getDB().getTeamsList().get(i);
                  
                  ChessMasterController.getDB().getTeamsList().set(j, oldt);
                  ChessMasterController.getDB().getTeamsList().set(i, newt);
                  
                  System.out.println("Swap");
               }
               else
                  System.out.println("Stay");  
            }
         }
         
         //Adding Teams to VBox
         for(int i = 0; i < ChessMasterController.getDB().getTeamsList().size(); i++) {
            leaderboard[i] = new Label();
            leaderboard[i].setFont(new Font("Georgia", 20));
            leaderboard[i].setText(String.format("%d",i+1) + ". " + ChessMasterController.getDB().getTeamsList().get(i).getName() + " | Score: " + ChessMasterController.getDB().getTeamsList().get(i).getPoints());
            LeaderboardVBox.getChildren().add(leaderboard[i]);
            
         }
         
      }
      catch(Exception e) {
         e.printStackTrace();
      }   
   }


}
