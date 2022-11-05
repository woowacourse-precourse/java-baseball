package baseball;

public class Game {
    HintMaker hintMaker;
    User user;
    public Game(){
        this.hintMaker = new HintMaker(new Opponent());
        this.user = new User();
    }
    public void start(){
        String input="";
        String hint="";
        while(!hint.equals("30")){
            input = user.readNumber();
            hint = hintMaker.getHintby(input);
            HintMessage.print(hint);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        return;
    }
    public String getEndInput(){
        return user.readEndInput();
    }
}
