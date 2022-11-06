package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private static final int MAX_STRIKE = 3;
    private static final String END = "1";
    private static final String RESTART = "2";
    private  int ballCount;
    private int strikeCount;
    private String userNumber;
    private String computerNumber;

    public BaseballGame() {}

    public BaseballGame(String user, String computer) {
        this.ballCount = 0;
        this.strikeCount = 0;
        this.userNumber = user;
        this.computerNumber = computer;
    }

    public void start() {
        System.out.println(GameMessage.start);
    }

    public boolean isStrike() {
        boolean isStrike = false;

        for (int strikeCountIndex = 0; strikeCountIndex < computerNumber.length(); strikeCountIndex++) {
            if (computerNumber.charAt(strikeCountIndex) == (userNumber.charAt(strikeCountIndex))) {
                strikeCount++;
                isStrike = true;
            }
        }

        return isStrike;
    }

    public void isBall() {
        for (int ballCountIndex = 0; ballCountIndex < computerNumber.length(); ballCountIndex++) {
            if ((computerNumber.contains(userNumber.charAt(ballCountIndex) + "")) && (userNumber.charAt(ballCountIndex) != computerNumber.charAt(ballCountIndex))) {
                ballCount++;
            }
        }
    }

    public void printCompareResult(){
        String result = "";

        if ((strikeCount == 0) && (ballCount == 0)) {
            result += GameMessage.nothing;
        }
        if ((strikeCount == 0) && (ballCount != 0)) {
            result += (ballCount + GameMessage.ball);
        }
        if ((strikeCount != 0) && (ballCount == 0)) {
            result += (strikeCount + GameMessage.strike);
        }
        if ((strikeCount != 0) && (ballCount != 0)) {
            result += (ballCount + GameMessage.ball);
            result += " ";
            result += (strikeCount + GameMessage.strike);
        }

        System.out.println(result);

        if (isThreeStrike()) {
            System.out.println(GameMessage.end);
        }
    }

    public boolean isThreeStrike() {
        boolean threeStrike = false;

        if (strikeCount == MAX_STRIKE) {
            threeStrike = true;
        }

        return threeStrike;
    }

    public boolean isRestart() {
        System.out.println(GameMessage.restart);

        String restartCheckNumber = Console.readLine();
        restartException(restartCheckNumber);

        return restartCheckNumber.equals(RESTART);
    }

    public void restartException(String restartCheckNumber) {
        if ((!restartCheckNumber.equals(END)) && (!restartCheckNumber.equals(RESTART))) {
            throw new IllegalArgumentException();
        }
    }
}
