package abstracts;

public abstract class Game {

    public enum Status {
        PLAYING, DONE
    }
    protected Status status;
    protected String gameName;


    public Status getStatus() {
        return this.status;
    }
    public String getGameName() {
        return this.gameName;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    protected abstract void initialize();
    protected abstract void terminate();
    public abstract boolean operate(String input);

}
