package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class UserTest {

    @Test
    void inputNumber() {
        checkNumberInteger();
        checkNumberLength();

        madeNumber();
        checkNumberDigit();
    }

    @Test
    void inputGameState() {
        String input_test1 = "1";
        String input_test2 = "2";
        String input_test3 = "123";
        if (input_test1.equals("1")) {
            String answer = "1";
            assertThat(answer).isEqualTo(input_test1);
        } else if (input_test2.equals("2")) {
            String answer = "2";
            assertThat(answer).isEqualTo(input_test2);
        } else if (!input_test3.equals("1") || !input_test3.equals("2")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    @Test
    void checkNumberInteger() {
        String input = "12*";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                assertThatIllegalArgumentException().isThrownBy(() -> {
                    throw new IllegalArgumentException("입력에 숫자가 아닌 문자가 포함되어 있습니다.");
                }).withMessage("%s", "입력에 숫자가 아닌 문자가 포함되어 있습니다.");
            }
        }
    }

    @Test
    void checkNumberLength() {
        String input_test1 = "";
        String input_test2 = "12345";
        if (input_test1.length() == 0) {
            assertThatIllegalArgumentException().isThrownBy(() -> {
                throw new IllegalArgumentException("입력한 수가 없습니다.");
            }).withMessage("%s", "입력한 수가 없습니다.");
        } else if (input_test2.length() != 3) {
            assertThatIllegalArgumentException().isThrownBy(() -> {
                throw new IllegalArgumentException("입력한 수가 세 자리의 수가 아닙니다.");
            }).withMessage("%s", "입력한 수가 세 자리의 수가 아닙니다.");
        }
    }

    @Test
    void checkNumber() {
        Character number = '3';
        ArrayList<Character> numberList = new ArrayList<>(Arrays.asList('1', '2'));
        Boolean answer = numberList.contains(number);
        assertThat(answer).isEqualTo(false);
    }

    @Test
    void addNumber() {
        Character answer = '3';
        ArrayList<Character> numberList = new ArrayList<>(Arrays.asList('1', '2'));
        numberList.add(answer);
        assertThat(numberList.get(2)).isEqualTo(answer);
    }

    @Test
    void madeNumber() {
        String input = "123";
        ArrayList<Character> numberList = new ArrayList<>(Arrays.asList('1', '2', '3'));
        ArrayList<Character> answer = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (!answer.contains(input.charAt(i))) {
                answer.add(input.charAt(i));
            }
        }
        assertThat(answer).isEqualTo(numberList);
    }

    @Test
    void checkNumberDigit() {
        ArrayList<Character> numberList = new ArrayList<>(Arrays.asList('1', '2'));
        if (numberList.size() != 3) {
            assertThatIllegalArgumentException().isThrownBy(() -> {
                throw new IllegalArgumentException("입력한 수가 서로 다른 3자리의 수가 아닙니다.");
            }).withMessage("%s", "입력한 수가 서로 다른 3자리의 수가 아닙니다.");
        }
    }

    @Test
    void setNumber() {
        Integer answer = 123;
        String input = "123";
        Integer inputInt = Integer.valueOf(input);
        assertThat(inputInt).isEqualTo(answer);
    }

    @Test
    void madeAnswer() {
        inputNumber();
        setNumber();
    }
}