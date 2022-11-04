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
        for(int i : answer){
            System.out.print(i);
        }
        // 사용자 입력 받기, 입력 값 조건 충족 확인
        System.out.print("숫자를 입력해주세요 : ");
        String inputValue = Console.readLine();

        try {
            CheckInput.isInput(inputValue);
        } catch (IllegalArgumentException e) {
            return;
        }

        // 스트라이크 및 볼 카운트 출력
        int ball = BallCount.ballCount(answer, inputValue);
        int strike = BallCount.strikeCount(answer, inputValue);

        if(ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
        }
        else if(ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        }
        else if(ball != 0 && strike != 0){
            System.out.println(ball+"볼 " + strike + "스트라이크");
        }
        else {
            System.out.println("낫싱");
        }


    }
}
