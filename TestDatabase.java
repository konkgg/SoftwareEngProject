import java.io.IOException;
import java.util.ArrayList;

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

        ScheduleObject schedule = data.getSchedule();   //reference object
        schedule.setName("Spring Tourney");
        System.out.printf("Welcome to the %s!%n", schedule.getName());
        System.out.printf("This tourney will span a total of %d weeks!%n", schedule.getTotalWeeks());
        System.out.printf("Let's take a took at the week %d matches!%n", schedule.getWeek(4).getWeek());
        TeamObject teamOne = new TeamObject("newTeamOne");
        TeamObject teamTwo = new TeamObject("newTeamTwo");
        schedule.getWeek(4).newMatch(teamOne, teamTwo);
        System.out.printf("There are %d matches for week %d!%n", schedule.getWeek(4).getMatchesSize(), schedule.getWeek(4).getWeek());
        System.out.printf("The matches for this week are as follows: %s%n", declareAllMatches(schedule.getWeek(4).getAllMatches()));
        System.out.println(declareAllMatches(data.getSchedule().getWeek(4).getAllMatches()));   //creating a reference object for schedule will work on the original


        data.updateCSV();
    }

    public static String declareSingleMatch(ArrayList<TeamObject> match)
    {
        String declaration = "";
        String firstTeam = match.get(0).getName();
        String secondTeam = match.get(1).getName();
        declaration = String.format("%s vs %s ", firstTeam, secondTeam);
        return declaration;
    }

    public static String declareAllMatches(ArrayList<TeamObject> match)
    {
        String declaration = "";
        
        for(int i = 0; i < match.size() - 1; i++)
        {
            ArrayList<TeamObject> currentMatch = new ArrayList<>();
            currentMatch.add(match.get(i));
            currentMatch.add(match.get(i+1));
            declaration += declareSingleMatch(currentMatch);
            i++;
        }

        return declaration;
    }
}

//schedule object does not have a matchmaking method. This will have to be done manually.