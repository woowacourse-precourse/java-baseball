package baseball;

public class MockReaderReturn1 extends Reader {
    public MockReaderReturn1() {
        super();
    }

    @Override
    protected int readInt() {
        return 1;
    }
}
