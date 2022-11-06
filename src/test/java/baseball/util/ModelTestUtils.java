package baseball.util;

import baseball.domain.number.GameNumber;
import baseball.mvc.structure.Model;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class ModelTestUtils {

    private static final String DATA_MAP_FIELD_NAME = "dataMap";
    private static final int FIELD_INDEX = 0;

    private ModelTestUtils() {
    }

    public static Map<String, Object> getModelDataMap(Model model) {
        List<Field> fields = Arrays
            .stream(model.getClass().getDeclaredFields())
            .filter(field -> field.getName().equals(DATA_MAP_FIELD_NAME))
            .collect(Collectors.toList());

        Field dataMap = fields.get(FIELD_INDEX);

        try {
            dataMap.setAccessible(true);
            return (Map<String, Object>) dataMap.get(model);
        } catch (Exception e) {
            return Collections.emptyMap();
        }
    }
}
