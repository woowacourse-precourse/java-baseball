package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class Stage {
    private Number computerNumber;
    private Number userNumber;

    public Stage(Number computerNumber) {
        this.computerNumber = computerNumber;
    }

    public void progress() {
        System.out.print("숫자를 입력해주세요 : ");
        String line = Console.readLine();
        validNumberInput(line);
        userNumber = new Number(line);
        StageResult stageResult = new StageResult(computerNumber, userNumber);
        stageResult.print();
    }

    private void validNumberInput(String line) {
        validLength(line.length());
        validInteger(line);
        validDuplicate(line);
    }

    private void validDuplicate(String line) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < line.length(); i++) {
            set.add(Character.getNumericValue(line.charAt(i)));
        }
        validLength(set.size());
    }

    private void validInteger(String line) {
        try {
            Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validLength(int length) {
        if (length != 3) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isComplete() {
        return computerNumber.equals(userNumber);
    }
}
