import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class GuestViewController {

   @FXML
   private VBox LeaderboardVBox;
   private VBox ScheduleVBox;
   private Label[] leaderboard;
       
   public void initialize() {
      try {
         Database data = new Database();
         System.out.println(data.getTeamsList());
         this.leaderboard = new Label[data.getTeamsList().size()];
         
         /* System.out.println(data.teams.get(1).getPoints()); //Don't mind this, was checking something
         
         if (data.teams.get(1).getPoints() > data.teams.get(2).getPoints())
            System.out.println("Epic");
         else if (data.teams.get(1).getPoints() < data.teams.get(2).getPoints())
            System.out.println("Wowzers");
         
         TeamObject newt = data.getTeam("team" + 5);
         TeamObject oldt = data.getTeam("team" + 1);
         TeamObject temp = new TeamObject("temp", 0);
         
         data.replaceTeam("team" + 5, temp);
         data.replaceTeam("team" + 1, newt);
         data.replaceTeam("temp", oldt); */
         
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
                  System.out.println("Oh No");  
            }
         }
         
         for(int i = 0; i < data.getTeamsList().size(); i++) {
            leaderboard[i] = new Label();
            leaderboard[i].setFont(new Font("Georgia", 12));
            leaderboard[i].setText("   " + data.getTeamsList().get(i).getName() + " | Score: " + data.getTeamsList().get(i).getPoints() + "\n\n");
            LeaderboardVBox.getChildren().add(leaderboard[i]);
         }
      }
      catch(Exception e) {
         e.printStackTrace();
      }   
   }
}
