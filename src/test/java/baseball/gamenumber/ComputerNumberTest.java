package baseball.gamenumber;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComputerNumberTest {
    ComputerNumber computerNumber;

    @BeforeEach
    void beforeEach() {
        computerNumber = new ComputerNumber();
    }

    @AfterEach
    void afterEach() {
        computerNumber.clear();
    }

    @Test
    void 중복_검사() {
        // given
        List<Integer> list = new ArrayList<>();
        list = List.of(1, 2, 3);

        // when
        boolean trueFlag = computerNumber.isDuplicate(list, 1);
        boolean falseFlag = computerNumber.isDuplicate(list, 4);

        // then
        assertThat(trueFlag).isEqualTo(true);
        assertThat(falseFlag).isEqualTo(false);
    }

    @Test
    void 컴퓨터_숫자_생성() {
        // given
        List<Integer> list = new ArrayList<>();

        // when
        list = computerNumber.getNumberList();

        // then
        assertThat(list.size()).isEqualTo(3);

    }
}