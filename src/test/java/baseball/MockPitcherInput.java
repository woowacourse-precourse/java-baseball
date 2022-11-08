package baseball;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MockPitcherInput {
    public static InputStream mockPitcherInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
