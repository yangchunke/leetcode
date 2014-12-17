package net.remyang.leetcode;

public class CompareVersionNumbers {

	public static void main(String[] args) {
		CompareVersionNumbers c = new CompareVersionNumbers();
		System.out.println(c.compareVersion("1.0", "1.1"));
		System.out.println(c.compareVersion("0", "1"));
		System.out.println(c.compareVersion("1", "1.0"));
	}

    public int compareVersion(String version1, String version2) {
        
        String [] v1 = version1.split("\\.");
        String [] v2 = version2.split("\\.");
        
        int i=0;
        for(;i<v1.length&&i<v2.length; i++){
            
            int vv1 = Integer.parseInt(v1[i]);
            int vv2 = Integer.parseInt(v2[i]);
            
            if (vv1<vv2){
                return -1;
            }
            if (vv1>vv2){
                return 1;
            }
        }
        
        if (v1.length<v2.length){
            for(;i<v2.length;i++){
            	if (Integer.parseInt(v2[i])>0){
            		return -1;
            	}
            }
        }
        if (v1.length>v2.length){
            for(;i<v1.length;i++){
            	if (Integer.parseInt(v1[i])>0){
            		return 1;
            	}
            }
        }
        
        return 0;
    }
	
}
