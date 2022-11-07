package baseball.controller;

public class HandleException{
    public void UserInputNumberException(String userInput) {
        try {
            for (int i = 0; i < userInput.length(); i++) {
                if (userInput.charAt(i) < 48 || userInput.charAt(i) > 57) {
                    throw new IllegalArgumentException();
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 값을 입력하였습니다. 게임을 종료합니다.");
        }
    }
}
