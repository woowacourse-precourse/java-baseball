package abstracts;

public abstract class Game {

    public enum Status {
        PLAYING, DONE
    }
    private Status status;
    private String gameName;


    public Status getStatus() {
        return this.status;
    }
    public String getGameName() {
        return this.gameName;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    abstract void initialize();
    abstract void terminate();

}
