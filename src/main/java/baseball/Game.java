package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Game {
    private static final String ONE_TO_NINE_THREE_DIGIT_NUMBER = "^[1-2]";
    private static final String RESTART = "1";
    private static final String END = "2";
    private static final Boolean ON = true;
    private static final Boolean OFF = false;
    private Boolean gamePower;

    public void run() {
        this.gamePower = ON;
        Message.GameMessage.printGameStart();
        while(gamePower) {
            Computer computer = new Computer();
            computer.setComputerBaseballList();
            runStage(computer);
            restartGame();
        }
    }
    private void runStage(Computer computer) {
        User user = new User();
        boolean gameStatus = ON;
        while(gameStatus) {
            Message.GameMessage.printEnterBasebllList();
            user.setBaseballList();
            BaseballList userBaseballList = user.getUserBaseballList();
            int ballCount = computer.getBalls(userBaseballList);
            int strikeCount = computer.getStrikes(userBaseballList);

            if(ballCount == 0 && strikeCount == 0) System.out.println("낫싱");
            if(ballCount > 0 && strikeCount == 0) System.out.println(ballCount + "볼");
            if(ballCount > 0 && strikeCount > 0) System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
            if(ballCount == 0 && strikeCount > 0) System.out.println(strikeCount + "스트라이크");

            if(computer.getStrikes(userBaseballList) == 3) {
                gameStatus = OFF;
                Message.GameMessage.printGameOver();
            }
        }
    }
    private void restartGame() {
        Message.GameMessage.printRestartGame();
        String input = Console.readLine();
        isOneOrTwo(input);
        if(input.equals(RESTART)) {
            this.gamePower = ON;
        }
        if(input.equals(END)) {
            this.gamePower = OFF;
        }
    }

    private void isOneOrTwo(String input) {
        if(!Pattern.matches(ONE_TO_NINE_THREE_DIGIT_NUMBER, input))
            throw new IllegalArgumentException();
    }
}
