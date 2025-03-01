import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class recursion {
    static void printingnumber(int n){
        if(n<1){
            return;
        } 
        System.out.println(n);
        printingnumber(n-1);

    }
    static long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
    static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
    static boolean iseven(int n){
        return n%2==0;
    }
    static int factorial(int n){
        if(n==0||n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
    static int fibonacci(int n){
        if(n==1||n==2){
            return 1;
        }
        return (fibonacci(n-1)+fibonacci(n-2));

    }
    static void naturalno(int n){
        if(n<0){
            return;
        }
        naturalno(n-1);
        System.out.println(n);
    
}
    static int No_Of_dig(int n){
        if(n==0){
            return 0;
        }
        return No_Of_dig(n/10)+1;

    }
    static int sumofdig(int n){
          if(n==0){
            return 0;
          }
          return sumofdig(n/10)+n%10;
    }
    static String reveString2(String str,String rev,int i){
        if(i<0){
            return rev;
        }
        return reveString2(str, rev+str.charAt(i), i-1);
    }
    static boolean palindrome(String s,int i,int j){
        if(s.charAt(i)!=s.charAt(j)){
            return false;
        }
        if(j>=i){
            return true;
        }
        return palindrome(s,i+1,j-1);
    }
    static int sumarray(int[] ar,int i){
        if(ar.length==1){
            return ar[0];
        }
        if(i==ar.length){
            return 0;
        }
        return sumarray(ar, i+1)+ ar[i];
         
    }
    static int jos(int n,int k){
        if(n==1){
            return 0;
        }
        return (jos(n-1,k)+k)%n;
    }
    static int finddiffword(String a,String b){
        Map<Character,Integer> s=new HashMap<>();
        for (int i = 0; i <a.length(); i++) {
            s.put(a.charAt(i), s.getOrDefault(a.charAt(i), 0)+1);
        }
        for (int i = 0; i < b.length(); i++) {
            if(s.containsKey(b.charAt(i))){
                if(s.get(b.charAt(i))==1){
                    s.remove(b.charAt(i));
                }
                else{
                    s.put(b.charAt(i), s.getOrDefault(b.charAt(i), 0)-1);
                }
            }
            else{
            s.put(b.charAt(i), s.getOrDefault(b.charAt(i), 0)+1);
            }
        }
        int count=0;
        for (int i: s.values()) {
            count+=i;
        }
        return count;
        // System.out.println(s.toString());
    }
    static String flames(String[] ar){
        int res=jos(ar.length, finddiffword("suji", "kani"));
        return ar[res];
    }
    static List<String> generate(int n){
        List<String> ans=new ArrayList<>();
        paranthesis(ans,"",n,0,0);
        return ans;
    }
    static void paranthesis(List<String> ans,String ch,int n,int o,int c){
        if(ch.length()==n*2){
           ans.add(ch);
           return;
        }    
        if(o<n){
              paranthesis(ans,ch+"(", n, o+1, c);
        }
        if(c<o){
             paranthesis(ans,ch+")", n, o, c+1);
        }       
    }    
    static List<String> gene(String s){
       List<String> ans=new ArrayList<>();
       subsequence(ans,s, "");
       return ans;
   }
    static void subsequence(List<String> res,String s,String ans){
        if(s.length()==0){
            res.add(ans);
            return;
        }
        //pick
        subsequence(res,s.substring(1), ans+s.charAt(0));
        // not pick
        subsequence(res,s.substring(1), ans);
    }
    static String[] key={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};  
    static void lcombination(String s,String ans){
        if(s.length()==0){
            System.out.println(ans);
            return;
        }
        String keys=key[s.charAt(0)-48];
        for (int i = 0; i < keys.length(); i++) {
            lcombination(s.substring(1), ans+keys.charAt(i));         
        }
      }  
    static void swap(int[] ar, int i, int fi) {
        int temp = ar[i];
        ar[i] = ar[fi];
        ar[fi] = temp;
    } 
    static void swap(char[] ar, int i, int fi) {
    char temp = ar[i];
    ar[i] = ar[fi];
    ar[fi] = temp;
}   
    static void permutation(char[] ar,int fi){
        if(fi==ar.length-1){
            System.out.println(ar);
            return;
        }
        for(int i=fi;i<ar.length;i++){
            swap(ar,i,fi);
            permutation(ar,fi+1);
            swap(ar,i,fi);
        }
      }
    static void permutation1(int[] ar, int fi, List<List<Integer>> ans) {
        // Base case: if all elements are fixed, add the permutation to the list
        if (fi == ar.length - 1) {
            List<Integer> perm = new ArrayList<>();
            for (int num : ar) {
                perm.add(num);
            }
            ans.add(perm);
            return;
        }
        // Recursive case: fix each element in the current position and permute the rest
        for (int i = fi; i < ar.length; i++) {   
            if(safe(ar,fi,i)==true){
            swap(ar, i, fi);
            permutation1(ar, fi + 1, ans);
            swap(ar, i, fi); // backtrack
        }
        }
    }
    static boolean safe(int ar[],int fi,int i){
        int v=ar[i];
        for(int j=fi;j<i;j++){
            if(ar[j]==v)
            return false;
        }
         return true;
    }
    static List<List<Integer>> permuteUnique(int[] nums) {
         List<List<Integer>> ans = new ArrayList<>();
        permutation1(nums, 0, ans);
        return ans;
    } 
    static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, "", 0, result);
        return result;
    }
    static void backtrack(String s, String current, int index, List<String> result) {
        if (index == s.length()) {
            result.add(current);
            return;
        }
        
        char ch = s.charAt(index);
        
        if (Character.isLetter(ch)) {
            // Include the lowercase version
            backtrack(s, current + Character.toLowerCase(ch), index + 1, result);
            // Include the uppercase version
            backtrack(s, current + Character.toUpperCase(ch), index + 1, result);
        } else {
            // Only include the current character if it's not a letter
            backtrack(s, current + ch, index + 1, result);
        }
    }  
    static void solve(int i,int[] nums, int target,List<List<Integer>> ans, List<Integer> temp){
        if(i==nums.length){
            if(target==0){
            ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if(nums[i]<=target){
        temp.add(nums[i]);
        solve(i,nums, target-nums[i],ans, temp);
        temp.remove(temp.size()-1);
        }
        solve(i+1,nums, target, ans, temp);
    }
    static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        solve(0,nums,target,ans,new ArrayList<>());
        return ans;
    }
    static void solve1(int ind,int[] nums, int target,List<List<Integer>> ans, List<Integer> temp){
            if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
            }
        for(int i=ind;i<nums.length;i++){
        if(i>ind && nums[i]==nums[i-1])continue;
        if(nums[i]>target)break;
        temp.add(nums[i]);
        solve(i+1,nums,target-nums[i],ans, temp);
        temp.remove(temp.size()-1);       
        }
    }
    static List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        solve1(0,nums,target,ans,new ArrayList<>());
        return ans;
    }
    static void solve3(int ind,int[] nums,int k, int target, List<List<Integer>> ans, List<Integer> temp){
        if(temp.size()==k &&target==0){
        ans.add(new ArrayList<>(temp));
        return;
        }
    for(int i=ind;i<nums.length;i++){
    if(nums[i]>target)break;
    temp.add(nums[i]);
    solve3(i+1,nums,k,target-nums[i],ans, temp);
    temp.remove(temp.size()-1);       
    }
}
    static List<List<Integer>> combinationSum3(int k, int n) {
   List<List<Integer>> ans=new ArrayList<>();
    int nums[]={1,2,3,4,5,6,7,8,9};
    solve3(0,nums,k,n,ans,new ArrayList<>());
    return ans; 
}
    static int ropecut(int n, int a,int b,int c){
        if(n==0){
            return 0;
        }
        if(n<0){
            return -1;
        }
        int temp1=ropecut(n-a, a, b, c);
        int temp2=ropecut(n-b, a, b, c);
        int temp3=ropecut(n-c, a, b, c);
        int pieces=Math.max(temp3,Math.max(temp1,temp2));
        if(pieces== -1){
            return -1;
        }
        return pieces+1;
      }
    static  int sumset(int[] ar,int n,int i){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(i==ar.length){
            return 0;
        }
        return (sumset(ar, n-ar[i], i+1) + sumset(ar, n, i+1));
       }
    static boolean luckyno(int n,int c){
        if(n<c){
            return true;
        }        
        if(n%c==0){
            return false;
         }
        return luckyno(n-(n/c), c+1);
       }
    static void TOH(int n,char src,char aux, char des){
        if(n==1){
            System.out.println(src + "->" + des);
            return;
        }
        TOH(n-1, src, des, aux);
        TOH(1, src, aux, des);
        TOH(n-1, aux, src, des);
       }
    static int pow1(int x,int y){
        if(y==0){
            return 1;
        }
        if(y%2==0){
            int res= pow1(x, y/2);
            return res*res;
        }
        return pow1(x,y-1)*x;
       }
    static boolean powof3(int n){
        if(n<1){
             return false;
        }
        if(n==1){
            return true;
        }
        return powof3(n/3) && n%3==0;
       }      
    static boolean isUgly(int n) {
        if(n==0){
            return false;
        }
        if(n<0 &&n>=3){
            return true;
        }
        if(n%2==0){
            return isUgly(n/2);
        }
        if(n%3==0){
            return isUgly(n/3);
        }
        if(n%5==0){
            return isUgly(n/5);
        }
        return n==1;
    }
    static int nthUglyNumber(int n) {
        int dp[]=new int[n+1];
        dp[1]=1;
        int i2=1,i3=1,i5=1;
        for(int i=2;i<=n;i++){
           dp[i]=Math.min(dp[i2]*2,Math.min(dp[i3]*3,dp[i5]*5));
            if(dp[i]==dp[i2]*2)i2++;
            if(dp[i]==dp[i3]*3)i3++;
            if(dp[i]==dp[i5]*5)i5++;
        }
        return dp[n];
    }
    static List<Integer> result = new ArrayList<>();
    static List<Integer> pattern(int N){
        if (N > 0) {
            result.add(N);
            pattern(N - 5);
        } 
        result.add(N);
        return result;
    }   
    static ArrayList<String> findPath(int[][] mat) {
        int n=mat.length;
        int vis[][]=new int[n][n];
      ArrayList<String> ans=new ArrayList<>();
       int di[]={1,0,0,-1};
       int dj[]={0,-1,1,0};
       if(mat[0][0]==1){
        solve4(0,0,mat,n,ans,"",di,dj,vis);
       }
       return ans;
    }   
    static void solve4(int i, int j, int[][] mat,int n, ArrayList<String> ans, String move, int[] di, int[] dj,int[][] vis) {
        if(i==n-1 && j==n-1){
            ans.add(move);
            return;
        }
        String dir="DLRU";
        for(int ind=0;ind<dir.length();ind++){
             int nexti=di[ind]+i;
             int nextj=dj[ind]+j;
             if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < n &&vis[nexti][nextj] == 0 && mat[nexti][nextj] == 1) {
                vis[i][j]=1;
                solve4(nexti, nextj, mat, n, ans, move+dir.charAt(ind), di, dj,vis);
                vis[i][j]=0;
        }
    }
 }
    static boolean solved(char[][] board,String word,int i,int j,int ind,boolean[][] vis){
        if(ind==word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || vis[i][j] || board[i][j] !=word.charAt(ind) ){
            return false;
        }
        vis[i][j]=true;
        if(solved(board,word,i+1,j,ind+1,vis)||solved(board,word,i,j+1,ind+1,vis)||solved(board,word,i-1,j,ind+1,vis)||solved(board,word,i,j-1,ind+1,vis)){
            return true;
        }
        else{
        vis[i][j]=false;
        }
        return false;
    }
    static boolean exist(char[][] board, String word) {
         int m = board.length, n = board[0].length;
        if (m*n < word.length())
            return false;
        boolean vis[][]=new boolean[board.length][board[0].length];
        boolean res=false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    res=solved(board,word,i,j,0,vis);
                    if(res){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    static ArrayList<Integer> subsetSum(int ar[]){
        ArrayList<Integer> ans=new ArrayList<>();
        solve5(0, ar, 0,ans);
        return ans;
    }
    static void solve5(int ind, int[] ar, int sum, ArrayList<Integer> ans) {
        if(ind==ar.length){
            ans.add(sum);
            return;
        }
        // pick
        solve5(ind+1, ar, sum+ar[ind], ans);
        // nonpick
        solve5(ind+1, ar, sum, ans);
    }
    static List<List<Integer>> subsetSum2(int ar[]){
        List<List<Integer>> ans=new ArrayList<>();
        if(ar.length==0) {
            return ans;
        }
        solve6(0,ar,ans,new ArrayList<>());
        return ans;
    }
    static void solve6(int ind, int[] ar, List<List<Integer>> ans, List<Integer> temp) {
       if(ind==ar.length){
        ans.add(new ArrayList<>(temp));
        return;
       }
    //    pick
        temp.add(ar[ind]);
        solve6(ind+1, ar, ans, temp);
        temp.remove(temp.size()-1);
    // nonpick
       solve6(ind+1, ar, ans, temp);
    }
    static List<List<Integer>> subsetsWithDup(int ar[]){
        List<List<Integer>> ans=new ArrayList<>();
        if(ar.length==0) {
            return ans;
        }
        Arrays.sort(ar);
        solve7(0,ar,ans,new ArrayList<>());
        return ans;
    }
    static void solve7(int ind, int[] ar, List<List<Integer>> ans, List<Integer> temp) {
    ans.add(new ArrayList<>(temp));
    for(int i=ind;i<ar.length;i++){
        if(i>ind && ar[i]==ar[i-1])continue;
        temp.add(ar[i]);
        solve7(i+1, ar, ans, temp);
        temp.remove(temp.size()-1);
     }
   }
    static List < List < String >> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List < List < String >> res = new ArrayList < List < String >> ();
        int leftRow[] = new int[n];
        int upperDiagonal[] = new int[2 * n - 1];
        int lowerDiagonal[] = new int[2 * n - 1];
        solve(0, board, res, leftRow, lowerDiagonal, upperDiagonal);
        return res;
    }
    static void solve(int col, char[][] board, List < List < String >> res, int leftRow[], int lowerDiagonal[], int upperDiagonal[]) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[board.length - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 + col - row] = 1;
                solve(col + 1, board, res, leftRow, lowerDiagonal, upperDiagonal);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }
    static List < String > construct(char[][] board) {
        List < String > res = new ArrayList < String > ();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
    static int totalNQueens(int n) {
        return backtrack(0, n, new boolean[n], new boolean[2 * n], new boolean[2 * n]);
    }
    static int backtrack(int row, int n, boolean[] cols, boolean[] d1, boolean[] d2) {
        if (row == n) {
            return 1; // A valid solution is found
        }
        int count = 0;
        for (int col = 0; col < n; col++) {
            int id1 = col - row + n-1; // Index for the main diagonal
            int id2 = col + row;      // Index for the secondary diagonal
            if (cols[col] || d1[id1] || d2[id2]) continue;
            cols[col] = true;
            d1[id1] = true;
            d2[id2] = true;
            count += backtrack(row + 1, n, cols, d1, d2);
            cols[col] = false;
            d1[id1] = false;
            d2[id2] = false;
        }
        return count;
    }     
    static void solve(int ind,String s,String str,ArrayList<String> ans){
        if(ind==s.length()-1){
            str+=s.charAt(ind);
            ans.add(str);
            return;
        }
        // pick
        solve(ind+1,s,str+s.charAt(ind)+" ",ans);
        // notpick
        solve(ind+1,s,str+s.charAt(ind),ans);
    }
    static ArrayList<String> permutationspace(String s) {
        ArrayList<String> ans=new ArrayList<>();
        solve(0,s,"",ans);
        return ans;
    }
    static  void solveSudoku(char[][] board) {
        solve(board);
    }
    static  boolean isvalid(char[][] board,int row,int col,char ch) {
        for(int i=0;i<9;i++){
            if(board[row][i]==ch){
                return false;
            }
             if(board[i][col]==ch){
                return false;
            }
             if(board[3*(row/3)+i/3][3*(col/3)+i%3]==ch){
                return false;
            }
        }
        return true;
 }
    static boolean solve(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    for(char c='1';c<='9';c++){
                        if(isvalid(board,i,j,c)){
                              board[i][j]=c;
                              if(solve(board)){
                                return true;
                              }
                              else{
                                board[i][j]='.';
                              }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    static  String countAndSay(int n) {
        if(n==1)return "1";  
        if(n==2)return "11";

        String s=countAndSay(n-1);

        StringBuilder sb=new StringBuilder();
        int l=0,r=0;
        char[]c=s.toCharArray();
        while(r<c.length){
            if(c[l]!=c[r]){
                sb.append(r-l).append(c[l]);
                l=r;
            }
            r++;
        }
        sb.append(r-l).append(c[l]);
        return sb.toString();
        }
    static  boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0 || nums.length < k) return false;
        
        int target = sum / k;
        Arrays.sort(nums); // Sort in ascending order
        
        if (nums[nums.length - 1] > target) return false; // Early exit if largest number is greater than target
        
        int[] bucket = new int[k];
        return canPartitionKSubsets(nums, target, nums.length - 1, bucket);
    }   
    static boolean canPartitionKSubsets(int[] nums, int target, int i, int[] bucket) {
        if (i < 0) {
            for (int b : bucket) {
                if (b != target) return false;
            }
            return true;
        }
        
        for (int j = 0; j < bucket.length; j++) {
            if (bucket[j] + nums[i] <= target) {
                bucket[j] += nums[i];
                if (canPartitionKSubsets(nums, target, i - 1, bucket)) {
                    return true;
                }
                bucket[j] -= nums[i];
            }
            if (bucket[j] == 0) break; // Skip further empty buckets
        }
        
        return false;
    }
    static  String kthPermutation(int n, int k) {
        List<Integer> nums=new ArrayList<>();
        int fact=1;
        for(int i=1;i<n;i++){
            fact=fact*i;
            nums.add(i);
        }
        nums.add(n);
        k=k-1;
        String ans="";
        while(true){
           ans+=nums.get(k/fact);
           nums.remove(k/fact);
           if(nums.size()==0){
            break;
           }
           k=k%fact;
           fact=fact/nums.size();
        }
        return ans;
    }
    static  boolean check(String s){
        if(s.length()==0 || s.length()>3){
            return false;
        }
        int temp=Integer.parseInt(s);
        if(temp<0 || temp>255){
            return false;
        }
        if(s.length()>1 && s.charAt(0)=='0'){
            return false;
        }
        return true;
    }
    static String generate(String s,int i,int j,int k){
        String s1=s.substring(0,i),s2=s.substring(i,j),s3=s.substring(j,k),s4=s.substring(k);
        String res="";
       if(check(s1)&&check(s2)&&check(s3)&&check(s4)){
           res= s1+"."+s2+"."+s3+"."+s4;
           return res;
       }
     return res;
    }
    static ArrayList<String> genIp(String s) {
        ArrayList<String> ans=new ArrayList<>(); 
        int n=s.length();
         for(int i=0;i<n-2;i++){
             for(int j=i+1;j<n-1;j++){
                 for(int k=j+1;k<n;k++){
                     String str=generate(s,i,j,k);
                     if(str.length()>0){
                         ans.add(str);
                     }
                 }
             }
         }
         return ans;
    }
    static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result; // Early exit if the length is not valid
        }
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
    static private void backtrack(String s, int start, List<String> current, List<String> result) {
        if (current.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", current));
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (start + i > s.length()) break; // Avoid out-of-bound errors
            String segment = s.substring(start, start + i);
            if (isValid(segment)) {
                current.add(segment);
                backtrack(s, start + i, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
    static private boolean isValid(String segment) {
        if (segment.length() > 1 && segment.charAt(0) == '0') {
            return false; // No leading zeros allowed
        }
        int value = Integer.parseInt(segment);
        return value >= 0 && value <= 255;
    }
    static List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        func(s,0,res,new ArrayList<>());
        return res;
    }
    static public void func(String s,int index,List<List<String>> res,List<String> temp){
        if(index==s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(ispalindrome(s,index,i)){
                temp.add(s.substring(index,i+1));
                func(s,i+1,res,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    static  boolean ispalindrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public int countGoodNumbers(long n) {
        long odd = n / 2;
        long even = (n + 1) / 2;
        long mod = 1000000007;
        
        // Calculate (5^even % mod) * (4^odd % mod) % mod
        long evenPower = pow(5, even, mod);
        long oddPower = pow(4, odd, mod);

        // Return the result cast to int after taking modulo
        return (int)((evenPower * oddPower) % mod);
    }
    // Function for modular exponentiation
    static long pow(long N, long exp, long mod) {
        long result = 1;
        long baseMod = N % mod;
        
        while (exp > 0) {
            if ((exp % 2) == 1) {  // If exp is odd
                result = (result * baseMod) % mod;
                exp -= 1;
            }
            baseMod = (baseMod * baseMod) % mod;
            exp /= 2;
        }
        
        return result;
    }
//    35 problems
    
    public static void main(String[] args) {
        // String ar[]={"friend","lover","affection","marriage","enemy","sibling"};
        //   int ar1[]={1,2,3,};
        //  int mat[][]={{1, 0, 0, 0},
        //     {1, 1, 0, 1}, 
        //     {1, 1, 0, 0},
        //     {0, 1, 1, 1}};
        int[] ar={2,2,4,5,6};
        System.out.println(canPartitionKSubsets(ar, 3));
        
            
    }    
}

