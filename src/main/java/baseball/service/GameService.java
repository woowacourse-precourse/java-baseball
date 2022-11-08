package baseball.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import baseball.handler.ExceptionHanlder;
import baseball.view.PrintOutput;
import baseball.controller.PlayGameController;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class GameService {
    private static final List<Integer> RANDOMBALL = new ArrayList<>();
    private static final int BALLCOUNTS = 3;
    private static List<Integer> userBall = new ArrayList<>();
    public static int strike, ball, errorCheck = 0;

    public void catchRandomBall() {
        while(strike != 3){
            checkInput();
            if(errorCheck == 1) break;
            findRandomBall();

            if(strike != 3) initData();
        }
        if(errorCheck == 0) selectContinue();
    }
    public void initData() {
        strike = 0;
        ball = 0;
    }
    public void checkInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputBall = Console.readLine();
        checkHandler(inputBall);
        userBall = stringToList(inputBall);
    }
    public void findRandomBall() {
        checkStrike();
        checkBall();
        giveHint();
    }
    public void selectContinue() {
        PrintOutput.finishOrder();
        String isContinue = Console.readLine();
        isContinueGame(isContinue);
    }
    public void isContinueGame(String num) {
        if(Objects.equals(num, "1")) {
            PlayGameController playGameController = new PlayGameController();

            initData();
            RANDOMBALL.clear();
            userBall.clear();
            playGameController.run();
            return;
        }
        if(Objects.equals(num, "2")) return;

        throw new IllegalArgumentException();
    }
    public List<Integer> makeRandomBall() {
        while(RANDOMBALL.size() < BALLCOUNTS) {
            int number = 0;
            number = Randoms.pickNumberInRange(1, 9);
            if(!RANDOMBALL.contains(number)) RANDOMBALL.add(number);
        }

        return RANDOMBALL;
    }
    public void callStartOrder() {
        PrintOutput.startOrder();
    }
    public List<Integer> stringToList(String inputBalls) {

        List<Integer> userBallObject = new ArrayList<>();
        String[] inputBallArr = inputBalls.split("");

        for(int i=0; i<inputBalls.length(); i++){
            userBallObject.add(Integer.valueOf(inputBallArr[i]));
        }

        return userBallObject;
    }
    public void checkHandler(String inputBall) {

        ExceptionHanlder exceptionHanlder = new ExceptionHanlder();

        exceptionHanlder.checkInputBallSize(inputBall);
        exceptionHanlder.checkNumber(inputBall);
        exceptionHanlder.checkSameInput(inputBall);
        exceptionHanlder.catchNonZero(inputBall);
    }
    public void checkStrike(){
        for(int i = 0; i < BALLCOUNTS; i++){
            if(RANDOMBALL.get(i) == userBall.get(i)) strike++;
        }
    }
    public void checkBall() {
        for(int i = 0; i < BALLCOUNTS; i++) {
            countBalls(i);
        }
    }
    public void countBalls(int index) {
        for(int i = 0; i < BALLCOUNTS; i++){
            if(i != index && RANDOMBALL.get(index) == userBall.get(i)) ball++;
        }
    }
    public void giveHint() {
        if(strike == 0 && ball == 0) System.out.println("낫싱");
        if(strike == 0 && ball > 0) System.out.println(ball+"볼");
        if(strike > 0 && ball == 0) System.out.println(strike+"스트라이크");
        if(strike > 0 && ball > 0) System.out.println(ball+"볼 "+strike+"스트라이크");
    }
}