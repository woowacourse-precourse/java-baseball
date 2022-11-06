package baseball.mvc.structure;

import java.util.HashMap;
import java.util.Map;

public class Model {

    private final Map<String, Object> dataMap;

    public Model() {
        this.dataMap = new HashMap<>();
    }

    public <T> T getAttribute(String key, Class<T> type) {
        return type.cast(dataMap.get(key));
    }

    public void addAttribute(String key, Object data) {
        dataMap.put(key, data);
    }
}
