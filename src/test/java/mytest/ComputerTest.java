package mytest;

import static org.assertj.core.api.Assertions.*;

import baseball.players.Computer;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class ComputerTest {
    @DisplayName("1과 9 사이의 서로 다른 세 자리 수인지 확인")
    @RepeatedTest(5)
    void isAllDifferent() {
        Computer computer = new Computer();
        List<Integer> threeDifferentNumbers = computer.createThreeDifferentNumbers();
        Set<Integer> listToSet = new HashSet<>(threeDifferentNumbers);

        assertThat(listToSet).doesNotContain(0);
        assertThat(listToSet.size()).isEqualTo(3);
    }

    @DisplayName("오름차순 발생 빈도를 기록해 숫자들이 잘 섞였는지 확인")
    @RepeatedTest(5)
    void isShuffled() {
        int numberOfDetectedCases = 0;
        int numberOfToTalCases = 1000;

        for (int i = 0; i <= numberOfToTalCases; i++) {
            Computer computer = new Computer();
            List<Integer> threeDifferentNumbers = computer.createThreeDifferentNumbers();

            boolean isInAscendingOrder = IntStream.range(1, threeDifferentNumbers.size())
                            .allMatch(index -> threeDifferentNumbers.get(index - 1) < threeDifferentNumbers.get(index));
            if (isInAscendingOrder) {
                numberOfDetectedCases++;
            }
        }
        System.out.printf("%d회의 셔플 중 %d회의 오름차순 발생\n", numberOfToTalCases, numberOfDetectedCases);
    }
}
