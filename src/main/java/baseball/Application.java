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
            System.out.println(answer);
            finallyData();

            if(judge.getStrike() == 3)
                playAgain = user.inputFlag();
        }
    }

    private static void finallyData() {
        user.truncateNumbers();
        numberGenerator.truncateNumbers();
        judge.truncateMembers();
    }
}
