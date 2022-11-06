package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        DataBase data = new DataBase();
        RunGame game = new RunGame();
        data.setAnswer(game.answer);
    }
    static int inputSize = 3;
    static class RunGame {
        List<Integer> answer = new ArrayList<>();
        RunGame() {
            while(answer.size()<inputSize) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!answer.contains(randomNumber)) {
                    answer.add(randomNumber);
                }
            }
        }
    }
}
class DataBase {
    private List<Integer> answer = new ArrayList<>();
    private List<Integer> userInput = new ArrayList<>();
    private int strike = 0;
    private int ball = 0;
    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }
    public void setUserInput(List<Integer> userInput) {
        this.userInput = userInput;
    }
    public void setStrike(int strike) {
        this.strike = strike;
    }
    public void setBall(int ball) {
        this.ball = ball;
    }
}