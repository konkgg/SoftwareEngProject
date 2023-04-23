import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class TeamListController {

    @FXML
    private VBox TeamListVBox;
    
    private Label[] lineup;

   public void initialize() {
      TeamListVBox.setSpacing(10);
      try {
         this.lineup = new Label[ChessMasterController.getDB().getTeamsList().size()];
         
         //Adding Teams to VBox
         for(int i = 0; i < ChessMasterController.getDB().getTeamsList().size(); i++) {
            lineup[i] = new Label();
            lineup[i].setFont(new Font("Georgia", 20));
            lineup[i].setText("• " + ChessMasterController.getDB().getTeamsList().get(i).getName());
            TeamListVBox.getChildren().add(lineup[i]);
         }
         
      }
      catch(Exception e) {
         e.printStackTrace();
      }   
   }


}