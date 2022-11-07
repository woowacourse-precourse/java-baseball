package baseball.service;

public class GameService {


    public void checkInputPlayerNumber(String inputPlayerNumbers){
        if (inputPlayerNumbers.length() != 3){
            throw new IllegalArgumentException();
        }
    }
}
