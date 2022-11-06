package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        startGame();

    }

    private static void startGame() {
        String answerNum = createAnswer();

        boolean endPoint = true;
        while(endPoint){
            System.out.println("숫자를 입력해주세요 : ");
            String inputNum = Console.readLine();

            if(inputNum.length() != 3) throw new IllegalArgumentException();


            int strike = countStrike(answerNum, inputNum);
            int ball = countBall(answerNum, inputNum, strike);

            endPoint = giveScore(strike, ball);
        }

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int startOrEnd = Integer.parseInt(Console.readLine());
        if(startOrEnd == 1) startGame();
    }

    private static boolean giveScore(int strike, int ball) {
        if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }
        if(strike == 0 && ball == 0){
            System.out.println("낫싱");
            return true;
        }
        System.out.println("3스트라이크");
        System.out.println(ball+"볼 "+strike+"스트라이크");
        return true;
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
        Set<Integer> set = createAnswerSet();
        StringBuilder answer = new StringBuilder();

        for (Integer integer : set) {
            answer.append(integer);
        }

        return answer.toString();
    }

    private static Set<Integer> createAnswerSet() {
        Set<Integer> set = new HashSet<>();

        while(set.size() < 3){
            int n = Randoms.pickNumberInRange(1,9);
            set.add(n);
        }

        return set;
    }
}
