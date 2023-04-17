public class TestTeam
{
    public static void main(String[] args) {
        TeamObject teamOne = new TeamObject("Dalton State College");
        teamOne.setPoints(15);
        System.out.printf("The team is %s and they have %d points.%n", teamOne.getName(), teamOne.getPoints());
        teamOne.setName("Kennesaw State University");
        teamOne.setPoints(teamOne.getPoints() + 10);
        System.out.printf("The team is %s and they have %d points.%n", teamOne.getName(), teamOne.getPoints());
        teamOne.addPoints(10);
        System.out.printf("Team one now has %d points!", teamOne.getPoints());
    }
}