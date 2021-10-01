
package main.util.stringutils;

public class StringUtils {

    public static boolean hasSequence (String corpus, String query) {
        if (query.isEmpty()) {
        	return true;
        }
        
        int total = 0;
        int loop = 0;
        int length = query.length();
        int begin = -1;
        while(total < length) {
        	if (loop >= 1 && total == 0) {
        		break;
        	}
        	int index = begin + 1;
        	while(index < corpus.length()) {
        		if(corpus.charAt(index) == query.charAt(loop)) {
        			total++;
        			begin = index;
        			break;
        		}
        		index++;
        	}
        	loop = loop + 1;	
        }
        
        if (total == length) {
        	return true;
        }
        
        return false;
    }
    
    public static String sentCap (String sents) {
        for (int i = 0; i < sents.length();i++) {
            if (sents.charAt(i) == '.' && i != sents.length() - 1) {
                String sub = sents.substring(i);
                String sub2 = sents.substring(0,i);
                int count = 0;
                while (count < temp.length()) {
                    if (sub.charAt(count) != ' ' && sub.charAt(count) != '.') {
                        char caps = Character.toUpperCase(sub.charAt(count));
                        sub = sub.substring(0, count) + caps + sub.substring(count + 1);
                        break;
                    }
                    count++;
                }
                sents = sub2 + sub;
                      
           }
        }
        return sents;
    }
    
    public static String getNthMatch (String sent, String query, int n) {
       String[] sentArray = sent.split(" ");
       if (n < 0 || query.isEmpty()) {
    	   throw new IllegalArgumentException("n must be an index in sent amd query cannot be empty");
       }
       
       String ans = "";
       if (n >= sentArray.length) {
    	   return null;
       }
       String str = sentArray[n];
       str = str.toLowerCase();
       if (str.equals(query.toLowerCase())) {
    	   ans += sentArray[n];
       } else {
    	   return null;
       }
    	
       return ans;
       
    }
    
}
