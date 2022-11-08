package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;

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
    void 랜덤_정답생성_데이터형_테스트(){
        Answer answer = new Answer();
        List<Integer> myAnswer = answer.getAnswer();

        boolean isOnlyInteger = false;
        if (myAnswer.toString().matches(".*[0-9].*")){
            isOnlyInteger = true;
        }

        assertThat(isOnlyInteger).isEqualTo(true);
    }

    @Test
    void 랜덤_정답생성_중복_테스트(){
        Answer answer = new Answer();
        List<Integer> myAnswer = answer.getAnswer();

        int filteredSize = myAnswer.stream()
                .distinct()
                .collect(Collectors.toList())
                .size();

        assertThat(filteredSize).isEqualTo(3);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
