package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        startGame();
    }

    static void startGame() {
        String randomThree = getRandomThree();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String s = Console.readLine();

            isNotLengthThree(s);
            isNotNumeric(s);

            printResult(s,randomThree);

            if (s.equals(randomThree)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임 종료");
                break;
            }
        }
        chooseResetOrExit();
    }

    static  void isNotLengthThree(String s) {
        if (s.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    static void isNotNumeric(String s) {
        for (int i=0;i<3;i++) {
            char c = s.charAt(i);
            if ('0' > c || '9' < c){
                throw new IllegalArgumentException();
            }

        }
    }

    static String getRandomThree() {
        List<Integer> randomList = new ArrayList<>();
        while (randomList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomList.contains(randomNumber)) {
                randomList.add(randomNumber);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<3;i++)
            builder.append(randomList.get(i));
        return builder.toString();
    }

    static void printResult(String input, String randomThree) {
        int strike = 0;
        int ball = 0;
        for (int i=0;i<3;i++) {
            int index = randomThree.indexOf(input.charAt(i));
            if (index == i) {
                strike++;
                continue;
            }
            if (index >= 0) {
                ball++;
            }
        }
        printStrikeBall(strike, ball);
    }

    static void printStrikeBall(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }
        if (strike > 0 && ball == 0) {
            System.out.println(strike+"스트라이크");
            return;
        }
        if (strike == 0 && ball > 0) {
            System.out.println(ball+"볼");
            return;
        }
        System.out.println(ball+"볼 "+strike+"스트라이크");
    }

    static void chooseResetOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String s = Console.readLine();
        resetOfExit(s);
    }

    static void resetOfExit(String s) {
        if (s.equals("1")) {
            startGame();
            return;
        }
        if (s.equals("2")) {
            return;
        }
        throw new IllegalArgumentException();
    }
}
