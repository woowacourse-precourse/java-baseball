package baseball.input;

public class MockInputReader implements InputReader {

    private int index = 0;
    private final String[] mockInput;

    public MockInputReader(String... mockInput) {
        this.mockInput = mockInput;
    }

    @Override
    public String readLine() {
        System.out.println();
        return this.mockInput[index++];
    }
}
