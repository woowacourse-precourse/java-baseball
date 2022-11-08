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
        List<Integer> computerNumberList = new ArrayList<>(Collections.emptyList());
        while (computerNumberList.size() < NumberNaming.MAX_NUMBER_SIZE) {
            createRandomNumber(computerNumberList);
        }
        return Collections.unmodifiableList(computerNumberList);
    }

    private void createRandomNumber(List<Integer> RandomNumberList) {
        int number = Randoms.pickNumberInRange(NumberNaming.MIN_RANGE_NUM, NumberNaming.MAX_RANGE_NUM);
        if (!RandomNumberList.contains(number)) {
            RandomNumberList.add(number);
        }
    }
}
