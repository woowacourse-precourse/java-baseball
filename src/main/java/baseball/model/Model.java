package baseball.model;

public class Model {
    public boolean findException(String input){
        boolean check = false;
        if (input.length()==3){
            check = !checkInput(input);
        }
        return check;
    }

    private static boolean checkInput(String input) {
        boolean check = false;
        for (int i = 0 ; i < 3 ; i++){
            if (input.charAt(i) < '1' || input.charAt(i) > '9') {
                check = true;
                break;
            }
        }
        return check;
    }
    public int findBall(int score,int input){
        int count = 0;
        if (score / 100 == input / 10 % 10 || score / 100 == input % 10) count++;
        if (score / 10 % 10 == input / 100 || score / 10 % 10 == input % 10) count ++;
        if (score % 10 == input / 100 || score % 10 == input / 10 % 10) count++;
        return count;
    }
    public int findStrike(int score,int input){
        int count = 0;
        if (score / 100 == input / 100) count++;
        if (score / 10 % 10 == input / 10 %10) count++;
        if (score % 10 == input % 10) count++;
        return count;
    }
}
