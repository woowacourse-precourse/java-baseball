package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static baseball.Application.addUserList;
import static baseball.Application.inputLengthCheck;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LocalTest {



    @Test
    void Ill_예외가_발생하는지_확인_1(){
        String[] arr = {"1","a","4"};
        List<Integer> list = new ArrayList<>();
        assertThatThrownBy(()->addUserList(list,arr)).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void Ill_예외가_발생_안하는지_확인_2(){
        String[] arr = {"1","2","4"};
        List<Integer> list = new ArrayList<>();
        addUserList(list,arr);
        assertThat(list.size()).isEqualTo(3);

    }
    @Test
    void 범위가_아닐_경우(){
        String[] arr = {"0","1","4"};
        List<Integer> list = new ArrayList<>();
        assertThatThrownBy(()->addUserList(list,arr)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력받은_길이를_체크하는_테스트(){
        String[] arr1 = {"1","1","4"};
        assertThat(inputLengthCheck(arr1)).isFalse();
        String[] arr2 = {"1","1","4","4"};
        assertThat(inputLengthCheck(arr2)).isTrue();
    }

    @Test
    void input_Test(){
    }
}
