package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");
        String answerNum = createAnswer();
        System.out.println(answerNum);

        int endPoint = 0;
        while(endPoint != 2){
            System.out.println("숫자를 입력해주세요 : ");
            String inputNum = Console.readLine();
            int strike = countStrike(answerNum, inputNum);
            int ball = countBall(answerNum, inputNum, strike);

            endPoint = giveScore(strike, ball);
        }

    }

    private static int giveScore(int strike, int ball) {
        if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return 2;
        }

        System.out.println(ball+"볼 "+strike+"스트라이크");
        return 0;
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
        Set<Integer> set = new HashSet<>();
        StringBuilder answer = new StringBuilder();

        while(set.size() < 3){
            int n = Randoms.pickNumberInRange(1,9);
            set.add(n);
        }

        for (Integer integer : set) {
            answer.append(integer);
        }

        return answer.toString();
    }
}
