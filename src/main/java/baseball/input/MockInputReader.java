package baseball.input;

public class MockInputReader implements InputReader {

  private final String mockData;

  public MockInputReader(String mockData) {
    this.mockData = mockData;
  }

  @Override
  public String readLine() {
    return this.mockData;
  }
}
