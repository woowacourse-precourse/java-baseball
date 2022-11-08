package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {
    @Test
    void 랜덤숫자_3개_생성() {
        List<Integer> testList = createRandomNums();
        // 생성 자리수 체크
        assertThat(testList.size()).isEqualTo(3);
        // 서로 모두 다른 수 체크
        assertThat(testList.get(0)!=testList.get(1) && testList.get(1)!= testList.get(2)).isEqualTo(true);
    }

    List<Integer> createRandomNums(){
        List<Integer> correctNums = new ArrayList<>();
        while (correctNums.size()<3) {
            int temp = Randoms.pickNumberInRange(1,9);
            if (!correctNums.contains(temp)) {
                correctNums.add(temp);
            }
        }
        return correctNums;
    }
}