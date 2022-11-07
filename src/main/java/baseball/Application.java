package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
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
    public static List<String> convertComputerList(List<Integer> computer){
        List<String> returnData = new ArrayList<String>();
        returnData.add(String.valueOf(computer.get(0)));
        returnData.add(String.valueOf(computer.get(1)));
        returnData.add(String.valueOf(computer.get(2)));

        return returnData;
    }
    //String형으로 입려받는 userInput을 List형으로 변환함
    public static List<String> convertUserInputToList (String userinput){
        List<String> returnData = new ArrayList<String>();
        returnData.add(Character.toString(userinput.charAt(0)));
        returnData.add(Character.toString(userinput.charAt(1)));
        returnData.add(Character.toString(userinput.charAt(2)));
        return returnData;
    }
    //userInput를 몇스트라이크 몇볼인지 검사해줌
    public static int[] inspectUserInput(List<String> userInput , List<String> computer){
        int[] returnData = new int[2];

        for(int i = 0; i < userInput.size(); i++){
            if(computer.indexOf(userInput.get(i)) == -1){
                continue;
            }
            else if(computer.indexOf(userInput.get(i)) >= 0 && computer.indexOf(userInput.get(i)) == i ){
                returnData[1] += 1;
            }
            else if(computer.indexOf(userInput.get(i)) >= 0){
                returnData[0] += 1;
            }
        }
        return returnData;
    }
    public static void printHint(int[] hint){
        if(hint[0] == 0 && hint[1] == 0){
            System.out.println("낫싱");
        }
        else{
            if(hint[0] != 0){
                System.out.println(hint[0]+"볼 ");
            }
            else if(hint[1] != 0){
                System.out.println(hint[1]+"스트라이크");
            }
        }
    }
    public static void runGame(){
        List<Integer> computer = setComputer();
        List<String> computer_StringList = convertComputerList(computer);
        System.out.println(computer);
        boolean state = true;
        String userinput;
        while(state) {
            System.out.print("숫자를 입력해주세요 : ");
            userinput = Console.readLine();
            List<String> userInput_List = convertUserInputToList(userinput);
            int[] hint = inspectUserInput(userInput_List, computer_StringList);
            printHint(hint);
            if (hint[1] == 3) {
                break;
            }
        }
        endGame();
    }
    public static void endGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userinput = Console.readLine();
        if(userinput.equals("1")){
            runGame();
        }
        else if(userinput.equals("2")){

        }
    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        runGame();
//        List<String> a = List.of("1","2","3");
//        List<String> b = List.of("1","2","3");
//        System.out.println(a.indexOf(b.get(1)));


    }
}
