package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class Application {
    List<Integer> computer = new ArrayList<>();
    String prediction = null;
    String[] splitprediction = prediction.split("");
    int[] intprediction = new int[splitprediction.length];
    int[] intarrcomputer = new int[computer.size()];



    int strike=0;


    public static void main(String[] args) {
        List<Integer> computer = new ArrayList<>();
//        while (computer.size() < 3) {
//            int randomNumber = Randoms.pickNumberInRange(1, 9);
//            if (!computer.contains(randomNumber)) {
//                computer.add(randomNumber);
//            }
//        }
//        int[] intcomputer = new int[computer.size()];
//        for(int j =0; j<computer.size(); j++){
//            intcomputer[j] = computer.get(j).intValue();
//        }

        System.out.println(computer);
        System.out.print("숫자를 입력해주세요: ");

        }

  public void makeRandomValue(){
      while (computer.size() < 3) {
          int randomNumber = Randoms.pickNumberInRange(1, 9);
          if (!computer.contains(randomNumber)) {
              computer.add(randomNumber);
          }
      }
  }
  public void compareRandomValue() {
      int[] intarrcomputer = new int[computer.size()];
      for (int b = 0; b < computer.size(); b++) {
          intarrcomputer[b] = computer.get(b).intValue();
      }
  }

    public void setPrediction(){
        String prediction = Console.readLine();
        String[] splitprediction = prediction.split("");
        int[] intprediction = new int[splitprediction.length];
        for (int i =0; i<splitprediction.length; i++){
            intprediction[i] = Integer.parseInt(splitprediction[i]);
        }
    }
    public void setStrike(){
        for(int a =0; a<intprediction.length; a++){
            intprediction[a] = intarrcomputer[a];
           strike +=1;
        }
    }

    public void setball(){

    }
}