package abstracts;

public abstract class Game {

    public enum Status {
        PLAYING, DONE
    }
    private Status status;

    public Status getStatus() {
        return this.status;
    }

    abstract void initialize();
    abstract void terminate();

}
