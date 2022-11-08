package baseball;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        Answer answer = new Answer();

        Game.start();
        answer.create();
        while (Game.isRepeat) {
            if (Game.isRestart) {
                answer.create();
            }
            System.out.println(answer.get());
            user.create();
            System.out.println(user.get());
            if (Comparison.isAnswered(user.get(), answer.get())) {
                Game.printCongratsMessage();
                user.createRepeatInput();
            }
        }
    }
}
