import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class GuestViewController {

   @FXML
   private VBox LeaderboardVBox;
   private HBox ScheduleHBox;
   private Label[] leaderboard;
   private Label[] schedule;
       
   public void initialize() {
      try {
         Database data = new Database();
         this.leaderboard = new Label[data.getTeamsList().size()];
         //add relevant schedule related values
         
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
            leaderboard[i].setFont(new Font("Georgia", 12));
            leaderboard[i].setText("   " + data.getTeamsList().get(i).getName() + " | Score: " + data.getTeamsList().get(i).getPoints() + "\n\n");
            LeaderboardVBox.getChildren().add(leaderboard[i]);
         }
         
         //Figure out how to deal with schedules
         
      }
      catch(Exception e) {
         e.printStackTrace();
      }   
   }
}
