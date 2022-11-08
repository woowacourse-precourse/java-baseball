package baseball;

public class Application {
    public static void main(String[] args) {
        Baseball baseball = new Baseball();
        baseball.start();

        while(baseball.run) {
            User user = new User();
            Computer computer = new Computer();
            computer.setRandom();

            user.request();
            baseball.generateEx(user.response);

            Inspector inspector = new Inspector();

            while (!user.result) {
                baseball.generateEx(user.response);
                inspector.check(computer.correct_answer, user.response);
                System.out.println(inspector.result);
                user.pass(inspector.result);
            }

            baseball.end();
        }

    }
}
