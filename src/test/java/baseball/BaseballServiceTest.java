package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class BaseballServiceTest {

    BaseballService baseballService;
    ComputerBaseball computerBaseball;
    @BeforeEach
    public void init() {
        computerBaseball = mock(ComputerBaseball.class);
        baseballService = new BaseballService(computerBaseball);
    }
    @Test
    @DisplayName("{2,3,5} 를 입력할 시 컴퓨터가 생성한 {2,3,6} 와 비교해서 2스트라이크가 나와야한다")
    public void 볼_스트라이크_반환_테스트() throws Exception {
        //given
        given(computerBaseball.getNumberList()).willReturn(List.of(2, 3, 6));
        //when
        BaseBallDto result = baseballService.getResult(List.of(2, 3, 5));
        //then
        String expected = result.getResult();
        Assertions.assertThat(expected)
                  .isEqualTo("2스트라이크");

    }

}