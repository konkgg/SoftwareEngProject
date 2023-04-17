public class TestAdmin
{
    public static void main(String[] args) {
        Account test = new Account("testUser", "testPass");

        System.out.printf("This username is %s, the password is %s, and are they admin? %b%n", test.getUsername(), test.getPassword(), test.checkAdmin());

        test.changeUsername("newUser");
        test.changePassword("newPass");
        test.admin();

        System.out.printf("This username is %s, the password is %s, and are they admin? %b%n", test.getUsername(), test.getPassword(), test.checkAdmin());


        System.out.printf("I will input password for the password. Validation: %b%n", test.checkCredential("password"));
        System.out.printf("I will input newPass for the password. Validation: %b%n", test.checkCredential("newPass"));

    }
}