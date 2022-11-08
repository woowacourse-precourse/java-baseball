package baseball.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerInputTest {

        ComputerInput computerInput = new ComputerInput();

        @Test
        @DisplayName("컴퓨터 랜덤 숫자 사이즈(3) 검증")
        void 컴퓨터_랜덤_숫자_사이즈_검증(){
            List<Integer> numberList = computerInput.getNumberList();
            assertThat(numberList.size()).isEqualTo(3);
        }

        @Test
        @DisplayName("컴퓨터 랜덤 숫자 중복 검증")
        void 컴퓨터_랜덤숫자_중복_검증(){
                List<Integer> numberList = computerInput.getNumberList();
                assertThat(numberList).doesNotHaveDuplicates();
            }
}