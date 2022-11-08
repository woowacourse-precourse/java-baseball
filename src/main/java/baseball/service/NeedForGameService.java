package baseball.service;

import baseball.handler.ExceptionHanlder;

import java.util.ArrayList;
import java.util.List;

import static baseball.service.GameService.*;

public class NeedForGameService {

    public static void startOrder() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    static void initData() {
        strike = 0;
        ball = 0;
        errorcheck = 0;
    }

    public static int errorOutput() {
        System.out.println("잘못된 입력입니다. 프로그램을 종료합니다.");
        return 1;
    }

    public static List<Integer> stringToList(String inputball) {

        List<Integer> usernumberdata = new ArrayList<>();
        String[] inputballarray = inputball.split("");

        for(int i=0; i<inputball.length(); i++){
            usernumberdata.add(Integer.valueOf(inputballarray[i]));
        }

        return usernumberdata;
    }

    public static void checkHandler(String inputball) {

        ExceptionHanlder exceptionHanlder = new ExceptionHanlder();

        exceptionHanlder.checkInputBallSize(inputball);
        exceptionHanlder.checkSameInput(inputball);
        exceptionHanlder.nonZero(inputball);
    }

    public static void checkStrike(){
        for(int i = 0; i < BALL_COUNTS; i++){
            if(RANDOMBALL.get(i) == userball.get(i)) strike++;
        }
    }

    public static void checkBall() {
        for(int i = 0; i < BALL_COUNTS; i++) {
            countBalls(i);
        }
    }
    public static void countBalls(int index) {
        for(int i = 0; i < BALL_COUNTS; i++){
            if(i != index && RANDOMBALL.get(i) == userball.get(index)) ball++;
        }
    }

    public static void giveHint() {
        if(strike == 0 && ball == 0) System.out.println("낫싱");
        if(strike == 0 && ball > 0) System.out.println(ball+"볼");
        if(strike > 0 && ball == 0) System.out.println(strike+"스트라이크");
        if(strike > 0 && ball > 0) System.out.println(ball+"볼 "+strike+"스트라이크");
    }
}