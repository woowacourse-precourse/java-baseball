package baseball;
import java.util.List;

public class Compare {
    List<Integer> randomList;
    List<Integer> inputList;
    boolean iscontinue;
    Compare(){}
    Compare(List<Integer> randomList, List<Integer> inputList){
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
    public void compareprint(){
        int[] compareresult =compareNumber();
        if(compareresult[1]!=0)System.out.print(compareresult[0]+"볼 ");
        if(compareresult[0]!=0)System.out.print(compareresult[0]+"스트라이크");
        if(compareresult[0]==0 && compareresult[1]==0) System.out.print("낫싱");
        if(compareresult[0]==3) iscontinue=false;
    }
    public boolean isbaseballcontinue(){
        return iscontinue;
    }


}
