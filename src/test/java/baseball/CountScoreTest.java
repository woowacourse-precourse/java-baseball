package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CountScoreTest {
    @Test
    void 점수_카운팅() {
        List list1 = Converter.stringToList("246");
        List list2 = Converter.stringToList("456");
        CountScore countScore = new CountScore();
        countScore.compare(list1, list2);
        Assertions.assertThat(countScore.getBall()).isEqualTo(1);
        Assertions.assertThat(countScore.getStrike()).isEqualTo(1);
    }

    @Test
    void 점수_카운팅2() {
        List list1 = Converter.stringToList("123");
        List list2 = Converter.stringToList("123");
        CountScore countScore = new CountScore();
        countScore.compare(list1, list2);
        Assertions.assertThat(countScore.getBall()).isEqualTo(0);
        Assertions.assertThat(countScore.getStrike()).isEqualTo(3);
    }

    @Test
    void 점수_카운팅3() {
        List list1 = Converter.stringToList("123");
        List list2 = Converter.stringToList("312");
        CountScore countScore = new CountScore();
        countScore.compare(list1, list2);
        Assertions.assertThat(countScore.getBall()).isEqualTo(3);
        Assertions.assertThat(countScore.getStrike()).isEqualTo(0);
    }

    @Test
    void 점수_카운팅4() {
        List list1 = Converter.stringToList("123");
        List list2 = Converter.stringToList("456");
        CountScore countScore = new CountScore();
        countScore.compare(list1, list2);
        Assertions.assertThat(countScore.getBall()).isEqualTo(0);
        Assertions.assertThat(countScore.getStrike()).isEqualTo(0);
    }

    @Test
    void 점수_카운팅5() {
        List list1 = Converter.stringToList("465");
        List list2 = Converter.stringToList("456");
        CountScore countScore = new CountScore();
        countScore.compare(list1, list2);
        Assertions.assertThat(countScore.getBall()).isEqualTo(2);
        Assertions.assertThat(countScore.getStrike()).isEqualTo(1);
    }
}