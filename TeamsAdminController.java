import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.FileWriter;
import java.io.IOException;

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
    private Button UpdatePoints;
    private Button UpdateTeams;
    private String data;
   
    
    public void initialize()
   {
   data = "";
      Teams = new TextField[10];
      Points = new TextField[10];
      UpdateTeams = new Button();
      UpdatePoints = new Button();
       UpdatePoints.setText("Update");
       UpdateTeams = new Button();
       UpdateTeams.setText("Update");
       UpdateTeams.setOnAction(event);
       UpdatePoints.setOnAction(event);
      for(int i = 0; i < 10; i++)
      {
         Teams[i] = new TextField();
         Points[i] = new TextField();
         TeamsTextFields.getChildren().add(Teams[i]);
         PointsFields.getChildren().add(Points[i]);
      }
      PointsButtons.getChildren().add(UpdatePoints);
      TeamsButtons.getChildren().add(UpdateTeams);
   }
   EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
            data = "";
                 for(int i = 0; i < 10; i++)
   {
      if(Teams[i].getText() != "")
      {
         data+=Teams[i].getText() + ",";
         if(Points[i].getText() != null)
            data+=Points[i].getText();
         if(Points[i].getText() == "")
            data += "0";
         data+="\n";
      }
      
   }
   System.out.println(data);
   try {

            FileWriter fw = new FileWriter("teams.csv");
                fw.write(data);
            System.out.println("Successfully written");

            fw.close();
        }
        catch (Exception exc) {
            exc.getStackTrace();
        }

            }
        };
  
}