package baseball;


public class Application {
    public static void main(String[] args) {
        do {
            Computer opponent = new Computer();
            do {
                opponent.checkAnswer(User.userInput());
            } while (!opponent.isCorrect);
            System.out.println(Message.CORRECT_ANSWER);
            System.out.println(Message.RESTART);
        } while (User.restart());
    }
}
