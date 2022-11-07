package baseball;

public class BaseBall implements Game{
    private String answer="";
    private Input input;
    private Random random;
    private int range;
    public BaseBall(int mix,int max,int range){
        this.range=range;
        random =new Random(mix,max,range);
        input =new Input(range);
        play();
    }
    @Override
    public void start() {
        answer=random.pick();
    }

    @Override
    public void play() {
        input.playInput();
    }

    @Override
    public void end() {
        input.endInput();
    }

    @Override
    public void score() {

    }
}