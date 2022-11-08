package baseball;

import baseball.domain.Computer;
import baseball.domain.InputValidation;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ComputerRandomNumbersGenerateTest extends NsTest {

    InputValidation inputValidation = new InputValidation();

    @Test
    void 숫자가_아닌_것이_포함() {

        Computer computer = new Computer();
        computer.setRandomNumber();

        String testInvalidNumber = "1김2%";

        assertThatThrownBy(() -> inputValidation.checkContainOnlyDigit(testInvalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자로만 이루어져 있어야 합니다.");

        Assertions.assertEquals(inputValidation.checkContainOnlyDigit(computer.getNumber()), true);

    }

    @Test
    void 중복된_숫자가_포함() {

        Computer computer = new Computer();
        computer.setRandomNumber();

        String testInvalidNumber = "334";

        assertThatThrownBy(() -> inputValidation.checkIncludeDuplicateNumber(testInvalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자가 존재하면 안됩니다.");

        Assertions.assertEquals(inputValidation.checkIncludeDuplicateNumber(computer.getNumber()), false);

    }

    @Test
    void 입력한_값이_3자리() {

        Computer computer = new Computer();
        computer.setRandomNumber();

        String testInvalidNumber = "1234";

        assertThatThrownBy(() -> inputValidation.checkValidNumberLength(testInvalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리 숫자로 이루어져 있어야 합니다.");

        Assertions.assertEquals(computer.getNumber().length() == 3, true);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }


}
