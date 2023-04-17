import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class TeamListController {

    @FXML
    private VBox TeamListVBox;
    private Label[] lineup;

   public void initialize() {
      try {
         Database data = new Database();
         this.lineup = new Label[data.getTeamsList().size()];
         
         //Adding Teams to VBox
         for(int i = 0; i < data.getTeamsList().size(); i++) {
            lineup[i] = new Label();
            lineup[i].setFont(new Font("Georgia", 15));
            
           if(i%2 == 0)
            lineup[i].setText("\n      " + data.getTeamsList().get(i).getName());
           else
            lineup[i].setText("|       " + data.getTeamsList().get(i).getName());
            
            TeamListVBox.getChildren().add(lineup[i]);
         }
         
      }
      catch(Exception e) {
         e.printStackTrace();
      }   
   }


}