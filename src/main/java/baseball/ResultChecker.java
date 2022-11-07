package baseball;

public class ResultChecker {

    private static final String MESSAGE_END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";


    public boolean checkRightAnswer(String hint){
        if(hint.equals("3스트라이크")){
            System.out.println(MESSAGE_END_GAME);
            return true;
        }
        return false;
    }
}
