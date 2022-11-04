package baseball.view;

public class PlayerView {
    private static final String INPUT_REQUEST = "숫자를 입력해주세요 : ";
    String input;

    public PlayerView(){
        input = "";
    }

    public void requestInput(){
        System.out.print(INPUT_REQUEST);
    }

    public void readInput(){

    }

    public String getInput(){
        return "";
    }
}
