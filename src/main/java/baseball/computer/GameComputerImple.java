package baseball.computer;

import java.util.ArrayList;
import java.util.List;

public class GameComputerImple implements GameComputer {

    private List<Integer> numbers = new ArrayList<>();
    private ComputerNumbersGenerator computerNumbersGenerator;
    private ComputerHintGenerator computerHintGenerator;
    private ComputerGameEndChecker computerGameEndChecker;

    public GameComputerImple(ComputerNumbersGenerator computerNumberAutoGenerator,
                             ComputerHintGenerator computerHintGenerator,
                             ComputerGameEndChecker computerGameEndChecker) {
        this.computerNumbersGenerator = computerNumberAutoGenerator;
        this.computerHintGenerator = computerHintGenerator;
        this.computerGameEndChecker = computerGameEndChecker;
    }

    @Override
    public void autoSetNumbers() {
        this.numbers = computerNumbersGenerator.autoCreateNumbers();
    }

    @Override
    public String printHintForInput(List<Integer> input) {
        return computerHintGenerator.generateHintForInput(input, this.numbers);
    }

    @Override
    public boolean isNotGameEndCase(List<Integer> input) {
        return computerGameEndChecker.isNotGameEnd(input, this.numbers);
    }

    @Override
    public boolean isNumberGenerated(int size){
        if(numbers.size()==size) {
            return true;
        }
        return false;
    }


}
