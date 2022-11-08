package baseball;

import java.util.ArrayList;
import java.util.List;

public class printCase {
    public static boolean makePrintCase(List<Integer> answerNumber, List<Integer> inputNumber) throws IllegalArgumentException {

        int strikeNum = 0;
        int ballNum = 0;

        try{
        for(int i=0; i<3; i++) {
            if(answerNumber.contains(inputNumber.get(i))) {
                if(answerNumber.get(i).equals(inputNumber.get(i))) {
                    strikeNum += 1;
                } else {
                    ballNum += 1;
                }
                /**
                 * indent 3초과 리팩터링 하기
                 */
            }
        }
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }

        if(strikeNum == 0 && ballNum == 0) {
            System.out.println("낫싱");
        } else {
            System.out.printf("%d볼 %d스트라이크\n", ballNum, strikeNum);
        }
        if(strikeNum == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return true;
        }
        return false;
    }
}
