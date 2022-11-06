package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        String computerNumber = "";

        int total = 0;
        int strike = 0;


//        List<Integer> computer = new ArrayList<>();
//        while (computer.size() < 3) {
//            int randomNumber = Randoms.pickNumberInRange(1, 9);
//            if (!computer.contains(randomNumber)) {
//                computer.add(randomNumber);
//            }
//        }
//
//        for (int item : computer) {
//            String numberStr = Integer.toString(item);
//            computerNumber += numberStr; // 'abc'
//        }


//        while (true) {
//
//            Random random = new Random();
//            int number = random.nextInt(9) + 1; // 1 ~ 9 까지의 무작위 int 값 리턴
//            nonce.add(number);
//
//            if (nonce.size() == 3) {
//                for (int item : nonce) {
//                    String numberStr = Integer.toString(item);
//                    computerNumber += numberStr; // 'abc'
//                }
//                break;
//            }
//        }

        System.out.println("숫자 야구 게임을 시작합니다.");
        String computerNumber = computerRandomNumber();

        while (true){ // 3 indent
            System.out.println("컴퓨터 숫자는 : " + computerNumber);
            System.out.print("숫자를 입력해주세요 : ");
            String userNumber = Console.readLine();
            /// ball 계산은 total 에서 strike 빼면 될듯? 예를들어 2개가 겹친다 치고 스트라이크가 1 이면 나머지 1이 볼이된다.

            /// 몇개 숫자가 같은지 = total
            for (String number : computerNumber.split("")) {
                if (userNumber.contains(number)) { // 몇개 숫자가 같은지
                    total++;
                }
            }

            /// 그중 위치가 같은게 있으면 if charAt(0) == charAt(0) strike += 1
            for (int i = 0; i < 3; i++) {
                if (userNumber.charAt(i) == computerNumber.charAt(i)){
                    strike++;
                }
            }

            int ball = (total - strike);

            if (strike == 3){
                System.out.println(strike + "스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int restartNumber = Integer.parseInt(Console.readLine());
                if (restartNumber == 1){
                    total = 0;
                    ball = 0;
                    strike = 0;
                    // 랜덤값 바뀌는 메소드
                    continue;
                }
                else if (restartNumber == 2){
                    total = 0;
                    ball = 0;
                    strike = 0;
                    break;
                }
            }
            else if (strike > 0 && ball > 0){
                System.out.println(ball + "볼" + strike + "스트라이크");
                total = 0;
                ball = 0;
                strike = 0;
            }
            else if (strike == 0 && ball > 0){
                System.out.println(ball + "볼");
                total = 0;
                ball = 0;
                strike = 0;
            }
            else if (strike > 0 && ball == 0){
                System.out.println(strike + "스트라이크");
                total = 0;
                ball = 0;
                strike = 0;
            }
            else if (strike == 0 && ball == 0){
                System.out.println("낫싱");
                total = 0;
                ball = 0;
                strike = 0;
            }

        }

    }

    public static String computerRandomNumber()  {
        List<Integer> computer = new ArrayList<>();
        String computerNumber = "";

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        for (int item : computer) {
            String numberStr = Integer.toString(item);
            computerNumber += numberStr; // 'abc'
        }
        return  computerNumber;
    }

}

