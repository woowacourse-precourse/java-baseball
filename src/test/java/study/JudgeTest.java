package study;

import baseball.Judge;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class JudgeTest {

    @Test
    void countStrike_메서드로_스트라이크_갯수를_카운트() {
        String input = "1,2";
        String[] result = input.split(",");

        List<Integer> randomNumberList = Arrays.asList(1,2,3);
        List<Integer> userNumberList = Arrays.asList(1,2,3);

        Judge judge = new Judge();

        Integer strikeCnt = judge.countStrike(randomNumberList, userNumberList);

        Assertions.assertEquals(3, strikeCnt);
    }

    @Test
    void countBall_메서드로_볼_갯수를_카운트() {
        String input = "1,2";
        String[] result = input.split(",");

        List<Integer> randomNumberList = Arrays.asList(7,1,3);
        List<Integer> userNumberList = Arrays.asList(2,1,6);

        Judge judge = new Judge();

        Integer strikeCnt = judge.countStrike(randomNumberList, userNumberList);
        Integer ballCnt = judge.countBall(randomNumberList, userNumberList, strikeCnt);

        System.out.println(strikeCnt);
        System.out.println(ballCnt);

        Assertions.assertEquals(0, ballCnt);
    }
}
