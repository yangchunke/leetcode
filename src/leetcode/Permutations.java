package leetcode;
import java.util.*;

public class Permutations {

	public static void main(String[] args) {
		Permutations c = new Permutations();
		List<List<Integer>> ret = c.permute(new int[]{1,2,2});
		for(List<Integer> l : ret){
			for(int i: l){
				System.out.print(i + " ");
			}
			System.out.println("");
		}
	}
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (num!=null)
        {
            List<Integer> partial = new ArrayList<Integer>();
            boolean used[] = new boolean[num.length];
            permute(num, used, partial, ret);
        }
        return ret;
    }
    
    private void permute(int[] num, boolean used[], List<Integer> partial, List<List<Integer>> ret)
    {
        if (partial.size()==num.length){
            ret.add(new ArrayList<Integer>(partial));
        }
        else
        {
            for(int i=0; i<num.length; i++){
                if (used[i]==false){
                    used[i]=true;
                    partial.add(num[i]);
                    permute(num, used, partial, ret);
                    used[i]=false;
                    partial.remove(partial.size()-1);
                }
            }
        }
    }

}
