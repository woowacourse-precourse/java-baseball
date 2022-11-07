package baseball;

public class BaseBall implements Game{
    String answer;
    @Override
    public void start() {
        Random random = new Random();
        System.out.println(random.pick());
    }

    @Override
    public void play() {

    }

    @Override
    public void end() {

    }

    @Override
    public void score() {

    }
}
