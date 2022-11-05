package baseball.controller;


import baseball.dto.NumListDto;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ReceiveConsoleTest {
    @BeforeEach
    void 콘솔값clear() {
        System.setOut(null);
    }

    @Test
    void receiveNum_성공테스트() throws IllegalAccessException {
        //given
        System.setIn(new ByteArrayInputStream(("123"+'\n').getBytes()));
        //when
        NumListDto numListDto = ReceiveConsole.receiveNumIncludeAllException();
        //then
        assertThat(numListDto.getNumList()).isEqualTo(Arrays.asList(1,2,3));
    }


    @Test
    void receiveNum_숫자외다른것이있는케이스() {
        //given
        System.setIn(new ByteArrayInputStream(("h1!"+'\n').getBytes()));
        //when
        //then
        assertThatThrownBy(() -> ReceiveConsole.receiveNumIncludeAllException())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void receiveNum_한글이있는경우테스트() {
        //given
        System.setIn(new ByteArrayInputStream(("한1글"+'\n').getBytes()));
        //when
        //then
        assertThatThrownBy(() -> ReceiveConsole.receiveNumIncludeAllException())
                .isInstanceOf(IllegalArgumentException.class);
    }

}