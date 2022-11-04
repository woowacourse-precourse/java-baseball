package baseball.model.domain;

import java.util.List;

public class NumberDto {
    private List<Integer> number;

    public NumberDto() {}

    public NumberDto(List<Integer> number) {
        this.number = number;
    }

    public List<Integer> getNumber() {
        return number;
    }

    public void setNumber(List<Integer> number) {
        this.number = number;
    }
}
