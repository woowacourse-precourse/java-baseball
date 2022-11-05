package baseball;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @Test
    void confirmInputValue() {
        //TODO : 예외 케이스를 던졌을 때 IllegalException을 반환할 것
        List<Integer> userInput = getUserInputValue();

        assertThat(userInput.size()).isEqualTo(3);

    }

    List<Integer> getUserInputValue () {

        List<Integer> userInput = new ArrayList<>();
        String input = "123";

        for(int i = 0; i < input.length(); i++) {
            userInput.add(input.charAt(i) -'0');
        }

        return userInput;
    }
}