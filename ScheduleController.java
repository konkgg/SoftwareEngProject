import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class ScheduleController {

   @FXML
    private Label tourneyNameLabel;

    @FXML
    private VBox vbox;
    
   public void initialize()
   {
         try {
         Database data = new Database();
         ScheduleObject schedule = data.getSchedule();
         schedule.setName("Dalton State College Chess Tournament");  //or give it a name with a user input
         tourneyNameLabel.setText(schedule.getName());

         Label startLabel = new Label("     Week 1      ");
         startLabel.setFont(new Font("Georgia", 12));
         startLabel.setUnderline(true);
         vbox.getChildren().add(startLabel);

         ArrayList<TeamObject> allMatches = new ArrayList<>();

         for(int i = 1; i <= schedule.getTotalWeeks(); i++)
         {
            allMatches = schedule.getWeek(i).getAllMatches();

            for(int j = 0; j < allMatches.size() - 1; j++)
            {
               Label matchLabel = new Label();
               matchLabel.setText(String.format("     %s vs %s%n%n", allMatches.get(j).getName(), allMatches.get(j+1).getName()));
               matchLabel.setFont(new Font("Georgia", 12));
               vbox.getChildren().add(matchLabel);
               j++;
            }

            if(i < schedule.getTotalWeeks())
            {
               Label weekLabel = new Label();
               weekLabel.setText(String.format("     Week %d      %n", i+1));
               weekLabel.setFont(new Font("Georgia", 12));
               weekLabel.setUnderline(true);
               vbox.getChildren().add(weekLabel);
            }
         }
      }
      catch(Exception e) {
         e.printStackTrace();
      } 
   }
    

}
