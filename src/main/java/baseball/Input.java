package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class Input {

    private final List<Integer> inputs;

    public Input(List<Integer> inputs) {
        this.inputs = inputs;
    }

    public void makeInputs() {
        try {
            String input = readLine();
            for (int i = 0; i < input.length(); i++) {
                this.inputs.add(Integer.parseInt(input.substring(i, i + 1)));
            }
            if (!isCorrectInput(this.inputs)) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            System.out.println("올바른 값을 입력해주세요.");
        }
    }

    public boolean isCorrectInput(List<Integer> inputs) {
        try {
            if (inputs.size() != 3) {
                throw new IllegalArgumentException();
            }

        } catch (IllegalArgumentException e) {
            System.out.println("3자리의 숫자를 입력해주세요.");
            return false;
        }
        try {
            if (inputs.get(0).equals(inputs.get(1)) || inputs.get(0).equals(inputs.get(2)) || inputs.get(1)
                    .equals(inputs.get(2))) {
                throw new IllegalArgumentException();
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("서로 다른 숫자를 입력해주세요.");
            return false;
        }
    }
}
