package baseball.mock;

import baseball.Target;

import java.util.ArrayList;
import java.util.List;

public class MockTarget extends Target {
    private static final int CHECK_VALUE = -1;

    List<Integer> MockTargetValue;

    public MockTarget(List<Integer> mockTargetValue) {
        this.MockTargetValue = new ArrayList<>(mockTargetValue);
    }

    @Override
    public Target copy() {
        return new MockTarget(this.MockTargetValue);
    }

    @Override
    public Integer get(int index) {
        return MockTargetValue.get(index);
    }

    @Override
    public boolean isContain(Integer element) {
        return MockTargetValue.contains(element);
    }

    @Override
    public void check(int index) {
        MockTargetValue.set(index, CHECK_VALUE);
    }
}
