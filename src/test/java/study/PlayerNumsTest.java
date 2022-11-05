package study;

import baseball.PlayerNums;
import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


class PlayerNumsTest {

  //  @ParameterizedTest
    @ValueSource(strings = {"122\n"})
    void 사용자_숫자_입력(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        int playerNumsLen = 3;
        PlayerNums playerNums = new PlayerNums();
        System.setIn(in);
        playerNums.setNums();
        System.out.println(playerNums.getNums());
        assertThat(playerNums.getNums().size()).isEqualTo(playerNumsLen);
    }


}