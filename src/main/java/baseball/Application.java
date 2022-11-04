package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        play();
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

    public static String inputGuess() {
        String guess = Console.readLine();
        if (!isValid(guess)) {
            throw new IllegalArgumentException();
        }
        return guess;
    }

    public static GuessInfo makeGuessInfo(String guess, String answer) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            int matchIndex = answer.indexOf(guess.charAt(i));
            if (matchIndex == i) {
                strike += 1;
            } else if (matchIndex != -1) {
                ball += 1;
            }
        }
        return new GuessInfo(strike, ball);
    }

    public static void play() {
        String answer = generateAnswer();
        String guess;
        do {
            guess = inputGuess();
            GuessInfo result = makeGuessInfo(guess, answer);
            result.show();
        }
        while (!guess.equals(answer));
    }
}
