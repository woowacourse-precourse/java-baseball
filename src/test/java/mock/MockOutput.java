package mock;

import basedomain.message.Message;
import basedomain.output.Output;

public class MockOutput implements Output {
    @Override
    public void print(Message message) {
    }

    @Override
    public void println(String string) {
    }
}
