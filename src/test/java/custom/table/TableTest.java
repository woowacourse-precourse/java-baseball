package custom.table;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class TableTest {

    private static final String DUPLICATE_NUMBER = "111";

    @Test
    void init_mustNotInitDuplicateNumber() {
        // given
        String input = DUPLICATE_NUMBER;

        // expect
        assertThatThrownBy(() -> {
            Table table = Table.init(DUPLICATE_NUMBER);
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void get_mustGetBeforeInit() {
        // given
        Table table = new Table();

        // expect
        assertThatThrownBy(() -> table.get(0)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void contains() {
        // given
        Table table = new Table();

        // expect
        assertThatThrownBy(() -> table.contains('1')).isInstanceOf(RuntimeException.class);
    }

    @Test
    void setNumber_mustNotSetDuplicateNumber() {
        // given
        String input = DUPLICATE_NUMBER;

        // expect
        assertThatThrownBy(() -> {
            Table table = new Table();
            table.setNumber(input);
        }).isInstanceOf(IllegalStateException.class);
    }
}