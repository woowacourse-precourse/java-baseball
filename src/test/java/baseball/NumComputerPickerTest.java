package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NumComputerPickerTest {

    @Test
    void pickNumComputer() {
        boolean actual = NumComputerPicker.validateNumComputer(NumComputerPicker.pickNumComputer());
        assertThat(actual).isEqualTo(true);
    }

    @Test
    void validateNumComputerCase1() {
        boolean actual = NumComputerPicker.validateNumComputer(111);
        assertThat(actual).isEqualTo(false);
    }

    @Test
    void validateNumComputerCase2() {
        boolean actual = NumComputerPicker.validateNumComputer(112);
        assertThat(actual).isEqualTo(false);
    }

    @Test
    void validateNumComputerCase3() {
        boolean actual = NumComputerPicker.validateNumComputer(120);
        assertThat(actual).isEqualTo(false);
    }

    @Test
    void validateNumComputerCase4() {
        boolean actual = NumComputerPicker.validateNumComputer(1000);
        assertThat(actual).isEqualTo(false);
    }

    @Test
    void validateNumComputerCase5() {
        boolean actual = NumComputerPicker.validateNumComputer(99);
        assertThat(actual).isEqualTo(false);
    }
}