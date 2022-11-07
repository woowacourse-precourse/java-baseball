package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final List<Integer> numbers;

    public Player() {
        this.numbers = new ArrayList<>();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void input() {
        System.out.printf("숫자를 입력해주세요 : ");
        setUserNumbers();
    }

    public int gameOverInput() {
        System.out.println("축하합니다! 경기를 다시 시작하겠습니까? 다시 시작 : 1, 종료 : 2");
        String input = readLine();
        validateInputLength(input.length(), 1);
        validateGameOverInput(Integer.parseInt(input));
        return Integer.parseInt(input);
    }

    public void setUserNumbers() {
        this.numbers.clear();
        String input = readLine();
        validateInputLength(input.length(), 3);
        for (int i = 0; i < input.length(); i++) {
            int number = Character.getNumericValue(input.charAt(i));
            validateInputRangeNumber(number);
            validateDuplicateInput(number);
            this.numbers.add(number);
        }
    }

    public void setComputerNumbers() {
        while (this.numbers.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            this.numbers.add(randomNumber);
        }
    }

    public void validateInputLength(int length, int maxLength) {
        if (length != maxLength) {
            throw new IllegalArgumentException(String.format("입력값은 %s 자여야 합니다.", maxLength));
        }
    }

    public void validateInputRangeNumber(int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("입력값은 1 ~ 9 사이의 값이어야 합니다.");
        }
    }

    public void validateDuplicateInput(int number) {
        if (this.numbers.contains(number)) {
            throw new IllegalArgumentException("중복된 값이 존재합니다.");
        }
    }

    public void validateGameOverInput(int number) {
        if (number < 1 || number > 2) {
            throw new IllegalArgumentException("입력값은 1 또는 2 의 값이어야 합니다.");
        }
    }
}
