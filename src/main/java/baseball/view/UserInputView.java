package baseball.view;

import baseball.domain.model.request.UserInputRequest;
import baseball.view.utils.OutputUtils;
import baseball.view.utils.UserInputUtils;
import java.util.List;
import java.util.stream.Collectors;

public class UserInputView {

    public UserInputRequest generateUserInputRequest() {
        String numberInput = requestNumber();
        List<Character> numberRequest = numberInput.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.toList());

        return new UserInputRequest(numberRequest);
    }

    public void openingText() {
        OutputUtils.outputLine("숫자 야구 게임을 시작합니다.");
    }

    private String requestNumber() {
        OutputUtils.output("숫자를 입력해주세요 : ");
        return UserInputUtils.readLine();
    }

}
