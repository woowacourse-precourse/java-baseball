package baseball;


import camp.nextstep.edu.missionutils.Console;

public class ProblemSolver extends Player{
    public void solveProblem(int sizeOfProblem) throws IllegalArgumentException{
        String answer = Console.readLine();

        if(!answer.matches("^[1-9]{3}$")){
            throw new IllegalArgumentException();
        }else if(answer.chars().distinct().count() != Settings.SIZE_OF_NUMBERS){
            throw new IllegalArgumentException();
        }

        for(int i = 0;i<answer.length();i++){
            int number = Character.getNumericValue(answer.charAt(i));
            addNumber(number);
        }

    }

    public int chooseToRestart(){
        int answer = 0;
        return answer;
    }
}
