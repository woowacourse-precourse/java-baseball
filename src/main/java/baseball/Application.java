package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int[] numArr = new int[3];
        int[] inputArr = new int[3];
        int strike = 0;
        int ball = 0;


        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = (int) (Math.random() * 9 + 1);
            for (int j = 0; j < i; j++) {
                if (numArr[j] == numArr[i]) {
                    i--;
                    break;
                }
            }
        }

        for (int x : numArr) {
            System.out.println(x + " ");
        }


        Scanner s = new Scanner(System.in);
        while (true) {

            for (int i = 0; i < inputArr.length; i++) {
                System.out.println("숫자를 입력해주세요 : ");
                inputArr[i] = s.nextInt();

            }

            for (int i = 0; i < numArr.length; i++) {
                for (int j = 0; j < inputArr.length; j++) {

                    if (numArr[i] == inputArr[j] && i == j) {

                        strike++;
                    } else if (numArr[i] == inputArr[j] && i != j) {

                        ball++;
                    }
                }
            }

            System.out.println(strike + "스트라이크" + ball + "볼");
            if (strike == 3) {
                System.out.println("3스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            strike = 0;
            ball = 0;
        }
    }
}
