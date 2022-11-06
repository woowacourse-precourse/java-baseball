package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;
import org.junit.jupiter.api.Test;

public class Application {
    static int inputSize = 3;
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        DataBase data = new DataBase();
        RunGame game = new RunGame();
        data.setAnswer(game.answer);
        data.setUserInput(game.userInput());

        CompareNumbers strikeBall = new CompareNumbers();
        strikeBall.checkNumber(data.getUserInput(), data.getAnswer());
        data.setBall(strikeBall.ball);
        data.setStrike(strikeBall.strike);
    }
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
        public List<Integer> userInput() {
            List<Integer> intUserInput = new ArrayList<>();
            String[] stringUserInput = {};
            stringUserInput = Console.readLine().split("");
            for (String number : stringUserInput) {
                intUserInput.add(Integer.parseInt(number));
            }
            return intUserInput;
        }
    }
}

class CompareNumbers {
    int strike = 0;
    int ball = 0;
    public void checkNumber(List<Integer> userInput, List<Integer> answer) {
        for(int number : userInput) {
            if (answer.contains(number)) {
                ball++;
            }
        }
        for(int i = 0; i < userInput.size(); i++) {
            if(userInput.get(i) == answer.get(i)) {
                strike++;
                ball--;
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
    public List<Integer> getAnswer() {
        return this.answer;
    }
    public void setUserInput(List<Integer> userInput) {
        this.userInput = userInput;
    }
    public List<Integer> getUserInput() {
        return this.userInput;
    }
    public void setStrike(int strike) {
        this.strike = strike;
    }
    public int getStrike() {
        return this.strike;
    }
    public void setBall(int ball) {
        this.ball = ball;
    }
    public int getBall(){
        return this.ball;
    }
}