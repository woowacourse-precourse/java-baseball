package baseball;

import java.util.Objects;

public class Baseball {

    private int value;

    public Baseball(int value) {
        this.value = value;
    }

    public Baseball(Character value) {
        this(Character.getNumericValue(value));
    }
}
