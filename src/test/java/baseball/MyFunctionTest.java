package baseball;

import ballAndStrike.Count;
import ballAndStrike.Hint;
import game.EnterNumber;
import game.RandomNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MyFunctionTest {
    @Nested
    class randomNumber {
        //given
        RandomNumber randomNumber = new RandomNumber();
        @Test
        void Random_리스트_모두_숫자인지_확인() {
            //when
            List<Integer> oneToNine = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
            randomNumber.getList();
            List<Integer> list = randomNumber.getRandomNumber();
            //then
            for(int i = 0; i < 3; i++) {
                assertThat(oneToNine).contains(list.get(i));
            }
        }
        @Test
        void Random_리스트_길이_3인지_확인() {
            //given
            int index = 3;
            randomNumber.getList();
            List<Integer> list = randomNumber.getRandomNumber();
            //then
            assertThat(list.size()).isEqualTo(index);
        }
        @Test
        void Random_리스트_중복_확인() {
            randomNumber.getList();
            List<Integer> list = randomNumber.getRandomNumber();
            for(int i = 0; i < 3; i++) {
                boolean isRepeat = (Collections.frequency(list, list.get(i))==1);
                assertThat(isRepeat).isEqualTo(true);
            }
        }
    }

    @Nested
    class enterNumber {
        //given
        EnterNumber enterNumber = new EnterNumber();
        @Test
        void 입력한_숫자_예외처리() {
            //given
            String hasRepeat = "112";
            String hasNoNumber = "2#4";
            String overLength_3 = "27834823";
            //when, then
            assertThat(enterNumber.exceptNumber(hasRepeat)).isEqualTo(true);
            assertThat(enterNumber.exceptNumber(hasNoNumber)).isEqualTo(true);
            assertThat(enterNumber.exceptNumber(overLength_3)).isEqualTo(true);
        }
        @Test
        void 사용자_입력숫자_리스트_구성_확인() {
            //given
            String correctEnter = "123";
            List<Integer> correctEnterList = List.of(1,2,3);
            //when
            enterNumber.getList(correctEnter);
            //then
            assertThat(enterNumber.getEnterNumber()).isEqualTo(correctEnterList);
        }
    }

    @Nested
    class CountBallAndStrikeNumber {
        //given
        Count count = new Count();
        Hint hint = new Hint(count);
        @Test
        void 볼_스트라이크_개수_찍기_1() {
            //given
            List<Integer> randomNumber = List.of(1,2,3);
            List<Integer> userNumber = List.of(3,1,2);
            List<Integer> ballAndStrikeNumber = List.of(3,0);
            //when
            count.calStrike(randomNumber, userNumber);
            count.calBall(randomNumber, userNumber);
            List<Integer> ballAndStrike = new ArrayList<>(Arrays.asList(count.getBallNumber(), count.getStrikeNumber()));
            //then
            assertThat(ballAndStrike).isEqualTo(ballAndStrikeNumber);
        }
        @Test
        void 볼_스트라이크_개수_찍기_2() {
            //given
            List<Integer> randomNumber = List.of(5,9,1);
            List<Integer> userNumber = List.of(1,9,2);
            List<Integer> ballAndStrikeNumber = List.of(1,1);
            //when
            count.calStrike(randomNumber, userNumber);
            count.calBall(randomNumber, userNumber);
            List<Integer> ballAndStrike = new ArrayList<>(Arrays.asList(count.getBallNumber(), count.getStrikeNumber()));
            //then
            assertThat(ballAndStrike).isEqualTo(ballAndStrikeNumber);
        }
        @Test
        void 볼_스트라이크_개수_찍기_3() {
            //given
            List<Integer> randomNumber = List.of(2,7,4);
            List<Integer> userNumber = List.of(3,5,1);
            List<Integer> ballAndStrikeNumber = List.of(0,0);
            //when
            count.calStrike(randomNumber, userNumber);
            count.calBall(randomNumber, userNumber);
            List<Integer> ballAndStrike = new ArrayList<>(Arrays.asList(count.getBallNumber(), count.getStrikeNumber()));
            //then
            assertThat(ballAndStrike).isEqualTo(ballAndStrikeNumber);
        }
        @Test
        void 볼_스트라이크_출력_확인() {
            //given
            List<Integer> randomNumber = List.of(2,3,4);
            List<Integer> userNumber = List.of(2,5,3);
            String expectedResult = "1볼 1스트라이크";
            //when
            count.calStrike(randomNumber, userNumber);
            count.calBall(randomNumber, userNumber);
            //then
            assertThat(hint.printHint()).isEqualTo(expectedResult);
        }
    }
}
