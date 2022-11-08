package baseball.verifier;

import baseball.verifiable.VerifiableInputRule;

import java.util.ArrayList;
import java.util.List;

public class Verifier {
    List<VerifiableInputRule> rules = new ArrayList<>();

    public void addRule(VerifiableInputRule rule) {
        rules.add(rule);
    }

    public boolean validates(String input) {
        return rules.stream()
                .allMatch(rule -> rule.validates(input));
    }
}
