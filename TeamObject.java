public class TeamObject 
{
    private String teamName;
    private int points;

    public TeamObject(String name)
    {
        this.teamName = name;
        this.points = 0;
    }

    public TeamObject(String name, int points)
    {
        this.teamName = name;
        this.points = points;
    }


    public String getName()
    {
        return teamName;
    }

    public void setName(String name)
    {
        this.teamName = name;
    }

    public int getPoints()
    {
        return points;
    }

    public void setPoints(int newPoints)
    {
        this.points = newPoints;
    }

    public void addPoints(int newPoints)
    {
        this.points += newPoints;
    }
}

/*
 * Create New TeamObject: TeamObject nameString = new TeamObject(nameString)    -- Constructor
 *      setName: nameString.setName(newName)
 *      getName: nameString.getName()
 *      setPoints: nameString.setPoints(int)
 *      getPints: nameString.getPoints()
 *      to add instead of set: nameString.addPoints(int)
 */
