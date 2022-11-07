package baseball.domain.model.request;

import java.util.List;

public class UserInputRequest {
    private final List<Character> numbersRequest;

    public UserInputRequest(List<Character> numbersRequest) {
        this.numbersRequest = numbersRequest;
    }

    public List<Character> getNumbersRequest() {
        return numbersRequest;
    }
}
