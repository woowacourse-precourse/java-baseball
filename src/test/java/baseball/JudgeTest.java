package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class JudgeTest {
  Judge judge;

  @BeforeEach
  void setUp() { judge = new Judge();}

  @Test
  @DisplayName("정확한 strike과 ball개수를 세는지 테스트1")
  void testWithResults1(){
    ArrayList<Integer> computer = new ArrayList<>(Arrays.asList(1, 2, 3));
    ArrayList<Integer> player = new ArrayList<>(Arrays.asList(2, 3, 1));
    assertThat(judge.compareBalls(player, computer))
            .as("실패시 -> 예상 값과 다르게 출력됨.")
            .usingRecursiveComparison()
            .isEqualTo(new Result(0, 3));
  }

  @Test
  @DisplayName("정확한 strike과 ball개수를 세는지 테스트1")
  void testWithResults2(){
    ArrayList<Integer> computer = new ArrayList<>(Arrays.asList(1, 2, 3));
    ArrayList<Integer> player = new ArrayList<>(Arrays.asList(1, 2, 4));
    assertThat(judge.compareBalls(player, computer))
            .as("실패시 -> 예상 값과 다르게 출력됨.")
            .usingRecursiveComparison()
            .isEqualTo(new Result(2, 0));
  }

  @Test
  @DisplayName("정확한 strike과 ball개수를 세는지 테스트3")
  void testWithResults3(){
    ArrayList<Integer> computer = new ArrayList<>(Arrays.asList(1, 2, 3));
    ArrayList<Integer> player = new ArrayList<>(Arrays.asList(1, 2, 3));
    assertThat(judge.compareBalls(player, computer))
            .as("실패시 -> 예상 값과 다르게 출력됨.")
            .usingRecursiveComparison()
            .isEqualTo(new Result(3, 0));
  }

  @Test
  @DisplayName("정확한 strike과 ball개수를 세는지 테스트4")
  void testWithResults4(){
    ArrayList<Integer> computer = new ArrayList<>(Arrays.asList(1, 2, 3));
    ArrayList<Integer> player = new ArrayList<>(Arrays.asList(1, 3, 2));
    assertThat(judge.compareBalls(player, computer))
            .as("실패시 -> 예상 값과 다르게 출력됨.")
            .usingRecursiveComparison()
            .isEqualTo(new Result(1, 2));
  }

  @Test
  @DisplayName("정확한 strike과 ball개수를 세는지 테스트5")
  void testWithResults5(){
    ArrayList<Integer> computer = new ArrayList<>(Arrays.asList(1, 2, 3));
    ArrayList<Integer> player = new ArrayList<>(Arrays.asList(4, 5, 6));
    assertThat(judge.compareBalls(player, computer))
            .as("실패시 -> 예상 값과 다르게 출력됨.")
            .usingRecursiveComparison()
            .isEqualTo(new Result(0, 0));
  }
}
