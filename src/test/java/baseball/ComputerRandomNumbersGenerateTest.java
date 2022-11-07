package baseball;

import baseball.domain.Computer;
import baseball.domain.InputValidation;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ComputerRandomNumbersGenerateTest extends NsTest {

    InputValidation inputValidation = new InputValidation();

    /**
     * 컴퓨터가 가질 랜덤 값을 반환
     * @return 컴퓨터가 가질 랜덤 값
     */
    public String getComputerRandomNumbers(){
        Computer computer = new Computer();

        return computer.getRandomNumber();
    }

    @Test
    void 숫자가_아닌_것이_포함() {

        String testInvalidNumber = "1김2%";
        String randomNumbers = getComputerRandomNumbers();

        assertThatThrownBy(() -> inputValidation.checkContainOnlyDigit(testInvalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자로만 이루어져 있어야 합니다.");

        Assertions.assertEquals(inputValidation.checkContainOnlyDigit(randomNumbers), true);

    }

    @Test
    void 중복된_숫자가_포함() {

        String testInvalidNumber = "334";
        String randomNumbers = getComputerRandomNumbers();

        assertThatThrownBy(() -> inputValidation.checkIncludeDuplicateNumber(testInvalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자가 존재하면 안됩니다.");

        Assertions.assertEquals(inputValidation.checkIncludeDuplicateNumber(randomNumbers), false);

    }

    @Test
    void 입력한_값이_3자리() {

        String testInvalidNumber = "1234";
        String randomNumbers = getComputerRandomNumbers();

        assertThatThrownBy(() -> inputValidation.checkValidNumberLength(testInvalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리 숫자로 이루어져 있어야 합니다.");

        Assertions.assertEquals(randomNumbers.length() == 3, true);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }


}
