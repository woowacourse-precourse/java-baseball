package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void 유저_입력_숫자_예외_테스트(){
        List<String> testStringList = Arrays.asList("044","abc","1234");
        User user = new User();
        for(int i=0;i<testStringList.size();i++){
            int finalI = i;
            assertSimpleTest(()->
                    assertThatThrownBy(()-> user.checkUserInput(testStringList.get(finalI)))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }
    @Test
    void String_to_IntegerList_테스트(){
        User user = new User();
        List<Integer> integerList = Arrays.asList(1,2,3);
        Assertions.assertThat(user.StringToIntegerList("123")).isEqualTo(integerList);
    }
    @Test
    void String_to_IntegerList_예외처리포함_테스트(){
        User user = new User();
        List<Integer> integerList = Arrays.asList(1,2,3);
        Assertions.assertThat(user.getUserIntegerList("123")).isEqualTo(integerList);

    }
}