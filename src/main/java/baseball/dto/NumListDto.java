package baseball.dto;

import java.util.List;

public class NumListDto {
    private List<Integer> numList;

    public NumListDto(List<Integer> numList) {
        this.numList = numList;
    }

    public List<Integer> getNumList() {
        return numList;
    }
}
