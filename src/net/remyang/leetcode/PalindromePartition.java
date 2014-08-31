package net.remyang.leetcode;
import java.util.*;

public class PalindromePartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<List<String>> partition(String s) {
        Map<Integer, List<List<String>>> partitionMap = new HashMap<Integer, List<List<String>>>();
        return partition(s, 0, partitionMap);
    }
    
    private List<List<String>> partition(String s, int thisIndex, Map<Integer,List<List<String>>> partitionMap){
        if (!partitionMap.containsKey(thisIndex))
        {
            List<List<String>> partitionList = new ArrayList<List<String>>();
            if (thisIndex<s.length())
            {
                for(int p : partitionPairs(s, thisIndex))
                {
                    String thisString = s.substring(thisIndex,p+1);
                    for(List<String> ss : partition(s, p+1, partitionMap))
                    {
                        List<String> ns = new ArrayList<String>();
                        ns.add(thisString);
                        ns.addAll(ss);
                        partitionList.add(ns);
                    }
                }
            }
            else
            {
                partitionList.add(new ArrayList<String>());
            }
            
            partitionMap.put(thisIndex, partitionList);
        }
        
        return partitionMap.get(thisIndex);
    }
    
    private List<Integer> partitionPairs(String s, int thisIndex){
        List<Integer> pairs = new ArrayList<Integer>();
        for(int endIndex = thisIndex; endIndex<s.length(); endIndex++)
        {
            if (isPalindrome(s, thisIndex, endIndex)){
                pairs.add(endIndex);
            }
        }
        return pairs;
    }
    
    private boolean isPalindrome(String s, int startIndex, int endIndex){
        boolean ret = true;
        while(startIndex<endIndex){
            if (s.charAt(startIndex++)!=s.charAt(endIndex--)){
                ret = false;
                break;
            }
        }
        return ret;
    }

}
