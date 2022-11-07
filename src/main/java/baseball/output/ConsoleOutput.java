package baseball.output;

import basedomain.message.Message;
import basedomain.output.Output;

public class ConsoleOutput implements Output {

    @Override
    public void print(Message message) {
        System.out.print(message.toString());
    }
}
