package baseball;

public class Application {
    private static final int START_GAME = 1;
    private static final int EXIT = 2;

    public static void main(String[] args) {
        NonPlayerCharacter npc;
        Player player;
        RandomNumber randomNumber;

        int menu = START_GAME;

        while (menu == START_GAME) {
            npc = new NonPlayerCharacter();
            player = new Player();
            randomNumber = RandomNumber.getInstance();
            System.out.println("randomNumber = " + randomNumber.fullNumber);
            npc.printGameStartNotice();

            while (true) {
                npc.printNumberInputNotice();
                int playerInput = player.guessRandomNumber();
                npc.countNumberOfBallAndStrike(playerInput);
                npc.printComparisonResult();

                if (playerInput == randomNumber.fullNumber) {
                    break;
                }
            }

            npc.printGameEndNotice();
            menu = player.selectExitMenu();

            randomNumber.initialize();
        }
    }
}
