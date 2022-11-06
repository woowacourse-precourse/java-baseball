package baseball;

import baseball.processor.NumberMatchProcessor;
import baseball.processor.NumberMatchProcessorImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PrintHintTest {

    private NumberMatchProcessor numberMatchProcessor;

    @TestFactory
    @DisplayName("힌트를 한글로 파싱해주는 기능을 테스트한다.")
    Stream<DynamicTest> numberMatchTest() {
        numberMatchProcessor = new NumberMatchProcessorImpl();

        return Stream.of(
                DynamicTest.dynamicTest("아무것도 못맞췄을경우", () -> {
                    List<Integer> targetList = List.of(0, 0);
                    String result = numberMatchProcessor.printHint(targetList);
                    assertThat(result).isEqualTo("낫싱");
                }),
                DynamicTest.dynamicTest("볼만 있을경우", () -> {
                    List<Integer> targetList = List.of(0, 1);
                    String result = numberMatchProcessor.printHint(targetList);
                    assertThat(result).isEqualTo("1볼");
                }),
                DynamicTest.dynamicTest("스트라이크만 있을경우", () -> {
                    List<Integer> targetList = List.of(1, 0);
                    String result = numberMatchProcessor.printHint(targetList);
                    assertThat(result).isEqualTo("1스트라이크");
                }),
                DynamicTest.dynamicTest("볼, 스트라이크가 다 있을경우", () -> {
                    List<Integer> targetList = List.of(1, 2);
                    String result = numberMatchProcessor.printHint(targetList);
                    assertThat(result).isEqualTo("2볼 1스트라이크");
                })
        );
    }
}
