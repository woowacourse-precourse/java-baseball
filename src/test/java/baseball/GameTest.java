package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Nested
    @DisplayName("사용자 입력 테스트")
    class UserNumTest{
        @Test
        @DisplayName("getUserNum 메소드 사용 시 사용자가 입력한 숫자를 List로 반환")
        void get_user_num_test(){
            //Given
            List<Integer> userNum = List.of(1,2,3);
            String input = "123";
            Game game = new Game();

            //When
            List<Integer> inputUserNum = game.getUserNum(input);

            //Then
            assertThat(inputUserNum).isEqualTo(userNum);
        }

        @Test
        @DisplayName("validateNum 메소드 사용 시 인자가 숫자가 아닌 경우 예외 처리")
        void validate_num_test(){
            String s = "AAA";
            Game game = new Game();
            assertThatThrownBy(() -> game.validateNum(s))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자 외 문자가 입력되었습니다.");
        }

        @Test
        @DisplayName("validateRangeForAll 메소드 사용 시 List에 1~9범위 초과하는 요소 있을 시 예외 발생")
        void validate_range_for_all_test(){
            List<Integer> nums = List.of(10,1,2);
            Game game = new Game();
            assertThatThrownBy(() -> game.validateRangeForAll(nums))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("입력된 숫자가 범위를 초과했습니다.");
        }

        @Test
        @DisplayName("validateDigit 메소드 사용 시 3자리 이상 숫자일 때 예외 발생")
        void validate_digit_test(){
            List<Integer> nums = List.of(1,2,3,4);
            Game game = new Game();
            assertThatThrownBy(() -> game.validateDigit(nums))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("세 자리 수가 아닙니다.");
        }

        @Test
        @DisplayName("validateDuplication 메소드 사용 시 중복되는 수가 있을 때 예외 발생")
        void validate_duplication_test(){
            List<Integer> nums = List.of(1,1,1);
            Game game = new Game();
            assertThatThrownBy(() -> game.validateDuplication(nums))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("중복된 수가 있습니다.");
        }
    }








    @Nested
    @DisplayName("컴퓨터 숫자 생성 테스트")
    class ComputerNumTest{
        @Test
        @DisplayName("3자리 수인지 테스트")
        void check_3_digit(){
            //Given
            Game game = new Game();

            //When
            List<Integer> computerNum = game.getComputerNum();

            //Then
            //3자리 수인지
            assertThat(computerNum.size()).isEqualTo(3);
        }

        @Test
        @DisplayName("중복있는지 테스트")
        void check_duplication(){
            //Given
            Game game = new Game();

            //When
            List<Integer> computerNum = game.getComputerNum();

            //Then
            assertThat(computerNum.stream()
                    .distinct()
                    .count()).isEqualTo(3);

        }

        @Test
        @DisplayName("숫자 범위가 1~9인지 테스트")
        void isInRange(){
            //Given
            Game game = new Game();

            //When
            List<Integer> computerNum = game.getComputerNum();

            //Then
            //숫자 범위가 1~9인지
            assertThat(computerNum
                    .stream()
                    .allMatch(n -> n >=1 && n <= 9)).isTrue();
        }

    }



}