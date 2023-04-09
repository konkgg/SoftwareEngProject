import java.util.ArrayList;

public class WeekObject {
    
    private int week;
    private ArrayList<TeamObject> matches;
    private ArrayList<TeamObject> vsMatches;

    public WeekObject() //new schedule constructor
    {
        this.week = 1;
    }

    public WeekObject(int week)
    {
        this.week = week;
    }

    public int getWeek()
    {
        return week;
    }

    public void newMatch(TeamObject team, TeamObject teamTwo)
    {
        matches.add(team);
        vsMatches.add(teamTwo);
    }

    public ArrayList<TeamObject> getMatch(String teamName)
    {
        boolean retrieved = false;
        ArrayList<TeamObject> match = new ArrayList<>();

        for(int i = 0; i < matches.size(); i++)
        {
            if(matches.get(i).getName().equals(teamName))
            {
                retrieved = true;
                match.add(matches.get(i));
                match.add(vsMatches.get(i));
            }
        }

        for(int i = 0; i < vsMatches.size(); i++)
        {
            if(retrieved)
            {
                break;
            }

            if(vsMatches.get(i).getName().equals(teamName))
            {
                retrieved = true;
                match.add(matches.get(i));
                match.add(vsMatches.get(i));
            }
        }

        if(!retrieved)
        {
            //error?
        }

        return match;

    }

    public void cancelMatch(String teamName)   //find team in either list. remove corrosponding team from other list
    {
        boolean canceled = false;
        for(int i = 0; i < matches.size(); i++)
        {
            if(matches.get(i).getName().equals(teamName))
            {
                canceled = true;
                vsMatches.remove(i);
                matches.remove(i);
                return;
            }
        }

        for(int i = 0; i < vsMatches.size(); i++)
        {
            if(vsMatches.get(i).getName().equals(teamName))
            {
                canceled = true;
                matches.remove(i);
                vsMatches.remove(i);
                return;
            }
        }

        if(!canceled)
        {
            //error?
        }
    }

    public ArrayList<TeamObject> getAllMatches()
    {
        ArrayList<TeamObject> weekMatches = new ArrayList<>();

        for(int i = 0; i < matches.size(); i++)
        {
            weekMatches.add(matches.get(i));
            weekMatches.add(vsMatches.get(i));
        }

        return weekMatches;
    }

    

}

/*
    weekObject();
        - brand new schedule with week as 1
        - Empty ArrayList

    WeekObject(int week)
        - new week
        - empty arraylist
        - week is set on creation

    getWeek()
        - returns the week

    newMatch(String teamName, String teamNameTwo)
        - input two teams into method
        - add them into their respective arraylist

    getMatch(String teamName)
        - Search for a team
        - returns that team and the team they are matched with in an arraylist

    cancelMatch(String teamName)
        - search for a team
        - remove that team as well as the team they were matched with

    getAllMatches()
        - appends every match into a single arraylist
        - i is first team, i+1 is the team they are matched with
        - returns an arraylist
 */