package baseball;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        NumberGenerator numberGenerator = new NumberGenerator();

        user.inputNumber();
        System.out.println(user.getNumber());

        numberGenerator.generateNumber();
        System.out.println(numberGenerator.getNumbers());
    }
}
