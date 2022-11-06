package study;

import baseball.ComputerNum;
import baseball.Number;
import baseball.PlayerNum;
import org.junit.jupiter.api.Test;

import java.io.*;
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

    @Test
    void 플레이어의_입력이_숫자로만_구성되어_있지_않다면_예외_발생() {
        Number playerNumber = new PlayerNum();
        assertThatThrownBy(() -> playerNumber.verifyInput("안녕3"))
                .isInstanceOf(IllegalArgumentException.class);
    }










}
