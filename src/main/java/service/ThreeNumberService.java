package service;

import model.ComputerThreeNumber;
import model.ThreeNumber;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class ThreeNumberService {
    private static ComputerThreeNumber computer;
    private static ThreeNumber user;
    private static int ball;
    private static int strike;
    private static boolean nothing;

    public ThreeNumberService() {
        computer = new ComputerThreeNumber();
        user = new ThreeNumber();
        ball = 0;
        strike = 0;
        nothing = true;
    }

    public void reset() {
        strike = 0;
        ball = 0;
        nothing = true;
        user.reset();
    }

    public void init() {
        reset();

        computer.setMyList();
    }

    public boolean playGame() {
        inputData();

        System.out.println(computer.getMyList().get(0) + " " + computer.getMyList().get(1) + " " + computer.getMyList().get(2));

        judgeResult(user.getMyList());

        printResult();

        return isEnd();
    }

    public void inputData() {
        System.out.print("숫자를 입력해주세요 : ");

        setUserData(Console.readLine());
    }

    public void setUserData(String line) {
        int data = Integer.parseInt(line);

        for(int i = 100; i >= 1; i /= 10) {
            user.addToMyList(data / i);

            data = data % i;
        }
    }

    public void setStrike(int num, int index) {
        if(computer.isSameIndex(num, index)) {
            strike += 1;
        }
        else
        {
            ball += 1;
        }
    }

    public void calculateStrikeOrBall(int num, int index) {
        if(computer.contains(num)) {
            setStrike(num, index);
        }
    }

    public void judgeResult(ArrayList<Integer> user) {
        for(int i = 0; i < 3; i++) {
            calculateScore(user.get(i), i);
        }

        if(strike != 0 || ball != 0) {
            nothing = false;
        }
        else
        {
            nothing = true;
        }
    }

    /**
     * 사용자 숫자가 있는지 확인 함수
     * */
    public void calculateScore(int num, int index) {
        if(computer.contains(num) == true) {
            calculateStrikeOrBall(num, index);
        }
    }

    public void printStrike() {
        if(strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        else if(0 < strike && strike < 3)
        {
            System.out.println(strike + "스트라이크");
        }
    }

    public boolean isEnd() {
        if(strike == 3) {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void printBall() {
        if(ball != 0) {
            System.out.println(ball + "볼 ");
        }
    }

    public void printResult() {
        if(nothing) {
            System.out.println("낫싱");
        }
        else
        {
            printBall();
            printStrike();
        }
    }

    public void computerReset() {
        computer.reset();
    }

    public static final int getStrike() {
        return ThreeNumberService.strike;
    }
}
