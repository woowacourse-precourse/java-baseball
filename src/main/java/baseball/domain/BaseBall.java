package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseBall {

    private List<OneBaseBallNumber> baseBallList = new ArrayList<>();

    public void BaseBall(List<Integer> numeberList) {
        OneBaseBallNumber oneBaseBallNumber = new OneBaseBallNumber();

        for(int i = 0; i < numeberList.size(); i++) {
            int number = numeberList.get(i);
            this.baseBallList.add(oneBaseBallNumber.OneBaseBallNumberInfo(number, i));
        }
    }
}
