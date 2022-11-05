package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;


public class Application {

    public static void main(String[] args) {
        // 랜덤으로 숫자 세개 생성
        AnswerNumber answerNumber = new AnswerNumber();
        int[] answer = new int[3];
        answer = answerNumber.getNumberArr();

        System.out.println("숫자 야구 게임을 시작합니다.");

        // 사용자 입력 받기, 입력 값 조건 충족 확인
        System.out.print("숫자를 입력해주세요 : ");
        String inputValue = Console.readLine();

        try {
            CheckInput.isInput(inputValue);
        } catch (IllegalArgumentException e) {
            return;
        }

        BallCount.printBallCount(answer, inputValue);
    }
}
