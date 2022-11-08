package baseball.serviceImpl;

import baseball.service.DigitGeneratorImpl;
import baseball.util.Digits;
import baseball.util.GameMessage;
import baseball.util.GameStatus;
import baseball.domain.StrikeAndBallDomain;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    public void starGame() {
        sendMassage(GameMessage.START_MASSAGE);

        GameStatus restartOrEnd = GameStatus.START;
        while (restartOrEnd != GameStatus.END) {
            List<Integer> computer = getComputerDigits(new ComputerDigitGeneratorService());
            figureOutComputerDigits(computer);
            restartOrEnd = getRestartOrEndGame();
        }
    }

    private void figureOutComputerDigits(List<Integer> computer) {
        boolean answer = false;
        while (!answer) {
            sendMassage(GameMessage.INPUT_NUMBER);
            List<Integer> user = getUserDigits(userInput());
            answer = calculationDigits(computer, user);
        }
    }

    private GameStatus getRestartOrEndGame() {
        sendMassage(GameMessage.ANSWER);
        sendMassage(GameMessage.RESTART_OR_END);
        if (isRestart(Console.readLine())) {
            return GameStatus.START;
        }
        return GameStatus.END;
    }

    public void sendMassage(GameMessage massage) {
        System.out.print(massage.getMassage());
    }

    private boolean calculationDigits(List<Integer> computer, List<Integer> user) {
        StrikeAndBallDomain strikeAndBallDomain = new StrikeAndBallDomain();
        strikeAndBallDomain.isStrikeOrBall(computer, user);
        GameMessage gameMassage = strikeAndBallDomain.getResult();

        sendMassage(gameMassage);

        return gameMassage == GameMessage.THREE_STRIKE;
    }

    private boolean isRestart(String str) {
        String regex = "[1]{1,1}";
        if (str.length() == 1) {
            return str.matches(regex);
        }
        return false;
    }

    private void checkDuplicatedDigits(List<Integer> values, boolean[] visited, int digit) {
        if (!visited[digit]) {
            values.add(digit);
            visited[digit] = true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> inputToDigits(String input) throws IllegalArgumentException {
        boolean[] visited = new boolean[Digits.LAST.getDigit() + 1];
        List<Integer> values = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            int digit = input.charAt(i) - '0';
            checkDuplicatedDigits(values, visited, digit);
        }
        return values;
    }

    private boolean isValid(String digits) {
        String isDigitRegex = "[1-9]{3,3}";
        return digits.matches(isDigitRegex);
    }

    private List<Integer> digits(String digits) {
        if (isValid(digits)) {
            return inputToDigits(digits);
        }
        throw new IllegalArgumentException();
    }

    private String userInput(){
        return Console.readLine();
    }

    public List<Integer> getUserDigits(String input) throws IllegalArgumentException {
        return digits(input);
    }

    public List<Integer> getComputerDigits(DigitGeneratorImpl generator) throws IllegalArgumentException {
        String computerDigits = generator.generator();
        return digits(computerDigits);
    }
}
