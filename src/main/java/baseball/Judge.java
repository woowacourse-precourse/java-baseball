package baseball;

import java.util.*;

/*
 * 입력값과 정답을 판정
 * 힌트 출력
 */
public class Judge {

    private String NOTHING = "낫싱";
    private String STRIKE = "스트라이크";
    private String BALL = "볼";
    private String GAMEOVER = "3개의 숫자를 모두 맞히셨습니다! 게임종료";

    private List<String> answer = new ArrayList<String>();
    private List<String> input = new ArrayList<String>();

    private int ball = 0;
    private int strike = 0;

    private int ballCode = 2;
    private int strikeCode = 1;

    public void setAnswerToJudge(String answer, String input) {
        this.answer = Arrays.asList(answer.split(""));
        this.input = Arrays.asList(input.split(""));
    }

    public void resetScore() {
        this.ball = 0;
        this.strike = 0;
    }

    public int isStrikeOrBall(int index) {
        for (int i = 0; i < 3; i++) {
            if (answer.get(i).equals(input.get(index)) && i == index) {
                return strikeCode;
            }
            if (answer.get(i).equals(input.get(index))) {
                return ballCode;
            }
        }
        return -1;
    }

    public void getScore() {
        for (int i = 0; i < input.size(); i++) {
            int score = isStrikeOrBall(i);
            if (score == ballCode) {
                ball++;
                continue;
            }
            if (score == strikeCode) {
                strike++;
            }
        }
    }

    public boolean isGameOver() {
        if (strike == 3) {
            return true;
        } else {
            return false;
        }
    }

    public String makeResultString()
    {
        String resultString = "";
        if(ball == 0 && strike == 0)
        {
            resultString = NOTHING;
        }
        else
        {
            if(ball > 0)
            {
                resultString += ball + " " + BALL;
            }
            if(strike > 0)
            {
                resultString += strike + " " + STRIKE;
            }
        }

        if(isGameOver())
        {
            resultString += "\n" + GAMEOVER;
        }

        return resultString;
    }
}
