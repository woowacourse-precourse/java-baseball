package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        List<Integer> guess = new ArrayList<>();
        try {
            userInput = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            guess = typeCast(userInput, guess);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
            return;
        }
        List<Integer> answer;
        answer = makeRandomNum();
    }

    public static List<Integer> makeRandomNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber))
                computer.add(randomNumber);
        }
        return computer;
    }

    public static boolean redundant(List<Integer> guess) {
        if (guess.get(0) == guess.get(1) || guess.get(0) == guess.get(2) || guess.get(1) == guess.get(2))
            return true;
        else
            return false;
    }

    public static boolean notInteger(List<Integer> guess) {
        for (int i = 0; i < guess.size(); i++) {
            if (guess.get(i) < 0 || guess.get(i) > 9)
                return true;
        }
        return false;
    }

    public static List<Integer> typeCast(String userInput, List<Integer> guess) throws IllegalArgumentException {
        for (int i = 0; i < userInput.length(); i++)
            guess.add(userInput.charAt(i) - '0');
        if (redundant(guess) || notInteger(guess))
            throw new IllegalArgumentException("잘못된 입력입니다. 게임을 종료합니다.");
        return guess;
    }
    public static class Result{
        public static int strike;
        public static int ball;
        public Result(){
        }
        public Result(int strike,int ball){
            this.strike=strike;
            this.ball=ball;
        }
        int getStrike(){
            return this.strike;
        }
        int getBall(){
            return this.ball;
        }
    }
}
