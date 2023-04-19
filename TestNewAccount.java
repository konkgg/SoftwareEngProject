import java.io.IOException;

public class TestNewAccount 
{
    public static void main(String[] args) throws IOException
    {
        Database data = new Database();
        System.out.println("Accounts: " + data.getAccountsList() + " Size: " + data.getAccountListSize()); //^
        System.out.println("Get 'account3': "+  data.getAccount("account3").getUsername() + " Password: " + data.getAccount("account3").getPassword() + " Admin: " + data.getAccount("account3").checkAdmin());
        //data.getAccount("tempA").admin();
        System.out.println(data.getAccount("tempA").checkAdmin());
        data.getAccount("tempA").removeAdmin();
        System.out.println(data.getAccount("tempA").checkAdmin());

        data.updateCSV();
    }
}
