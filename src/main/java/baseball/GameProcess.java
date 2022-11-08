package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameProcess {

    // 게임 최초 시작
    public static void newStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
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
        System.out.print("숫자를 입력해주세요 : ");

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
        for(String s : inputNumArr) {
            inputNumList.add(Integer.parseInt(s));
        }

        answer = Answer.isAnswer(randomNumList, inputNumList);

        // 오답인 경우, 반복
        if (!answer) {
            getInputNum(randomNumList, answer);
        }

        // 정답인 경우, 종료 구분값 받기
        if(answer) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String inputOverYn = Console.readLine();
        }
    }
}
