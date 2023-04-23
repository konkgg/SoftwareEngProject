import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginController {

    @FXML
    private AnchorPane MainPane;

    @FXML
    private Button loginButton1;

    @FXML
    private TextField passwordField1;

    @FXML
    private TextField usernameField1;

    @FXML
    void loginPressed(ActionEvent event) throws IOException{
        ArrayList<Account> accountsList = ChessMasterController.getDB().getAccountsList();
        Account thisAccount = new Account("null", "null");
        boolean correctCredentials = false;

        for(int i = 0; i < accountsList.size(); i++)
        {
            if(accountsList.get(i).checkCredential(usernameField1.getText(), passwordField1.getText()))
            {
                thisAccount = accountsList.get(i);
                correctCredentials = true;
                break;
            }
        }

        if(correctCredentials)
        {
            System.out.println("Username:" + thisAccount.getUsername());
            System.out.println("Password:" + thisAccount.getPassword());
            System.out.println("Admin: " + thisAccount.checkAdmin());
        }

    }

}
