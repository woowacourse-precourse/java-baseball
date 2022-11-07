package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    //랜덤으로 컴퓨터의 숫자 정하기
    public static List<Integer> setComputer(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    //int형으로 입려받는 userInput을 List형으로 변환
    public static List<Integer> convertUserInputToList (int userinput){
        List<Integer> returnData = new ArrayList<Integer>();
        if(userinput >= 1000){
            return List.of(-1);
        }
        returnData.add(userinput/100);
        returnData.add(userinput/10 - returnData.get(0)*10);
        returnData.add(userinput % 10);
        return returnData;
    }
    //userInput를 몇스트라이크 몇볼인지 검사해줌
    public static int[] inspectUserInput(List<Integer> userInput , List<Integer> computer){
        int[] returnData = new int[2];

        for(int i = 0; i < userInput.size(); i++){
            if(computer.indexOf(userInput.get(i)) == -1){
                System.out.println(i+"1번");
                continue;
            }
            else if(computer.indexOf(userInput.get(i)) >= 0 && computer.indexOf(userInput.get(i)) == i ){
                System.out.println(i+"2번");
                returnData[0] += 1;
            }
            else if(computer.indexOf(userInput.get(i)) >= 0){
                System.out.println(i+"3번");
                returnData[1] += 1;
            }
        }
        return returnData;
    }
    public static void main(String[] args) {

    }
}
