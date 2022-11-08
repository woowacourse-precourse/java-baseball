package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import util.Util;

public class BaseBallGame {

    public void run() {
        System.out.println(MessageList.GAME_START);
        while (true) {
            startGame();
            if (!isRestart()) {
                break;
            }
        }
    }

    private void startGame() {
        List<Integer> computer = Util.makeRandomNumbers();
        String input;

        while (true) {
            System.out.print(MessageList.INPUT);
            input = Console.readLine();
            InputException.validGameInput(input);

            List<Integer> inputNumbers = Util.toIntegerArray(input);
            String message = takeTurn(computer, inputNumbers);
            System.out.println(message);
            if (isEnd(message)) {
                break;
            }
        }
    }

    private boolean isRestart() {
        System.out.println(MessageList.RESTART_OR_END);
        String input = Console.readLine();
        InputException.validRestartInput(input);
        if (input.contains("1")) {
            return true;
        }
        return false;
    }

    private String takeTurn(List<Integer> computer, List<Integer> inputNumbers) {
        String message = countBall(computer, inputNumbers) + countStrike(computer, inputNumbers);
        return checkMessage(message);
    }

    private boolean isEnd(String message) {
        return message.contains("게임 종료");
    }

    public String checkMessage(String message) {
        if (message.isEmpty()) {
            message = MessageList.NOTHING;
        }
        if (message.contains("3스트라이크")) {
            message += MessageList.ALL_CORRECT;
        }
        return message;
    }

    public String countStrike(List<Integer> computer, List<Integer> inputNumbers) {
        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(inputNumbers.get(i))) {
                strikes++;
            }
        }
        return MessageList.setStrikeMessage(strikes);
    }

    public String countBall(List<Integer> computer, List<Integer> inputNumbers) {
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            Integer inputNumber = inputNumbers.get(i);
            if (!computer.get(i).equals(inputNumber) && computer.contains(inputNumber)) {
                balls++;
            }
        }
        return MessageList.setBallMessage(balls);
    }
}
