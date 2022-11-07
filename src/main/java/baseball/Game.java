package baseball;

import java.util.List;

public class Game {
    private ProblemMaker problemMaker = new ProblemMaker();
    private ProblemSolver problemSolver = new ProblemSolver();
    private Result result = new Result();
    private int status = Settings.START_STATUS;

    public void start(){
        while(isStartStatus()){
            problemMaker.makeProblem(Settings.SIZE_OF_NUMBERS);
            printMessage(Settings.START_MESSAGE);
            while(result.isWrongAnswer()){
                requestAnswer();
                checkAnswer();
            }
            printMessage(Settings.SUCCESS_MESSAGE);
            setStatusByProblemSolver();
        }

    }

    public void printMessage(String message){
        System.out.println(message);
    }

    public boolean isStartStatus(){
        return status == Settings.START_STATUS;
    }

    public void requestAnswer(){
        printMessage(Settings.ANSWER_REQUEST_MESSAGE);
        problemSolver.solveProblem(Settings.SIZE_OF_NUMBERS);
    }

    public void checkAnswer(){
        countResult();
        printMessage(result.createResultMessage());
    }

    public void countResult(){
        List<Integer> numbers = problemSolver.getNumbers();
        for(int i = 0;i<Settings.SIZE_OF_NUMBERS;i++){
            int number = numbers.get(i);
            boolean doesAnswerHasNumber = problemMaker.hasNumber(number);
            boolean isNumberAndAnswerSameAtGivenLocation = problemMaker.isSameAtGivenLocation(number, i);

            if(doesAnswerHasNumber && isNumberAndAnswerSameAtGivenLocation){
                result.increaseStrikeCount();
            }else if(doesAnswerHasNumber){
                result.increaseBallCount();
            }
        }

    }

    public void setStatusByProblemSolver(){

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
