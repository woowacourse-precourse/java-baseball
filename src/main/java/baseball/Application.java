package baseball;


import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        boolean restart = true;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (restart) {

            List<Integer> computer_num = Randoms.pickUniqueNumbersInRange(1,9,3);
            System.out.println("computer_num = " + computer_num);

            restart = playGame(computer_num);



        }








    }

    public static boolean playGame(List<Integer> computer_num) {
        int strike;
        int ball;

        while (true) {

            System.out.println("숫자를 입력해주세요 : ");

            String answer = Console.readLine();

            strike = checkStrike(computer_num,answer);

            ball = checkBall(computer_num,answer);

            printResult(strike,ball);

            if (strike == 3) {
                break;
            }
        }


        return askContinue();
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

    public static void printResult(int strike, int ball) {

        if (strike + ball == 0) {
            System.out.println("낫싱");
        } else {
            if (ball > 0) {
                System.out.print(ball+"볼 ");
            }
            if (strike > 0) {
                System.out.println(strike+"스트라이크 ");
            }

        }
    }

    public static boolean askContinue() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        while (true){
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String answer = Console.readLine();

            if (answer.equals("1")){
                return true;
            } else if (answer.equals("2")) {
                return false;
            } else {
                throw new IllegalArgumentException("숫자 1,2중 하나로 입력해야 합니다.");
            }
        }

    }


}
