package service;

import model.ComputerThreeNumber;
import model.ThreeNumber;

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
    }

    public void reset() {
        strike = 0;
        ball = 0;
        nothing = true;
    }

    public void init() {
        computer.setMyList();

        reset();

        System.out.println("숫자 야구 게임을 시작합니다.");

        System.out.print("숫자를 입력해주세요 : ");
    }

    /**
     * true: strike
     * false: ball
     * */
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
            calculateStrikeOrBall(user.get(i), i);
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
    public int IsIn(int num) {
        if(computer.contains(num)) {
            return 1;
        }
        else
        {
            return 0;
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

        }
    }
}
