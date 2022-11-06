package baseball;

import org.junit.jupiter.api.*;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class UtilTest {

    private RandomUtil randomUtil = new RandomUtil();
    private CheckUtil checkUtil = new CheckUtil();
    @DisplayName("컴퓨터 랜덤값 길이 테스트")
    @Test
    void 컴퓨터_랜덤값_길이_테스트(){
        int length = randomUtil.giveComputerNumber().size();
        assertThat(length).isEqualTo(3);
    }

    @DisplayName("컴퓨터 랜덤값 중복 테스트")
    @Test
    void 컴퓨터_랜덤값_중복_테스트(){
        List<String> comList = randomUtil.giveComputerNumber().stream()
                .distinct()
                .collect(Collectors.toList());
        assertThat(comList.size()).isEqualTo(3);
    }

    @DisplayName("컴퓨터 랜덤값 유효성 테스트")
    @Test
    void 컴퓨터_랜덤값_유효성_테스트(){
        for(String str:randomUtil.giveComputerNumber()){
            assertThat(Integer.parseInt(str))
                    .isGreaterThanOrEqualTo(1)
                    .isLessThanOrEqualTo(9);
        }
    }

    @DisplayName("사용자 입력값 길이 테스트")
    @Test
    void 사용자_입력값_길이_테스트(){
        assertThatThrownBy(()->checkUtil.checkIsValidLength("1234".length()))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("사용자 입력값 중복 테스트")
    @Test
    void 사용자_입력값_중복_테스트(){
        List<String> list = List.of("1","1","2");
        assertThatThrownBy(()->checkUtil.checkIsDuplicated(list))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자 입력값 유효성 테스트")
    @Test
    void 사용자_입력값_유효성_테스트(){
        assertThatThrownBy(()->checkUtil.checkIsValidDigit("012"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
