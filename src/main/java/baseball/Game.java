package baseball;

public class Game {
    private String computer;
    private String player;
    private int strike;

    public Game() {
    }

    public void start() {
        Number playerNumber = new Number();
        Number computerNumber = new Number();

        computerNumber.setRandomNumber();
        playerNumber.setNumber();

        computer = computerNumber.getNumber();
        player = playerNumber.getNumber();

        strike = countStrike(computer, player);
    }

    private int countStrike(String random, String input) {
        int count = 0;
        for (int i = 0; i < random.length(); i++) {
            count += isStrike(random.charAt(i), input.charAt(i));
        }
        return count;
    }

    private int isStrike(Character a, Character b) {
        if (a == b) {
            return 1;
        }
        return 0;
    }
}
