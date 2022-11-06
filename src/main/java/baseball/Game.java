package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {

    final private int COUNT_START = 0;
    final private int COUNT_FIN = 3;
    final private int STRIKE_NUM = 1;
    final private int BALL_NUM = 2;
    final private String GAME_START_STRING = "숫자 야구 게임을 시작합니다.";
    final private String NOTHING_STRING = "낫싱";
    final private String GAME_OVER_STRING = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    final private String BALL_STRING = "볼 ";
    final private String STRIKE_STRING = "스트라이크";
    final private String END_STRING = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    final private String REGEX = "[1-2]";
    final private String END_NUM = "2";


    private int[] user;
    private int[] computer;

    private int strike = COUNT_START;
    private int ball = COUNT_START;
    private boolean end = false;
    public Game() {
    }

    public void GameStart() {
        Number userNumber = new Number();
        Number computerNumber = new Number();

        computerNumber.setComputerNumbers();
        computer = computerNumber.getNumbers();
        GameStartString();

        while(!end) {
            userNumber.setUserNumbers();
            user = userNumber.getNumbers();

            ScoreReset();
            Calculator();
            printResult();

            if (strike == COUNT_FIN) {
                GameOver(computerNumber);
            }
        }
    }
    private void GameStartString() {
        System.out.println(GAME_START_STRING);
    }
    private void GameOver(Number computerNumber) {
        String input = getGameOver();
        if (END_NUM.equals(input)) {
            end = true;
        } else {
            computerNumber.setComputerNumbers();
            computer = computerNumber.getNumbers();
            GameStartString();
        }

    }

    private String getGameOver() {
        System.out.println(END_STRING);
        String input = Console.readLine();
        if (!WrongInput(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }
    private boolean WrongInput(String input) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(input);
        return pattern.matcher(input).matches();
    }
    private void ScoreReset() {
        strike = COUNT_START;
        ball = COUNT_START;
    }

    private void Calculator() {
        int i = COUNT_START;
        while (i < COUNT_FIN) {
            int currentScore = StrikeVsBall(user[i], i);
            if (currentScore == STRIKE_NUM) {
                strike += 1;
            }
            if (currentScore == BALL_NUM) {
                ball += 1;
            }
            i++;
        }
    }

    private int StrikeVsBall(int number, int index) {
        int i = COUNT_START;
        while (i < COUNT_FIN) {
            if (computer[i] == number && i == index) {
                return STRIKE_NUM;
            }
            if (computer[i] == number) {
                return BALL_NUM;
            }
            i++;
        }
        return 0;
    }

    private String getResult() {
        if (strike == COUNT_START && ball == COUNT_START) {
            return NOTHING_STRING;
        }
        StringBuilder stringBuilder = new StringBuilder();

        if (ball > COUNT_START) {
            stringBuilder.append(ball);
            stringBuilder.append(BALL_STRING);
        }
        if (strike > COUNT_START) {
            stringBuilder.append(strike);
            stringBuilder.append(STRIKE_STRING);
        }
        return stringBuilder.toString();
    }

    private void printResult() {
        System.out.println(getResult());
        if (strike == COUNT_FIN) {
            System.out.println(GAME_OVER_STRING);
        }
    }
}
