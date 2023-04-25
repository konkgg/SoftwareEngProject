import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import java.util.ArrayList;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import java.util.Arrays;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class ScheduleAdminController {

    @FXML
    private VBox LeaderboardVBox1;
    
    @FXML
    private VBox LeaderboardVBox2;
    
    @FXML
    private Button GenerateButton;


    @FXML
    private Button UpdateButton;

    @FXML
    private Label tourneyNameLabel;
    
    private TextField[] games;
    private TextField[] vsGames; 

    @FXML
    void UpdateButtonPressed(ActionEvent event) {
    String data = "";
    ArrayList teams = ChessMasterController.getDB().getTeamsList();
    TeamObject[] arr = new TeamObject[teams.size()];
    for(int i = 0; i < teams.size(); i++)
    {
    arr[i] = (TeamObject)teams.get(i);
    }
    
    List<TeamObject[]> pairs = new ArrayList<TeamObject[]>();
        
        for (int i = 0; i < arr.length; i++) { // loop through each element in the array
            for (int j = i + 1; j < arr.length; j++) { // loop through each remaining element
                TeamObject[] pair = {arr[i], arr[j]}; // create the pair with the current elements
                boolean pairExists = false;
                for (TeamObject[] existingPair : pairs) { // loop through existing pairs
                    if (Arrays.equals(existingPair, pair) || Arrays.equals(existingPair, new TeamObject[]{pair[1], pair[0]})) { // check if the pair already exists or is a duplicate in reverse order
                        pairExists = true;
                        break;
                    }
                }
                if (!pairExists) { // if the pair is unique, add it to the list
                    pairs.add(pair);
                }
            }
        }    
        System.out.println(pairs.size());
        for(int i = 0; i < pairs.size(); i++)
        {
        if(i%6==0)
         data+=String.format("Week%d\n",(i/6+1));
        data += pairs.get(i)[0].getName();
        data += ",";
        data +=pairs.get(i)[1].getName();
        data +="\n";
        }
        
         try {

            FileWriter fw = new FileWriter("schedule.csv");
                fw.write(data);
            System.out.println("Successfully written");

            fw.close();
        }
        catch (Exception exc) {
            exc.getStackTrace();
        }

        }
    
     @FXML
    void UpdateGenerateButtonPressed(ActionEvent event) {

    }
    
public void initialize()
   {
      LeaderboardVBox1.setSpacing(10);
      LeaderboardVBox2.setSpacing(10);
      games = new TextField[8*3];
      vsGames = new TextField[8*3];
      for(int i = 0; i < 8*3; i++)
      {
         games[i] = new TextField();
         vsGames[i] = new TextField();
      }
      for(int i = 0; i < 8*3; i++)
      {
         if(i % 3 == 0)
         {
         Label weekLabel = new Label();
         Label numberLabel = new Label();
         weekLabel.setText(String.format("Week %d", (i/3)+1));
         numberLabel.setText(String.format(" "));
         weekLabel.setFont(new Font("Georgia", 24));
         numberLabel.setFont(new Font("Georgia", 24));
         weekLabel.setUnderline(true);
         numberLabel.setUnderline(true);
         LeaderboardVBox1.getChildren().add(weekLabel);
         LeaderboardVBox2.getChildren().add(numberLabel);
         }
         LeaderboardVBox1.getChildren().add(games[i]);
         LeaderboardVBox2.getChildren().add(vsGames[i]);
      }
   }

}
