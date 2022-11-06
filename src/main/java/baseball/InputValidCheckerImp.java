package baseball;

import static constant.Rules.END_INCLUSIVE;
import static constant.Rules.NUMBER_LENGTH;
import static constant.Rules.START_INCLUSIVE;

import java.util.List;

public class InputValidCheckerImp implements InputValidChecker {

    @Override
    public boolean checkValid(List<Integer> user) {
        return checkLength(user) && checkRange(user) && checkDistinct(user);
    }

    private boolean checkLength(List<Integer> user) {
        return user.size() == NUMBER_LENGTH;
    }

    private boolean checkRange(List<Integer> user) {
        return user.stream().allMatch(digit -> digit >= START_INCLUSIVE && digit <= END_INCLUSIVE);
    }

    private boolean checkDistinct(List<Integer> user) {
        return user.stream().distinct().count() == NUMBER_LENGTH;
    }
}
