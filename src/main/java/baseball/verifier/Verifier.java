package baseball.verifier;

import baseball.verifiable.VerifiableRule;

import java.util.ArrayList;
import java.util.List;

public class Verifier {
    List<VerifiableRule> rules = new ArrayList<>();

    public void addRule(VerifiableRule rule) {
        rules.add(rule);
    }

    public boolean validates(String input) {
        return rules.stream()
                .allMatch(rule -> rule.validates(input));
    }
}
