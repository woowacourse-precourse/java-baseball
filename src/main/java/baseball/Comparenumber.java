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

}
