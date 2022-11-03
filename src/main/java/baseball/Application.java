package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

   public static List<Integer> getPlaceValuesFromNum(int num)  {
        int count = 0;
        List<Integer> placeValuesFromNum = new ArrayList<>();
        for(int temp = num; temp > 0; temp /= 10, count++) {
            if(temp % 10 == 0)  throw new IllegalArgumentException();
            placeValuesFromNum.add(temp % 10);
        }
        placeValuesFromNum.add(num);

        // 각 자릿수 중 같은 수가 있으면 예외 발생 필요.

        if(count == 3)  return placeValuesFromNum;
        else throw new IllegalArgumentException("세 자릿수를 입력해주세요.");
   }

    public static void ballStrikeCountFromCurrentInput(int computer, int user) {
        List<Integer> computersInputList = getPlaceValuesFromNum(computer);
        List<Integer> usersInputList = getPlaceValuesFromNum(user);

        int strike = 0;
        int ball = 0;

        if(computersInputList.get(3).equals(usersInputList.get(3))) {
            strike = 3;
        }
        else {
            for(int idx = 0; idx < computersInputList.size() - 1; idx++) {
                int computersValue = computersInputList.get(idx);
                int usersValue = usersInputList.get(idx);

                if(computersValue == usersValue)    strike++;
                else if(computersInputList.contains(usersValue))    ball++;
            }
        }

        printResult(strike, ball);

    }

    private static void printResult(int strike, int ball) {
        if(strike == 3) exitOrRestart();
        else {
            String output =
                    (strike == 0 && ball == 0)? "낫싱" :
                            (strike == 0 && ball > 0)? ball + "볼" :
                                    (strike > 0 && ball == 0)? strike + "스트라이크"
                                            : ball + "볼 " + strike + "스트라이크";
            System.out.println(output);
        }
    }

    private static void exitOrRestart() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

//        Scanner scanner = new Scanner(System.in);
//        int input = scanner.nextInt();
//        switch(input) {
//            case 1:
//                // 게임 재시작을 위한 메소드(구현 예정) 호출
//                break;
//            case 2:
//                return;
//            default:
//                throw new IllegalArgumentException("1 또는 2만 입력할 수 있습니다.");
//
//        }
    }
}
