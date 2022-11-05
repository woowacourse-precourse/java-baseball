package baseball;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerNumberTest {
    Application app = new Application();

    @Test
    void 컴퓨터_랜덤_숫자_리스트_사이즈_검증() {
        List<Integer> computerNumberList = app.getComputerNumberList();
        assertThat(computerNumberList.size()).isEqualTo(3);
    }

    @Nested
    @DisplayName("랜덤 숫자 유효성 검증")
    class 랜덤숫자유효성{

        @Test
        @DisplayName("유효한 범위 검증")
        void 유효하지_않은_범위의_입력_검증(){
            List<Integer> tmp = new ArrayList<>();
            assertThat(app.isValidNumber(10,tmp)).isFalse();
        }

        @Test
        @DisplayName("고유한 값 검증")
        void 고유하지_않은_입력_검증(){
            List<Integer> tmp = List.of(9,1);
            assertThat(app.isValidNumber(9, tmp)).isFalse();
        }
    }

}
