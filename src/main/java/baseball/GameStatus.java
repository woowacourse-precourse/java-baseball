package baseball;

public class GameStatus {

    private boolean status;

    public GameStatus(boolean status) {
        this.status = status;
    }


    public void change(String val){
        status = !val.equals("2");
    }

    public boolean isOn(){
        return status;
    }
}
