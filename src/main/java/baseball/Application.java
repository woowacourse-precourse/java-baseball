package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {

    public static void main(String[] args) {
        boolean run = true;
        boolean finish = true;
        GameStarter.printStartingMent();
        while (run && finish) {
            finish = false;
            GameManager game = new GameManager();
            Database data = new Database();
            data.setAnswer(GameStarter.createAnswer());
            while (!finish) {
                data.setUserInput(UserInput.whileRunning());
                game.checkInputException(data.getUserInput());
                data.setBall(CompareNumbers.checkNumber(data.getUserInput(), data.getAnswer())[0]);
                data.setStrike(CompareNumbers.checkNumber(data.getUserInput(), data.getAnswer())[1]);
                Output.printResult(data.getStrike(), data.getBall());
                finish = game.isFinish(data.getStrike());
                run = game.isAgain(finish);
            }
        }
        System.out.println("게임 종료");
    }
}

class GameStarter {
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
    public static void printStartingMent() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}

class GameManager {
    int numberSize = 3;
    int restart = 1;
    int terminate = 2;

    public void checkInputException(List<Integer> userInput) {

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

    public boolean isFinish(int strike) {
        if (strike == numberSize) {
            return true;
        }
        return false;
    }

    public boolean isAgain(boolean finish) {
        int userInput = -1;
        if (finish == true) {
            userInput = Integer.parseInt(Console.readLine());
        }
        if (userInput == restart) {
            return true;
        }
        if (userInput == terminate) {
            return false;
        }
        if (finish == true) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}

class UserInput {
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
}

class CompareNumbers {
    static int[] checkNumber(List<Integer> userInput, List<Integer> answer) {
        int[] ballStrike = {0, 0};
        for (int number : userInput) {
            if (answer.contains(number)) {
                ballStrike[0]++;
            }
        }
        for (int i = 0; i < userInput.size(); i++) {
            if (userInput.get(i) == answer.get(i)) {
                ballStrike[1]++;
                ballStrike[0]--;
            }
        }
        return ballStrike;
    }
}

class Database {

    private static List<Integer> answer = new ArrayList<>();
    private List<Integer> userInput = new ArrayList<>();
    private int strike = 0;
    private int ball = 0;

    public static void setAnswer(List<Integer> randomNumber) {
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

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getStrike() {
        return this.strike;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getBall() {
        return this.ball;
    }
}