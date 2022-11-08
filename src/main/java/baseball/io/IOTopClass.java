package baseball.io;

import java.util.List;

public class IOTopClass {

    private final Input input;
    private final Output output;

    public IOTopClass(int listSize) {
        this.input = new Input(listSize);
        this.output = new Output();
    }

    public List<Character> makeInputList() {
        return input.readAndMakeInputList();
    }

    public void printStrikeAndBalls(List<Integer> strikeBalls) {
        output.printStrikeBall(strikeBalls);
    }

    public void printGuide(String guide) {
        System.out.print(guide);
    }

    public Integer endOrReOneOrTwo() {
        return input.endOrReNum();
    }
}
