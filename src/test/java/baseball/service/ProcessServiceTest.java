package baseball.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class ProcessServiceTest {
    private final ProcessService processService = new ProcessService();

    @Test
    void 길이가_다른_사용자_입력_검증() {
        String userInput = "12";
        assertThatThrownBy(() -> processService.validateGameInput(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력의 길이는 3자리수여야 합니다.");
    }

    @Test
    void 숫자가_아닌_사용자_입력_검증() {
        String userInput = "12a";
        assertThatThrownBy(() -> processService.validateGameInput(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 1 ~ 9 사이의 값이어야만 합니다.");
    }

    @Test
    void 중복_사용자_입력_검증() {
        String userInput = "122";
        assertThatThrownBy(() -> processService.validateGameInput(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 중복되지 않아야 합니다.");
    }

    @Test
    void 길이가_다른_게임종료_입력_검증() {
        String endInput = "12";
        assertThatThrownBy(() -> processService.validateEndInput(endInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력의 길이는 1자리 수여야 합니다.");
    }

    @Test
    void 값이_다른_게임종료_입력_검증() {
        String endInput = "3";
        assertThatThrownBy(() -> processService.validateEndInput(endInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력은 1 또는 2의 커맨드여야 합니다.");
    }

    @Test
    void 사용자_입력_파싱_확인() {
        String userInput = "123";

        List<Integer> parsedInput = processService.parseGameInput(userInput);
        List<Integer> CompareInput = List.of(1, 2, 3);

        assertThat(parsedInput).isEqualTo(CompareInput);
    }

    @Test
    void 사용자_입력에_따른_게임_결과_확인() {
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> userInput = List.of(3, 2, 1);

        List<Integer> compareResult = processService.compare(userInput, answer);
        List<Integer> correctResult = List.of(1, 2); // 2볼 1스트라이크

        assertThat(compareResult).isEqualTo(correctResult);
    }
}