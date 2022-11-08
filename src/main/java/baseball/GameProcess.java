package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.Constants.GAME_START_MESSAGE;
import static baseball.Constants.INPUT_NUMBER_MESSAGE;
import static baseball.Constants.INPUT_GAME_OVER_YN_MESSAGE;
import static baseball.Constants.GAME_OVER_NO;

public class GameProcess {

    // 게임 최초 시작
    public static void newStart() {
        System.out.println(GAME_START_MESSAGE);
        start();
    }

    // 게임 시작
    public static void start() {
        // 랜덤수 생성
        List<Integer> randomNumList = RandomNum.generate();

        boolean answer = false;
        getInputNum(randomNumList, answer);
    }

    // 수 입력 받기
    public static void getInputNum(List<Integer> randomNumList, boolean answer) {
        System.out.print(INPUT_NUMBER_MESSAGE);

        // 사용자 입력값 받기
        String inputNum = Console.readLine();

        // 입력값 검증
        Vailidator.checkInputNum(inputNum);

        // 정답 확인
        checkAnswer(randomNumList, inputNum, answer);
    }

    // 정답 체크
    public static void checkAnswer(List<Integer> randomNumList, String inputNum, boolean answer) {
        List<Integer> inputNumList = new ArrayList<>();
        String[] inputNumArr = inputNum.split("");
        for (String s : inputNumArr) {
            inputNumList.add(Integer.parseInt(s));
        }

        answer = Answer.isAnswer(randomNumList, inputNumList);

        // 오답인 경우, 반복
        if (!answer) {
            getInputNum(randomNumList, answer);
        }

        // 정답인 경우, 종료 구분값 받기
        if (answer) {
            System.out.println(INPUT_GAME_OVER_YN_MESSAGE);
            String inputOverYn = Console.readLine();

            // 입력값 검증
            int overYnNum = Integer.parseInt(inputOverYn);
            Vailidator.checkInputOverYn(overYnNum);

            // 종료 여부 확인
            isOver(overYnNum);
        }
    }

    private static void isOver(int overYnNum) {
        if (overYnNum == GAME_OVER_NO) {
            start();
        }
    }


}
