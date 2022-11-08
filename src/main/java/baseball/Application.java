package baseball;


import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        boolean start = true;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (start) {

            List<Integer> computer_num = makeNum();

//            System.out.println("computer_num = " + computer_num);

            start = playGame(computer_num);



        }


    }

    public static List<Integer> makeNum(){
        List<Integer> num = new ArrayList<>();
        while (num.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!num.contains(randomNumber)) {
                num.add(randomNumber);
            }
        }
        return num;
    }

    public static boolean playGame(List<Integer> computer_num) {
        int strike;
        int ball;

        while (true) {

            System.out.println("숫자를 입력해주세요 : ");

            String answer = Console.readLine();

            checkAnswer(answer);

            strike = checkStrike(computer_num,answer);

            ball = checkBall(computer_num,answer);

            printResult(strike,ball);

            if (strike == 3) {
                break;
            }
        }


        return askContinue();
    }



    public static void checkAnswer(String answer) {

        Set<Integer> set = new HashSet<Integer>();

        if (answer.length() == 3){
            for (int i =0; i<3; i++){

                if (Character.isDigit(answer.charAt(i))){
                    set.add(answer.charAt(i)- '0');
                }

            }

            if (set.size() == 3){
                return;
            }
        }
        throw new IllegalArgumentException("3자리의 서로 다른 자연수를 입력하여 주세요.");
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
