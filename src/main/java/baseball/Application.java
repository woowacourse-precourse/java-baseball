package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static int distinguishStrike (List<Integer> inputNumberList, List<Integer> computerNumberList) {
        int strikeCounting = 0;

        for (int i = 0; i <3; i++) {
            if (inputNumberList.get(i).equals(computerNumberList.get(i))) {
                strikeCounting += 1;
            }
        }

        return strikeCounting;
    }

    // 수정 필요 중복된 값을 처리 못 함
    public static int distinguishBall (List<Integer> inputNumberList, List<Integer> computerNumberList, int strikeCounting) {
        int ballCounting = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumberList.contains(inputNumberList.get(i))) {
                ballCounting += 1;
            }
        }

        return ballCounting - strikeCounting;
    }

    public static void makeComputerNumber (List<Integer> computerNumberList) {
        for (int j = 0; j < 3; j++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }
    }

    public static void splitNumber (List<Integer> inputNumberList, String inputNumber) {

        for (int k = 0; k < 3; k++) {
            inputNumberList.add(Character.getNumericValue(inputNumber.charAt(k)));
        }

        //return inputNumberList;
    }

    public static void printResult (int ballCounting, int strikeCounting) {
        if (strikeCounting == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }else if (strikeCounting > 0 && ballCounting == 0) {
            System.out.printf("%d스트라이크", strikeCounting);
        }else if (strikeCounting == 0 && ballCounting > 0) {
            System.out.printf("%d볼", ballCounting);
        }else if (strikeCounting > 0 && ballCounting > 0) {
            System.out.printf("%d볼 %d스트라이크", ballCounting, strikeCounting);
        }else {
            System.out.println("낫싱");
        }
    }


    public static void main(String[] args) {

        List<Integer> computerNumberList = new ArrayList<>();
        List<Integer> inputNumberList = new ArrayList<>();
        makeComputerNumber(computerNumberList);

        while (true) {
            splitNumber(inputNumberList, Console.readLine());
            int strikeCounting = distinguishStrike(inputNumberList, computerNumberList);
            int ballCounting = distinguishBall(inputNumberList, computerNumberList, strikeCounting);
            inputNumberList.clear();

            printResult(ballCounting, strikeCounting);

            if (strikeCounting == 3) break;
        }

    }
}
