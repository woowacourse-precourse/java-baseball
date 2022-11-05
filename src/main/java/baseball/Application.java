package baseball;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        NumberGenerator numberGenerator = new NumberGenerator();

        boolean playAgain = true;

        while (playAgain) {
            user.inputNumber();
            System.out.println(user.getNumber());

            numberGenerator.generateNumber();
            System.out.println(numberGenerator.getNumbers());

            playAgain = user.inputFlag();
        }
    }

}
