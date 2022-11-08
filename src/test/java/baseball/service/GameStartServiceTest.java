package baseball.service;

import baseball.repository.GameStartRepository;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameStartServiceTest {
    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "999", "1234", " ", "012", "qs", "-12"})
    void 사용자가_입력한_값이_유효한지_체크(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
        assertThatThrownBy(() -> GameStartService.saveUserNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "987"})
    void 사용자가_입력한_값이_저장되는지_체크(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
        GameStartService.saveUserNumber();
        assertThat(GameStartRepository.lastUserNumberList.size()).isEqualTo(3);
    }

    @Test
    @RepeatedTest(10000)
    void 난수_생성이_유효한지_체크() {
        Set<String> randomNumberSet = new HashSet<>();
        GameStartService.saveComputerNumber();
        for (int i = 0; i < 3; i++) {
            String number = GameStartRepository.lastComputerNumberList.get(i);
            randomNumberSet.add(number);
            assertThat(Integer.parseInt(number) >= 1 && Integer.parseInt(number) <= 9).isTrue();
        }
        assertThat(randomNumberSet.size()).isEqualTo(3);

    }

    @Test
    void 사용자_입력과_난수_비교가_정상적인지_체크() {
        GameStartRepository.lastComputerNumberList = new ArrayList<>(Arrays.asList("3", "2", "1"));
        GameStartRepository.lastUserNumberList = new ArrayList<>(Arrays.asList("1", "2", "3"));
        String hint = GameStartService.compareNumber();
        assertThat(hint).isEqualTo("2볼 1스트라이크");
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "12", "999", "1234", " ", "012", "qs", "0", "-1"})
    void 게임_재시작시_사용자_입력이_유효한지_체크(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
        assertThatThrownBy(() -> GameStartService.saveUserNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
