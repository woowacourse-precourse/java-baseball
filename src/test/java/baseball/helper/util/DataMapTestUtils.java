package baseball.helper.util;

import baseball.helper.exception.CannotReflectionException;
import baseball.mvc.model.DataMap;
import java.lang.reflect.Field;
import java.util.Map;

public final class DataMapTestUtils {

    private static final String DATA_MAP_FIELD_NAME = "dataMap";

    private DataMapTestUtils() {
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> getModelDataMap(DataMap model) {
        Field dataMap = ReflectionFieldUtils.processReflectionField(DataMap.class, DATA_MAP_FIELD_NAME);

        try {
            dataMap.setAccessible(true);
            return (Map<String, Object>) dataMap.get(model);
        } catch (Exception e) {
            throw new CannotReflectionException(e);
        }
    }
}
