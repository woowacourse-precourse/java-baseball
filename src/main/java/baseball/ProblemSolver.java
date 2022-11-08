package baseball;

import camp.nextstep.edu.missionutils.Console;

public class ProblemSolver extends Player {
    public void solveProblem(int sizeOfNumbers) {
        String answer = Console.readLine();

        checkValidAnswerInput(answer, sizeOfNumbers);

        initialize();

        for (int i = 0; i < sizeOfNumbers; i++) {
            int number = Character.getNumericValue(answer.charAt(i));
            addNumber(number);
        }
    }

    private void checkValidAnswerInput(String answer, int sizeOfNumbers) throws IllegalArgumentException {
        if (!answer.matches("^[1-9]{3}$")) {
            // 1~9 사이의 수로 이루어진 3자리 수가 아닌 경우
            throw new IllegalArgumentException();
        } else if (answer.chars().distinct().count() != sizeOfNumbers) {
            // 각 자리수가 서로 다른 수가 아닌 경우
            throw new IllegalArgumentException();
        }
    }

    public String chooseToRestart() {
        String choice = Console.readLine();

        checkValidRestartChoiceInput(choice);

        return choice;
    }

    private void checkValidRestartChoiceInput(String choice) throws IllegalArgumentException {
        if (!choice.matches("^[1-2]$")) {
            // 1 또는 2가 아닌 경우
            throw new IllegalArgumentException();
        }
    }
}
