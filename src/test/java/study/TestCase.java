package study;

import baseball.ComputerNum;
import baseball.Number;
import baseball.PlayerNum;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TestCase {

    @Test
    void 컴퓨터의_각_숫자가_1부터9까지_있는지_확인() {
        Number computerNumber = new ComputerNum();
        List<Integer> num = computerNumber.createNumber();
        assertThat(num).allSatisfy(
                integer -> assertThat(integer).isBetween(1, 9));
    }

    @Test
    void 컴퓨터의_숫자간_중복이_있는지_확인() {
        Number computerNumber = new ComputerNum();
        List<Integer> num = computerNumber.createNumber();
        assertThat(num).allSatisfy(
                integer -> assertThat(integer)
        ).containsOnlyOnce(num.get(0));
    }

    @Test
    void 컴퓨터의_수가_3자리_수로_이루어져_있는지_확인() {
        Number computerNumber = new ComputerNum();
        List<Integer> num = computerNumber.createNumber();
        assertThat(num.size()).isEqualTo(3);
    }

    @Test
    void 컴퓨터의_각_숫자가_1부터_9까지가_아닌_숫자가_들어왔을때_예외_발생() {
        List<Integer> num = Arrays.asList(10, 2, 5);
        Number computerNumber = new ComputerNum();
        assertThatThrownBy(() -> computerNumber.verifyNumber(num))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 컴퓨터의_숫자간_중복이_있는_숫자가_들어왔을때_예외_발생() {
        List<Integer> num = Arrays.asList(2, 2, 5);
        Number computerNumber = new ComputerNum();
        assertThatThrownBy(() -> computerNumber.verifyNumber(num))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 컴퓨터의_수가_3자리수가_아닌것이_들어왔을때_예외_발생() {
        List<Integer> num = Arrays.asList(1, 3, 2, 5);
        Number computerNumber = new ComputerNum();
        assertThatThrownBy(() -> computerNumber.verifyNumber(num))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /*
        @Test
        void 플레이어의_입력이_숫자로만_구성되어_있지_않다면_예외_발생() {
            PlayerNum playerNumber = new PlayerNum();
            assertThatThrownBy(() -> playerNumber.verifyInput("안녕3"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 플레이어의_입력_문자열을_Integer형_리스트로_변환() {
            List<Integer> num = Arrays.asList(1, 2, 3);
            PlayerNum playerNumber = new PlayerNum();
            assertThat(num).isEqualTo(playerNumber.convertInput("123"));
        }
    */
    @Test
    void 플레이어의_숫자가_1부터_9까지가_아닌_숫자가_들어왔을때_예외_발생() {
        List<Integer> num = Arrays.asList(10, 2, 5);
        Number playerNumber = new PlayerNum();
        assertThatThrownBy(() -> playerNumber.verifyNumber(num))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 플레이어의_숫자가_중복이_있는_숫자가_들어왔을때_예외_발생() {
        List<Integer> num = Arrays.asList(2, 2, 5);
        Number playerNumber = new PlayerNum();
        assertThatThrownBy(() -> playerNumber.verifyNumber(num))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 플레이어의_숫자가_3자리가_아닌_숫자가_들어왔을때_예외_발생() {
        List<Integer> num = Arrays.asList(1, 3, 2, 5);
        Number playerNumber = new PlayerNum();
        assertThatThrownBy(() -> playerNumber.verifyNumber(num))
                .isInstanceOf(IllegalArgumentException.class);
    }
/*
    @Test
    void 재시작이나_게임종료에_해당하지_않는_입력이_들어왔을때_예외_발생() {
        String input = "3";
        Computer computer = new Computer();
        assertThatThrownBy(() -> computer.getStatusByInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }



    @Test
    void 컴퓨터가_플레이어에게_받은_수와_자신의_수를_비교_결과출력() {
        String result = "3스트라이크";

        List<Integer> playerNumber = Arrays.asList(1, 2, 3);
        List<Integer> computerNumber = Arrays.asList(1, 2, 3);

        Computer computer = new Computer();
        assertThat(result).isEqualTo(computer.getResult(playerNumber,computerNumber));
    }
*/


}
