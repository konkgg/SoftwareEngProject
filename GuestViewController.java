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
         
         /*System.out.println(data.teams.get(1).getPoints()); //Don't mind this, was checking something
         
         if (data.teams.get(1).getPoints() < data.teams.get(2).getPoints())
            System.out.println("Epic");
         else if (data.teams.get(1).getPoints() > data.teams.get(2).getPoints())
            System.out.println("Wowzers");
         
         TeamObject newt = data.getTeam("team" + 5);
         TeamObject oldt = data.getTeam("team" + 1);
         TeamObject temp = new TeamObject("temp", 0);
         
         data.replaceTeam("team" + 5, temp);
         data.replaceTeam("team" + 1, newt);
         data.replaceTeam("temp", oldt);*/
         
         for(int i = 1; i < data.teams.size(); i++) { 
            int j = i - 1;
            
         }
         
         for(int i = 0; i < data.teams.size(); i++) {
            leaderboard[i] = new Label();
            leaderboard[i].setFont(new Font("Jokerman", 13));
            leaderboard[i].setText(" Rank #" + (i+1) + " | " + data.teams.get(i).getName() + " | Score: " + data.teams.get(i).getPoints() + "\n\n");
            LeaderboardVBox.getChildren().add(leaderboard[i]);
         }
      }
      catch(Exception e) {
         e.printStackTrace();
      }   
   }
}
