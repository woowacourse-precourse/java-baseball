package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            play();
        }
        while (wantNewGame());
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
        if (numbers.contains("0")) {
            return false;
        }
        return numbers.charAt(0) != numbers.charAt(1)
                && numbers.charAt(1) != numbers.charAt(2)
                && numbers.charAt(2) != numbers.charAt(0);
    }

    public static String inputGuess() {
        System.out.print("숫자를 입력해주세요 : ");
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

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static boolean wantNewGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        return input.equals("1");
    }
}
