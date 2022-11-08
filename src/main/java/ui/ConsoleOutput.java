package ui;

import domain.GameResultConverter;
import java.util.List;

public class ConsoleOutput implements Output{

    @Override
    public void printOut(String message) {
        System.out.print(message);
    }

    @Override
    public void printOutAfterConversion(List<Integer> judgement) {
        GameResultConverter converter = new GameResultConverter();
        String buffer = converter.convertGameResult(judgement);
        printOut(buffer+"\n");
    }
}
