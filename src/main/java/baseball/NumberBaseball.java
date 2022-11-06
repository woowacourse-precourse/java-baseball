package baseball;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class NumberBaseball {
    private static final int NUMBER_SIZE = 3;

    private static final int START_NUMBER = 1;

    private static final int END_NUMBER = 9;

    private static final int ASCII_ZERO = 48;

    private static final int ASCII_NINE = 57;

    private static final int ASCII_ONE = 49;

    private static final int ASCII_TWO = 50;

    private ArrayList<Character> numbers;

    public NumberBaseball() {
        this.numbers = new ArrayList<>(NUMBER_SIZE);
    }

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            setNumbers();
            playGame();
        } while (isRestart());
    }

    private void playGame() {
        int ballCount = 0;
        int strikeCount = 0;

        while (strikeCount != 3) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();

            if (userInput.length() != 3) {
                throw new IllegalArgumentException("숫자 3자리를 입력을 해야합니다.");
            }

            for (int i = 0; i < userInput.length(); ++i) {
                checkNumberCharacter(userInput.charAt(i));
            }

            ballCount = getBallCount(userInput);
            strikeCount = getStrikeCount(userInput);

            if (ballCount > 0 && strikeCount > 0) {
                System.out.printf("%d볼 %d스트라이크%s", ballCount, strikeCount, System.lineSeparator());
            } else if (ballCount > 0) {
                System.out.printf("%d볼%s", ballCount, System.lineSeparator());
            } else if (strikeCount > 0) {
                System.out.printf("%d스트라이크%s", strikeCount, System.lineSeparator());
            } else {
                System.out.printf("낫싱%s", System.lineSeparator());
            }
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private boolean isRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();

        if (userInput.length() != 1) {
            throw new IllegalArgumentException("숫자 1자리를 입력을 해야합니다.");
        }

        if (userInput.charAt(0) != ASCII_ONE && userInput.charAt(0) != ASCII_TWO) {
            throw new IllegalArgumentException("숫자 '1' 또는 '2'를 입력을 해야합니다.");
        }

        if (userInput.equals("1")) {
            return true;
        }

        return false;
    }

    private int getBallCount(String presentNumber) {
        int ballCount = 0;

        for (int i = 0; i < presentNumber.length(); ++i) {
            char value = presentNumber.charAt(i);

            if (isBall(value, i)) {
                ++ballCount;
            }
        }

        return ballCount;
    }

    private int getStrikeCount(String presentNumber) {
        int strikeCount = 0;

        for (int i = 0; i < presentNumber.length(); ++i) {
            char value = presentNumber.charAt(i);

            if (value == this.numbers.get(i).charValue()) {
                ++strikeCount;
            }
        }

        return strikeCount;
    }

    private boolean isBall(char value, int index) {
        boolean condition1 = this.numbers.contains(Character.valueOf(value));
        boolean condition2 = this.numbers.indexOf(Character.valueOf(value)) != index;
        return condition1 && condition2;
    }

    private void checkNumberCharacter(char value) {
        if (value < ASCII_ZERO || value > ASCII_NINE) {
            throw new IllegalArgumentException("숫자 문자가 아닙니다.");
        }
    }

    private void setNumbers() {
        this.numbers.clear();
        while (numbers.size() != 3) {
            int value = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);

            Character character = Character.valueOf((char) (value + ASCII_ZERO));

            if (!this.numbers.contains(character)) {
                this.numbers.add(character);
            }
        }
    }
}