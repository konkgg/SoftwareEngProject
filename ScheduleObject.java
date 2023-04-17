import java.util.ArrayList;

public class ScheduleObject {
    
    private String tourneyName;
    private ArrayList<WeekObject> schedule;

    public ScheduleObject()
    {
        this.tourneyName = "New Schedule";
        schedule = new ArrayList<WeekObject>();
    }

    public void setName(String newName)
    {
        this.tourneyName = newName;
    }

    public String getName()
    {
        return tourneyName;
    }

    public void addWeek()
    {
        WeekObject newWeek = new WeekObject(getTotalWeeks()+1);
        schedule.add(newWeek);
    }

    public void addWeek(int weekNumber)
    {
        WeekObject newWeek = new WeekObject(weekNumber);
        schedule.add(newWeek);
    }

    public void removeWeek(int weekNumber)
    {
        schedule.remove(getWeekIndex(weekNumber));
    }

    public int getTotalWeeks()
    {
        return schedule.size();
    }


    public int getWeekIndex(int weekNumber)
    {
        int weekIndex = -1;
        for(int i = 0; i < schedule.size(); i++)
        {
            if(schedule.get(i).getWeek() == weekNumber)
            {
                weekIndex = i;
                break;
            }
        }

        return weekIndex;
    }

    public WeekObject getWeek(int weekNumber)
    {
        int weekIndex = -1;
        for(int i = 0; i < schedule.size(); i++)
        {
            if(schedule.get(i).getWeek() == weekNumber)
            {
                weekIndex = i;
                break;
            }
        }

        return schedule.get(weekIndex);
    }
}

/*
    ScheduleObject()
        - Create a new object with an empty list

    setName(String newName)
        - give the shedule a new name

    getName()
        - get the name

    addWeek()
        - creates a new week at the end
    
    addWeek(int weekNumber)
        - create a new week and add it to the list

    removeWeek(int weekNumber)
        - input a week number
        - find and remove it from the list

    getTotalWeeks()
        - return number of weeks as an int

    getWeekIndex(int weekNumber)                                    <----------------- This is the main function
        - search the arraylist for a week using the week number
        - Use this method to edit the week applying the methods that the weekObject contains
    
 */