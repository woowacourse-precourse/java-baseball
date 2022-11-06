package io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class IOProcessorTest {
    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    @DisplayName("사용자 입력내용을 제대로 받아오는 가?")
    void get_user_input_test() {
        systemIn("123");
        String input = IOProcessor.getUserInput();

        assertThat(input)
                .isEqualTo("123");
    }
}
