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
        try{
            System.out.print("숫자를 입력해주세요 : ");
            playerNumber = playerInput();
        } catch(WrongInputException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<Integer> playerInput() {
        String playerInputString = Console.readLine();
        checkInputFormat(playerInputString);
        List<Integer> playerInput = convertToIntegerList(playerInputString);
        return playerInput;
    }

    private void checkInputFormat(String inputString) {
        if (inputString.length() != 3)
            throw new WrongInputException("3자리 수만 입력 가능합니다.");
        if (!isNumber(inputString))
            throw new WrongInputException("숫자만 입력 가능합니다.");
        if (!isAllDifferent(inputString))
            throw new WrongInputException("서로 다른 수로 이루어져야 합니다.");
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
        for (int i = 0; i < 3; i++) {
            char tmp = inputString.charAt(i);
            if (('1' <= tmp) && (tmp <= '9'))
                return true;
        }
        return false;
    }

    private boolean isAllDifferent(String inputString) {
        char first = inputString.charAt(0);
        char second = inputString.charAt(1);
        char third = inputString.charAt(2);
        if ((first != second) && (second != third) && (third != first)) {
            return true;
        }
        return false;
    }
}

class WrongInputException extends IllegalArgumentException{
    WrongInputException(String message) {
        super(message);
    }
}

class GameInit{
    List<Integer> computerNumber;
    List<Integer> playerNumber;
    public GameInit() {
        List<Integer> computerNumber = new ComputerNumber().computerNumber;
        List<Integer> playerNumber = new PlayerNumber().playerNumber;
        GamePlay gamePlay = new GamePlay(computerNumber, playerNumber);
    }
}

class GamePlay {
    GamePlay(List<Integer> computerNumber, List<Integer> playerNumber) {
        boolean isRight = isRight(computerNumber, playerNumber);
        while (!isRight) {
            getHint(computerNumber, playerNumber);
            playerNumber = new PlayerNumber().playerNumber;
            isRight = isRight(computerNumber, playerNumber);
        }
        new GameEnd();
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
}

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        GameInit startGame = new GameInit();
    }
}
