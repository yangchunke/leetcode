package leetcode;

public class DivideTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int divide(int dividend, int divisor) {
        
        if (divisor==Integer.MIN_VALUE)
        {
            return dividend==Integer.MIN_VALUE?1:0;
        }

        int additional = 0;
        if (dividend==Integer.MIN_VALUE){
            if (divisor>0){
                dividend += divisor;
                additional = -1;
            }
            else
            {
                dividend -=divisor;
                additional = 1;
            }
        }
        
        boolean minus = false;
        
        if (dividend<0){
            minus = true;
            dividend = -dividend;
        }
        if (divisor<0){
            minus = !minus;
            divisor = -divisor;
        }
        
        int[] ret = _divide(dividend, divisor);
        
        int quo = minus?-ret[0]:ret[0];
        return quo+additional;
    }
    
    private int[] _divide(int dividend, int divisor){
        
        if (dividend==0){
            return new int[]{0,0};
        }
        else if (dividend==divisor){
            return new int[]{1,0};
        }
        
        int[] ret = new int[2];
        
        int half = dividend>>1;
        int[] halfRes = _divide(half, divisor);
        ret[0] = halfRes[0] + halfRes[0];

        int remainder = halfRes[1] + halfRes[1];
        remainder+=(dividend&0x01);        
        while (remainder>=divisor){
            ret[0]+=1;
            remainder -=divisor;
        }
        ret[1]=remainder;

        return ret;
    }
}
