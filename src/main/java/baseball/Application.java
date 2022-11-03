package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static List<Integer> generateRandomNumber() // 난수 생성
    {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static int checkRightNumber(String number, List<Integer> computer) {
        int strike = 0;
        int ball = 0;
        int pickedNumber = 0;

        for(int i=0; i<3; i++) {
            pickedNumber = Character.getNumericValue(number.charAt(i));

            if(pickedNumber == computer.get(i)) strike += 1;
            else if(computer.contains(pickedNumber)) ball += 1;
        }

        if(strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            return -1;
        }

        if(strike == 0 && ball == 0) {
            System.out.println("낫싱");

            return 0;
        }

        else {
            if(ball > 0) System.out.print(ball + "볼 ");
            if(strike > 0) System.out.print(strike + "스트라이크");

            System.out.println("");

            return 1;
        }

    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
