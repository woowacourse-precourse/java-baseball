package baseball.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseballServiceTest {
    BaseballService baseballService = new BaseballService();

    @BeforeEach
    void startGame() {
        baseballService.startGame();
    }

    @Test
    void 낫싱() throws Exception {
        //given
        baseballService.progress("000");

        //when
        String result = baseballService.getResult();

        //then
        Assertions.assertThat(result).isEqualTo("낫싱");
    }

    @Test
    void 임의의_결과_출력() throws Exception {
        //given
        baseballService.progress("123");

        //when
        String result = baseballService.getResult();

        //then
        System.out.println("baseballService = " + baseballService.getResult());
    }

}