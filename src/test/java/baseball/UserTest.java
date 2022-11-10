package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void 유저값이_올바른지_확인_중복판별(){
        User user=new User();
        List<Integer> distinct_list=new ArrayList<>(Arrays.asList(1,2,2));

        assertThatThrownBy(()->
                user.isValidUserNumber(distinct_list))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저값이_올바른지_확인_숫자판별(){
        User user=new User();
        List<Integer> alphabet_list=new ArrayList<>(Arrays.asList((int)'a',(int)'b',(int)'c'));
        List<Integer> special_list=new ArrayList<>(Arrays.asList((int)'@',(int)'!',(int)'$'));

        assertThatThrownBy(()->
                user.isValidUserNumber(alphabet_list))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->
                user.isValidUserNumber(special_list))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저값이_올바른지_확인_길이판별(){
        User user=new User();
        List<Integer> length4_list=new ArrayList<>(Arrays.asList(1,2,3,4));

        assertThatThrownBy(()->
                user.isValidUserNumber(length4_list))
                .isInstanceOf(IllegalArgumentException.class);
    }
}