package baseball.baseballs;

import java.util.Objects;

public class Baseball {

    private int value;

    public Baseball(int value) {
        this.value = value;
    }

    public Baseball(Character value) {
        this(Character.getNumericValue(value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Baseball baseball = (Baseball) o;
        return value == baseball.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
