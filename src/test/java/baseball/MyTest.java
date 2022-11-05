package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MyTest {

    @Test
    void computerBallsList의_길이와_유효성검사(){
        assertThat(Computer.makeBalls())
                .isNotEmpty()
                .doesNotContain(0)
                .size().isEqualTo(Computer.BallsLength);
    }

    @Test
    void computerBallsList가_중복값을_가지지는_않는지_알아본다(){
        for(int i=0; i<100; i++){
            List<Integer> computerBallsList = Computer.makeBalls();
            assertThat(computerBallsList.get(0))
                    .isNotEqualTo(computerBallsList.get(1))
                    .isNotEqualTo(computerBallsList.get(2));
        }
    }

    @Test
    void 사용자의_입력값이_제대로_userBallList로_반환되는지_알아본다(){
        String userInput = "134";
        List<Integer> result = List.of(1,3,4);
        assertThat(User.checkUserInput(userInput)).isEqualTo(result);
    }

    @Test
    void 사용자가_잘못된_입력값을_입력했을때_exception이_제대로_발생하는지_알아본다(){
        /*List<String> errorInputList = List.of("1", "10", "223", "", "3455" , "하하하");
        for(String errorInput :errorInputList){
            assertThatThrownBy(()-> User.checkUserInput(errorInput))
                        .isInstanceOf(IllegalArgumentException.class);
        }*/
        assertThatThrownBy(()-> User.checkUserInput("1"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()-> User.checkUserInput("10"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()-> User.checkUserInput("223"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()-> User.checkUserInput(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()-> User.checkUserInput("3455"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()-> User.checkUserInput("하하하"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()-> User.checkUserInput("-256"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
