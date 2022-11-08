package baseball.service;

import java.util.ArrayList;
import java.util.List;

import baseball.config.PrintOutput;
import baseball.controller.PlayGameController;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import static baseball.service.NeedForGameService.*;

public class GameService {
    public final static List<Integer> RANDOMBALL = new ArrayList<>();
    public static List<Integer> userball = new ArrayList<>();
    public static final int BALL_COUNTS = 3;
    public static int strike = 0;
    public static int ball = 0;
    public static int errorcheck = 0;

    public static void CatchException() {
        while(strike != 3){
            try {   checkInput();
            } catch (IllegalArgumentException e){   errorcheck = callErrorOrder();
            }
            if(errorcheck == 1) break;
            findRandomBall();

            if(strike != 3) initData();
        }

        if(errorcheck == 0) selectContinue();
        if(errorcheck == 1) return;

    }

    public static void checkInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputball = Console.readLine();
        checkHandler(inputball);
        userball = stringToList(inputball);
    }

    public static void findRandomBall() {
        checkStrike();
        checkBall();
        giveHint();
    }

    private static void selectContinue() {
        PrintOutput.finishOrder();
        String selectNumber = Console.readLine();

        if(Integer.valueOf(selectNumber) == 1) {
            initData();
            RANDOMBALL.clear();
            userball.clear();
            PlayGameController.run();
        }

        if(Integer.valueOf(selectNumber) == 2) return;
    }

    public static List<Integer> makeRandomBall() {
        while(RANDOMBALL.size() < BALL_COUNTS){
            int number = 0;
            number = Randoms.pickNumberInRange(1, 9);
            if(!RANDOMBALL.contains(number)) RANDOMBALL.add(number);
        }

        return RANDOMBALL;
    }
}