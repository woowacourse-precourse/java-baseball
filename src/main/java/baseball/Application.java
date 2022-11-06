package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    static final int SIZE = 3;
    static int computer = 0;
    static int input = 0;
    static int finishNumber = 1;
    public static void main(String[] args) {
        initGame();
        while (finishNumber == 1) {
            startGame();
        }
    }

    private static void initGame() {
        computer = 0;
        input = 0;
        finishNumber = 1;
    }

    private static void startGame() {
        computer = CreateNumbers(SIZE);
        while (true) {
            boolean isFinished = playGame();
            if (isFinished) return;
        }
    }

    private static boolean playGame() {
        input = InputNumbers(SIZE);
        boolean isFinished = checkFinish();
        if (isFinished) return true;
        computeScore(input, computer);
        return false;
    }

    private static boolean checkFinish() {
        if (input == computer) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            finishNumber = inputFinish();
            return true;
        }
        return false;
    }

    

    private static int inputFinish() throws IllegalArgumentException {
        int intInput = Integer.parseInt(Console.readLine());
        if (intInput != 1 && intInput != 2) {
            throw new IllegalArgumentException();
        }
        return intInput; 
    }
    private static int CreateNumbers(int SizeOfNum) {
        List<Integer> computerIntList = new ArrayList<>();
        while (computerIntList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerIntList.contains(randomNumber)) {
               computerIntList.add(randomNumber);
            }
        }
        List<String> computerStrList = computerIntList.stream().map(Object::toString).collect(Collectors.toUnmodifiableList());
        int computer = Integer.parseInt(String.join("", computerStrList));
        return computer;
    }

    private static int InputNumbers(int SizeOfNum) throws IllegalArgumentException {
        String strInput = Console.readLine();
        if (strInput.length() != SizeOfNum) { // 1. 길이가 맞지 않는 값이 입력된 경우
            throw new IllegalArgumentException();
        }

        int intInput = Integer.parseInt(strInput);
        int[] arrInput = Stream.of(String.valueOf(intInput).split("")).mapToInt(Integer::parseInt).toArray();
        int[] check = new int[10];
        for (int i = 0; i < strInput.length(); i++) {
            if (check[arrInput[i]] == 1) { // 2. 각 자리수의 값이 중복이 있는 경우
                throw new IllegalArgumentException();
            }
            check[arrInput[i]] = 1;
        }

        return intInput;
    }

    private static void computeScore(int input, int computer) {
        int strike = getStrikeNumber(input, computer);
        int ball = getBallNumber(input, computer);
        PrintGameScore(strike, ball);   
    }

    private static int getStrikeNumber(int input, int computer) {
        int strike = 0;
        int[] arrInput = Stream.of(String.valueOf(input).split("")).mapToInt(Integer::parseInt).toArray();
        int[] arrComputer = Stream.of(String.valueOf(computer).split("")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < arrInput.length; i++) {
            if (arrInput[i] == arrComputer[i]) {
                strike++;
            }
        }
        return strike;
    }

    private static int getBallNumber(int input, int computer) {
        int ball = 0;
        int[] arrInput = Stream.of(String.valueOf(input).split("")).mapToInt(Integer::parseInt).toArray();
        int[] arrComputer = Stream.of(String.valueOf(computer).split("")).mapToInt(Integer::parseInt).toArray();
        int[] checkComputer = new int[10];
        for (int i = 0; i < arrComputer.length; i++) {
            checkComputer[arrComputer[i]] = 1;
        }
        for (int i = 0; i < arrInput.length; i++) {
            if (checkComputer[arrInput[i]] == 1 && arrComputer[i] != arrInput[i]) {
                ball++;
            }
        }
        return ball;
    }

    private static void PrintGameScore(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        else if (strike == 0) {
            System.out.println(ball + "볼");
        }
        else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        }
        else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
}
