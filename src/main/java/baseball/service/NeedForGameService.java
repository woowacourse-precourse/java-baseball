package baseball.service;

import baseball.config.PrintOutput;
import baseball.handler.ExceptionHanlder;

import java.util.ArrayList;
import java.util.List;

import static baseball.service.GameService.*;

public class NeedForGameService {
    public static void callStartOrder() {
        PrintOutput.startOrder();
    }

    public static int callErrorOrder() {
        PrintOutput.errorOrder();
        return 1;
    }

    static void initData() {
        strike = 0;
        ball = 0;
        errorcheck = 0;
    }

    public static List<Integer> stringToList(String inputballs) {

        List<Integer> userballobject = new ArrayList<>();
        String[] inputballarray = inputballs.split("");

        for(int i=0; i<inputballs.length(); i++){
            userballobject.add(Integer.valueOf(inputballarray[i]));
        }

        return userballobject;
    }

    public static void checkHandler(String inputball) {

        ExceptionHanlder exceptionHanlder = new ExceptionHanlder();

        exceptionHanlder.checkInputBallSize(inputball);
        exceptionHanlder.checkSameInput(inputball);
        exceptionHanlder.CatchNonZero(inputball);
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