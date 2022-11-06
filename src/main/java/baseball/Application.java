package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sc = new Scanner(System.in);

        System.out.println("숫자 야구 게임을 시작합니다.");
        String answerNum = createAnswer();
        System.out.println(answerNum);

        int endPoint = 0;
        while(endPoint != 2){
            System.out.println("숫자를 입력해주세요 : ");
            String inputNum = sc.next();
            int strike = countStrike(answerNum, inputNum);
            int ball = countBall(answerNum, inputNum, strike);

        }


        sc.close();
    }



    private static int countBall(String answerNum, String inputNum, int strike) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            if(answerNum.contains(String.valueOf(inputNum.charAt(i)))){
                count++;
            }
        }

        return count - strike;
    }

    private static int countStrike(String answerNum, String inputNum) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            if(answerNum.charAt(i) == inputNum.charAt(i)){
                count++;
            }
        }

        return count;
    }

    private static String createAnswer() {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            answer.append(Randoms.pickNumberInRange(1,9));
        }

        return answer.toString();
    }
}
