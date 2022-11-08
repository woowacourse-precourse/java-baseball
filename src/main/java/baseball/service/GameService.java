package baseball.service;

import java.util.ArrayList;
import java.util.List;

import baseball.view.PrintOutput;
import baseball.controller.PlayGameController;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import static baseball.service.NeedForGameService.*;

public class GameService {
    public static final List<Integer> RANDOMBALL = new ArrayList<>();
    public static final int BALLCOUNTS = 3;
    public static List<Integer> userBall = new ArrayList<>();
    public static int strike, ball, errorCheck = 0;

    public static void catchRandomBall() {
        while(strike != 3){
            checkInput();
            if(errorCheck == 1) break;
            findRandomBall();

            if(strike != 3) initData();
        }
        if(errorCheck == 0) selectContinue();
        if(errorCheck == 1) return;
    }

    public static void checkInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputBall = Console.readLine();
        checkHandler(inputBall);
        userBall = stringToList(inputBall);
    }

    public static void findRandomBall() {
        checkStrike();
        checkBall();
        giveHint();
    }

    private static void selectContinue() {
        PrintOutput.finishOrder();
        String isContinue = Console.readLine();

        if(Integer.parseInt(isContinue) == 1) {
            initData();
            RANDOMBALL.clear();
            userBall.clear();
            PlayGameController.run();
        }

        if(Integer.parseInt(isContinue) == 2) return;
    }

    public static List<Integer> makeRandomBall() {
        while(RANDOMBALL.size() < BALLCOUNTS) {
            int number = 0;
            number = Randoms.pickNumberInRange(1, 9);
            if(!RANDOMBALL.contains(number)) RANDOMBALL.add(number);
        }

        return RANDOMBALL;
    }
}