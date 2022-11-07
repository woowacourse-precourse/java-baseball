package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberFactory {

	public List<Integer> createRamdomNumbers(int startNumber, int endNumber, int size) {
    	validateRange(startNumber, endNumber);
    	validateCount(size);
    	
    	return createRandomNumberList(startNumber, endNumber, size);
    }
    
    
    private List<Integer> createRandomNumberList(int start, int end, int size){
    	Set<Integer> randomNumberSet = new HashSet<>(size);
    	List<Integer> randomNumberList = new ArrayList<>(size);
    	
    	while(true) {
    		int randomNumber = Randoms.pickNumberInRange(start, end);
    		if(!randomNumberSet.contains(randomNumber)) {
    			randomNumberList.add(randomNumber);
    			randomNumberSet.add(randomNumber);
    		}
    		
    		if(randomNumberList.size()==size) {
    			break;
    		}
    	}
    	return randomNumberList;
    }
    
    
    private void validateRange(final int start, final int end) {
        if (start > end) {
            throw new IllegalArgumentException("startInclusive cannot be greater than endInclusive.");
        }
        if (end == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("endInclusive cannot be greater than Integer.MAX_VALUE.");
        }
        if (end - start >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("the input range is too large.");
        }
    }
    
    
    private void validateCount(final int count) {
        if (count < 0) {
            throw new IllegalArgumentException("count cannot be less than zero.");
        }
    }
}
