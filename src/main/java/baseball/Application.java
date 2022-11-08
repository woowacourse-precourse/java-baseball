package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

class ComputerNumber {
    List<Integer> computerNumber;

    public ComputerNumber() {
        computerNumber = makeRandomNumber();
    }

    private List<Integer> makeRandomNumber() {
        List<Integer> numberList = new ArrayList<>();
        do {
            int newNumber = Randoms.pickNumberInRange(1, 9);
            if (numberList.contains(newNumber))
                continue;
            numberList.add(newNumber);
        } while (numberList.size() < 3);

        return numberList;
    }
}

class PlayerNumber {
    List<Integer> playerNumber;

    public PlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        playerNumber = playerInput();
    }

    private List<Integer> playerInput() {
        String playerInputString = Console.readLine();
        checkInputFormat(playerInputString);
        return convertToIntegerList(playerInputString);
    }

    private void checkInputFormat(String inputString) {
        if (inputString.length() != 3)
            throw new IllegalArgumentException();
        if (!isNumber(inputString))
            throw new IllegalArgumentException();
        if (!isAllDifferent(inputString))
            throw new IllegalArgumentException();
    }

    private List<Integer> convertToIntegerList(String playerInputString) {
        List<Integer> playerInput = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            char numberInString = playerInputString.charAt(i);
            int converted = numberInString - '0';
            playerInput.add(converted);
        }
        return playerInput;
    }

    private boolean isNumber(String inputString) {
        String numbers = "123456789";
        for (int i = 0; i < 3; i++) {
            char tmp = inputString.charAt(i);
            if (numbers.indexOf(tmp) == -1)
                return false;
        }
        return true;
    }

    private boolean isAllDifferent(String inputString) {
        char first = inputString.charAt(0);
        char second = inputString.charAt(1);
        char third = inputString.charAt(2);
        return ((first != second) && (second != third) && (third != first));
    }
}

class GameInit{
    List<Integer> computerNumber;
    List<Integer> playerNumber;
    public GameInit() {
        computerNumber = new ComputerNumber().computerNumber;
        playerNumber = new PlayerNumber().playerNumber;
        GamePlay gamePlay = new GamePlay(computerNumber, playerNumber);
        while (!gamePlay.isRight) {
            playerNumber = new PlayerNumber().playerNumber;
            gamePlay = new GamePlay(computerNumber, playerNumber);
        }
        new GameEnd();
    }
}

class GamePlay {
    boolean isRight;
    GamePlay(List<Integer> computerNumber, List<Integer> playerNumber) {
        getHint(computerNumber, playerNumber);
        isRight = isRight(computerNumber, playerNumber);
    }

    private boolean isRight(List<Integer> computerNumber, List<Integer> playerNumber) {
        int n = computerNumber.size();
        for (int i = 0; i < n; i++)
            if (computerNumber.get(i) != playerNumber.get(i))
                return false;
        return true;
    }

    private void getHint(List<Integer> computerNumber, List<Integer> playerNumber) {
        int strike = checkStrike(computerNumber, playerNumber);
        int ball = checkBall(computerNumber,playerNumber);
        printHint(strike, ball);
    }

    private int checkStrike(List<Integer> computerNumber, List<Integer> playerNumber) {
        int strike = 0;
        int n = computerNumber.size();
        for (int i = 0; i < n; i++) {
            if (playerNumber.get(i) == computerNumber.get(i))
                strike++;
        }
        return strike;
    }

    private int checkBall(List<Integer> computerNumber, List<Integer> playerNumber) {
        int ball = 0;
        int n = computerNumber.size();
        for (int i = 0; i < n; i++) {
            if (computerNumber.contains(playerNumber.get(i)))
                ball++;
        }
        int strike = checkStrike(computerNumber, playerNumber);
        return ball - strike;
    }

    private void printHint(int strike, int ball) {
        if ((strike == 0) && (ball == 0)) {
            System.out.println("낫싱");
            return;
        }
        if ((strike == 0) && (ball != 0)) {
            System.out.println(ball + "볼");
            return;
        }
        if ((strike != 0) && (ball == 0)) {
            System.out.println(strike + "스트라이크");
            return;
        }
        if ((strike != 0) && (ball != 0)) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
}

class GameEnd {
    int answer;
    GameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        answer = ask();
        if (answer == 1)
            new GameInit();
    }

    private int ask() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        answer = answerInput();
        return answer;
    }

    private int answerInput() {
        String answer = Console.readLine();
        checkAnswerFormat(answer);
        return Integer.parseInt(answer);
    }

    private void checkAnswerFormat(String answer) {
        if (answer.equals("1") || answer.equals("2"))
            return;
        throw new IllegalArgumentException();
    }
}

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        new GameInit();
    }
}