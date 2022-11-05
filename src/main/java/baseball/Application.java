package baseball;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        NumberGenerator numberGenerator = new NumberGenerator();
        Judge judge = new Judge();

        boolean playAgain = true;

        while (playAgain) {
            user.inputNumber();
            numberGenerator.generateNumber();
            playAgain = user.inputFlag();
        }


    }

}
