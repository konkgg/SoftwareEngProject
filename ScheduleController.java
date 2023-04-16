import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ScheduleController {

    @FXML
    private HBox hbox;
    
    private VBox[] weeks;
    
   public void initialize()
   {
      try {
      Database data = new Database();
      
      weeks = new VBox[data.getSchedule().getTotalWeeks()];
      
      //for loop that for each week adds labels to the vbox for that week
      
         //create a label saying the week
         
         //create labels for each game that week saying who is playing
         //show who wins each week
      }
      catch(Exception e) {
         e.printStackTrace();
      } 
   }
    

}
