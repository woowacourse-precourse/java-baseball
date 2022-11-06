package mytest;

import static org.assertj.core.api.Assertions.*;

import baseball.players.Computer;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class ComputerTest {
    @DisplayName("컴퓨터가 생성한 숫자가 1과 9 사이의 서로 다른 세 자리 수인지 확인")
    @Nested
    class NumberTest {
        Computer computer = new Computer();
        List<Integer> computerNumbers = computer.createThreeDifferentNumbers();

        @DisplayName("세 자리 수 테스트")
        @Test
        void lengthTest() {
            assertThat(computerNumbers.size()).isEqualTo(3);
        }

        @DisplayName("숫자 범위 테스트")
        @Test
        void rangeTest() {
            boolean isBetweenOneAndNine = computerNumbers.stream()
                    .allMatch(number -> number >= 1 && number <= 9);
            assertThat(isBetweenOneAndNine).isTrue();
        }

        @DisplayName("중복 여부 테스트")
        @Test
        void uniquenessTest() {
            Set<Integer> numbersToBeTested = new HashSet<>(computerNumbers);
            assertThat(computerNumbers.size()).isEqualTo(3);
        }
    }

    @DisplayName("오름차순 발생 빈도를 통해 숫자들이 무작위로 추출되고 있는지 확인")
    @Nested
    class RandomizationTest {
        @DisplayName("오름차순 발생 빈도 테스트")
        @RepeatedTest(5)
        void ascendingOrderTest() {
            int numberOfDetectedCases = 0;
            int numberOfToTalCases = 1000;

            for (int num = 1; num <= numberOfToTalCases; num++) {
                Computer computer = new Computer();
                List<Integer> computerNumbers = computer.createThreeDifferentNumbers();

                boolean isInAscendingOrder = IntStream.range(1, computerNumbers.size())
                        .allMatch(index -> computerNumbers.get(index - 1) < computerNumbers.get(index));
                if (isInAscendingOrder) {
                    numberOfDetectedCases++;
                }
            }
            System.out.printf("%d회의 셔플 중 %d회의 오름차순 발생\n", numberOfToTalCases, numberOfDetectedCases);
        }
    }
}
