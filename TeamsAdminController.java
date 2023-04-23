import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class TeamsAdminController {

    @FXML
    private VBox PointsButtons;

    @FXML
    private VBox PointsFields;

    @FXML
    private VBox TeamsButtons;

    @FXML
    private VBox TeamsTextFields;
    
    //varr
    private TextField[] Teams;
    private TextField[] Points;
    private Button[] UpdatePoints;
    private Button[] UpdateTeams;
    
    
    public void initialize()
   {
      Teams = new TextField[10];
      Points = new TextField[10];
      UpdatePoints = new Button[10];
      UpdateTeams = new Button[10];
      for(int i = 0; i < 10; i++)
      {
         Teams[i] = new TextField();
         Points[i] = new TextField();
         UpdatePoints[i] = new Button();
         UpdatePoints[i].setText("Update");
         UpdateTeams[i] = new Button();
         UpdateTeams[i].setText("Update");
         TeamsTextFields.getChildren().add(Teams[i]);
         PointsFields.getChildren().add(Points[i]);
         PointsButtons.getChildren().add(UpdatePoints[i]);
         TeamsButtons.getChildren().add(UpdateTeams[i]);
      }
   }
}
