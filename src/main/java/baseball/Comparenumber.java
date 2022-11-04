package baseball;
import java.util.ArrayList;
import java.util.List;

public class Comparenumber {
    List<Integer> randomList;
    List<Integer> inputList;
    boolean iscontinue;
    Comparenumber(){}
    Comparenumber(List<Integer> randomList, List<Integer> inputList){
        this.randomList=randomList;
        this.inputList=inputList;
        iscontinue=true;
    }
    public int ballscore(int index){
        if(randomList.contains(inputList.get(index))){return 1;}
        return 0;
    }
    public int strickscore(int index){
        if(randomList.get(index).equals(inputList.get(index))) return 1;
        else return 0;

    }
    public int[] compareNumber(){
        int[] compareresult = new int[2];
        for (int indexNumber =0; indexNumber<3; indexNumber++) {
            int sum = ballscore(indexNumber)+strickscore(indexNumber);
            if(sum==2) compareresult[0]++; //strick
            if(sum==1) compareresult[1]++; //ball
        }
        return compareresult;
    }


}
