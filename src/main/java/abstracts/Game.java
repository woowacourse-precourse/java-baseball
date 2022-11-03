package abstracts;

public abstract class Game {

    public enum Status {
        PLAYING, DONE
    }
    private Status status;

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    abstract void initialize();
    abstract void terminate();

}
