package baseball;

import baseball.domain.MyBalls;
import baseball.domain.RandomBall;

import java.util.List;
import java.util.Scanner;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        RandomBall randomBall = new RandomBall();
        List<Integer> computerBalls = randomBall.makeRandomBalls();
        System.out.println(computerBalls);

        MyBalls myBalls = new MyBalls();
        List<Integer> myBallNumbers = myBalls.inputBalls();

    }
}
