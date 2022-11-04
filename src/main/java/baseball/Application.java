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
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> answer;
        answer = makeRandomNum();

        while (true) {
            List<Integer> guess = new ArrayList<>();
            System.out.print("숫자를 입력해주세요 : ");
            try {
                userInput = br.readLine();
                if (inputError(userInput))
                    throw new IllegalArgumentException("잘못된 입력입니다. 게임을 종료합니다.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            guess = typeCast(userInput, guess);

            Result result = checkNum(answer, guess);
            if (result.getStrike() == 3) {
                System.out.println(result.getStrike() + "스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                try {
                    String replay = br.readLine();
                    if (replay.equals("1")) {
                        answer = makeRandomNum();
                        continue;
                    } else if (replay.equals("2"))
                        return;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return;
            } else if (result.getStrike() == 0 && result.getBall() == 0)
                System.out.println("낫싱");
            else if (result.getStrike() == 0)
                System.out.println(result.getBall() + "볼");
            else if (result.getBall() == 0)
                System.out.println(result.getStrike() + "스트라이크");
            else
                System.out.println(result.getBall() + "볼 " + result.getStrike() + "스트라이크");

        }
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

    public static boolean inputError(String userInput) {
        if (sizeNotMatch(userInput) || redundant(userInput) || notInteger(userInput))
            return true;
        else
            return false;
    }

    public static boolean sizeNotMatch(String userInput) {
        if (userInput.length() != 3)
            return true;
        else
            return false;
    }

    public static boolean redundant(String userInput) {
        char firstNum = userInput.charAt(0);
        char secondNum = userInput.charAt(1);
        char thirdNum = userInput.charAt(2);
        if (firstNum == secondNum || firstNum == thirdNum || secondNum == thirdNum)
            return true;
        else
            return false;
    }

    public static boolean notInteger(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.charAt(i) < 0 || userInput.charAt(i) > 9)
                return true;
        }
        return false;
    }


    public static List<Integer> typeCast(String userInput, List<Integer> guess) throws IllegalArgumentException {
        for (int i = 0; i < userInput.length(); i++)
            guess.add(userInput.charAt(i) - '0');
        if (redundant(guess) || notInteger(guess) || sizeNotMatch(userInput))
            throw new IllegalArgumentException("잘못된 입력입니다. 게임을 종료합니다.");
        return guess;
    }

    public static class Result {
        public static int strike;
        public static int ball;

        public Result() {
        }

        public Result(int strike, int ball) {
            this.strike = strike;
            this.ball = ball;
        }

        int getStrike() {
            return this.strike;
        }

        int getBall() {
            return this.ball;
        }
    }

    public static Result checkNum(List<Integer> answer, List<Integer> guess) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < guess.size(); i++) {
            if (answer.get(i) == guess.get(i))
                strike++;
            else if (answer.contains(guess.get(i)))
                ball++;
        }
        return new Result(strike, ball);
    }
}
