package baseball;

import camp.nextstep.edu.missionutils.Console;
import domain.Computer;
import domain.Flag;
import domain.Number;

import java.util.ArrayList;
import java.util.List;

class Judgement {
    int strike;
    int ball;
}

public class BaseballGame {
    public static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final String GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private int restartNumber;

    public List<Integer> input() {
        System.out.print(INPUT_NUMBER);
        String inputNumber = Console.readLine();

        return stringToIntegerList(inputNumber);
    }

    public List<Integer> stringToIntegerList(String inputNumber) {
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

        while(restartNumber == 0) {
            Number number = new Number(input());
            makeResult(number, computerNumber);
        }

        System.out.println(GAME_RESTART);
        Flag flag = new Flag(Console.readLine());

        if (flag.isRestart()) {
            gameStart();
        }
    }

    public void makeResult(Number number, List<Integer> computerNumber) {
        Judgement judgement = new Judgement();
        judge(number, computerNumber, judgement);

        if (judgement.ball > 0) {
            System.out.print(judgement.ball + BALL + " ");
        }
        if (judgement.strike > 0) {
            System.out.print(judgement.strike + STRIKE);
        }
        if (judgement.strike == 3) {
            System.out.print("\n" + GAME_END);
            restartNumber++;
        }
        if (judgement.strike == 0 && judgement.ball == 0) {
            System.out.print(NOTHING);
        }
        System.out.print("\n");
    }

    public void judge(Number number, List<Integer> computerNumber,  Judgement judgement) {
        int computerDigit, myDigit;

        for (int index = 0; index < 3; index++) {
            computerDigit = computerNumber.get(index);
            myDigit = number.getDigit(index);

            if (computerDigit == myDigit) {
                judgement.strike += 1;
            }
            if (computerNumber.contains(myDigit) && computerDigit != myDigit) {
                judgement.ball += 1;
            }
        }
    }
}