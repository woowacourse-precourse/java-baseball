package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import baseball.domain.User;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

public class UserTest {
    private MockedStatic<Console> console;

    @BeforeEach
    void before() {
        console = mockStatic(Console.class);
    }

    @AfterEach
    void after() {
        console.close();
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789", "951" })
    void 입력한_값이_올바른_값이면_리스트를_리턴(String input) {
        when(Console.readLine()).thenReturn(input);

        User user = new User();
        List<Integer> result = user.inputGameNumber();

        String[] inputValues = input.split("");

        assertThat(result.get(0)).isEqualTo(Integer.parseInt(inputValues[0]));
        assertThat(result.get(1)).isEqualTo(Integer.parseInt(inputValues[1]));
        assertThat(result.get(2)).isEqualTo(Integer.parseInt(inputValues[2]));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "89", "012", " 56", "aa9", "!1@"})
    void 입력한_값이_올바르지_않은_값이면_에러_발생(String input) {
        when(Console.readLine()).thenReturn(input);

        User user = new User();

        assertThatThrownBy(user::inputGameNumber).isInstanceOf(IllegalArgumentException.class);
    }
}
