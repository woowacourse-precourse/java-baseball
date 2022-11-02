package missionuutils;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConsoleAPITest {

    @Test
    void readLine_메서드_사용시_문자열을_입력받음(){
        String input = "hello world!";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThat(Console.readLine()).isEqualTo("hello world!");
    }
    @Test
    void readLine_메서드_사용시_문자열을_입력받음_실패(){
        String input = "hi world!";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThat(Console.readLine()).isNotEqualTo("hello world!");
    }
}
