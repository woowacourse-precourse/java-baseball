package baseball;
import camp.nextstep.edu.missionutils.*;
import java.util.*;




public class Application {
    public static void main(String[] args) {
        int check = 1; // while 문에 사용할 변수
        ArrayList<Integer> computer = new ArrayList<>();
        String user ="";
        randomComputer(computer);

        while(check==1) {
//            System.out.println(computer);
            System.out.print("숫자를 입력해주세요 : ");

            user = Console.readLine();

            // 3글자 이상의 string이 입력 될 시 에러가 나오도록 한다.
            if(user.length()!=3){
                throw new IllegalArgumentException();
            }
            printResult( calculateBall(computer,user), calculateStrike(computer,user));

            if(calculateStrike(computer,user)==3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                check = Integer.parseInt(Console.readLine());

                computer.clear();
                randomComputer(computer);
            }
        }
        System.out.println("게임종료");
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
