package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.Constants.GAME_START_MESSAGE;
import static baseball.Constants.INPUT_NUMBER_MESSAGE;
import static baseball.Constants.INPUT_GAME_OVER_YN_MESSAGE;
import static baseball.Constants.GAME_OVER_NO;

public class GameProcess {

    public static void newStart() {
        System.out.println(GAME_START_MESSAGE);
        start();
    }

    public static void start() {
        List<Integer> randomNumList = RandomNum.generate();

        boolean answer = false;
        getInputNum(randomNumList, answer);
    }

    public static void getInputNum(List<Integer> randomNumList, boolean answer) {
        System.out.print(INPUT_NUMBER_MESSAGE);
        String inputNum = Console.readLine();

        Vailidator.checkInputNum(inputNum);

        checkAnswer(randomNumList, inputNum, answer);
    }

    public static void checkAnswer(List<Integer> randomNumList, String inputNum, boolean answer) {
        List<Integer> inputNumList = new ArrayList<>();
        String[] inputNumArr = inputNum.split("");
        for (String s : inputNumArr) {
            inputNumList.add(Integer.parseInt(s));
        }

        answer = Answer.isAnswer(randomNumList, inputNumList);

        if (!answer) {
            getInputNum(randomNumList, answer);
        }

        if (answer) {
            System.out.println(INPUT_GAME_OVER_YN_MESSAGE);
            String inputOverYn = Console.readLine();

            int overYnNum = Integer.parseInt(inputOverYn);
            Vailidator.checkInputOverYn(overYnNum);

            isOver(overYnNum);
        }
    }

    public static void isOver(int overYnNum) {
        if (overYnNum == GAME_OVER_NO) {
            start();
        }
    }

}
