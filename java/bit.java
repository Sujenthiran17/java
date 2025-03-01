import java.util.ArrayList;
import java.util.List;

public class bit {
    public static void oddeven2(int n) {
        
        if((n & 1)==0){
            System.out.println("even");
        }
        else{
            System.out.println("odd");
        }
        
    }
    public static boolean powOf2(int n){
        if(n==0){
             return false;
        }
        return ((n&(n-1))==0);
    }
    public static void checkbit(int n,int k){
        if((n&(1<<k))==0){
             System.out.println("not set");
        }
        else{
            System.out.println("set");
        }
    }
    public static int togglebit (int n,int k){
        return n^(1<<k);
    }
    public static int setbit (int n,int k){
        return n|(1<<k);
    }
    public static int unsetbit (int n,int k){
        return n&~(1<<k);
    }
    public static String decimaltobinary(int n){
        String s="";
        while(n>=1){
        int x=n&1;
        n=n>>1;
        s=x+s;
        }
        return s;
    }
    public static int binaryTuDecimal(String s){
        int res=0;
        int powerof2=1;
        int i=s.length()-1;
        int count=0;
        while(i>=0){
        if(s.charAt(i)=='1'){
                res=res+powerof2;
        }
        count++;
        powerof2=1<<count;
        i--; 
    }
    return res;
    }
    public static int count(int n) {
        int count = 0;
        while (n>0) {
            n = n & (n - 1);  // Removes the rightmost set bit
            count++;
        }
        return count;
    }
        public static int[] countBits(int n) {   
             int ans[]=new int[n+1];
             for(int i=0;i<=n;i++){
                ans[i]=count(i);
             }
             return ans;                             
        }
    public static int rms(int n){
        //return (int)(Math.log(n^n&(n-1))/Math.log(2))+1;
        int pos=0;
        int m=1;
        if(n==0){
            return -1;
        }

        while((n&m)==0){
            m=m<<1;
            pos++;
        }
        return pos+1;
         
    }
    public static int countsbit(int n){     
        int count=0;
        while(n>0){
          n=n&n-1;
          count++;
        }
        return count;
    }
    public static int lonelyint(){
            int[] ar={5,10,3,5,3};
            // HashSet<Integer> nums=new HashSet<Integer>();
            // for(int i:ar){
            //     if(nums.contains(i)){
            //         nums.remove(i);
            //     }
            //     else{
            //         nums.add(i);
            //     }
            // }
            // for(int i: nums){
            //     return i;
            // }
            // return -1;
            int res=0;
            for(int i=0;i<ar.length;i++){
                 res=res^ar[i];
            }
            return res;
    }
    public static int consecutive1s(int n){
        int count=0;
        while(n>0){
            n=(n&(n<<1));
               count++;
            }       
        return count;
    }
    public static int swapoddevenbit(int n){
        return ((n&0xaaaaaaaa)>>>1|(n&0x55555555)<<1);
    }
    public static int trailingzerobit(int n){
        int a=rms(n);
        return a-1;
    }
    public static int reversebit(int n){
          int rev=0;
          int f=31;
          int l=0;
          while(f>l){
            if((n&(1<<f))!=0){
                rev=rev | (1<<l);
            }
            if((n&(1<<l))!=0){
                rev=rev | (1<<f);
            }
            f--;
            l++;
          }
          return rev;
    }
    public static int maxAndbit(int[] ar,int mask){
        int count=0;
        for (int i = 0; i < ar.length; i++) {
            if((mask &ar[i])==mask){
                count++;
            }
        }
        return count;
    }
    public static int maxAndvalue(int[] ar){
        int mask=0;
        int res=0;
        for (int i = 31; i >=0; i--) {
            mask=(1<<i)|res;
            int count=maxAndbit(ar,mask);
            if(count>=2){
                 res=res|mask;
            }          
        }
        return res;
    }
    static int findcount(int num){
        return Integer.toBinaryString(num).length(); 
        // int count=0;
        // while(num>0){
        //     num=num>>1;
        //     count++;
        // }
        // return count;
    }
    static int findComplement(int num) {
        if (num == 0){
            return 1;
        } 
        int mask = (1 << findcount(num) ) - 1;
        return num ^ mask;
    }
    static int minBitFlips(int start, int goal) {
        int count = 0; 
        // XOR will give 1 where the bits are different
        int xor = start ^ goal;

        while(xor!=0){
            // If the last bit is 1, increment count 
            count += xor & 1;

            // Right-shift to check the next bit
            xor >>=1;
        }
        return count;
    }
//  20 problems
    public int getSum(int a, int b) {
    while (b != 0) {
        int tmp = (a & b) << 1; // carry calculation
        a = a ^ b; // sum without carry
        b = tmp; // carry shifted left
    }
    return a;
}
    public int largestCombination(int[] candidates) {
    int maxCombination = 0;
    for (int bit = 0; bit < 32; bit++) {
        int count = 0;
        for (int num : candidates) {
            // Check if the current number has the `bit`-th bit set
            if ((num & (1 << bit)) != 0) {
                count++;
            }
        }
        maxCombination = Math.max(maxCombination, count);
    }
    return maxCombination;
}
   static public int[] getMaximumXor(int[] nums, int maximumBit) {
    int xorProduct = 0;
    for (int i = 0; i < nums.length; i++) {
        xorProduct = xorProduct ^ nums[i];
    }
    int[] ans = new int[nums.length];

    int mask = (1 << maximumBit) - 1;

    for (int i = 0; i < nums.length; i++) {
        ans[i] = xorProduct ^ mask;
        // remove last element
        xorProduct = xorProduct ^ nums[nums.length - 1 - i];
    }

    return ans;
}
   static public long minEnd(int n, int x) {
    long res=x;
    while(--n>0){
        res=(res+1)|x;
    }
    return res;
}
static int rmssetBit(int n) {
    return n | n+1;
}
public static int countSetBits(int n){
    int count=0;
    for(int i=0;1<<i<=n;i++){
        int blockcount=1<<i+1;
        int complete=n/blockcount;
        count+=(complete*(blockcount/2));
        int remainder=n%blockcount;
        count+=Math.max(0,remainder-(blockcount/2)+1);
    }
    
   return count; 
}      
static List<List<Integer>> subset(int ar[]){
        List<List<Integer>> ans=new ArrayList<>();
        if(ar.length==0) {
            return ans;
        }
        for(int i=0;i<(1<<ar.length);i++){
            List<Integer> lis=new ArrayList<>();
            for(int j=0;j<ar.length;j++){
                if((i & (1<<j))!=0){
                    lis.add(ar[j]);
                }
            }
            ans.add(lis);
        }
        return ans;
    } 
public static int findXOR(int l, int r) {
        return xorrr(l-1)^ xorrr(r);
    }
static int xorrr(int n){
        if(n%4==1){
            return 1;
        }
        else if(n%4==2){
            return n+1;
        }
        else if(n%4==3){
            return 0;
        }
        else{
            return n;
        }
    }
    public int singleNumber(int[] nums) {
        int ones=0;
        int twos=0;
        for(int i=0;i<nums.length;i++){
            ones=(ones ^ nums[i])& ~twos;
            twos=(twos ^ nums[i])& ~ones;
        }
        return ones;
    }
public static void main(String[] args) {
        System.out.println(binaryTuDecimal("1010"));
    }
}

