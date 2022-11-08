package baseball;

import java.util.List;

public class Game {
    private ProblemMaker problemMaker = new ProblemMaker();
    private ProblemSolver problemSolver = new ProblemSolver();
    private Result result = new Result();
    private String status = Settings.START_STATUS;

    public void start() {
        printStartMessage();

        while (isStartStatus()) {
            initialize();
            solveProblem();
            requestToRestart();
        }
    }

    private void printStartMessage() {
        System.out.println(Settings.START_MESSAGE);
    }

    private boolean isStartStatus() {
        return status.equals(Settings.START_STATUS);
    }

    private void initialize() {
        result.initialize();
        problemMaker.makeProblem(Settings.SIZE_OF_NUMBERS);
    }

    private void solveProblem() {
        while (result.isWrongAnswer()) {
            checkAnswer();
        }

        System.out.println(Settings.SUCCESS_MESSAGE);
    }

    private void checkAnswer() {
        result.initialize();

        System.out.print(Settings.ANSWER_REQUEST_MESSAGE);
        problemSolver.solveProblem(Settings.SIZE_OF_NUMBERS);

        countResult();
        System.out.println(result.createResultMessage());
    }

    private void countResult() {
        List<Integer> numbers = problemSolver.getNumbers();

        for (int i = 0; i < Settings.SIZE_OF_NUMBERS; i++) {
            int number = numbers.get(i);

            if (problemMaker.isSameAtGivenLocation(number, i)) {
                result.increaseStrikeCount();
            } else if (problemMaker.hasNumber(number)) {
                result.increaseBallCount();
            }
        }

    }

    private void requestToRestart() {
        System.out.println(Settings.RESTART_REQUEST_MESSAGE);
        status = problemSolver.chooseToRestart();
    }

    public Player getProblemMaker() {
        return problemMaker;
    }

    public void setProblemMaker(ProblemMaker problemMaker) {
        this.problemMaker = problemMaker;
    }

    public Player getProblemSolver() {
        return problemSolver;
    }

    public void setProblemSolver(ProblemSolver problemSolver) {
        this.problemSolver = problemSolver;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
