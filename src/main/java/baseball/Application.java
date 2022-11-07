package baseball;

public class Application {

    public static void main(String[] args) {
        Configure configure = new Configure();
        BaseballGame.execute(configure.generator(), configure.validator(), configure.checker());
    }

}
