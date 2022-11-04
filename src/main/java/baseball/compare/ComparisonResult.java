package baseball.compare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ComparisonResult {

    private final List<ComparisonResultType> results;

    public ComparisonResult() {
        this.results = new ArrayList<>();
    }

    public void add(ComparisonResultType type) {
        results.add(type);
    }

    public HashMap<ComparisonResultType, Integer> getFrequency() {
        HashMap<ComparisonResultType, Integer> result = new HashMap<>();

        this.results.forEach((type) -> {
            if (result.containsKey(type)) {
                result.put(type, result.get(type) + 1);
            } else {
                result.put(type, 1);
            }
        });

        return result;
    }
}
