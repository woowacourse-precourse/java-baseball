package baseball;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.util.Sets;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static camp.nextstep.edu.missionutils.Console.*;


public class Application {

    /* 정답 숫자 생성 */
    public static int createNumber() {
        while (true) {
            int first = pickNumberInRange(1, 9);
            int second = pickNumberInRange(1, 9);
            int third = pickNumberInRange(1, 9);

            if (first != second && second != third && first != third) {
                return 100*first + 10*second + third;
            }
        }
    }

    /* 예외 처리 */
    public static void isValidNumber(String number){
        if(number.length() != 3){
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }


    /* 볼, 스트라이크 카운팅 */
    public static List<Integer> countBallStrike(int answer, int submit) {
        List submit_letter = List.of(String.valueOf(submit).split(""));
        List answer_letter = List.of(String.valueOf(answer).split(""));
        HashSet<String> intersection = new HashSet(answer_letter);
        intersection.retainAll(submit_letter);
        int ball = intersection.size();
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (Objects.equals(submit_letter.get(i), answer_letter.get(i))) {
                strike = strike + 1;
                ball = ball - 1;
            }
        }
        return List.of(ball, strike);

    }

    /* 힌트 메시지 출력 */
    public static void printHint(List<Integer> count) {
        int ball = count.get(0);
        int strike = count.get(1);
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (strike == 3) {
            System.out.println("3스트라이크");
        } else {
            System.out.print(String.format("%d볼".repeat((ball > 0) ? 1 : 0), ball));
            System.out.println(String.format(" %d스트라이크".repeat((strike > 0) ? 1 : 0), strike));
        }

    }

    /* 야구게임 플레이 */
    public static void playBaseball(){
        int answer = createNumber();

        while(true){
            String submit = readLine();
            isValidNumber(submit);
            List<Integer> count = countBallStrike(answer, Integer.valueOf(submit));
            printHint(count);
            if(answer == Integer.valueOf(submit)){
                System.out.println("게임 종료");
                return ;
            }
        }
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while(true){
            playBaseball();
            int retry = Integer.valueOf(readLine());

            if(retry == 2){
                return ;
            }

        }

        }
    }

