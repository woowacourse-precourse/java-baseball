package baseball.generator;

import java.util.List;

public class MockRandomGenerator extends RandomNumberGenerator {

    private final List<Integer> mockData;

    public MockRandomGenerator(int first, int second, int third) {
        this.mockData = List.of(first, second, third);
    }

    @Override
    protected List<Integer> generateRandomNumber(int resultSize) {
        return this.mockData;
    }
}
