package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        boolean gameLife = true;
        String number;

        while (gameLife) {
            number = setNumber();
            gameLife = playGame(number);
        }
    }

    private static boolean playGame(String number) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        String inputNumber = inputNumberFromPlayer();
    }

    public static String inputNumberFromPlayer() {

        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();

        return inputNumber;
    }

    public static String setNumber() {

        int first = Randoms.pickNumberInRange(1, 9);
        int second = Randoms.pickNumberInRange(1, 9);
        int third = Randoms.pickNumberInRange(1, 9);

        while (second == first) {
            second = Randoms.pickNumberInRange(1, 9);
        }

        while (third == first || third == second) {
            third = Randoms.pickNumberInRange(1, 9);
        }

        Integer number = (first * 100) + (second * 10) + third;
        return number.toString();
    }
}