package baseball;



import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        start();



    }
    static void start() {
        List<Integer> computernumber = randomnum();

        equalnumber(computernumber);

        restart();
    }
    static List<Integer> randomnum() {
        List<Integer> computer= new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    static void equalnumber(List<Integer> computer) {
        List<Integer> usernum = new ArrayList<>();
        int[] result= new int[2];
            userinput(usernum);
            for (int i = 0; i < computer.size(); i++) {
                if(computer.contains(usernum.get(i))&&computer.get(i)==usernum.get(i)) {
                    result[1] += 1;
                }
                else if(computer.contains(usernum.get(i))&&computer.get(i)!=usernum.get(i)) {
                    result[0] += 1;
                }
            }
            equaltotalnum(result,computer);
    }
    static void equaltotalnum(int[] result,List<Integer> computer) {
        if(result[0]==0&&result[1]==0){
            System.out.println("낫싱");
        }
        else if(result[0]!=0&&result[1]==0){
            System.out.println(result[0]+"볼");
        }
        else if(result[0]==0&&result[1]!=0){
            System.out.println(result[1]+"스트라이크");
            if(result[1]==3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다!");
                return;
            }
        }
        else if(result[0]!=0&&result[1]!=0){
            System.out.println(result[0]+"볼 "+result[1]+"스트라이크");
        }
        equalnumber(computer);
    }
    static void userinput(List<Integer> usernum) {
        System.out.println("숫자를 입력해주세요 : ");
        String[] temp = Console.readLine().split("");
        for(int i=0;i<temp.length;i++) {
            usernum.add(Integer.parseInt(temp[i]));
        }
        exceptiontest(usernum);
    }
    static void restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int onoff = Integer.parseInt(Console.readLine());
        if(onoff== 1){
            start();
        }
        else if(onoff== 2) {
            System.out.println("게임 종료");
        }
    }

    static void exceptiontest(List<Integer> num) {
        if(num.size()!=3) {
            throw new IllegalArgumentException();
        }

    }


}
