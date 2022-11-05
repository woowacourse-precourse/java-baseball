package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

public class UserNumberTest {
    Application app = new Application();

    public static InputStream getConsoleInput(String input){
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    @DisplayName("올바른 입력")
    void 사용자_입력_리스트_검증1(){
        String input = "123";
        InputStream in = getConsoleInput(input);
        System.setIn(in);

        List<Integer> userNumberList = app.getUserNumberList();
        assertThat(userNumberList).isEqualTo(List.of(1,2,3));
    }

    @Test
    @DisplayName("숫자 2개만 입력")
    void 사용자_입력_리스트_검증2(){
        String input = "12";
        InputStream in = getConsoleInput(input);
        System.setIn(in);

        assertThatThrownBy(() -> app.getUserNumberList())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자아닌거 입력")
    void 사용자_입력_리스트_검증3(){
        String input = "ㄱㄴㄷ";
        InputStream in = getConsoleInput(input);
        System.setIn(in);

        assertThatThrownBy(() -> app.getUserNumberList())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복 숫자 입력")
    void 사용자_입력_리스트_검증4(){
        String input = "121";
        InputStream in = getConsoleInput(input);
        System.setIn(in);

        assertThatThrownBy(() -> app.getUserNumberList())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
