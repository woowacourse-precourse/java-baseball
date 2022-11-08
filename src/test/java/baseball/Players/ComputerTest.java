package baseball.Players;

import baseball.Players.Computer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class ComputerTest {

    Computer computer;

    @BeforeAll
    public void setUp() {
        System.out.println("셋업");
        computer = new Computer();
    }

    @Nested
    @DisplayName("getNumberList 메서드 테스트")
    class getNumberListTest {

        @Test
        void getNumberList_IsSizeOfThree_True() {
            assertThat(computer.getNumberList().size()).isEqualTo(3);
        }

        @Test
        void getNumberList_IsNumbersInOneToNine_True() {
            List<Integer> threeNumbers = computer.getNumberList();
            List<Integer> oneToNine = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
            for (int i = 1; i < threeNumbers.size(); i++) {
                assertThat(oneToNine).contains(threeNumbers.get(i));
            }
        }

        @Test
        void getNumberList_IsAllNumbersUnique_True() {
            HashSet<Integer> threeNumbers = new HashSet<>(computer.getNumberList());
            assertThat(threeNumbers.size()).isEqualTo(3);
        }
    }
}