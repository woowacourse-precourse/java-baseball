package baseball;

import baseball.domain.RandomNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallGameTest {
    @Nested
    class randomNumbers {
        @DisplayName("컴퓨터 랜덤 숫자 생성 테스트")
        @Test
        void getComputerRandomNumbers() {
            RandomNumbers computerNumbers = new RandomNumbers();
            System.out.println(computerNumbers.toString());
            assertThat(computerNumbers.size()).isEqualTo(3);
        }
    }

//    @Nested
//    class hintTest {
//        @DisplayName("스트라이크 개수 테스트")
//        @Test
//        void getStrikeCount() {
//            final List<Integer> computerNumbers = List.of(5, 8, 9);
//            final List<Integer> playerNumbers = List.of(5, 9, 7);
//
//            assertThat(Application.getStrikeCount(computerNumbers, playerNumbers)).isEqualTo(1);
//        }
//
//        @DisplayName("볼 개수 테스트")
//        @Test
//        void getBallCount() {
//            final List<Integer> computerNumbers = List.of(5, 8, 9);
//            final List<Integer> playerNumbers = List.of(5, 9, 7);
//
//            assertThat(Application.getBallCount(computerNumbers, playerNumbers)).isEqualTo(1);
//        }
//
//        @DisplayName("결과 로직 메소드")
//        @Test
//        void baseBallGame() {
//            final List<Integer> computerNumbers = List.of(5, 8, 9);
//            final List<Integer> playerNumbers = List.of(5, 9, 7);
//            System.out.println(Application.baseBallGame(computerNumbers, playerNumbers));
//            assertThat(Application.baseBallGame(computerNumbers, playerNumbers)).isEqualTo("1볼 1스트라이크");
//        }
//    }
}
