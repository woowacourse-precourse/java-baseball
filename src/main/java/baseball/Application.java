package baseball;
import camp.nextstep.edu.missionutils.*;
import java.util.*;




public class Application {
    public static void main(String[] args) {

    }

     static ArrayList<Integer> randomComputer(ArrayList<Integer> computer){
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        } return computer;
    }

    static void printResult(int ball, int strike ){
        StringBuilder sb = new StringBuilder();
        if(ball ==0 && strike == 0){
            sb.append("낫싱");
        }
        if(ball!=0){
            sb.append(ball).append("볼 ");
        }
        if(strike!=0){
            sb.append(strike).append("스트라이크");
        }
        System.out.println(sb.toString());
    }

    static int calculateStrike(ArrayList<Integer> computer, String user){
        ArrayList<Integer> intAnswer = convertStringToInt(user);
        int strike = 0;
        for(int i=0; i<computer.size();i++){
            if(computer.get(i) == intAnswer.get(i)){
                strike ++;
            }
        }
        return strike;
    }
    static int calculateBall(ArrayList<Integer> computer, String user){
        ArrayList<Integer> intAnswer = convertStringToInt(user);
        int ball = 0;
        for(int i=0; i<computer.size();i++){
            if(computer.contains(intAnswer.get(i)) && computer.get(i) != intAnswer.get(i)){
                ball ++;
            }
        }
        return ball;
    }
    static ArrayList<Integer> convertStringToInt(String user){
        ArrayList<Integer> intAnswer = new ArrayList<>();
        String[] splitNumber = user.split("");
        for ( String number : splitNumber ) {
            intAnswer.add(Integer.parseInt(number));
        }
        return intAnswer;
    }
}
