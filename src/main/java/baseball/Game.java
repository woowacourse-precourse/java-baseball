package baseball;

public class Game {
    private Player problemMaker = new ProblemMaker();
    private Player problemSolver = new ProblemSolver();
    private Result result = new Result();
    private int status = Settings.START_STATUS;

    public void start(){
        while(isStartStatus()){
            problemMaker.setNumbers(Settings.SIZE_OF_NUMBERS);
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

    }

    public void checkAnswer(){

    }

    public void countResult(){

    }

    public void setStatusByProblemSolver(){

    }

    public Player getProblemMaker() {
        return problemMaker;
    }

    public void setProblemMaker(Player problemMaker) {
        this.problemMaker = problemMaker;
    }

    public Player getProblemSolver() {
        return problemSolver;
    }

    public void setProblemSolver(Player problemSolver) {
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
