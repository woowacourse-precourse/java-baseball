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

    public static void initData() {
        strike = 0;
        ball = 0;
        errorCheck = 0;
    }

    public static List<Integer> stringToList(String inputBalls) {

        List<Integer> userBallObject = new ArrayList<>();
        String[] inputBallArr = inputBalls.split("");

        for(int i=0; i<inputBalls.length(); i++){
            userBallObject.add(Integer.valueOf(inputBallArr[i]));
        }

        return userBallObject;
    }

    public static void checkHandler(String inputBall) {

        ExceptionHanlder exceptionHanlder = new ExceptionHanlder();

        exceptionHanlder.checkInputBallSize(inputBall);
        exceptionHanlder.checkSameInput(inputBall);
        exceptionHanlder.CatchNonZero(inputBall);
    }

    public static void checkStrike(){
        for(int i = 0; i < BALLCOUNTS; i++){
            if(RANDOMBALL.get(i) == userBall.get(i)) strike++;
        }
    }

    public static void checkBall() {
        for(int i = 0; i < BALLCOUNTS; i++) {
            countBalls(i);
        }
    }

    public static void countBalls(int index) {
        for(int i = 0; i < BALLCOUNTS; i++){
            if(i != index && RANDOMBALL.get(i) == userBall.get(index)) ball++;
        }
    }

    public static void giveHint() {
        if(strike == 0 && ball == 0) System.out.println("낫싱");
        if(strike == 0 && ball > 0) System.out.println(ball+"볼");
        if(strike > 0 && ball == 0) System.out.println(strike+"스트라이크");
        if(strike > 0 && ball > 0) System.out.println(ball+"볼 "+strike+"스트라이크");
    }
}