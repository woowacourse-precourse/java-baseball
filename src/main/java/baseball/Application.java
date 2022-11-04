package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        int restart = 1;
        while(restart == 1) {
            String answer = makeBall();
            System.out.println("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            int[] result = count(answer, input); // [0] = strikes, [1] = balls

            boolean isEnd = printRes(result);

        }
    }

    public static String makeBall() {
        List<Integer> cands = new ArrayList<>();
        while(cands.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if(!cands.contains(num)) {
                cands.add(num);
            }
        }
        String balls = "";
        for(int ball : cands) {
            balls += ball;
        }
        return balls;
    }

    public static int[] count(String answer, String input) {
        int[] res = new int[2];
        for(int idx = 0; idx < 3; idx++) {
            if(input.charAt(idx) == answer.charAt(idx)) {
                res[0]++;
            } else if(answer.indexOf(input.charAt(idx)) != -1) {
                res[1]++;
            }
        }
        return res;
    }

    public static boolean printRes(int[] result) {
        boolean flag = false;
        if(result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        } else if(result[0] == 0) {
            System.out.println(String.format("%d볼", result[1]));
        } else if(result[1] == 0) {
            System.out.println(String.format("%d스트라이크", result[0]));
            if(result[0] == 3) {
                flag = true;
            }
        } else {
            System.out.println(String.format("%d볼 %d스트라이크", result[1], result[0]));
        }
        return flag;
    }
}
