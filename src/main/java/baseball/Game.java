package baseball;

public class Game {
    Player problemMaker = new ProblemMaker();
    Player problemSolver = new ProblemSolver();
    Result result = new Result();
    int status = Settings.START_STATUS;

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

    }

    public boolean isStartStatus(){
        return false;
    }

    public void requestAnswer(){

    }

    public void checkAnswer(){

    }

    public void countResult(){

    }

    public void setStatusByProblemSolver(){

    }
}
