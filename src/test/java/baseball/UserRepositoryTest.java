package baseball;

import data.UserData;
import org.junit.jupiter.api.Test;
import repository.UserRepository;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class UserRepositoryTest {
    private UserRepository userRepository;

    @Test
    public void 숫자대신_문자_입력(){
        UserData userData = new UserData();
        userRepository = new UserRepository(userData);
        String str="r12";
        assertThatThrownBy(() -> userRepository.inputanswer(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 단어길이_3이_아닐_때(){
        UserData userData = new UserData();
        userRepository = new UserRepository(userData);
        String str="2134";
        assertThatThrownBy(() -> userRepository.inputanswer(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 숫자_중복_체크(){
        UserData userData = new UserData();
        userRepository = new UserRepository(userData);
        String str="211";
        assertThatThrownBy(() -> userRepository.inputanswer(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 숫자_0이_들어갈_때(){
        UserData userData = new UserData();
        userRepository = new UserRepository(userData);
        String str="203";
        assertThatThrownBy(() -> userRepository.inputanswer(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 정상작동_그리고_제대로_저장(){
        UserData userData = new UserData();
        userRepository = new UserRepository(userData);
        String str="213";
        userRepository.inputanswer(str);
        List<Integer> data= List.of(2,1,3);
        assertThat(userRepository.getUserData()).isEqualTo(data);
    }
}
