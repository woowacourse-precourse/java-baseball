package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;
import java.util.function.Consumer;

public class Application {

    public static void main(String[] args) {
        boolean isRunning = true;
        boolean isFinished = true;
        Output.printStartingMent();
        while (isRunning && isFinished) {
            isFinished = false;
            Database data = new Database();
            data.setAnswer(GameManager.createAnswer());
            while (!isFinished) {
                data.setUserInput(Input.whileRunning());
                ExceptionChecker.checkGuessingInput(data.getUserInput());
                data.setBallCount(Referee.judge(data.getUserInput(), data.getAnswer())[0]);
                data.setStrikeCount(Referee.judge(data.getUserInput(), data.getAnswer())[1]);
                Output.printResult(data.getStrikeCount(), data.getBallCount());
                isFinished = GameManager.isFinish(data.getStrikeCount());
                isRunning = GameManager.isAgain(isFinished);
            }
        }
        Output.printFinishingMent();
    }
}

class GameManager {

    static int restart = 1;
    static int terminate = 2;

    public static List<Integer> createAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }

    public static boolean isFinish(int strike) {
        return strike == 3;
    }

    public static boolean isAgain(boolean isFinished) {
        int userInput = -1;
        if (isFinished) {
            userInput = Integer.parseInt(Console.readLine());
            ExceptionChecker.checkAfterGameInput(userInput);
        }
        if (isRestart(userInput)) {
            return true;
        }
        if (isTerminate(userInput)) {
            return false;
        }
        return true;
    }

    public static boolean isRestart(int userInput) {
        return userInput == restart;
    }

    public static boolean isTerminate(int userInput) {
        return userInput == terminate;
    }
}

class Input {

    static List<Integer> whileRunning() {
        List<Integer> intUserInput = new ArrayList<>();
        String[] stringUserInput = {};
        System.out.print("숫자를 입력해주세요 : ");
        stringUserInput = Console.readLine().split("");
        for (String number : stringUserInput) {
            intUserInput.add(Integer.parseInt(number));
        }
        return intUserInput;
    }
}

class Output {

    static void printResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
        }
        if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        }
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }

    public static void printStartingMent() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printFinishingMent() {
        System.out.println("게임 종료");
    }
}

class Referee {

    static int[] judge(List<Integer> userInput, List<Integer> answer) {
        int[] judgement = {0, 0};
        for (int number : userInput) {
            if (answer.contains(number)) {
                judgement[0]++;
            }
        }
        for (int i = 0; i < userInput.size(); i++) {
            if (userInput.get(i) == answer.get(i)) {
                judgement[1]++;
                judgement[0]--;
            }
        }
        return judgement;
    }
}

class ExceptionChecker {

    static int numberSize = 3;

    public static void checkGuessingInput(List<Integer> userInput) {

        if (userInput.size() != numberSize) {
            throw new IllegalArgumentException();
        }
        for (int inputElement : userInput) {
            if (inputElement < 1 || inputElement > 9) {
                throw new IllegalArgumentException();
            }
        }
        if (userInput.stream().distinct().count() != numberSize) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkAfterGameInput(int inputAfterGameFinished) {
        if (inputAfterGameFinished != 1 && inputAfterGameFinished != 2) {
            throw new IllegalArgumentException();
        }
    }
}

class Database {

    private List<Integer> answer;
    private List<Integer> userInput;
    private int strikeCount;
    private int ballCount;

    public Database() {
        answer = new ArrayList<>();
        userInput = new ArrayList<>();
        strikeCount = 0;
        ballCount = 0;
    }

    public void setAnswer(List<Integer> randomNumber) {
        answer = randomNumber;
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

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public int getStrikeCount() {
        return this.strikeCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public int getBallCount() {
        return this.ballCount;
    }
}