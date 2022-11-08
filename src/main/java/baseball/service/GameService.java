package baseball.service;

import java.util.ArrayList;
import java.util.List;

import baseball.controller.PlayGameController;
import baseball.handler.ExceptionHanlder;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class GameService {
    public static final int BALL_NUMBERS = 3;
    public static int strike = 0;
    public static int ball = 0;
    public static int errorcheck = 0;
    public final static List<Integer> RANDOMBALL = new ArrayList<>();
    public static List<Integer> userball = new ArrayList<>();
    public static void startOrder(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        GameService.makeRandomBall();
    }
    public static void inputOrder() {
        while(strike != 3){
            try {   checkInput();
            } catch (IllegalArgumentException e){   errorcheck = errorOutput();
            }
            if(errorcheck == 1) break;

            findRandomBall();
            if(strike!=3) initData();
        }
        if(errorcheck == 0) selectContinue();
        if(errorcheck == 1) return;
    }
    private static void selectContinue() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String selectNumber = Console.readLine();

        RANDOMBALL.clear();
        userball.clear();
        strike = 0;
        ball = 0;

        if(Integer.valueOf(selectNumber)==1) PlayGameController.run();
        if(Integer.valueOf(selectNumber)==2) System.out.println("게임 종료");
    }
    public static void checkInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputball = Console.readLine();
        checkHandler(inputball);
        userball = stringToList(inputball);
    }
    public static int errorOutput() {
        System.out.println("잘못된 입력입니다. 프로그램을 종료합니다.");
        return 1;
    }
    public static List<Integer> makeRandomBall(){
        while(RANDOMBALL.size()<BALL_NUMBERS){
            int number = 0;
            number = Randoms.pickNumberInRange(1,9);
            if(!RANDOMBALL.contains(number))   RANDOMBALL.add(number);
        }
        return RANDOMBALL;
    }
    public static List<Integer> stringToList(String inputball){
        List<Integer> usernumberdata = new ArrayList<>();
        String[] inputballarray = inputball.split("");

        for(int i=0; i<inputball.length(); i++){
            usernumberdata.add(Integer.valueOf(inputballarray[i]));
        }
        return usernumberdata;
    }
    public static void checkHandler(String inputball){
        ExceptionHanlder exceptionHanlder = new ExceptionHanlder();

        exceptionHanlder.checkInputBallSize(inputball);
        exceptionHanlder.checkSameInput(inputball);
        exceptionHanlder.nonZero(inputball);
    }
    public static void findRandomBall() {
        checkStrike();
        checkBall();
        giveHint();
    }
    private static void giveHint() {
        if(strike == 0 && ball == 0) System.out.println("낫싱");
        if(strike == 0 && ball != 0) System.out.println(ball+"볼");
        if(strike != 0 && ball == 0) System.out.println(strike+"스트라이크");
        if(strike != 0 && ball != 0) System.out.println(ball+"볼 "+strike+"스트라이크");
    }
    private static void initData(){
        strike = 0;
        ball = 0;
    }
    public static void checkStrike(){
        int prevstrike = strike;

        for(int i = 0; i < BALL_NUMBERS; i++){
            if(RANDOMBALL.get(i) == userball.get(i)) strike++;
        }
    }
    public static void checkBall(){
        int prevball = ball;

        for(int i=0; i< BALL_NUMBERS; i++){
            countBalls(i);
        }
    }
    private static void countBalls(int index) {
        for(int i=0; i<BALL_NUMBERS; i++){
            if(i!=index && RANDOMBALL.get(i) == userball.get(index)) ball++;
        }
    }
}