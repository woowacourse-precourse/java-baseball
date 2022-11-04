package baseball;

public class MockReaderReturnError extends Reader {

    public MockReaderReturnError() {
        super();
    }

    @Override
    protected int readInt() {
        throw new IllegalArgumentException();
    }
}
