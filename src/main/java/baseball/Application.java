package baseball;


import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Integer> computer_num = Randoms.pickUniqueNumbersInRange(1,9,3);
        System.out.println("computer_num = " + computer_num);

        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println("숫자를 입력해주세요 : ");
        String answer = Console.readLine();

        int strike = checkStrike(computer_num,answer);
        System.out.println(strike);

        int ball = checkBall(computer_num,answer);
        System.out.println(ball);
    }

    public static int checkStrike(List<Integer> computer_num, String answer) {
        int cnt = 0;
        for (int i = 0; i < 3; i++){
            if (computer_num.get(i) == answer.charAt(i) - '0'){
                cnt += 1;
            }
        }
        
        return cnt;
    }


    public static int checkBall(List<Integer> computer_num, String answer) {
        int cnt = 0;
        for (int i = 0; i < 3; i++){
            for (int j =0; j < 3; j++) {
                if (computer_num.get(i) == answer.charAt(j) - '0' && i != j){
                    cnt += 1;
                }
            }
        }

        return cnt;
    }




}
