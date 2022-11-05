package baseball;

public class Game {
    HintMaker hintMaker;
    User user;
    public Game(HintMaker hintMaker,User user){
        this.hintMaker = hintMaker;
        this.user = user;
    }
    public void start(){
        String input="";
        String hint="";
        while(!hint.equals("30")){
            input = user.readNumber();
            hint = hintMaker.getHintby(input);
            HintMessage.print(hint);
        }
    }
}
