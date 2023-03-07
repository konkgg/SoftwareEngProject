import java.io.IOException;

public class TestDatabase
{
    public static void main(String[] args) throws IOException 
    {
        Database data = new Database(); //create new database object
        System.out.println("Teams: " + data.getTeamsList() + " Size: " + data.getTeamListSize());   //get List and size methods
        System.out.println("Accounts: " + data.getAccountsList() + " Size: " + data.getAccountListSize()); //^
        data.addTeam("New Team", 25);   //add a new team
        data.addAccount("New Account", "Password", false);  //add a new account

        System.out.println("Update1 Teams: " + data.getTeamsList());
        System.out.println("Update1 Accounts: " + data.getAccountsList());

        System.out.println("Get 'team1': " + data.getTeam("team1").getName() + " Points: " + data.getTeam("team1").getPoints());    //search get a team
        System.out.println("Get 'account2': "+  data.getAccount("account2").getUsername() + " Password: " + data.getAccount("account2").getPassword());
        //search and get an account^

        TeamObject temp = new TeamObject("temp");
        data.replaceTeam("team2", temp);    //search for a team and replace it with new team object
        Account tempA = new Account("tempA", "tempA");  
        data.replaceAccount("account", tempA);  //searh for account and replace with new account object

        data.removeTeam("team3");   //remove a team
        data.removeAccount("account2"); //remove an account

        data.addPoints("temp", 10); //add points

        data.updateCSV();
    }
}