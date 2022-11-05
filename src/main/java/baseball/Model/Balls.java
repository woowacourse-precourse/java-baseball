package baseball.Model;

public class Balls {
    private int [] balls;

    public Balls(){
        this.balls = new int[3];
    }

    public void setValue(int index, int value){
        balls[index] = value;
    }

    public int getValue(int index){
        return balls[index];
    }
}
