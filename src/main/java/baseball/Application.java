package baseball;

public class Application {
    public Computer computer;
    public User user;
    public boolean isGameFinished;

    public Application(Computer computer, User user) {
        this.computer = computer;
        this.user = user;
        this.isGameFinished = false;
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User();
        Application application = new Application(computer, user);
        application.computer.pickRandomNumber();
        application.printStartGame();
        while(!application.isGameFinished){
            application.user.getUserGuessInput();
            application.computer.calculateStrikeBall(application.user.getUserInputList());
            application.computer.giveHintToUser();
            application.checkGameFinished();
        }
    }

    public void printStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void checkGameFinished(){
//        if(computer.isThreeStrike()) isGameFinished = true;
    }
}
