package baseball.domain.comparator;

import baseball.domain.number.BaseBallGameNumber;
import baseball.domain.number.BaseBallGameNumbers;
import baseball.domain.result.CompareResult;

import java.util.List;

public class Comparator {

    public CompareResult compare(BaseBallGameNumbers playerNumbers, BaseBallGameNumbers computerNumbers) {
        List<BaseBallGameNumber> inputNumbers = computerNumbers.numbers();
        List<BaseBallGameNumber> resultNumbers = playerNumbers.numbers();

        CompareResult compareResult = new CompareResult();
        int size = resultNumbers.size();
        for (int index = 0; index < size; index++) {
            compare(index, inputNumbers, resultNumbers, compareResult);
        }

        return compareResult;
    }

    private void compare(int index,List<BaseBallGameNumber> inputNumbers,
                         List<BaseBallGameNumber> resultNumbers, CompareResult compareResult) {

        BaseBallGameNumber inputNumber = inputNumbers.get(index);
        BaseBallGameNumber resultNumber = resultNumbers.get(index);

        if (isStrike(inputNumber, resultNumber)) {
            compareResult.addStrike();
            return;
        }

        if (isBall(inputNumber, resultNumbers)){
            compareResult.addBall();
        }
    }

    private boolean isStrike(BaseBallGameNumber inputNumber, BaseBallGameNumber resultNumber) {
        return inputNumber.equals(resultNumber);
    }

    private boolean isBall(BaseBallGameNumber inputNumber, List<BaseBallGameNumber> resultNumbers) {
        return resultNumbers.contains(inputNumber);
    }
}
