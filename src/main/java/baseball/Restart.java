package baseball;

public class Restart {
    private static final String NOT_ALLOWED_IS_END_NUMBER="1(시작) 2(종료) 중 숫자를 고르세요";
    private static final String RESTART="1";
    private static final String END="2";

    public boolean isEndGame(String restartByInput){
        if(restartByInput.equals(RESTART)){
            return true;
        }
        if(restartByInput.equals(END)){
            return false;
        }
        throw new IllegalArgumentException(NOT_ALLOWED_IS_END_NUMBER);
    }
}
