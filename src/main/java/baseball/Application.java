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
            System.out.println("answer : " + numberGenerator.getNumbers());
            String answer = judge.judgement(numberGenerator.getNumbers(), user.getNumbers());

            while(!(judge.getStrike() == 3)) {
                System.out.println(answer);
                user.inputNumber();
                judge.truncateMembers();
                answer = judge.judgement(numberGenerator.getNumbers(), user.getNumbers());
            }

            judge.truncateMembers();
            playAgain = user.inputFlag();
        }
    }
}
