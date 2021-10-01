
package main.util.financeutils;
import java.util.Arrays;

public class FinanceUtils {
	 
    public static int[] getEvenRedistribution (int[] amounts) {
        int[] ans = new int[amounts.length]; 
        try {
        	int tot = 0;
        	int position = 0;
        	while (position < amounts.length) {
        		if (amounts[position] <= 0) {
        			throw new IllegalArgumentException("amount cannot be zero or negative");
        		} else {
        			tot += amounts[position];
        		}
        		position++;
        	}
        	
            position = 0;
        	int howMany = amounts.length; 
        	while (howMany > 0) {
        		int times = tot / howMany;
        		ans[position] = times; 
        		tot -= times; 
        		position++;
        		howMany--;
        	}
        } catch (Exception e) {
        	   System.out.println(e.getMessage());
        }
        return ans;
        
    }
    
    public static int[] greedyChangemaker (int amount) {
        if (amount < 0) {
          throw new IllegalArgumentException("cannot be negative");
        }
        
        int position = 0;
        int[] ans = new int[4];
        int[] store = new int[5]; 
        store[0] = 1;
        store[1] = 5;
        store[2] = 10;
        store[3] = 25;
        while (amount > 0) {
            
            store[4] = amount;
            Arrays.sort(store); 
            int end = store.length - 1;
            while (end > -1) {
            	if (store[end] == amount) {
                    position = end;
                    break;
        
            	}
            	position--;
            }
            
            if (position == store.length - 1) {
            	int times = amount / 25; 
            	ans[3] = times; 
            	amount -= 25 * times; 
            } else {
            	int leftSide = amount % store[end-1]; 
                int rightSide = amount % store[end+1]; 
                if (leftSide < rightSide) {
                	int times = amount / store[position-1]; 
                    ans[position-1] = ans[position-1] + times; 
                    amount -= times * store[position-1];  
                } else {
                	int times = amount / store[position+1]; 
                    ans[position+1] = ans[position+1] + times; 
                    amount -= times * store[times+1];  
                }
            }
            
        }
        return ans;

    }
    
}
