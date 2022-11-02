package baseball.domain;

import java.util.Objects;

public class Baseball {

    private Integer number;

    public Baseball(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
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
        return Objects.equals(number, baseball.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
