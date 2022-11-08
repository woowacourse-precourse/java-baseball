package baseball.service;

import baseball.domain.Baseball;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballServiceTest {
    BaseballService baseballService;

    @BeforeEach
    void startGame() {
        baseballService = new BaseballService(new Baseball());
    }

    @Test
    public void 낫싱() throws Exception {
        //given
        baseballService.start("000");

        //when
        String result = baseballService.getResult();

        //then
        assertThat(result).isEqualTo("낫싱");
    }

    @Test
    public void 결과_출력() throws Exception {
        //given
        baseballService.start("123");

        //when
        String result = baseballService.getResult();

        //then
        System.out.println("baseballService = " + baseballService.getResult());
    }
}
