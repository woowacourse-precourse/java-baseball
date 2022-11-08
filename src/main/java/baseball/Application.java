package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;


public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game Game = new Game();
        Game.start();
    }
}

class Calculator {

    private static final int NumberLength = 3;
    private static int ballNum = 0;
    private static int strikeNum = 0;

    Calculator() {
    }

    public int getBallNum() {
        return ballNum;
    }

    public int getStrikeNum() {
        return strikeNum;
    }

    public void addBall() {
        ballNum++;
    }

    public void addStrike() {
        strikeNum++;
    }

    public boolean IsBall(int computerOneNumber, String userNumber) {
        return userNumber.contains(Integer.toString(computerOneNumber));
    }

    public boolean IsStrike(int computerOneNumber, int userOneNumber) {
        return computerOneNumber == userOneNumber;
    }

    public void calculateNum(String computerNumber, String userNumber) {
        ballNum = 0;
        strikeNum = 0;
        for (int i = 0; i < NumberLength; i++) {
            if (IsStrike(computerNumber.charAt(i) - '0', userNumber.charAt(i) - '0')) {
                addStrike();
                continue;
            }
            if (IsBall(computerNumber.charAt(i) - '0', userNumber)) {
                addBall();
            }
        }
    }
}


class User {

    private static final int NumberLength = 3;
    private static String userNumber;

    User() {
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber() {
        userNumber = Input.getInput();
        inputValidation(userNumber);
    }

    public boolean checkNumLength(String num) {
        return num.length() == NumberLength;
    }

    public boolean checkNumFormat(String num) {
        try {
            Integer.parseInt(num);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean checkNumDuplication(String num) {
        HashSet<Integer> checkEqualHashSet = new HashSet<>();
        for (int i = 0; i < NumberLength; i++) {
            checkEqualHashSet.add(num.charAt(i) - '0');
        }
        return checkEqualHashSet.size() == NumberLength;
    }

    public void inputValidation(String num) {
        if (!checkNumFormat(num) || !checkNumLength(num) || !checkNumDuplication(num)) {
            throw new IllegalArgumentException();
        }
    }

}

class Computer {

    private static final int NumberLength = 3;
    private static String computerNumber;

    Computer() {
    }

    public void setComputerNumber() {
        computerNumber = getRandomDifferentNumber();
    }

    public String getComputerNumber() {
        return computerNumber;
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public String getRandomDifferentNumber() {
        String number = "";
        HashSet<Integer> differentNumSet = new HashSet<>();
        for (int i = 0; i < NumberLength; i++) {
            int newNum = getRandomNumber();
            if (differentNumSet.contains(newNum)) {
                i--;
                continue;
            }
            differentNumSet.add(newNum);
            number += Integer.toString(newNum);
        }
        return number;
    }
};


class Game {

    private final Computer Computer;
    private final User User;
    private final Calculator Calculator;

    private static int startFlag = 1;
    private static int NumberLength = 3;

    public Game() {
        Computer = new Computer();
        User = new User();
        Calculator = new Calculator();
    }

    public void start() {
        Output.printStartMsg();
        while (true) {
            this.Computer.setComputerNumber();
            while (true) {
                Output.printInputMsg();
                User.setUserNumber();
                Calculator.calculateNum(Computer.getComputerNumber(), User.getUserNumber());
                Output.printOutput(Calculator.getBallNum(), Calculator.getStrikeNum());
                if (checkThreeStrike(Calculator.getStrikeNum())) {
                    Output.printEndMsg();
                    getStartFlag();
                    break;
                }
            }
            if (checkEndGame()) {
                break;
            }
        }
    }

    public Boolean checkThreeStrike(int StrikeNum) {
        return StrikeNum == NumberLength;
    }

    public void getStartFlag() {
        startFlag = Integer.parseInt(Console.readLine());
    }

    public boolean checkEndGame() {
        if (startFlag != 1 && startFlag != 2) {
            throw new IllegalArgumentException();
        }
        return startFlag == 2;
    }
}

class Input {

    public static String getInput() {
        String inputNumber;
        inputNumber = Console.readLine();
        return inputNumber;
    }

};

class Output {

    private static final String StartSymbol = "숫자 야구 게임을 시작합니다.";
    private static final String InputSymbol = "숫자를 입력해주세요 : ";
    private static final String EndSymbol = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
        + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printStartMsg() {
        System.out.println(StartSymbol);
    }

    public static void printInputMsg() {
        System.out.print(InputSymbol);
    }

    public static void printOutput(int ballNum, int strikeNum) {
        if (ballNum > 0) {
            System.out.print(ballNum + "볼 ");
        }
        if (strikeNum > 0) {
            System.out.print(strikeNum + "스트라이크");
        }
        if (ballNum == 0 && strikeNum == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public static void printEndMsg() {
        System.out.println(EndSymbol);
    }
};

