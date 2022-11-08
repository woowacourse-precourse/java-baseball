package baseball.gametype;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public enum BaseballType {
    THREE_DIGITS(3),
    FOUR_DIGITS(4),
    Five_DIGITS(5);

    BaseballType(int numberOfDigit){
        this.numberOfDigit = numberOfDigit;
    }

    private int numberOfDigit;

    public int getNumberOfDigit() {
        return numberOfDigit;
    }

    public boolean isFormatCorrect(int candidate) {
        return isNumberOfDigitsMatched(candidate) &&
                isNotContain0(candidate) &&
                isNotOverlapped(candidate);
    }

    private boolean isNumberOfDigitsMatched(int candidate) {
        return numberOfDigit == String.valueOf(candidate).length();
    }

    private boolean isNotContain0(int candidate) {
        String stringCandidate = String.valueOf(candidate);
        return stringCandidate.chars()
                .mapToObj(unicode -> (char) unicode != '0')
                .reduce(true, ((aBoolean, aBoolean2) -> aBoolean && aBoolean2));
    }

    private boolean isNotOverlapped(int candidate) {
        String stringCandidate = String.valueOf(candidate);
        List<Character> list = stringCandidate.chars()
                .mapToObj(e->(char)e).collect(Collectors.toList());
        Set<Character> set = stringCandidate.chars()
                .mapToObj(e->(char)e).collect(Collectors.toSet());

        return list.size() == set.size();
    }
}
