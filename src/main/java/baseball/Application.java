package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    private static List<Integer> createRandomNumber() {
        List<Integer> computer_num = new ArrayList<>();

        while (computer_num.size() < 3) {
            int random_number = Randoms.pickNumberInRange(1, 9);
            if (!computer_num.contains(random_number)) {
                computer_num.add(random_number);
            }
        }
        return computer_num;
    }

    private static List<Integer> numToList(String number) {
        List<Integer> number_list = new ArrayList<>();

        String[] number_split = number.split("");

        for (String num : number_split) {
            int to_int = Integer.parseInt(num);
            number_list.add(to_int);
        }

        return number_list;
    }

    private static int countStrike(
            List<Integer> computer_number,
            List<Integer> user_number
    ) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            if (computer_number.get(i).equals(user_number.get(i))) {
                count += 1;
            }
        }

        return count;
    }

    private static int countBall(
            List<Integer> computer_number,
            List<Integer> user_number,
            int strike
    ) {
        int count = 0;

        for (Integer number : user_number) {
            if (computer_number.contains(number)) {
                count += 1;
            }
        }

        count -= strike;

        return count;
    }

    private static String setHint(int ball, int strike) {

        if (ball + strike == 0) {
            return "낫싱";
        }

        String hint = "";

        if (ball > 0) {
            hint = hint.concat(Integer.toString(ball));
            hint = hint.concat("볼");

            if (strike > 0) {
                hint = hint.concat(" ");
            }
        }

        if (strike > 0) {
            hint = hint.concat(Integer.toString(strike));
            hint = hint.concat("스트라이크");
        }

        return hint;
    }

    private static void validateUserNumber(String user_number) {
        if (user_number.length() != 3) {
            throw new IllegalArgumentException("입력된 값의 길이가 3이 아닙니다.");
        }

        String pattern = "^[1-9]*$";
        boolean is_match = Pattern.matches(pattern, user_number);

        if (!(is_match)) {
            throw new IllegalArgumentException("1-9 외의 값이 입력되었습니다.");
        }

        String[] number_split = user_number.split("");
        boolean is_duplicate = number_split[0].equals(number_split[1]);
        is_duplicate = is_duplicate || number_split[0].equals(number_split[2]);
        is_duplicate = is_duplicate || number_split[1].equals(number_split[2]);

        if (is_duplicate) {
            throw new IllegalArgumentException("중복된 수가 입력되었습니다.");
        }
    }

    private static void validateGameStart(String user_input) {
        String pattern = "^[1-2]$";
        boolean is_match = Pattern.matches(pattern, user_input);

        if (!(is_match)) {
            throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
        }
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer_num = createRandomNumber();
        String user_input = "1";

        while (user_input.equals("1")) {
            System.out.print("숫자를 입력해주세요 : ");
            String guess_number = Console.readLine();
            validateUserNumber(guess_number);
            List<Integer> user_num = numToList(guess_number);
            int strike = countStrike(computer_num, user_num);
            int ball = countBall(computer_num, user_num, strike);
            System.out.println(setHint(ball, strike));

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                user_input = Console.readLine();
                validateGameStart(user_input);
                computer_num = createRandomNumber();
            }
        }
    }
}
