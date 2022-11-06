package baseball.validator;

public class Referee implements Validator{
    @Override
    public boolean checkAnswer() {
        return false;
    }

    @Override
    public boolean validateAnswer() {
        return false;
    }
}
