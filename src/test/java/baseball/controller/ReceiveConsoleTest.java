package baseball.controller;


import baseball.dto.NumListDto;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ReceiveConsoleTest {

    @Test
    void receiveNum_성공테스트() {
        //given
        System.setIn(new ByteArrayInputStream(("123"+'\n').getBytes()));
        //when
        NumListDto numListDto = ReceiveConsole.receiveNum();
        //then
        assertThat(numListDto.getNumList()).isEqualTo(Arrays.asList(1,2,3));
    }

    @Test
    void receiveNum_한글이있는경우() {
        //given
        System.setIn(new ByteArrayInputStream(("한1글"+'\n').getBytes()));
        //when
        //then
        assertThatThrownBy(() -> ReceiveConsole.receiveNum())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void receiveNum_영어가있는경우() {
        //given
        System.setIn(new ByteArrayInputStream(("h1i"+'\n').getBytes()));
        //when
        //then
        assertThatThrownBy(() -> ReceiveConsole.receiveNum())
                .isInstanceOf(IllegalArgumentException.class);
    }

}