package leetcode;
import java.util.*;

public class WordBreakII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<String> wordBreak(String s, Set<String> dict) {
        Map<Integer, List<String>> indexToListMap = new HashMap<Integer,List<String>>();
        return wordBreak(s,0,dict,indexToListMap);
    }
    
    private List<String> wordBreak(String s, int fromIndex, Set<String> dict, Map<Integer, List<String>> indexToListMap){
        if (!indexToListMap.containsKey(fromIndex))
        {
            List<String> list = new ArrayList<String>();
            
            for(String d : dict){
                if (s.startsWith(d,fromIndex))
                {
                	if ( fromIndex+d.length() == s.length()){
                		list.add(d);
                	}
                	else
                	{
	                    List<String> subList = wordBreak(s, fromIndex+d.length(), dict, indexToListMap);
	                    for(String subStr : subList){
	                        list.add(d + " " + subStr);
	                    }
                	}
                }
            }
            
            indexToListMap.put(fromIndex,list);
        }
        return indexToListMap.get(fromIndex);
    }
}
