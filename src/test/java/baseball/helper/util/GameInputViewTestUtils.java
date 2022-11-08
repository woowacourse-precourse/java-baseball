package baseball.helper.util;

import baseball.helper.exception.CannotReflectionException;
import baseball.mvc.view.GameInputView;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.function.Consumer;

public final class GameInputViewTestUtils {

    private static final String MESSAGE_FIELD_NAME = "message";

    private GameInputViewTestUtils() {
    }

    public static String getMessage(GameInputView view, Consumer<String> printLog, ByteArrayOutputStream out) {
        out.reset();

        Field message = ReflectionFieldUtils.processReflectionField(GameInputView.class, MESSAGE_FIELD_NAME);

        try {
            printLog.accept((String) message.get(view));
            return out.toString();
        } catch (Exception e) {
            throw new CannotReflectionException(e);
        }
    }
}
