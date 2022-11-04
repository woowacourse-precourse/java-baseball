package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @Test
    void makeNewNumbers_메서드로_사용자_숫자_설정() {
        User user = new User();
        int target = 0;
        String numbers = "123";
        user.makeNewNumbers(numbers);

        for(int i=0; i<numbers.length(); i++) {
            target = target * 10 + user.getNumber(i);
        }

        assertThat(target).isEqualTo(Integer.parseInt(numbers));
    }
}
