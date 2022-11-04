package baseball.service;

import baseball.repository.GameStartRepository;
import baseball.util.UserUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameStartServiceTest {
    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","12","999","1234"," ","012","qs"})
    void 사용자가_입력한_값이_유효한지_체크(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
        assertThatThrownBy(() -> GameStartService.saveUserNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123"})
    void 사용자가_입력한_값이_저장되는지_체크(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
        GameStartService.saveUserNumber();
        assertThat(GameStartRepository.lastUserNumberList.size()).isEqualTo(3);
    }

    @Test
    void 난수_생성이_유효한지_체크() {
        GameStartService.saveComputerNumber();
        for (int i = 0 ; i <= 100000000; i++) {
            String firstNum = GameStartRepository.lastComputerNumberList.get(0);
            String secondNum = GameStartRepository.lastComputerNumberList.get(1);
            String thirdNum = GameStartRepository.lastComputerNumberList.get(2);
            assertThat(Integer.parseInt(firstNum) >= 1 && Integer.parseInt(firstNum) <= 9).isTrue();
            assertThat(Integer.parseInt(secondNum) >= 1 && Integer.parseInt(secondNum) <= 9).isTrue();
            assertThat(Integer.parseInt(thirdNum) >= 1 && Integer.parseInt(thirdNum) <= 9).isTrue();
        }
    }
}