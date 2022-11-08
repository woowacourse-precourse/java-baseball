package baseball.domain;
/*
2. 사용자는 3개의 서로 다른 1~9의 수를 입력할 수 있어야 한다.
 */

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertThrows;


import java.io.*;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사용자 입력 관련 테스트 코드 작성")
public class UserTest {

    private static User user;

    @BeforeAll
    static void initAll() {
        user = new User();
    }

    @AfterEach
    void afterEach() {
        user = new User();
    }

    @DisplayName("서로 다른 1 ~ 9 까지의 수를 선택하는 기능 - [성공]")
    @Test
    void givenUser_whenUserPickedNumber_thenReturnNumbers(){
        // Given
        String input = "123";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        // When

        user.pickANumber();
        ArrayList<Integer> user_selectedNumbers = user.getUser_selectedNumbers();

        // Then
        assertThat(user_selectedNumbers.size()).isEqualTo(3);
        assertThat(user_selectedNumbers.stream().distinct().count()).isEqualTo(3);
    }

    @DisplayName("0 또는 다른 기호 입력 IllegalArgumentException 발생")
    @Test
    void givenUser_whenUserPickedWrongNumberOtherCharacters_thenReturnIllegalArgumentException(){
        // Given
        String input = "0AB";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        // When
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> user.pickANumber());

        // Then
        assertThat(illegalArgumentException.getMessage()).isEqualTo("0과 숫자 이외의 문자를 입력하셨습니다.");

    }

    @DisplayName("숫자인데 입력이 없거나 한자리수, 두자리수 IllegalArgumentException 발생")
    @Test
    void givenUser_whenUserPickedWrongNumber1_thenReturnIllegalArgumentException(){
        // Given
        String input = "34";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        System.out.println(user);
        // When
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> user.pickANumber());

        // Then
        assertThat(illegalArgumentException.getMessage()).isEqualTo("세자리 수를 정확하게 입력해주세요.");

    }

    @DisplayName("숫자인데 세자리 초과인 경우 IllegalArgumentException 발생")
    @Test
    void givenUser_whenUserPickedWrongNumber2_thenReturnIllegalArgumentException(){
        // Given
        String input = "33234234";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        // When
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> user.pickANumber());

        // Then
        assertThat(illegalArgumentException.getMessage()).isEqualTo("세자리 수를 정확하게 입력해주세요.");

    }
}
