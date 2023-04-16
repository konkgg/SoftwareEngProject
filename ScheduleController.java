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
      }
      catch(Exception e) {
         e.printStackTrace();
      } 
   }
    

}
