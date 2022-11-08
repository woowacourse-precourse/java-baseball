package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class NumberBaseballTest {

    @Test
    public void testAnswerIsNotSameNumber(){
        NumberBaseball test1 = new NumberBaseball();
        assertThat(test1.getAnswer().get(0))
                .isNotEqualTo(test1.getAnswer().get(1))
                .isNotEqualTo(test1.getAnswer().get(2));
    }

    @Test
    public void testCheckInput(){
        NumberBaseball test2 = new NumberBaseball();
        assertThat(test2.checkInput("359")).isEqualTo(true);
    }

    @Test
    public void testCountStrike(){
        NumberBaseball test3 = new NumberBaseball();
        test3.setAnswer(1,2,3);
        int[] testanswer = {1, 4, 5};
        assertThat(test3.countStrike(testanswer)).isEqualTo(1);
    }

    @Test
    public void testCountStrike2(){
        NumberBaseball test4 = new NumberBaseball();
        test4.setAnswer(1,2,3);
        int[] testanswer = {3, 1, 2};
        assertThat(test4.countStrike(testanswer)).isEqualTo(0);
    }

    @Test
    public void testCountBall(){
        NumberBaseball test5 = new NumberBaseball();
        test5.setAnswer(1,2,3);
        int[] testanswer = {1, 4, 2};
        assertThat(test5.countBall(testanswer)).isEqualTo(2);
    }
    @Test
    public void testCountBall2(){
        NumberBaseball test6 = new NumberBaseball();
        test6.setAnswer(1,2,3);
        int[] testanswer = {3, 2, 1};
        assertThat(test6.countBall(testanswer)).isEqualTo(3);
    }

    @Test
    public void testJudgeBall(){
        NumberBaseball test7 = new NumberBaseball();
        test7.setAnswer(4,5,6);
        int[] testanswer = {4,5,6};
        assertThat(test7.judgeBall(testanswer)).isEqualTo(true);
    }
    @Test
    public void testJudgeBall2(){
        NumberBaseball test8 = new NumberBaseball();
        test8.setAnswer(4,5,6);
        int[] testanswer = {6,4,5};
        assertThat(test8.judgeBall(testanswer)).isEqualTo(false);
    }
}