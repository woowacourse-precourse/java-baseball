package baseball;

public class Application {
    static User user = new User();
    static NumberGenerator numberGenerator = new NumberGenerator();
    static Judge judge = new Judge();
    public static void main(String[] args) {
        boolean playAgain = true;

        while (playAgain) {
            user.inputNumber();
            numberGenerator.generateNumber();
            String answer = judge.judgement(numberGenerator.getNumbers(), user.getNumbers());

            while(!(judge.getStrike() == 3)) {
                System.out.println(answer);
                user.inputNumber();
                answer = judge.judgement(numberGenerator.getNumbers(), user.getNumbers());
            }
            System.out.println(answer);
            playAgain = user.inputFlag();
        }
    }
}
