package baseball.helper.util;

import baseball.helper.exception.CannotReflectionException;
import baseball.mvc.view.GameGuideView;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;

public final class GameGuideViewTestUtils {

    private static final String MESSAGE_FIELD_NAME = "message";

    private GameGuideViewTestUtils() {
    }

    public static String getMessage(GameGuideView view, ByteArrayOutputStream out) {
        out.reset();

        Field message = ReflectionFieldUtils.processReflectionField(GameGuideView.class, MESSAGE_FIELD_NAME);

        try {
            System.out.println((String) message.get(view));
            return out.toString();
        } catch (Exception e) {
            throw new CannotReflectionException(e);
        }
    }
}

