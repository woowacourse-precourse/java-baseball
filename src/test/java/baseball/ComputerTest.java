package baseball;

import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ComputerTest {

    @Nested
    class stateTest{
      @Test
      void 낫싱출력(){
        Computer computer = new Computer();
        computer.answer = List.of(1, 2, 3);
        String resultNothing = computer.state("687");
        assertThat(resultNothing).isEqualTo("낫싱");
      }

      @Test
      void 스트라이크출력(){
        Computer computer = new Computer();
        computer.answer = List.of(1, 2, 3);
        String resultStrike = computer.state("524");
        assertThat(resultStrike).isEqualTo("1스트라이크");
      }

      @Test
      void 볼출력(){
        Computer computer = new Computer();
        computer.answer = List.of(1, 2, 3);
        String resultStrike = computer.state("534");
        assertThat(resultStrike).isEqualTo("1볼");
      }

      @Test
      void 볼_스트라이크출력(){
        Computer computer = new Computer();
        computer.answer = List.of(1, 2, 3);
        String resultStrike = computer.state("132");
        assertThat(resultStrike).isEqualTo("2볼 1스트라이크");
      }

      @Test
      void 스트라이크3_게임종료(){
        Computer computer = new Computer();
        computer.answer = List.of(1, 2, 3);
        String resultStrike = computer.state("123");
        assertThat(resultStrike).isEqualTo("3스트라이크\n"
            + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
      }
    }

    @Nested
    class isNothingTest{

      @Test
      void Nothing(){
        Computer computer = new Computer();
        computer.answer = List.of(1, 2, 3);
        boolean resultNothing = computer.isNothing("456");
        assertThat(resultNothing).isTrue();
      }

      @Test
      void noNothing(){
        Computer computer = new Computer();
        computer.answer = List.of(1, 2, 3);
        boolean resultNothing = computer.isNothing("356");
        assertThat(resultNothing).isFalse();
      }
    }

    @Nested
    class isStrikeTest{

      @Test
      void Strike(){
        Computer computer = new Computer();
        computer.answer = List.of(1, 2, 3);
        boolean resultNothing = computer.isStrike(1, 0);
        assertThat(resultNothing).isTrue();
      }

      @Test
      void noStrike(){
        Computer computer = new Computer();
        computer.answer = List.of(1, 2, 3);
        boolean resultNothing = computer.isStrike(1, 2);
        assertThat(resultNothing).isFalse();
      }
    }
  @Nested
  class isBallTest {

    @Test
    void caseBall() {
      Computer computer = new Computer();
      computer.answer = List.of(1, 2, 3);
      boolean resultBall = computer.isBall(2, 0);
      assertThat(resultBall).isTrue();
    }

    @Test
    void caseNotBall() {
      Computer computer = new Computer();
      computer.answer = List.of(1, 2, 3);
      boolean resultNotBall = computer.isBall(2, 1);
      assertThat(resultNotBall).isFalse();
    }
  }

  @Nested
  class getStrikeCountTest {

    @Test
    void caseZeroStrike() {
      Computer computer = new Computer();
      computer.answer = List.of(1, 2, 3);
      int resultZeroStrike = computer.getStrikeCount("231");
      assertThat(resultZeroStrike).isEqualTo(0);
    }

    @Test
    void caseOneStrike() {
      Computer computer = new Computer();
      computer.answer = List.of(1, 2, 3);
      int resultOneStrike = computer.getStrikeCount("168");
      assertThat(resultOneStrike).isEqualTo(1);
    }

    @Test
    void caseTwoStrike() {
      Computer computer = new Computer();
      computer.answer = List.of(1, 2, 3);
      int resultTwoStrike = computer.getStrikeCount("623");
      assertThat(resultTwoStrike).isEqualTo(2);
    }

    @Test
    void caseThreeStrike() {
      Computer computer = new Computer();
      computer.answer = List.of(1, 2, 3);
      int resultThreeStrike = computer.getStrikeCount("123");
      assertThat(resultThreeStrike).isEqualTo(3);
    }
  }

  @Nested
  class getBallCountTest {

    @Test
    void caseZeroBall() {
      Computer computer = new Computer();
      computer.answer = List.of(1, 2, 3);
      int resultZeroBall = computer.getBallCount("145");
      assertThat(resultZeroBall).isEqualTo(0);
    }

    @Test
    void caseOneBall() {
      Computer computer = new Computer();
      computer.answer = List.of(1, 2, 3);
      int resultOneBall = computer.getBallCount("325");
      assertThat(resultOneBall).isEqualTo(1);
    }

    @Test
    void caseTwoBall() {
      Computer computer = new Computer();
      computer.answer = List.of(1, 2, 3);
      int resultTwoBall = computer.getBallCount("234");
      assertThat(resultTwoBall).isEqualTo(2);
    }

    @Test
    void caseThreeBall() {
      Computer computer = new Computer();
      computer.answer = List.of(1, 2, 3);
      int resultThreeBall = computer.getBallCount("231");
      assertThat(resultThreeBall).isEqualTo(3);
    }
  }

  @Nested
  class isGameOverTest {

    @Test
    void caseGameOver() {
      Computer computer = new Computer();
      computer.answer = List.of(1, 2, 3);
      boolean resultGameOver = computer.isGameOver("123");
      assertThat(resultGameOver).isTrue();
    }

    @Test
    void caseNotGameOver() {
      Computer computer = new Computer();
      computer.answer = List.of(1, 2, 3);
      boolean resultNotGameOver = computer.isGameOver("234");
      assertThat(resultNotGameOver).isFalse();
    }
  }
}
