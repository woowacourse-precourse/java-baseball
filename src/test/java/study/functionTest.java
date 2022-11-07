package study;

import baseball.Application;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class functionTest {
    @Test
    void generateComputerNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer.toString());
    }

    @Test
    void readUserNumber() {
        String inputNum = "345";
        List<String> splittedNum = List.of(inputNum.split(""));
        List<Integer> digits = splittedNum.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println(digits.toString());
    }

    @Test
    void 오류_던지기() {
        String input = "1234";
        assertThatThrownBy(() -> {
            if (input.length() != 3) {
                throw new IllegalArgumentException();
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열_쪼개기() {
        List<String> splittedUserInput = List.of("123".split(""));
        assertThat(splittedUserInput).containsExactly("1", "2", "3");

    }

    @Test
    void 문자열_정수리스트로_변환() {
        List<String> splittedUserInput = List.of("123".split(""));
        List<Integer> digits;
        try {
            digits = splittedUserInput.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }

        assertThat(digits).containsExactly(1, 2, 3);
    }

    @Test
    void 숫자_이외의_값_입력() {
        List<String> splittedUserInput = List.of("abc".split(""));
        assertThatThrownBy(() -> {
            try {
                splittedUserInput.stream()
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
            } catch (Exception e) {
                throw new IllegalArgumentException("숫자만 입력해주세요.");
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 빈_문자열_입력() {
        List<String> splittedUserInput = List.of("".split(""));
        assertThatThrownBy(() -> {
            try {
                splittedUserInput.stream()
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
            } catch (Exception e) {
                throw new IllegalArgumentException("숫자만 입력해주세요.");
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복유무_체크() {
        List<Integer> digits = List.of(1, 2, 3, 3);
        HashSet<Integer> nonDuplicateDigits = new HashSet<>(digits);

        assertThatThrownBy(() -> {
            if (nonDuplicateDigits.size() != digits.size()) {
                throw new IllegalArgumentException("동일한 숫자를 입력했습니다.");
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시작_기능_예외테스트1() {
        String userInput = "";
        boolean output = true;
        Exception e;

        if (userInput.equals("1")) {
            output = true;
        }
        if (userInput.equals("2")) {
            output = false;
        }
        e = new IllegalArgumentException("1이나 2를 입력해주세요.");

        assertThat(e).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시작_기능_예외테스트2() {
        String userInput = "a";
        boolean output = true;
        Exception e;

        if (userInput.equals("1")) {
            output = true;
        }
        if (userInput.equals("2")) {
            output = false;
        }
        e = new IllegalArgumentException("1이나 2를 입력해주세요.");

        assertThat(e).isInstanceOf(IllegalArgumentException.class);
    }
}
