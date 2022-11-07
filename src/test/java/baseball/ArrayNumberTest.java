package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayNumberTest {
    private static final int cnt_nbr = 3;
    private static final int min_nbr = 1;
    private static final int max_nbr = 9;

    private static ArrayNumber arraynbr;

    @BeforeEach
    private void createNumber() {
        arraynbr = new ArrayNumber();
    }
}