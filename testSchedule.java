import java.util.ArrayList;

public class testSchedule {
    public static void main(String[] args) {
        ScheduleObject schedule = new ScheduleObject();
        schedule.setName("Summer Tourney");
        System.out.printf("Welcome to the %s!%n", schedule.getName());

        schedule.addWeek(1);
        schedule.addWeek(2);
        schedule.addWeek(3);
        schedule.addWeek(4);
        schedule.addWeek(5);
        schedule.addWeek(6);
        schedule.addWeek();
        System.out.printf("Week %d is currently has %d matches.%n", schedule.getWeek(7).getWeek(), schedule.getWeek(7).getMatchesSize());
        System.out.printf("This tourney will span a total of %d weeks!%n", schedule.getTotalWeeks());

        schedule.removeWeek(6);
        System.out.printf("A week was removed. There are now %d weeks!%n%n", schedule.getTotalWeeks());

        System.out.printf("Let's take a took at the week %d matches!%n", schedule.getWeek(4).getWeek());
        TeamObject teamOne = new TeamObject("Team1");
        TeamObject teamTwo = new TeamObject("Team2");
        TeamObject teamThree = new TeamObject("TeamThree");
        TeamObject teamFour = new TeamObject("TeamFour");

        schedule.getWeek(4).newMatch(teamOne, teamTwo);
        schedule.getWeek(4).newMatch(teamThree, teamFour);

        System.out.printf("There are %d matches for week %d!%n", schedule.getWeek(4).getMatchesSize(), schedule.getWeek(4).getWeek());
        System.out.printf("The matches for this week are as follows: %s%n", declareAllMatches(schedule.getWeek(4).getAllMatches()));


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
