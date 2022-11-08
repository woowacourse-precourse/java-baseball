package baseball.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class PrintServiceTest {

    private final PrintService printService = new PrintService();

    @Test
    void 낫싱_결과_생성_확인() {
        List<Integer> counts = List.of(0, 0);
        String nothingResult = printService.getResultString(counts);
        assertThat(nothingResult).isEqualTo("낫싱");
    }

    @Test
    void 스트라이크_결과_생성_확인() {
        List<Integer> counts = List.of(2, 0);
        String twoStrikeResult = printService.getResultString(counts);
        assertThat(twoStrikeResult).isEqualTo("2스트라이크");
    }

    @Test
    void 볼_결과_생성_확인() {
        List<Integer> counts = List.of(0, 1);
        String oneBallResult = printService.getResultString(counts);
        assertThat(oneBallResult).isEqualTo("1볼");
    }

    @Test
    void 혼합_결과에_공백_생성_확인() {
        List<Integer> counts = List.of(2, 1);
        String twoStrikeOneBallResult = printService.getResultString(counts);
        assertThat(twoStrikeOneBallResult).isEqualTo("1볼 2스트라이크");
    }
}