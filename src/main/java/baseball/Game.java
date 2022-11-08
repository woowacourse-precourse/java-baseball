package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.security.spec.ECField;

public class Game {
    public void startGame(Exception exception) {
        System.out.println(GameMessage.START_GAME.getValue());
        Computer computer = new Computer();
//        System.out.println(computer.getAnswer());

        boolean reStartGame = true;

        while (reStartGame) {
            System.out.println(GameMessage.QUESTION__NUMBER.getValue());
            String input = Console.readLine();

            exception.createNumberInputException(input);

            String status = computer.getStatus(input);
            reStartGame = printResultAndQuest(status, computer);
        }
    }

    public int continueGame(Exception exception) {
        System.out.println(GameMessage.QUESTION_CONTINUE.getValue());

        int selectNext = Integer.parseInt(Console.readLine());

        exception.restartException(selectNext);
        // 새시작시 True, 종료 시  false
        return selectNext;
    }

    public boolean printResultAndQuest(String input, Computer computer) {
        if (computer.countStrike(input) == 3) {
            System.out.println(GameMessage.GAME_OVER.getValue());
            return false;
        }
        return true;
    }

}
