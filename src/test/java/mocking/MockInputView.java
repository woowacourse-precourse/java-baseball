package mocking;

import baseball.view.InputView;

public class MockInputView extends InputView {
    private String message;

    @Override
    protected String readInput() {
        return message;
    }

    public void setMockMessage(String message) {
        this.message = message;
    }
}
