package baseball.repository;

import baseball.model.BaseNumber;

public class BaseNumberRepository {
    private BaseNumber baseNumber;

    public void saveBaseNumber(BaseNumber baseNumber) {
        this.baseNumber = baseNumber;
    }

    public BaseNumber findBaseNumber(){
        return this.baseNumber;
    }
}
