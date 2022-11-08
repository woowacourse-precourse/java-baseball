package baseball.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class UserTest {

    private final User user = spy(new User());
    private final BufferedReader reader = mock(BufferedReader.class);

    @DisplayName("유저가 인풋 타이핑하면 입력값을 반환한다.")
    @Test
    void givenInput_whenUserTyping_thenReturnString() throws IOException {
        //given
        doCallRealMethod().when(user).answer();
        given(user.getReader()).willReturn(reader);
        given(reader.readLine()).willReturn("369");
        String ans = "369";

        //when
        String result = user.answer();

        //then
        verify(reader).readLine();
        assertThat(result).isEqualTo(ans);
    }
}