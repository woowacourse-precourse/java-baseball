package baseball;

import baseball.verifiable.VerifiableRule;

import java.util.ArrayList;
import java.util.List;

public class Verifier {
    private final List<VerifiableRule> rules = new ArrayList<>();

    public void addRule(VerifiableRule rule) {
        rules.add(rule);
    }

    public boolean validates(int input) {
        return rules.stream()
                .allMatch(rule -> rule.validates(input));
    }
}
