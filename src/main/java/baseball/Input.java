package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private List<Integer> inputs;

    public Input() {
        this.inputs = new ArrayList<>();
    }

    public void makeInputs() throws IllegalArgumentException {

            String input = readLine();
            for (int i = 0; i < input.length(); i++) {
                this.inputs.add(Integer.parseInt(input.substring(i,i+1)));
            }
            if (inputs.size() != 3) {
                throw new IllegalArgumentException("3자리의 숫자를 입력해주세요.");
            }
            if (inputs.get(0).equals(inputs.get(1)) || inputs.get(0).equals(inputs.get(2)) || inputs.get(1).equals(inputs.get(2))) {
                throw new IllegalArgumentException("중복된 숫자를 입력할 수 없습니다.");
            }
        }



    public List<Integer> getInputs() {

        return inputs;
    }

    public void resetInputs() {
        this.inputs.clear();
    }

}
