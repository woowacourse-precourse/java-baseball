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
        ValidateUtils.checkInputLength(input.length(), 1);
        ValidateUtils.checkGameOverInput(Integer.parseInt(input));
        return Integer.parseInt(input);
    }

    public void setUserNumbers() {
        this.numbers.clear();
        String input = readLine();
        ValidateUtils.checkInputLength(input.length(), 3);
        for (int i = 0; i < input.length(); i++) {
            int number = Character.getNumericValue(input.charAt(i));
            ValidateUtils.checkInputRangeNumber(number);
            ValidateUtils.checkDuplicateInput(numbers, number);
            this.numbers.add(number);
        }
    }

    public void setComputerNumbers() {
        while (this.numbers.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            this.numbers.add(randomNumber);
        }
    }
}
