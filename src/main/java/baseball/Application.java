package baseball;


public class Application {
    public static void main(String[] args) {
        do {
            Computer opponent = new Computer();
            do {
                opponent.checkAnswer(User.userInput());
            } while (!opponent.isCorrect);
        } while (User.restart());
    }
}
