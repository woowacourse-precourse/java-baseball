package baseball.repository;

import baseball.model.BaseNumber;

import static baseball.utils.GameNumberGenerator.generate;

public class BaseNumberRepository {
    private BaseNumber baseNumber;

    public BaseNumberRepository() {
    }

    //테스트를 위해 직접 기준숫자 주입
    @Deprecated
    public BaseNumberRepository(BaseNumber baseNumber) {
        this.baseNumber = baseNumber;
    }

    public void createBaseNumber() {
        this.baseNumber = generate();
    }

    public BaseNumber findBaseNumber(){
        return this.baseNumber;
    }
}
