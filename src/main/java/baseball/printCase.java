package baseball;

import java.util.List;

public class printCase {
    public static void makePrintCase(List<Integer> answerNumber, List<Integer> inputNumber) {
//        ArrayList<Integer> strike = new ArrayList<>();
//        ArrayList<Integer> ball = new ArrayList<>();

        int strikeNum = 0;
        int ballNum = 0;

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

        System.out.printf("%d볼 %d스트라이크\n", ballNum, strikeNum);
        if(strikeNum == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        }
    }
}
