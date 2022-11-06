package baseball;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class NumberBaseball {
    private static final int NUMBER_SIZE = 3;

    private static final int START_NUMBER = 1;

    private static final int END_NUMBER = 9;

    private static final int ASCII_START = 48;

    private ArrayList<Character> numbers;

    public NumberBaseball() {
        this.numbers = new ArrayList<>(NUMBER_SIZE);

        while (numbers.size() != 3) {
            int value = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);

            Character character = Character.valueOf((char) (value + ASCII_START));

            if (!this.numbers.contains(character)) {
                this.numbers.add(character);
            }
        }
    }

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            playGame();
        } while (isRestart());
    }

    private void playGame() {
        int ballCount = 0;
        int strikeCount = 0;

        while (strikeCount != 3) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();
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

}