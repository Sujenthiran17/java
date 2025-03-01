import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class problems {
    static int[] twosum(int arr[], int x) {
        Map<Integer,Integer> M=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(M.containsKey(x-arr[i])){
                return new int[] {i,M.get(x-arr[i])} ;
            }
            M.put(arr[i], i);
        }
        return null;
    }
    static int[] reverse_array(int[] ar,int f,int l){
        int temp;
        while(f<=l){
          temp=ar[f];
          ar[f]=ar[l];
          ar[l]=temp;
          f++;
          l--;
        }
        return ar;
     }    
    static void swap(int[] ar,int first,int second){
        int temp=ar[first];
        ar[first]=ar[second];
        ar[second]=temp;
    }
    static  void nextPermutation(int[] nums) {
        int n=nums.length;
        int breakIndex=-1;
        for (int i = n-2; i >=0; i--) {
            if(nums[i+1]> nums[i]){
                breakIndex=i;
                break;
            }
        }
        if(breakIndex==-1){
           reverse_array(nums, 0, n-1);          
           return;
        }
        else{
        for (int i = n-1; i>breakIndex; i--){
            if(nums[i]>nums[breakIndex]){
                swap(nums,breakIndex,i );
                break;
            }
        }
        reverse_array(nums,breakIndex+1,n-1);     
     }
     for (int index = 0; index < nums.length; index++) {
        System.out.print(nums[index]);
     }
     
    }
    static int addDigits(int num) {
        if (num == 0){
            return 0;
        }
        if (num%9 == 0){
            return 9;
        }
        return num%9;
    }
    static List<Integer> singlerow(int n){
        List<Integer> l=new ArrayList<>();
        // row-col/col
        l.add(1);
        long ans=1;
        for(int i=1;i<n;i++){
            ans=ans*(n-i);
            ans=ans/i;
            l.add((int)ans);
        }
        return l;
    }
    static List<List<Integer>> generatepaskal(int numRows) {
        List<List<Integer>> s=new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            s.add(singlerow(i));

        }
        return s;
    }
    static int paskaltriangle2(int row,int col){
        // n-1cr-1
        // n!/r!-(n-r)!
        // n!/r!
        int res=1;
        for (int i = 1; i <col ; i++) {
            res=res*(row-i);
            res=res/i;
        }
        return res;
    }
    public static int subarraysWithXorK(int []a, int k) {
        int n = a.length; //size of the given array.
        int xr = 0;
        Map<Integer, Integer> mpp = new HashMap<>(); //declaring the map.
        mpp.put(xr, 1); //setting the value of 0.
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            // prefix XOR till index i:
            xr = xr ^ a[i];

            //By formula: x = xr^k:
            int x = xr ^ k;

            // add the occurrence of xr^k
            // to the count:
            if (mpp.containsKey(x)) {
                cnt += mpp.get(x);
            }

            // Insert the prefix xor till index i
            // into the map:
            if (mpp.containsKey(xr)) {
                mpp.put(xr, mpp.get(xr) + 1);
            } else {
                mpp.put(xr, 1);
            }
        }
        return cnt;
    }
    public static int getLucky(String s, int k) {
        int sum=0;
        String n="";
        for(int i=0;i<s.length();i++){
           n+=(s.charAt(i)-'a'+1);
            }
        while(k>0){
          sum=0;
        for(char c: n.toCharArray()){
                sum += Integer.parseInt(c+"");
            }
            n = String.valueOf(sum);
            k--;
        }
        return sum;
    }
    static  int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n != original.length){
            return new int[0][0];
        }
        int[][] arr = new int[m][n];

        for(int i=0; i<m; i++){
           arr[i] = Arrays.copyOfRange(original, i*n, i*n+n);
        }
        return arr;
        //  if (m * n != original.length) {
        //     return  new int[][] {};  // Return an empty vector if the dimensions don't match
        // }
        // int[][] ans=new int[m][n];
        //  for (int i = 0; i < m * n; i++) {
        //     ans[i / n][i % n] = original[i];
        // }
        //  return ans;
    }
    static int chalkReplacer(int[] chalk, int k) {
            long accSum = 0;
            for (int c : chalk) accSum += c;
    
            k %= accSum;
    
            for (int i = 0; i < chalk.length; i++) {
                if (chalk[i] > k) return i;
                k -= chalk[i];
            }
            return -1; 
        }
    static int[] missingRolls(int[] rolls, int mean, int n) {
        int[] ret = new int[n];
        int sum = 0;
        for (int i : rolls) {
            sum += i;
        }
        int missingSum = mean * (n + rolls.length) - sum;
        if (missingSum > 6*n || missingSum < n) {
            return new int[]{};
        }
        int expectedAvg = missingSum/n, remainder = missingSum%n;

        for (int i = 0; i < remainder; i++) {
            ret[i] = expectedAvg + 1;
        }
        for (int i = remainder; i < n;i++) {
            ret[i] = expectedAvg;
        }
        return ret;
    }
    static  public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            int start = 0;
            int end = 0; 
            for (int i = 0; i < s.length(); i++) {
                int odd = expandAroundCenter(s, i, i);
                int even = expandAroundCenter(s, i, i + 1);
                int max_len = Math.max(odd, even);
                if (max_len > end - start) {
                    start = i - (max_len - 1) / 2;
                    end = i + max_len / 2;
                }
            }
            return s.substring(start, end + 1);        
        }
        static private int expandAroundCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return right - left - 1;
        }    
        static String defangIPaddr(String str) {

            StringBuilder sb =new StringBuilder();
            String str2="[.]";
            for(int i=0;i<str.length();i++){
               char ch=str.charAt(i);
               if(ch=='.'){
                sb.append(str2);
               }
               else{
                sb.append(ch);
               }
            }
            return sb.toString();
        }
        static public String validIPAddress(String IP) {
            if (IP == null || IP.isEmpty()) return "Neither";
            if (isIPv4(IP)) return "IPv4";
            if (isIPv6(IP)) return "IPv6";
            return "Neither";
        }
        static private boolean isIPv4(String IP) {
            if(IP.charAt(0)=='.' || IP.charAt(IP.length()-1)=='.') return false;
            // IPv4 addresses must have 4 segments separated by '.'
            String[] segments = IP.split(".");
            if (segments.length != 4) return false;
            for (String segment : segments) {
                // Each segment must be a valid number between 0 and 255
                if (segment.length() == 0 || segment.length() > 3) return false;
                if (segment.startsWith("0") && segment.length() > 1) return false; // No leading zeros allowed
                
                try {
                    int num = Integer.parseInt(segment);
                    if (num < 0 || num > 255) return false;
                } catch (Exception e) {
                    return false;
                }
            }
            
            return true;
        }       
       static private boolean isIPv6(String IP) {
            if(IP.charAt(0)==':' || IP.charAt(IP.length()-1)==':') return false;
            // IPv6 addresses must have 8 segments separated by ':'
            String[] segments = IP.split(":");
            if (segments.length != 8) return false;
            for (String segment : segments) {
                // Each segment must be between 1 and 4 hexadecimal digits
                if (segment.length() == 0 || segment.length() > 4 ) return false;
                for (char c : segment.toCharArray()) {
                    if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) {
                        return false;
                    }
                }
            }   
            return true;
        }
// 14 problem




    
    public static void main(String[] args) {
        // int arr[]={4,1,2,1};
      // int res[]= twosum(arr, 16);
        System.out.println(paskaltriangle2(5,3));
      
    }
}
