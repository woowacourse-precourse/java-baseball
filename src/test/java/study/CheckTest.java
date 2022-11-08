package study;

import baseball.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckTest{
    List<Integer> check_list = List.of(1,2,3);

    @Test
    @DisplayName("3스트라이크 확인")
    void strike_check(){
        List<Integer> compare_list = List.of(1,2,3);
        assertThat(3).isEqualTo(Application.check_strike(check_list, compare_list));
    }

    @Test
    @DisplayName("3볼 확인")
    void nothing_check(){
        List<Integer> compare_list = List.of(2,3,1);

        assertThat(3).isEqualTo(Application.check_ball(check_list, compare_list));
    }
}