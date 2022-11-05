package baseball;

import camp.nextstep.edu.missionutils.Console;
import domain.Computer;
import domain.Number;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    public static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final String GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private int restartNumber;

    public List<Integer> input() {   // 입력
        System.out.print(INPUT_NUMBER);
        String inputNumber = Console.readLine();

        return stringToIntegerList(inputNumber);
    }

    public List<Integer> stringToIntegerList(String inputNumber) {  // 입력 값을 List<Integer>로
        List<Integer> number = new ArrayList<>();

        for (int digit = 0; digit < inputNumber.length(); digit++) {
            number.add(Integer.parseInt(String.valueOf(inputNumber.charAt(digit))));
        }
        return number;
    }

    public void gameStart() {
        restartNumber = 0;

        Computer computer = new Computer();
        List<Integer> computerNumber = computer.makeRandomNumber();
        System.out.println(computerNumber);

        while(restartNumber == 0) {
            Number number = new Number(input());
            makeResult(number, computerNumber);
        }

        System.out.println(GAME_RESTART);

        if (Console.readLine().equals("1")) {
            gameStart();
        };
    }

    public void makeResult(Number number, List<Integer> computerNumber) {
        int strike = 0;
        int ball = 0;

        strike = judgeStrike(number, computerNumber, strike);
        ball = judgeBall(number, computerNumber, ball);

        if (ball > 0) {
            System.out.print(ball + BALL + " ");
        }
        if (strike > 0) {
            System.out.print(strike + STRIKE);
        }
        if (strike == 3) {
            System.out.print("\n" + GAME_END);
            restartNumber++;
        }
        if (strike == 0 && ball == 0) {
            System.out.print(NOTHING);
        }
        System.out.print("\n");
    }

    public int judgeStrike(Number number, List<Integer> computerNumber,  int strike) {   // 스트라이크 판정
        for (int digit = 0; digit < 3; digit++) {
            if (computerNumber.get(digit).equals(number.getDigit(digit))) {
                strike++;
            }
        }
        return strike;
    }

    public int judgeBall(Number number, List<Integer> computerNumber, int ball) { // 볼 판정
        for (int digit = 0; digit < 3; digit++) {
            if (computerNumber.contains(number.getDigit(digit)) && !(computerNumber.get(digit).equals(number.getDigit(digit)))) {
                ball++;
            }
        }
        return ball;
    }
}
