package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
/*
 * 임의의 세자리 수를 생성하는 클래스.
 * ""를 통해 정답 체크.
 */
public class Computer {
    
    private String answer = "";
    private int INPUT_LENGTH = 3;
    private List<Integer> list = new ArrayList<Integer>();
    public void createNumber()
    {
        while(list.size() <INPUT_LENGTH)
        {
            int temp = Randoms.pickNumberInRange(1,9);
            if(!list.contains(temp))
            {
                list.add(temp);
            }
        }
        for(Integer list_ : list)
        {
            answer += Integer.toString(list_);
        }
    }

    public String getAnswer()
    {
        return this.answer;
    }
}
