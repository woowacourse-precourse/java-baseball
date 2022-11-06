package baseball;

public class GameOverServiceImpl implements GameOverService {
    @Override
    public boolean retries() {
        final String userInput = Console.readLine();
        return ControlNumber.controlNumberOf(userInput)
                .retries();
    }
}
