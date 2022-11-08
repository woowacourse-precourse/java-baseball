package study;

import baseball.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest{
    @Test
    @DisplayName("랜덤 숫자 생성 테스트")
    void computer_num_test(){
        List<Integer> test_num = Application.make_number();
        assertThat(3).isEqualTo(test_num.size());
    }

    @Test
    @DisplayName("랜덤 숫자 중복 테스트")
    void computer_duplicate_test(){
        List<Integer> num_list = Application.make_number();
        Set<Integer> num_set = new HashSet<>(num_list);
        assertThat(3).isEqualTo(num_set.size());
    }
}
