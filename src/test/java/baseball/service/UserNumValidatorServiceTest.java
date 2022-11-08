package baseball.service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static baseball.service.UserNumValidatorService.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserNumValidatorServiceTest {

    @Test
    void 길이가_3인지(){
        assertThat(true).isEqualTo(isThreelen("222"));
        assertThat(false).isEqualTo(isThreelen("22"));
    }

    @Test
    void 중복이_있는지(){
        assertThat(true).isEqualTo(isNotDuplicated("123"));
        assertThat(false).isEqualTo(isNotDuplicated("22"));
    }

    @Test
    void 입력이_1부터9까지_정수인지(){
        assertThat(true).isEqualTo(isOneNineInt("123"));
        assertThat(false).isEqualTo(isOneNineInt("220"));
        assertThat(false).isEqualTo(isOneNineInt("22jj"));
    }

    @Test
    void 사용자_입력_검증(){

        assertThat(Arrays.asList(1, 2, 3)).isEqualTo(UserNumValidatorService.validator("123"));
        assertSimpleTest(() ->
                assertThatThrownBy(() -> UserNumValidatorService.validator("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> UserNumValidatorService.validator("103"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> UserNumValidatorService.validator("hii"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> UserNumValidatorService.validator("1hi4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}