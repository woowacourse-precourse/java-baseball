package baseball;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        Baseball baseball = new Baseball();
        baseball.start();

        while(user.oneMore) {
            user = new User();
            Computer computer = new Computer();
            computer.setRandom();

            user.request();

            Inspector inspector = new Inspector();

            while (!user.result) {
                inspector.check(computer.correct_answer, user.response);
                System.out.println(inspector.result);
                user.pass(inspector.result);
            }

            baseball.end();
            user.one_more_time(baseball.user_answer);
        }

    }
}
