package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CompareTest {
    static final String BALL = "볼";
    static final String STRIKE = "스트라이크";

    @DisplayName("Compare: 정답과 비교해서 Ball, Strike를 잘 계산하는지 확인")
    @Test
    void compareWithAnswer() {
        List<Character> answerList = List.of('1', '2', '3');
        List<Character> userInputList = List.of('1', '2', '4');
        HashMap<String, Integer> map = Compare.compareWithAnswer(answerList,userInputList);
        HashMap<String, Integer> answerMap=new HashMap<>();
        answerMap.put(BALL, 0);
        answerMap.put(STRIKE, 2);
        assertThat(map).isEqualTo(answerMap);
    }
}
