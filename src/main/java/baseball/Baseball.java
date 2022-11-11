package baseball;

import static baseball.GameOption.*;
import static baseball.Hint.*;
import static baseball.Message.*;
import static baseball.NumberOption.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Baseball {

    private static final String ANSWER = "3스트라이크";

    public void notifyGameStart() {
        System.out.println(GAME_START_MESSAGE.getValue());
    }

    public void startGame() throws IllegalArgumentException {
        List<Integer> computerNumbers = createComputerNumbers();
        boolean isCorrectAnswer = false;
        while (!isCorrectAnswer) {
            List<Integer> userNumbers = InputUserNumber();
            String hint = getHint(computerNumbers, userNumbers);
            System.out.println(hint);
            isCorrectAnswer = isCorrectAnswer(hint);
        }
        gameOver();
    }

    public List<Integer> createComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < COUNT.getValue()) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE.getValue(), END_INCLUSIVE.getValue());
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

    public List<Integer> InputUserNumber() throws IllegalArgumentException {
        System.out.print(INPUT_USER_NUMBER_MESSAGE.getValue());
        String userNumbers = Console.readLine();
        validUserNumbers(userNumbers);
        return Arrays.stream(userNumbers.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public String getHint(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int ballCnt = getBallCnt(computerNumbers, userNumbers);
        int strikeCnt = getStrikeCnt(computerNumbers, userNumbers);
        ballCnt -= strikeCnt;

        if (ballCnt == 0 && strikeCnt == 0) {
            return NOTHING.getValue();
        } else if (strikeCnt == 0) {
            return String.format(BALL.getValue(), ballCnt);
        } else if (ballCnt == 0) {
            return String.format(STRIKE.getValue(), strikeCnt);
        } else {
            return String.format(BALL_AND_STRIKE.getValue(), ballCnt, strikeCnt);
        }
    }

    public void gameOver() throws IllegalArgumentException {
        System.out.println(GAME_OPTION_MESSAGE.getValue());
        String gameOption = Console.readLine();
        validGameOption(gameOption);
        if (gameOption.equals(RESTART_GAME.getValue())) {
            startGame();
        } else if (gameOption.equals(GAME_OVER.getValue())) {
            System.out.println(CLOSE_MESSAGE.getValue());
        }
    }

    private boolean isCorrectAnswer(String hint) {
        if (hint.equals(ANSWER)) {
            System.out.println(CONGRATULATION_MESSAGE.getValue());
            return true;
        }
        return false;
    }

    private int getStrikeCnt(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strikeCnt = 0;
        for (int loc = 0; loc < userNumbers.size(); loc++) {
            if (computerNumbers.get(loc).equals(userNumbers.get(loc))) {
                strikeCnt++;
            }
        }

        return strikeCnt;
    }

    private int getBallCnt(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int ballCnt = 0;
        for (Integer userNumber : userNumbers) {
            if (computerNumbers.contains(userNumber)) {
                ballCnt++;
            }
        }
        return ballCnt;
    }

    private void validUserNumbers(String userNumbers) throws IllegalArgumentException {
        if (!userNumbers.matches("^[1-9]{3}$")) {
            throw new IllegalArgumentException(INPUT_USER_NUMBER_ERROR_MESSAGE.getValue());
        }
        if (userNumbers.charAt(0) == userNumbers.charAt(1) ||
                userNumbers.charAt(0) == userNumbers.charAt(2) ||
                userNumbers.charAt(1) == userNumbers.charAt(2)) {
            throw new IllegalArgumentException(INPUT_USER_NUMBER_ERROR_MESSAGE.getValue());
        }
    }

    private void validGameOption(String inputGameOption) throws IllegalArgumentException {
        if (!inputGameOption.matches("^[1-2]$")) {
            throw new IllegalArgumentException(GAME_OPTION_ERROR_MESSAGE.getValue());
        }
    }

}
