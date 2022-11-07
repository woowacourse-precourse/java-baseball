package baseball;

public class BaseBall implements Game{
    String answer="";
    @Override
    public void start() {
        Random random = new Random();
        answer=random.pick();
    }

    @Override
    public void play() {
        Input input =new Input();
        input.playInput();
    }

    @Override
    public void end() {
        Input input =new Input();
        input.endInput();
    }

    @Override
    public void score() {

    }
}
