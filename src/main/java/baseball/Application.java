package baseball;

public class Application {
    private static final int RESTART = 1;
    private static final int EXIT = 2;

    static NonPlayerCharacter npc;
    static Player player;
    static RandomNumber randomNumber;

    public static void main(String[] args) {
        int menu = RESTART;

        player = new Player();

        while (menu != EXIT) {
            randomNumber = RandomNumber.getInstance();
            npc = new NonPlayerCharacter();

            npc.printGameStartNotice();

            guessRandomNumber();

            npc.printGameEndNotice();
            menu = player.selectExitMenu();

            randomNumber.initialize();
        }
    }

    public static void guessRandomNumber() {
        while (true) {
            npc.printNumberInputNotice();
            int playerInput = player.guessRandomNumber();
            npc.countNumberOfBallAndStrike(playerInput);
            npc.printComparisonResult();

            if (playerInput == randomNumber.fullNumber) {
                return;
            }
        }
    }
}
