import java.io.*;
import java.util.ArrayList;

public class Database
{

    private ArrayList<TeamObject> teams = new ArrayList<TeamObject>();
    private ArrayList<Account> accounts = new ArrayList<Account>();
//_______________________________________________________________________________________Constructor
    public Database() throws IOException
    {
        try(FileReader fr = new FileReader("teams.csv");
            BufferedReader br = new BufferedReader(fr))
        {
           String line = br.readLine();
           while(line != null)
           {
                int commaIndex = line.indexOf(",");
                String currentName = line.substring(0, commaIndex);
                int currentPoints = Integer.parseInt(line.substring(commaIndex + 1));
                TeamObject newTeam = new TeamObject(currentName, currentPoints);
                teams.add(newTeam);
                line = br.readLine();
           }
           br.close();
           fr.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Dang");
            try(FileWriter fw = new FileWriter("teams.csv");
                BufferedWriter out = new BufferedWriter(fw))
            {
                //empty csv file to edit with one admin account with account and teams objects
                /*out.write("This is line of text.\n");
                out.write("This is another line of text.\n");
                out.append("This is yet another line of text.\n");*/
                out.close();
                fw.close();
            }
            catch(IOException ex)
            {
                System.out.printf("IO Exception:  %s", ex.getMessage());
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
//____________________________________________________________________________________________seperation of team and account file readers/writers
        try(FileReader fr = new FileReader("accounts.csv");
            BufferedReader br = new BufferedReader(fr))
        {
           String line = br.readLine();
           while(line != null)
           {
                int commaIndex = line.indexOf(",");
                String newUser = line.substring(0, commaIndex);
                String newPassword = line.substring(commaIndex + 1);
                Account newAccount = new Account(newUser, newPassword);
                this.accounts.add(newAccount);
                line = br.readLine();
           }
           br.close();
           fr.close();
        }
        catch(FileNotFoundException e)
        {
            try(FileWriter fw = new FileWriter("accounts.csv");
                BufferedWriter out = new BufferedWriter(fw))
            {
                Account newAccount = new Account("ADMIN", "PASSWORD");
                newAccount.admin();
                out.write(newAccount.getUsername() + "," + newAccount.getPassword());
                out.close();
            }
            catch(IOException ex)
            {
                System.out.printf("IO Exception:  %s", ex.getMessage());
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
//___________________________________________________________________________________Update CSV File (will replace old file with info in arraylists)

    public void updateCSV()
    {
        try(FileWriter fw = new FileWriter("teams.csv");
            BufferedWriter out = new BufferedWriter(fw))
        {
            for(int i = 0; i < teams.size(); i++)
            {
                out.write(String.format("%s,%d%n", teams.get(i).getName(), teams.get(i).getPoints()));
            }
        }
        catch(IOException ex)
        {
            System.out.printf("IO Exception:  %s", ex.getMessage());
        }


        try(FileWriter fw = new FileWriter("accounts.csv");
            BufferedWriter out = new BufferedWriter(fw))
        {
            for(int i = 0; i < accounts.size(); i++)
            {
                out.write(String.format("%s,%s%n",accounts.get(i).getUsername(), accounts.get(i).getPassword()));
            }
        }
        catch(IOException ex)
        {
            System.out.printf("IO Exception:  %s", ex.getMessage());
        }
    }


//________________________________________________________________________________Database editing methods
    public ArrayList<TeamObject> getTeamsList()
    {
        return teams;           //WILL RETURN REFERENCE TYPES. NOT NAMES.
    }

    public ArrayList<Account> getAccountsList()
    {
        return accounts;        //WILL RETURN REFERENCE TYPES. NOT NAMES.
    }

    public int getTeamListSize()
    {
        return teams.size();
    }

    public int getAccountListSize()
    {
        return accounts.size();
    }


    public void addTeam(String teamName, int points)
    {
        TeamObject newTeam = new TeamObject(teamName, points);
        teams.add(newTeam);
    }

    public void addAccount(String username, String password, boolean admin)
    {
        Account newAccount = new Account(username, password);

        if(admin == true)
        {
            newAccount.admin();
        }

        this.accounts.add(newAccount);
    }

    public TeamObject getTeam(String teamName)
    {
        TeamObject returnTeam = new TeamObject(teamName);
        for (int i = 0; i < teams.size(); i++) 
        {
            if(teams.get(i).getName().equals(teamName))
            {
                return teams.get(i);
            }
            else
            {
                returnTeam.setName("NO TEAM");
                returnTeam.setPoints(0);
            }
        }
        return returnTeam; 
    }

    public Account getAccount(String accountName)
    {
        Account returnAccount = new Account("", "");
        for (int i = 0; i < accounts.size(); i++) 
        {
            if(accounts.get(i).getUsername().equals(accountName))
            {
                return accounts.get(i);
            }
            else
            {
                returnAccount.changeUsername("NO ACCOUNT");
                returnAccount.changePassword("NO PASSWORD");
                returnAccount.removeAdmin();
            }
        }
        return returnAccount; 
    }

    public void replaceTeam(String oldTeam, TeamObject team)
    {
        for(int i = 0; i < teams.size(); i++) 
        {
            if(teams.get(i).getName().equals(oldTeam))
            {
                teams.set(i, team);
            }
        }
    }

    public void replaceAccount(String oldAccount, Account account)
    {
        for(int i = 0; i < accounts.size(); i++) 
        {
            if(accounts.get(i).getUsername().equals(oldAccount))
            {
                accounts.set(i, account);
            }
        }
    }

    public void removeTeam(String team)
    {
        for(int i = 0; i < teams.size(); i++) 
        {
            if(teams.get(i).getName().equals(team))
            {
                teams.remove(i);
            }
        }
    }

    public void removeAccount(String account)
    {
        for(int i = 0; i < accounts.size(); i++) 
        {
            if(accounts.get(i).getUsername().equals(account))
            {
                accounts.remove(i);
            }
        }
    }

    public void addPoints(String additionTeam, int pointsGained)
    {
        TeamObject team = getTeam(additionTeam);
        team.addPoints(pointsGained);
        replaceTeam(additionTeam ,team);
    }
}

/*
    Database()
        - Searches for exisiting csv file and reads the data, then places it into a list for you to access
        - If the file does not exist, it will create a new file in it's place. The account.csv will have an admin account automatically.
        - I gave mine the name data. So i use data.(FUNCTION NAME) for the following functions

    getTeamsList() | getAccountsList()
        - RETURNS REFERENCE OBJECTS. USE getName() (teamObject) OR getUsername() (account) TO GET THE NAME
        - returns the list of teams or accounts.
        - Will return the reference objects. Not names, points or passwords. 
        - Must use .getName(), .getPassword() if you want them. Can only do one at a time.

    addTeam("Team Name", int points) | addAccount("Username", "Password", "Admin Boolean")
        - Creates a new team or accounts object. 
        - Use it's versatility when creating new accounts. Can set it to be a variable in your function or give it default values

    getTeam("Team Name") | getAccount("Account username")
        - Returns a team or account OBJECT. Use .getName(), .getPassword() if you want specific information.
        - We can discuss later what should happen if the account is not found.

    replaceTeam("Team Name", new teamObject) | replaceAccount("Account Username", Account Obejct)
        - Search for the team or account and replace it with a new object
        - Must have a team or account object made beforehand.
        - We can discuss later what should happen if the account is not found.

    removeTeam("Team Name") | removeAccount("Account Username")
        - Search for the team or account and remove it from the list
        - We can discuss later what should happen if the account is not found.
    
    addPoints("Team Name", int [POINTS TO BE ADDED])
        - Search for a team and add points to it's current total
        - We can discuss later what should happen if the account is not found.

    updateCSV()
        - Takes current team and account lists and overwrites the CSV file.
        - Un edited data will remain the same since you did not edit it when it was in the arrayList
 */