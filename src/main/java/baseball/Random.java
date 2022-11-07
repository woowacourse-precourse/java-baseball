package baseball;
import camp.nextstep.edu.missionutils.Randoms;

public class Random {
    private int range;
    private int min,max;
    public Random(int min, int max,int range){
        this.min=min;
        this.max=max;
        this.range=range;
    }
    public String pick(){
        String randomString= "";
        int randomNum;
        while (randomString.length() != range){
            randomNum=Randoms.pickNumberInRange(min, max);
            if(!contains(randomString,randomNum)){
                randomString=randomString+randomNum;
            }
        }
        return  randomString;
    }
    private Boolean contains(String randomString,int randomNum){return randomString.contains(Integer.toString(randomNum));}

}
