package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int answer;

        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            answer = gameStart();

            if (!(answer == 1) && !(answer == 2)) {
                throw new IllegalArgumentException("잘못 입력!");
            }

        } while (answer == 1);

        System.exit(0);

    }


    public static int gameStart() {
        List<Integer> computer = new ArrayList<>();

        int answer;

        while (computer.size() < 3) {

            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        inputNumber(computer);

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        answer = Integer.parseInt(Console.readLine());

        return answer;
    }


    public static void inputNumber(List<Integer> computer) {
        boolean check;
        List<Integer> user;

        do {
            System.out.print("숫자를 입력해주세요 : ");

            int input = Integer.parseInt(Console.readLine());

            user = splitNumber(input);

            check = new HashSet<>(computer).containsAll(user);

            if (!check) {

                checkInput(user);

                printAnswer(computer, user);

            }
        } while (!check);

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void checkInput(List<Integer> user) {

        Set<Integer> userSet = new HashSet<>(user);

        if (userSet.size() != user.size()) {

            throw new IllegalArgumentException("중복된 숫자 입력!");

        }

    }

    public static void printAnswer(List<Integer> computer, List<Integer> user) {

        int strike = 0;

        int ball;

        String result = "";
        for (int i = computer.size() - 1; i >= 0; i--) {

            if (Objects.equals(computer.get(i), user.get(i))) {

                user.remove(i);

                strike++;

            }
        }

        user.retainAll(computer);

        ball = user.size();

        if (strike == 0 && ball == 0) {

            result = result.concat("낫싱");

        }
        if (ball > 0) {

            result = result.concat(ball + "볼 ");

        }

        if (strike > 0) {

            result = result.concat(strike + "스트라이크");

        }
        System.out.println(result);

    }

    public static List<Integer> splitNumber(int number) {
        List<Integer> splitInt = new ArrayList<>();

        int langthNumber = (int) (Math.log10(number));

        int divide = (int) Math.pow(10, langthNumber);

        while (divide > 0) {

            splitInt.add(number / divide);

            number %= divide;

            divide /= 10;
        }
        return splitInt;
    }

}

