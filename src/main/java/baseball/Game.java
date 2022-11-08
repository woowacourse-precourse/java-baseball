package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static int[] getScore(List<Integer> answer, String guess) {
        int[] result = {0, 0}; //스트라이크, 볼
        for (int i = 0; i < 3; i++) {
            int c = Character.getNumericValue(guess.charAt(i));
            if (answer.get(i) == c) {
                result[0]++;
                continue;
            } else if (answer.contains(c))
                result[1]++;
        }

        if (result[0] == 0) {
            if (result[0] == result[1])
                System.out.println("낫싱");
            else
                System.out.printf("%d볼\n", result[1]);
        } else if (result[1] == 0)
            System.out.printf("%d스트라이크\n", result[0]);
        else
            System.out.printf("%d볼 %d스트라이크\n", result[1], result[0]);

        return result;
    }

    public int gameStart(List<Integer> answer) {
        int strike = 0;
        int state;
        while (strike != 3) {
            System.out.print("숫자를 입력해주세요 : ");
            String guess;
            guess = Console.readLine();
            state = checkNumber(guess);
            if (state != 0)
                return state;
            int[] score = getScore(answer, guess);
            strike = score[0];
        }
        return 0;
    }

    public static List<Integer> createNumber() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }

        return answer;
    }

    public static int checkNumber(String input) throws IllegalArgumentException {
        if (input.equals("1") || input.equals("2"))
            return Integer.parseInt(input);
        else if (input.length() != 3)
            throw new IllegalArgumentException("3자리 숫자를 입력하세요");

        for (int i = 0; i < 3; i++) {
            String x = Character.toString(input.charAt(i));
            if (x.equals("0"))
                throw new IllegalArgumentException("1부터 9까지의 수를 입력하세요");
            try {
                int j = Integer.parseInt(x);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자를 입력하세요");
            }
            String s = input;
            s = s.replace(x, "");
            if (s.contains(x))
                throw new IllegalArgumentException("서로 다른 3자리 숫자를 입력하세요");

        }
        return 0;
    }
}
