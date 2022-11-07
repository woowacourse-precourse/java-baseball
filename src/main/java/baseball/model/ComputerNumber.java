package baseball.model;

import baseball.util.NumberNaming;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
컴퓨터 숫자를 구해서 List로 반환
 */
public class ComputerNumber {

    public List<Integer> getComputerRandomNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < NumberNaming.MAX_NUMBER_SIZE) {
            createRandomNumber(computerNumber, Randoms.pickNumberInRange(NumberNaming.MIN_RANGE_NUM, NumberNaming.MAX_RANGE_NUM));
        }
        return computerNumber = Collections.unmodifiableList(computerNumber);
    }

    public void createRandomNumber(List<Integer> RandomNumberList, int number) {
        if (!RandomNumberList.contains(number)) {
            RandomNumberList.add(number);
        }
    }
}




