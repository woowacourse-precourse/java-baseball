package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NumberBaseballGame {
    private static final String START_TEXT = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_TEXT = "숫자를 입력해주세요 : ";
    private static final String RESULT_TEXT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_TEXT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String STRIKE_TEXT = "스트라이크 ";
    private static final String BALL_TEXT = "볼 ";
    private static final String NOTHING_TEXT = "낫싱";

    private final Answer answer = new Answer();
    private List<Integer> computerNumber = new ArrayList<>();
    private List<Integer> inputNumber = new ArrayList<>();

    public void startGame() {
        System.out.println(START_TEXT);
        computerNumber = answer.generateAnswer();

        while (true) {
            System.out.println(INPUT_TEXT);
            String userInput = Console.readLine();
            UserInputException.checkUserNumberInput(userInput);
            inputNumber = changeStringToList(userInput);

            Score userScore = new Score();
            playGame(userScore);

            String result = getResult(userScore);
            System.out.println(result);

            if (userScore.getStrike() == 3) {
                System.out.println(RESTART_TEXT);
                break;
            }
        }

        System.out.println(RESTART_TEXT);
        String restartFlag = Console.readLine();
        UserInputException.checkUserRestartInput(restartFlag);
        if (restartGame(restartFlag)) startGame();
    }

    public List<Integer> changeStringToList(String userInput) {
        List<Integer> changedList = new ArrayList<>();

        for (char digit : userInput.toCharArray()) {
            changedList.add(Character.getNumericValue(digit));
        }
        return changedList;
    }

    public void playGame(Score score) {
        for (int i=0; i<3; i++) {
            if (Objects.equals(computerNumber.get(i), inputNumber.get(i))) {
                score.setStrike(score.getStrike() + 1);
                continue;
            }
            if (computerNumber.contains(inputNumber.get(i))) {
                score.setBall(score.getBall() + 1);
            }
        }
    }

    public String getResult(Score score) {
        int strike = score.getStrike();
        int ball = score.getBall();

        if (strike == 0 && ball == 0) {
            return NOTHING_TEXT;
        }

        StringBuilder result = new StringBuilder();
        if (ball > 0) {
            result.append(ball);
            result.append(BALL_TEXT);
        }
        if (strike > 0) {
            result.append(strike);
            result.append(STRIKE_TEXT);
        }
        return result.toString();
    }

    public boolean restartGame(String restartFlag) {
        return restartFlag.equals("1");
    }
}
