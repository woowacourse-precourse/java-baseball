package baseball;


public class Restart {
    private int restart;

    public Restart(int restart){
        validateRange(restart);

        this.restart = restart;
    }
    private void validateRange(int restart){
        if(restart != 1 && restart != 2)
            throw new IllegalArgumentException("Wrong number range");
    }

    public boolean isRestart(){
        if (restart == 1)
            return true;
        return false;
    }
}
