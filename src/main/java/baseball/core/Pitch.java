package baseball.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.util.Random.generateIntegers;

public class Pitch {
    private List<Integer> pitches;

    public Pitch() {
        this.pitches = List.of(1, 2, 3);
    }

    public Pitch random() {
        this.pitches = generateIntegers(3);
        return this;
    }

    public Pitch update(String s) {
        validateInputString(s);
        this.pitches = Arrays.asList(s.split(""))
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return this;
    }

    private void validateInputString(String s) {
        if (s.length() != 3 | containsDuplicateCharacters(s) | !s.matches("[1-9]+")) {
            throw new IllegalArgumentException();
        }
    }

    private boolean containsDuplicateCharacters(String s) {
        List<Character> existingChars = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (existingChars.contains(s.charAt(i))) {
                return true;
            } else {
                existingChars.add(s.charAt(i));
            }
        }
        return false;
    }

}
