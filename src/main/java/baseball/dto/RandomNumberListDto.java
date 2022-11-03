package baseball.dto;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberListDto {

    private List<Integer> randomNumberList;

    public RandomNumberListDto(List<Integer> randomNumberList) {
        this.randomNumberList = randomNumberList;
    }

    public List<Integer> getRandomNumberList() {
        return randomNumberList;
    }
}
