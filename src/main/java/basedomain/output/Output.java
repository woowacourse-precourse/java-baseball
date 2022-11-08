package basedomain.output;

import basedomain.message.Message;

public interface Output {
    void print(Message message);
    void println(String string);
}
