package baseball.domain;

public class Game {
    private Computer computer;
    private User user;
    private InputValidation inputValidation = new InputValidation();

    public Game(Computer computer, User user) {
        this.computer = computer;
        this.user = user;
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public boolean validateComputerNumber(String computerNumber){
        return inputValidation.checkAllValidation(computerNumber);
    }

}
