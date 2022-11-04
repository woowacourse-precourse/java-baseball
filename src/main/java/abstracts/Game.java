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

    protected void setStatus(Status status) {
        this.status = status;
    }


    public abstract void initialize();
    public abstract void terminate();
    public abstract boolean operate(String input);

}
