package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static baseball.Constant.*;

public class Game {

    public void startProgram() {
        Computer computer = new Computer();
        computer.setRandomNumber();
        startGame(computer.getComputerNumber());
        if (finishGame())
            startProgram();
    }

    private void startGame(List<Integer> computerNumber) {
        User user = new User();
        String gameScore = "";

        while (!gameScore.equals(ALL_STRIKE)) {
            user.inputNumber();
            gameScore = getHint(user.getUserNumber(), computerNumber);
            System.out.println(gameScore);
        }
    }

    private boolean finishGame() throws IllegalArgumentException {
        System.out.println(ALL_STRIKE_SENTENCE);
        System.out.println(EXIT_SENTENCE);
        String input = Console.readLine();

        if (!isRightAnswer(input))
            throw new IllegalArgumentException();

        if (input.equals(START_CODE))
            return true;
        return false;
    }

    public String getHint(String userNumber, List<Integer> computerNumber) {

        List<Integer> scoreList = calculateScore(userNumber, computerNumber);
        StringBuilder sb = new StringBuilder();

        if (scoreList.get(0) == 0 && scoreList.get(1) == 0) {
            return NOTHING;
        }
        if (scoreList.get(0) > 0) {
            sb.append(scoreList.get(0)).append(BALL);
        }
        if (scoreList.get(1) > 0) {
            sb.append(scoreList.get(1)).append(STRIKE);
        }
        return sb.toString();
    }

    private List<Integer> calculateScore(String userNumber, List<Integer> computerNumber) {

        int ballCount = getBallCount(userNumber, computerNumber);
        int strikeCount = getStrikeCount(userNumber, computerNumber);

        return List.of(ballCount - strikeCount, strikeCount);
    }

    private int getBallCount(String userNumber, List<Integer> computerNumber) {
        int ball = 0;

        for (int i = 0; i < CNT_NUMBER; i++) {
            if (computerNumber.contains(Character.getNumericValue(userNumber.charAt(i))))
                ball += 1;
        }
        return ball;
    }

    private int getStrikeCount(String userNumber, List<Integer> computerNumber) {
        int strike = 0;

        for (int i = 0; i < CNT_NUMBER; i++) {
            if (computerNumber.get(i) == (Character.getNumericValue(userNumber.charAt(i))))
                strike += 1;
        }
        return strike;
    }

    public boolean isRightAnswer(String input) {
        Pattern pattern = Pattern.compile("[1-2]");
        return pattern.matcher(input).matches();
    }

}
