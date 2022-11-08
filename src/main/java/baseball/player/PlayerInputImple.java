package baseball.player;

import java.util.List;

public class PlayerInputImple implements PlayerInput {

    private List<Integer> numbers;
    private PlayerInputValidator playerInputValidator;

    public PlayerInputImple(List<Integer> numbers, PlayerInputValidator playerInputValidator) {
        this.numbers = numbers;
        this.playerInputValidator = playerInputValidator;
    }

    @Override
    public void setNumbers(String input) {
        playerInputValidator.validatePlayerInput(input);
        save(input);
    }

    private List<Integer> save(String input) {
        numbers.clear(); //반드시 이전 기록을 비워내야한다

        for (String element : input.split("")) {
            numbers.add(Integer.parseInt(element));
        }

        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


}
