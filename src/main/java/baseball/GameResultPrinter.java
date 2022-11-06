package baseball;

import java.util.List;

public class GameResultPrinter {
    private GameResultConverter converter;
    public GameResultPrinter() {
        converter = new GameResultConverter();
    }
    public void printer(List<Integer> result) {
        String buffer = converter.convertGameResult(result);
        System.out.println(buffer);
    }
}
