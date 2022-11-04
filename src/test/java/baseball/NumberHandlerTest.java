package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NumberHandlerTest {

    @Test
    void 랜덤난수생성() {
        NumberHandler numberHandler = new NumberHandler();
        ArrayList<Integer> computerNumber = numberHandler.getComputerNumber();

        for (Integer number : computerNumber) {
            System.out.print(number);
        }
        System.out.println();
    }

    @Test
    void 사용자_숫자_입력() {
        NumberHandler numberHandler = new NumberHandler();
        InputStream in = new ByteArrayInputStream("178".getBytes());
        System.setIn(in);

        numberHandler.setUserNumber();
        ArrayList<Integer> userNumber = numberHandler.getUserNumber();

        assertThat(userNumber).containsExactly(1, 7, 8);
    }

    @Test
    void 사용자_잘못된_문자_입력() {
        NumberHandler numberHandler1 = new NumberHandler();
        InputStream in1 = new ByteArrayInputStream("178zz".getBytes());
        System.setIn(in1);

        assertThatThrownBy(() -> numberHandler1.setUserNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백없이 숫자만 입력해주세요.");
    }

    @Test
    void 사용자_중복_숫자_입력() {
        NumberHandler numberHandler = new NumberHandler();
        ByteArrayInputStream in = new ByteArrayInputStream("787".getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> numberHandler.setUserNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되는 숫자 없이 입력해주세요.");
    }


}