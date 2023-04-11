import java.util.ArrayList;

public class testWeekObject {
    
    public static void main(String[] args) {
        WeekObject testWeek = new WeekObject();

        int testWeekNumber = testWeek.getWeek();
        TeamObject teamOne = new TeamObject("Team1");
        TeamObject teamTwo = new TeamObject("Team2");
        TeamObject teamThree = new TeamObject("TeamThree");
        TeamObject teamFour = new TeamObject("TeamFour");

        testWeek.newMatch(teamOne, teamTwo);
        testWeek.newMatch(teamThree, teamFour);
        int currentSize = testWeek.getMatchesSize();

        System.out.println("Get ready for these week " + testWeekNumber + " matches!\nThere are " + currentSize + " total matches!");
    
        ArrayList<TeamObject> findMatch = testWeek.getMatch("Team1");
        System.out.println("Upcoming Match: " + declareSingleMatch(findMatch));

        ArrayList<TeamObject> matches = testWeek.getAllMatches();
        System.out.println("Here are this weeks matches: " + declareAllMatches(matches));

        testWeek.cancelMatch("TeamThree");

        ArrayList<TeamObject> updatedMatches = testWeek.getAllMatches();
        System.out.println("Here is the updated matches: " + declareAllMatches(updatedMatches));

        


        WeekObject testWeekTwo = new WeekObject(2);
        System.out.println("Be sure to look our for upcoming week" + testWeekTwo.getWeek() + "!!!");

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
