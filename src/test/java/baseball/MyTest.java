package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MyTest extends NsTest {

    @Test
    void 랜덤_정답생성_테스트(){
        Answer answer = new Answer();
        List<Integer> myAnswer = answer.getAnswer();

        //check if it is number
        boolean isOnlyInteger = false;
        if (myAnswer.toString().matches(".*[0-9].*")){
            isOnlyInteger = true;
        }

        //check if it is duplicated
        int filteredSize = myAnswer.stream()
                .distinct()
                .collect(Collectors.toList())
                .size();

        assertThat(isOnlyInteger).isEqualTo(true);
        assertThat(filteredSize).isEqualTo(3);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
