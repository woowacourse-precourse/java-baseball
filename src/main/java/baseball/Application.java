package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {

    }

    public static String generateAnswer() {
        StringBuilder answer = new StringBuilder();
        while (answer.length() < 3) {
            String number = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (!answer.toString().contains(number)) {
                answer.append(number);
            }
        }
        return answer.toString();
    }

    public static boolean isValid(String numbers) {
        if (numbers.length() != 3) {
            return false;
        }
        return numbers.charAt(0) != numbers.charAt(1)
                && numbers.charAt(1) != numbers.charAt(2)
                && numbers.charAt(2) != numbers.charAt(0);
    }
}
