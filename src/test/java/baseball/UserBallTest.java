package baseball;

import org.junit.jupiter.api.Test;
import baseball.domain.UserBall;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class UserBallTest {

    @Test
    void 유저볼_3개_이상_값이_들어올_때(){
        String ball = "1114";

        UserBall userBall = new UserBall();

        assertThatThrownBy(() -> userBall.generateUserBall(ball))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저볼_2개_이하_값이_들어올_때(){
        String ball = "14";

        UserBall userBall = new UserBall();

        assertThatThrownBy(() -> userBall.generateUserBall(ball))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저볼_문자가_들어올_때(){
        String ball = "ab3";

        UserBall userBall = new UserBall();

        assertThatThrownBy(() -> userBall.generateUserBall(ball))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저볼_숫자가_범위_벗어날_때(){
        String ball = "014";

        UserBall userBall = new UserBall();

        assertThatThrownBy(() -> userBall.generateUserBall(ball))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저볼_중복숫자가_있을때(){
        String ball = "121";

        UserBall userBall = new UserBall();

        assertThatThrownBy(() -> userBall.generateUserBall(ball))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 유저볼_성공(){
        String ball = "135";
        List<Integer> answer = List.of(1, 3, 5);

        UserBall userBall = new UserBall();
        userBall.generateUserBall(ball);

        assertThat(userBall.userNumber).isEqualTo(answer);
    }
}
