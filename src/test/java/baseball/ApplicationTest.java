package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void computerSelectThreeNumbers_서로_다른_3개의_정수가_생성되는지_확인() {
        Game game = new Game();
        game.computerSelectThreeNumbers();
        assertThat(game.numbersPickedByComputer).containsAnyOf(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(game.numbersPickedByComputer.size()).isEqualTo(3);
        assertThat(game.numbersPickedByComputer.get(0)).isNotEqualTo(game.numbersPickedByComputer.get(1));
        assertThat(game.numbersPickedByComputer.get(0)).isNotEqualTo(game.numbersPickedByComputer.get(2));
        assertThat(game.numbersPickedByComputer.get(1)).isNotEqualTo(game.numbersPickedByComputer.get(2));
    }

    @Test
    void validateLengthOfInputString_입력_문자열의_길이가_3인지_확인() {
        Game game = new Game();
        assertThat(game.validateLengthOfInputString("123")).isEqualTo(true);
        assertThat(game.validateLengthOfInputString("489")).isEqualTo(true);
        assertThat(game.validateLengthOfInputString("23")).isEqualTo(false);
        assertThat(game.validateLengthOfInputString("12367")).isEqualTo(false);
        assertThat(game.validateLengthOfInputString("-asdf")).isEqualTo(false);
        assertThat(game.validateLengthOfInputString("-as")).isEqualTo(true);

    }

    @Test
    void validateTypeOfInputString_입력_문자열이_1에서_9_사이의_정수로_이루어졌는지_확인() {
        Game game = new Game();
        assertThat(game.validateTypeOfInputString("123")).isEqualTo(true);
        assertThat(game.validateTypeOfInputString("489")).isEqualTo(true);
        assertThat(game.validateTypeOfInputString("23")).isEqualTo(true);
        assertThat(game.validateTypeOfInputString("123670")).isEqualTo(false);
        assertThat(game.validateTypeOfInputString("-123")).isEqualTo(false);
        assertThat(game.validateTypeOfInputString("abc")).isEqualTo(false);

    }

    @Test
    void validateUniquenessOfEachCharacter_입력_문자열이_서로_다른_값으로_이루어져있는지_확인() {
        Game game = new Game();
        assertThat(game.validateUniquenessOfEachCharacter("123")).isEqualTo(true);
        assertThat(game.validateUniquenessOfEachCharacter("484")).isEqualTo(false);
        assertThat(game.validateUniquenessOfEachCharacter("235")).isEqualTo(true);
        assertThat(game.validateUniquenessOfEachCharacter("122")).isEqualTo(false);
        assertThat(game.validateUniquenessOfEachCharacter("6713")).isEqualTo(true);
        assertThat(game.validateUniquenessOfEachCharacter("abcc")).isEqualTo(false);

    }

    @Test
    void validateInputNumber_사용자가_선택한_3개_숫자의_유효성_테스트() {
        Game game = new Game();

        assertThatThrownBy(() -> game.validateInputNumber("1244"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> game.validateInputNumber("144"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> game.validateInputNumber("024"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> game.validateInputNumber("asb144"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> game.validateInputNumber("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
