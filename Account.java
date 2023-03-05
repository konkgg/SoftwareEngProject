public class Account
{
    private String username;
    private String password;
    private boolean admin;

    public Account(String username, String password)
    {
        this.username = username;
        this.password = password;
        this.admin = false;
    }

    public void changeUsername(String newName)
    {
        this.username = newName;
    }

    public String getUsername()
    {
        return username;
    }

    public void changePassword(String newPass)
    {
        this.password = newPass;
    }

    public String getPassword()
    {
        return password;
    }

    public void admin()
    {
        this.admin = true;
    }

    public boolean checkAdmin()
    {
        return admin;
    }

    public boolean checkCredential(String passwordInput)
    {
        if(passwordInput.equals(this.password))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

/*
 *  create Account object: Account name = new Account(String username, String password);
 *  change username: name.changeUsername(String);
 *  get username: name.getUsername();
 *  change password: name.changePassword(String);
 *  get password: name.getPassword();
 *  make the account and admin account: name.admin();
 *  check if account is an admin: name.checkAdmin();
 *  check credentials: name.checkCredential();
 */