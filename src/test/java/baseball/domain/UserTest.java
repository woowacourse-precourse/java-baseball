package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("사용자의 입력에 대한 테스트")
class UserTest {

    private User user;

    @BeforeEach
    @DisplayName("테스트에 사용할 User 인스턴스 생성")
    public void makeGameInstance() {
        this.user = new User();
        assertThat(user).isInstanceOf(User.class);
    }
}