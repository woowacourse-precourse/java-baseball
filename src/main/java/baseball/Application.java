package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        while (true) {
            startGame();
        }

    }

    public static boolean startGame() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int replayFlag = 0;
        String userInput;
        List<Integer> answer;
        answer = makeRandomNum();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            List<Integer> guess = new ArrayList<>();
            System.out.print("숫자를 입력해주세요 : ");
            try {
                userInput = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (inputError(userInput)) {
                throw new IllegalArgumentException();
            }
            guess = typeCast(userInput, guess);
            Result result = checkNum(answer, guess);
            if (correctAnswer(result)) {
                printRight(result);
                replayFlag = replay();          //(replayFlag) =>  1 : 재시작, 2 : 게임종료
            } else {
                printWrong(result);
                replayFlag = 0;                 //(replayFlag) => 0 : 오답, 게임 계속 진행
            }
            if (replayFlag == 1)
                return true;
            else if (replayFlag == 1)
                return false;
            else
                continue;
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
        if (sizeNotMatch(userInput) || notInteger(userInput) || redundant(userInput))
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

    public static boolean notInteger(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.charAt(i) - '0' < 0 || userInput.charAt(i) - '0' > 9)
                return true;
        }
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

    public static List<Integer> typeCast(String userInput, List<Integer> guess) {
        for (int i = 0; i < userInput.length(); i++)
            guess.add(userInput.charAt(i) - '0');
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


    public static boolean correctAnswer(Result result) {
        if (result.getStrike() == 3)
            return true;
        else
            return false;
    }

    public static void printRight(Result result) {
        System.out.println(result.getStrike() + "스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printWrong(Result result) {
        if (result.getStrike() == 0 && result.getBall() == 0)
            System.out.println("낫싱");
        else if (result.getStrike() == 0)
            System.out.println(result.getBall() + "볼");
        else if (result.getBall() == 0)
            System.out.println(result.getStrike() + "스트라이크");
        else
            System.out.println(result.getBall() + "볼 " + result.getStrike() + "스트라이크");
    }

    public static int replay() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String replayInput = null;
        try {
            replayInput = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (replayInput.equals("1")) {
            return 1;
        } else if (replayInput.equals("2"))
            return 2;
        else
            throw new IllegalArgumentException();
    }
}
