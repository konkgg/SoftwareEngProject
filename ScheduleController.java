import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class ScheduleController {

   @FXML
    private Label tourneyNameLabel;

    @FXML
    private VBox LeaderboardVBox;
    
   public void initialize()
   {
      LeaderboardVBox.setSpacing(10);
         try {
         ScheduleObject schedule = ChessMasterController.getDB().getSchedule();


         ArrayList<TeamObject> allMatches = new ArrayList<>();

         for(int i = 1; i <= schedule.getTotalWeeks(); i++)
         {
            allMatches = schedule.getWeek(i).getAllMatches();
            Label weekLabel = new Label();
            weekLabel.setText(String.format("Week %d", i));
            weekLabel.setFont(new Font("Georgia", 24));
            weekLabel.setUnderline(true);
            LeaderboardVBox.getChildren().add(weekLabel);

            for(int j = 0; j < allMatches.size() - 1; j++)
            {
               Label matchLabel = new Label();
               matchLabel.setText(String.format("%s vs %s", allMatches.get(j).getName(), allMatches.get(j+1).getName()));
               matchLabel.setFont(new Font("Georgia", 20));
               LeaderboardVBox.getChildren().add(matchLabel);
               j++;
            }
         }
      }
      catch(Exception e) {
         e.printStackTrace();
      } 
   }
    

}
