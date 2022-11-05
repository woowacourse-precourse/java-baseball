package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            List<Integer> computer = getRandomNum();
            System.out.println(computer);

            int strike;
            int ball;

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");

                strike = 0;
                ball = 0;

                String number = Console.readLine();
                verifyNum(number);

                for(int i = 0; i < number.length(); i++) {

                    int num = Integer.parseInt(String.valueOf(number.charAt(i)));
                    if (num == computer.get(i)) {
                        strike++;
                    }
                    if (num != computer.get(i) && computer.contains(num) ) {
                        ball++;
                    }
                }

                if(Boolean.TRUE.equals(result(strike, ball))) {
                    break;
                }
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            int checkNum = Integer.parseInt(Console.readLine());
            if(Boolean.TRUE.equals(restartCheck(checkNum))) {
                break;
            }
        }
    }
    public static List<Integer> getRandomNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void verifyNum(String number) {

        if(number.length() != 3) {
            throw new IllegalArgumentException();
        }
        if(number.charAt(0) == number.charAt(1) || number.charAt(1) == number.charAt(2) ||
                number.charAt(0) == number.charAt(2)) {
            throw new IllegalArgumentException();
        }
    }
    public static Boolean result(int strike, int ball) {

        boolean flag = false;

        if (strike != 0 && strike != 3 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0 && strike != 3 && strike != 0) {
            System.out.println(strike + "스트라이크");
        } else if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (strike == 3) {
            System.out.println(strike + "스트라이크");
            flag = true;
        }
        return flag;
    }

    public static Boolean restartCheck(int num) {

        if(num == 1) {
            return false;
        }
        if(num == 2) {
            return true;
        }
        else throw new IllegalArgumentException();
    }
}
