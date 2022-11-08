package baseball;

import static baseball.ConstantAndMessage.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class NumberBaseBallGame {

    private int strike;
    private int ball;
    private final List<Integer> computer;

    public void play() {
        while (strike < NUMBER_LENGTH) {
            System.out.print(GETTING_USER_NUMBER_MESSAGE);
            getUserNumber();
            printMessage();
        }
        System.out.println(GAME_END_MESSAGE);
    }
    protected void getUserNumber(){
        User user = new User(Console.readLine());
        user.errorChecking();
        compareUserAndComputer(user);
    }
    protected void compareUserAndComputer(User user) {
        strike = user.strike(computer);
        ball = user.ball(computer);
    }
    protected void printMessage(){
        printNothing();
        printBall();
        if(strike > 0){
            System.out.print(" ");
        }
        printStrike();
        System.out.println();
    }
    protected void printNothing() {
        if (strike == 0 && ball == 0) {
            System.out.print(NOTHING_MESSAGE);
        }
    }
    protected void printBall() {
        if (ball > 0) {
            System.out.print(ball + BALL_MESSAGE);
        }
    }
    protected void printStrike() {
        if (strike > 0) {
            System.out.print(strike + STRIKE_MESSAGE);
        }
    }

    public NumberBaseBallGame(List<Integer> computer) {
        this.computer = computer;
        strike = 0;
        ball = 0;
    }
}
