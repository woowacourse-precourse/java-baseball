package baseball;

import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String answer = Randoms.pickNumberInRange(1, 9) + "" + Randoms.pickNumberInRange(1, 9) + Randoms.pickNumberInRange(1, 9);
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();


            if (!isValid(input)) {
                throw new IllegalArgumentException();
            }


            int strikes = getStrikes(input, answer);
            int balls = getTotal(input, answer) - strikes;


            if (balls == 0 && strikes == 0) {
                System.out.println("낫싱");
                continue;
            } else if (balls == 0 && strikes != 3) {
                System.out.println(strikes + "스트라이크");
                continue;
            } else if (strikes == 0 && balls > 0) {
                System.out.println(balls + "볼");
                continue;
            } else if (balls > 0 && strikes > 0) {
                System.out.println(balls + "볼 " + strikes + "스트라이크");
                continue;
            }


            System.out.println("3스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input = Console.readLine();


            if (isStopOrContinue(input) == 1) {
                answer = Randoms.pickNumberInRange(1, 9) + "" + Randoms.pickNumberInRange(1, 9) + Randoms.pickNumberInRange(1, 9);
            } else if (isStopOrContinue(input) == 2) {
                break;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public static boolean isValid(String input) {
        if (input.length() != 3) return false;
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    public static int getStrikes(String input, String answer) {
        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            if (input.charAt(i) == answer.charAt(i)) strikes += 1;
        }
        return strikes;
    }

    public static int getTotal(String input, String answer) {
        int total = 0;
        for (int i = 0; i < 3; i += 1) {
            if (answer.contains(input.charAt(i) + "")) total += 1;
        }
        return total;
    }

    public static int isStopOrContinue(String input) {
        if (input.equals("1")) {
            return 1;
        }
        if (input.equals("2")) {
            return 2;
        }
        return 0;
    }
}
