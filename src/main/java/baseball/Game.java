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
        while(!end) {
            GameStartString();
            userNumber.setUserNumbers();
            user = userNumber.getNumbers();
            ScoreReset();
            Calculator();

        }
    }
    private void GameStartString() {
        System.out.println(GAME_START_STRING);
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
        }
        return 0;
    }



}
