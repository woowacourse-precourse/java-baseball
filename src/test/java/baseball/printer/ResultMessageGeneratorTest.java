package baseball.printer;

import baseball.console.ResultMessageGenerator;
import baseball.core.dto.BallStrikeDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultMessageGeneratorTest {

    ResultMessageGenerator generator;

    @BeforeEach
    void init() {
        generator = new ResultMessageGenerator();
    }

    @Test
    @DisplayName("낫싱")
    void case1() {
        //given
        BallStrikeDto dto = new BallStrikeDto(0, 0);

        //when
        String res = generator.generateMessage(dto);

        //then
        assertThat(res).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("1볼")
    void case2() {
        //given
        BallStrikeDto dto = new BallStrikeDto(1, 0);

        //when
        String res = generator.generateMessage(dto);

        //then
        assertThat(res).isEqualTo("1볼");
    }

    @Test
    @DisplayName("1스트라이크")
    void case3() {
        //given
        BallStrikeDto dto = new BallStrikeDto(0, 1);

        //when
        String res = generator.generateMessage(dto);

        //then
        assertThat(res).isEqualTo("1스트라이크");
    }

    @Test
    @DisplayName("1볼 1스트라이크")
    void case4() {
        //given
        BallStrikeDto dto = new BallStrikeDto(1, 1);

        //when
        String res = generator.generateMessage(dto);

        //then
        assertThat(res).isEqualTo("1볼 1스트라이크");
    }

    @Test
    @DisplayName("2볼 1스트라이크")
    void case5() {
        //given
        BallStrikeDto dto = new BallStrikeDto(2, 1);

        //when
        String res = generator.generateMessage(dto);

        //then
        assertThat(res).isEqualTo("2볼 1스트라이크");
    }

    @Test
    @DisplayName("3스트라이크")
    void case6() {
        //given
        BallStrikeDto dto = new BallStrikeDto(0, 3);

        //when
        String res = generator.generateMessage(dto);

        //then
        assertThat(res).isEqualTo("3스트라이크");
    }
}