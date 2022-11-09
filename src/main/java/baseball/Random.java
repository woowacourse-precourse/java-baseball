package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
public class Random {
    private int range,min,max;
    private Set<Integer> randomSet;
    public Random(int min, int max,int range){
        this.min=min;
        this.max=max;
        this.range=range;
        randomSet= new HashSet<Integer>();
    }
    public ArrayList<Integer> pick(){
        randomSet.clear();
        while (randomSet.size() != range){
            randomSet.add(Randoms.pickNumberInRange(min, max));
        }
        return new ArrayList<>(randomSet);
    }
}
