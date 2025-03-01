import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class dynmic {
       static int fibonacci1(int n){
            int dp[]=new int[n+1]; 
            if(n==0 || n==1){
                return n;
            }
            // if (dp[n]!= 0) {
            //     return dp[n];
            // }
            // return dp[n]=fibonacci1(n-2)+fibonacci1(n-1);
            dp[0]=0;
            dp[1]=1;
            for(int i=2;i<=n;i++){
                dp[i]=dp[i-2]+dp[i-1];
            }
            return dp[n];
        }
       public static int climbStairs(int n) {
            if(n==0 ||n==1 ||n==2){
               return n;
           }
           int dp[]=new int[n+1];
           dp[0]=0;
           dp[1]=1;
           dp[2]=2;
           for(int i=3;i<=n;i++){
               dp[i]=dp[i-2]+dp[i-1];
           }
           return dp[n];
       }
       static  int frogGame(int[] height) {
            int dp[]=new int[height.length];
            dp[0]=0;
            int jmp1=Integer.MAX_VALUE;
            int jmp2=Integer.MAX_VALUE;
            for(int i=1;i<height.length;i++){
                jmp1=dp[i-1] + Math.abs(height[i] -height[i-1]);
                if(i>1){
                    jmp2=dp[i-2] + Math.abs(height[i]-height[i-2]);
                }
                dp[i]=Math.min(jmp1,jmp2);
            }
            return dp[height.length-1];
            
            //     int prev=0;
            //     int prev2=0;
            //     int curr=0;
            //     int jmp2=Integer.MAX_VALUE;
            //     for(int i=1;i<height.length;i++){
            //         int jmp1=prev + Math.abs(height[i] -height[i-1]);
            //         if(i>1){
            //             jmp2=prev2 + Math.abs(height[i]-height[i-2]);
            //         }
            //         curr=Math.min(jmp1,jmp2);
            //         prev2=prev;
            //         prev=curr;
            //     }
            //     return curr;
            // }
        }
       static  public int minimizeCost(int k, int height[]) {
            int dp[]=new int[height.length];
               dp[0]=0;
               int jmp1=Integer.MAX_VALUE;
               for(int i=1;i<height.length;i++){
                   int minjump=Integer.MAX_VALUE;
                   for(int j=1;j<=k;j++){
                       if(i-j>=0){
                          jmp1=dp[i-j] + Math.abs(height[i] -height[i-j]);
                          minjump=Math.min(jmp1,minjump);
                       }
                   }
                   dp[i]=minjump;
               }
               return dp[height.length-1];
       }
       public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        int n=nums.length;
        return solve(nums,n-1,dp);
        
    }
       static int solve(int nums[] ,int n,int dp[]){
        dp[0]=nums[0];
        // pick
        int pick=Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
            pick=nums[i];
             if(i-2>=0){
                pick+=dp[i-2];
             }
             int nonpick=dp[i-1];
             dp[i]=Math.max(pick,nonpick);
             
        }
        return dp[n];
    } 
       public int maximumPoints(int arr[][]) {
        int n=arr.length;
        int[][] dp=new int[n][4];
        return solve(arr,n-1,3,dp);
    }
       static int solve(int[][] arr,int n,int last,int[][] dp){
        if(n==0){
            int maxi=0;
            for(int i=0;i<3;i++){
                if(i!=last){
                    maxi=Math.max(maxi,arr[0][i]);
                }
            }
            return maxi;
        }
        if(dp[n][last]!=0){
            return dp[n][last];
        }
        int maxi=0;
        for(int i=0;i<3;i++){
            
                if(i!=last){
                    int points=arr[n][i]+solve(arr,n-1,i,dp);
                    maxi=Math.max(maxi,points);
                    dp[n][last]=maxi;
                }
            }
            return dp[n][last];
    }
       public int maximumPoint(int arr[][]) {
        int n=arr.length;
        int[] dp=new int[4];
        return solve(arr,n,dp);
    }
       static int solve(int[][] arr,int n,int[] dp){
       dp[0]=Math.max(arr[0][1],arr[0][2]);
       dp[1]=Math.max(arr[0][0],arr[0][2]);
       dp[2]=Math.max(arr[0][0],arr[0][1]);
       dp[3]=Math.max(arr[0][1],Math.max(arr[0][2],arr[0][0]));
        for(int day=1;day<n;day++){
            int temp[]=new int[4];
            for(int last=0;last<4;last++){
                temp[last]=0;
                 for(int task=0;task<3;task++){
                    if(task!=last){
                        int points=arr[day][task]+dp[task];
                        temp[last]=Math.max(temp[last],points);
                    }
                 }
            }
            dp=temp;
        }
        return dp[3];
    }
       public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        return solve(m-1,n-1,dp);
    }
       static int solve(int m,int n,int[][] dp){
        if(m==0 && n==0){
            return 1;
        }
        if(m<0 || n<0){ 
            return 0;
        }
        if(dp[m][n]!=0){
            return dp[m][n];
        }
        dp[m][n]=solve(m-1,n,dp)+solve(m,n-1,dp);
        return dp[m][n];
    }
       public int uniquePaths1(int m, int n) {
        int dp[]=new int[m];
        return solve(m-1,n-1,dp);
    }
       static int solve(int m,int n,int[] dp){
        for(int i=0;i<m+1;i++){
            int temp[] =new int[n+1];
            for(int j=0;j<n+1;j++){
                 if(i==0 && j==0){
                    temp[i]=1;
                    continue;
                 } 
                 int up=0;
                 int down=0;
                if(i>0){
                     up=dp[j];
                }
                if(j>0){
                   down=temp[j-1];
                }
                temp[j]=up+down;
            }
            dp=temp;
        }
        return dp[n];
    }
       public int uniquePathsWithObstacles(int[][] ob) {
        if(ob[0][0]==1){
            return 0;
        }
        int m=ob.length;
        int n=ob[0].length;
         int dp[]=new int[m];
        return solve(ob,m-1,n-1,dp);
    }
       static int solve(int mat[][],int m,int n,int[] dp){
        for(int i=0;i<m+1;i++){
            int temp[] =new int[n+1];
            for(int j=0;j<n+1;j++){
                 if(i==0 && j==0){
                    temp[i]=1;
                    continue;
                 } 
                 if(mat[i][j]==1){
                    temp[j]=0;
                    continue;
                 }
                 int up=0;
                 int down=0;
                if(i>0){
                     up=dp[j];
                }
                if(j>0){
                   down=temp[j-1];
                }
                temp[j]=up+down;
            }
            dp=temp;
        }
        return dp[n];
    }
       public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[]=new int[n];
        return solve(m-1,n-1,grid,dp);
    }
       static int solve(int m,int n,int grid[][],int dp[]){
        for(int i=0;i<m+1;i++){
            int temp[]=new int[n+1];
            for(int j=0;j<n+1;j++){
                int up=0;
                int left=0;
                if(i==0 && j==0 ){
                    temp[j]=grid[i][j];
                    continue;
                }
                if(i>0){
                    up=dp[j];
                }
                else{
                    up=Integer.MAX_VALUE;
                }
                if(j>0){
                    left=temp[j-1];
                }
                else{
                    left=Integer.MAX_VALUE;
                }
                temp[j]=grid[i][j]+Math.min(left,up);
            }
            dp=temp;
        }
        return dp[n];
    }
       public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        List<List<Integer>> dp=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < triangle.get(i).size(); j++) {
                row.add(-1);  // Use -1 to indicate that the cell hasn't been computed yet
            }
            dp.add(row);
        }
        return solve(triangle,0,0,n,dp);
    }
       static int solve(List<List<Integer>> triangle,int i,int j,int n,List<List<Integer>> dp){
        if (i == n - 1) {
            return triangle.get(i).get(j);
        }
        
        // If dp[i][j] is already computed, return its value
        if (dp.get(i).get(j) != -1) {
            return dp.get(i).get(j);
        }
        
        // Recursive calls: move down and diagonally
        int down = solve(triangle, i + 1, j, n, dp);
        int diag = solve(triangle, i + 1, j + 1, n, dp);
        
        // Compute the minimum path sum for the current position
        dp.get(i).set(j, triangle.get(i).get(j) + Math.min(down, diag));
        
        // Return the computed value
        return dp.get(i).get(j);
    }
       public int minimumTotal1(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[] dp=new int[n];
        for (int j = 0; j < n; j++) {
            dp[j]=triangle.get(n - 1).get(j);
        }
        for (int i = n-2; i>=0; i--) {
            for (int j = 0; j <=i; j++) {
                   int up=0;
                   int diag=0;
                   up=dp[j];
                   diag=dp[j+1];
                   dp[j]=triangle.get(i).get(j) + Math.min(up, diag);
            }
        }
        return dp[0];
    }
       public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] dp=new int[m][n];
        int res=Integer.MAX_VALUE;
        for(int j=0;j<n;j++){ 
           int count= solve1(matrix,m-1,n-1-j,dp);
           res=Math.min(res,count);
        }
        return res;
    }
       static int solve1(int[][] mat,int m,int n,int[][] dp){
        for(int j=0;j<n+1;j++){
            dp[0][j]=mat[0][j];
        }
        for(int i=1;i<m+1;i++){
            for(int j=0;j<n+1;j++){
               int diag1=Integer.MAX_VALUE;
               int diag2=Integer.MAX_VALUE;
               int top=dp[i-1][j];
                 if(j>0)
                   diag1=dp[i-1][j-1];
                 if(j<mat[0].length-1)
                   diag2=dp[i-1][j+1];
                dp[i][j]=mat[i][j]+ Math.min(top,Math.min(diag1,diag2));
            }
        }
        return dp[m][n];
    }
       public int dim3(int n, int m, int grid[][]) {
		int dp[][][]=new int[n][m][m];
		return backtrack(0, 0, m-1 , n, m, grid,dp);
	}
       static int backtrack(int i, int j1, int j2, int n, int m, int grid[][],int[][][] dp) {
        // Base case: when we reach the last row
        if (i == n - 1) {
            if (j1 == j2) {
                return grid[i][j1];  // If both are at the same position, collect only one cherry
            } else {
                return grid[i][j1] + grid[i][j2];  // If at different positions, collect cherries from both
            }
        }
        if(dp[i][j1][j2]!=0){
			return dp[i][j1][j2];
		}
        // If any of the two people goes out of bounds, return a very negative value
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) {
            return Integer.MIN_VALUE;
        }

        // Try all combinations of movements for the two people (9 possible moves)
        for (int id1 = -1; id1 <= 1; id1++) {  // j1's possible movements: -1, 0, 1
            for (int id2 = -1; id2 <= 1; id2++) {  // j2's possible movements: -1, 0, 1
                // Calculate the value for the current row based on their positions
                   int newJ1 = j1 + id1;
            int newJ2 = j2 + id2;

            
            if (newJ1 < 0 || newJ1 >= m || newJ2 < 0 || newJ2 >= m) {
                continue;  // Skip this iteration and move to the next one
            }
				int value = 0;
                if (j1 == j2) {
                    value = grid[i][j1];  // Both people are at the same position
                } else {
                    value = grid[i][j1] + grid[i][j2];  // Collect cherries from both
                }

                // Recursively calculate the value for the next row
                value += backtrack(i + 1, j1 + id1, j2 + id2, n, m, grid,dp);

                // Track the maximum value among all possible moves
                dp[i][j1][j2] = Math.max(value,dp[i][j1][j2]  );
            }
        }

        return dp[i][j1][j2];  // Return the maximum cherries collected
    }
       static boolean subsetSumToK(int n, int k, int[] arr) {
        // Create a boolean DP table with dimensions [n][k+1]
        boolean dp[][] = new boolean[n][k + 1];
        
        // Initialize the first row of the DP table
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Initialize the first column of the DP table
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        // Fill in the DP table using bottom-up approach
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                // Calculate if the current target can be achieved without taking the current element
                boolean notTaken = dp[ind - 1][target];
                
                // Calculate if the current target can be achieved by taking the current element
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }
                
                // Store the result in the DP table
                dp[ind][target] = notTaken || taken;
            }
        }

        // The final result is stored in the bottom-right cell of the DP table
        return dp[n - 1][k];
    }   
       public int maximumPoint1s(int arr[][]) {
        int n=arr.length;
        int[] dp=new int[4];
        return solve(arr,n,dp);
    }
       static int solve1(int[][] arr,int n,int[] dp){
       dp[0]=Math.max(arr[0][1],arr[0][2]);
       dp[1]=Math.max(arr[0][0],arr[0][2]);
       dp[2]=Math.max(arr[0][0],arr[0][1]);
       dp[3]=Math.max(arr[0][1],Math.max(arr[0][2],arr[0][0]));
        for(int day=1;day<n;day++){
            int temp[]=new int[4];
            for(int last=0;last<4;last++){
                temp[last]=0;
                 for(int task=0;task<3;task++){
                    if(task!=last){
                        int points=arr[day][task]+dp[task];
                        temp[last]=Math.max(temp[last],points);
                    }
                 }
            }
            dp=temp;
        }
        return dp[3];
    }
       public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i: nums){
            sum+=i;   
        }
        if(sum%2!=0){
            return false;
        }
        return solve(0,nums,sum/2);
    }
       static boolean solve(int ind,int[] nums,int target){
        boolean dp[] =new boolean[target+1];
        
        if(nums[0]<=target){
            dp[nums[0]]=true;
        }
        dp[0]=true;
        for(int i=1;i<nums.length;i++){
            boolean curr[]=new boolean[target+1];
            curr[0]=true;
            for(int j=1;j<=target;j++){
                 boolean notpick=dp[j];
                 boolean pick=false;
                 if(nums[i]<=j){
                    pick=dp[j-nums[i]];
                 }
                 curr[j]= pick || notpick;
            }
            dp=curr;
        }
        return dp[target];
    }
       public static int minSubsetSumDifference(int [] nums, int n) {
        int sum=0;
        for(int i: nums){
            sum+=i;   
        }
        boolean dp[] = solve11(n,sum,nums);
        int s1=0;
        int s2=0;
        int res=Integer.MAX_VALUE;
        for(int i=0;i<=sum;i++){
             if(dp[i]){
                s1=i;
                s2=sum-i;
                res=Math.min(res,Math.abs(s1-s2));

             }
        }
        return res;
    }
       static boolean[] solve11(int n, int k, int[] arr) {
        // Create a boolean DP table with dimensions [n][k+1]
        boolean dp[][] = new boolean[n][k + 1];
        
        // Initialize the first row of the DP table
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Initialize the first column of the DP table
        if (arr[0] <= k) {
            dp[0][Math.abs(arr[0])] = true;
        }

        // Fill in the DP table using bottom-up approach
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                // Calculate if the current target can be achieved without taking the current element
                boolean notTaken = dp[ind - 1][target];
                
                // Calculate if the current target can be achieved by taking the current element
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }
                
                // Store the result in the DP table
                dp[ind][target] = notTaken || taken;
            }
        }
        return dp[n-1];
    }
       public int perfectSum(int[] ar, int target) {
        int dp[][]=new int[ar.length][target+1];
        return solve5(0, ar, target,dp);
 }
       static int solve5(int ind, int[] ar, int target,int[][] dp) {
     // Base case: if we have processed all elements
     if (ind == ar.length) {
         return target == 0 ? 1 : 0; // Return 1 if target is 0 (valid subset), otherwise 0
     }
     if(dp[ind][target]!=0){
         return dp[ind][target];
     }

     // Recursively consider two cases: pick or not pick the current element

     // Case 1: Pick the current element and reduce the target
     int pick=0;
     if(ar[ind]<=target){
         pick = solve5(ind + 1, ar, target - ar[ind],dp);
     }

     // Case 2: Do not pick the current element and move to the next
     int nonPick = solve5(ind + 1, ar, target,dp);

     // Return the sum of both cases
     return dp[ind][target]= pick + nonPick;
 }
       static int countPartitions(int[] arr, int d) {
    int sum=0;
    for(int i:arr){
        sum+=i;
    }
    if(((sum-d))%2==1 ||(sum-d)<0 ){
        return 0;
    }
    int dp[][] =new int[arr.length][(sum-d)/2 +1];
    return solve(arr.length-1,arr,(sum-d)/2,dp);
}
       static int solve(int ind, int[] ar, int target,int[][] dp) {
// Base case: if we have processed all elements
if(ind == 0){
   if(target==0 && ar[0]==0)
       return 2;
   if(target==0 || target == ar[0])
       return 1;
   return 0;
}

if(dp[ind][target]!=0){
    return dp[ind][target];
}

// Recursively consider two cases: pick or not pick the current element

// Case 1: Pick the current element and reduce the target
int pick=0;
if(ar[ind]<=target){
    pick = solve5(ind - 1, ar, target - ar[ind],dp);
}

// Case 2: Do not pick the current element and move to the next
int nonPick = solve5(ind - 1, ar, target,dp);

// Return the sum of both cases
return dp[ind][target]= pick + nonPick;
}
       static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
    int dp[][]=new int[n][maxWeight+1];
    return back(weight,value,n-1,maxWeight,dp);
   }
       static int back(int[] weight,int[] value,int n,int maxWeight,int[][] dp){
       if(n==0){
           if(maxWeight>=weight[0])
              return value[0];
           else{
               return 0;
           }
       }
       if(dp[n][maxWeight]!=0){
           return dp[n][maxWeight];
       }
       
       
       int pick=Integer.MIN_VALUE;
       if(weight[n]<=maxWeight){
           pick=value[n] + back(weight,value,n-1,maxWeight-weight[n],dp);
       }
       int nonpick= back(weight,value,n-1,maxWeight,dp);
       return dp[n][maxWeight]=Math.max(pick,nonpick);
   }
       public int coinChange(int[] coins, int amount) {
    int n=coins.length-1;
    int dp[]=new int[amount+1];
    int curr[]=new int[amount+1];
    for (int i = 0; i <= amount; i++) {
        if (i % coins[0] == 0)
            dp[i] = i / coins[0];
        else
            dp[i] = (int) Math.pow(10, 9);
    }

    for(int i=1;i<n+1;i++){
        for(int j=0;j<=amount;j++){
              int pick = (int)Math.pow(10,9);
               if (j >= coins[i]) {
                      pick = 1 + curr[j-coins[i]]; 
               }
               int notPick = dp[j];
                curr[j]=Math.min(pick, notPick);
        }
        dp=curr;
    }
    return dp[amount]==Math.pow(10,9) ? -1 : dp[amount];
}
        public int change( int T,int[] arr) {
    int[] prev = new int[T + 1];

       // Initialize base condition for the first element of the array
       for (int i = 0; i <= T; i++) {
           if (i % arr[0] == 0)
               prev[i] = 1;
           // Else condition is automatically fulfilled, as prev array is initialized to zero
       }

       // Fill the prev array using dynamic programming
       for (int ind = 1; ind < arr.length; ind++) {
           // Create an array to store results of subproblems for the current element
           int[] cur = new int[T + 1];
           for (int target = 0; target <= T; target++) {
               int notTaken = prev[target];

               int taken = 0;
               if (arr[ind] <= target)
                   taken = cur[target - arr[ind]];

               cur[target] = notTaken + taken;
           }
           prev = cur;
       }

       return prev[T];
}
       public int cutRod(int[] price) {
    int n=price.length;
     int dp[][] =new int[n+1][n];
    return backtrack(n-1,n,price,dp);
}
       static int backtrack(int ind,int n,int[] prices,int dp[][]){
    if(ind==0){
        return n*prices[0];
    }
    
    if(dp[n][ind]!=0){
        return dp[n][ind];
    }
    int rodlength=ind+1;
    int pick=0;
    if(n>=rodlength){
        pick=prices[ind]+backtrack(ind,n-rodlength,prices,dp);
    }
    int notpick=backtrack(ind-1,n,prices,dp);
    return dp[n][ind]= Math.max(pick,notpick);
    
}
       public List<String> all_longest_common_subsequences(String s, String t) {
        // Code here
        int m = s.length();
        int n = t.length();
        int dp[][] = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        Set<String> res = new LinkedHashSet<>();
        Map<String,Set<String>> dpMap = new HashMap<>();
        findLongestString(dp,s,t,m,n,res,new StringBuilder(),dpMap);
        List<String> ans = new ArrayList<>(res);
        Collections.sort(ans);
        return ans;
    }
       private void findLongestString(int[][] dp,String s,String t,int i,int j,Set<String> res,StringBuilder cur,Map<String,Set<String>> dpMap){    
        if(i==0 || j==0) {
            res.add(cur.reverse().toString());
            cur.reverse();
            return;
        }
        String key = i + "," + j + cur.toString();
        if (dpMap.containsKey(key)){
            res.addAll(dpMap.get(key));
            return;
        }
        if(s.charAt(i-1) == t.charAt(j-1)){
            cur.append(s.charAt(i-1));
            findLongestString(dp,s,t,i-1,j-1,res,cur,dpMap);
            cur.deleteCharAt(cur.length()-1);
        }
        else{ 
            // check two diagonals , thats why two if clause
            if(dp[i-1][j] == dp[i][j]){
                findLongestString(dp,s,t,i-1,j,res,cur,dpMap);
            
            }
            if(dp[i][j-1] == dp[i][j]){
                findLongestString(dp,s,t,i,j-1,res,cur,dpMap);
            }
        }
        dpMap.put(key,new HashSet<>(res));
    }
       public int longestCommonSubstr(String s, String t) {
        int m = s.length();
        int n = t.length();
        int dp[][] = new int[m+1][n+1];
        int maxi=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    maxi=Math.max(maxi,dp[i][j]);
                }else{
                    dp[i][j] =0;
                }
            }
        }
        return maxi;
    }
       public int longestPalindromeSubseq(String s) {
        StringBuilder s2=new StringBuilder(s);
        return gall_longest_common_subsequences(s,s2.reverse().toString());
    }
       public static int gall_longest_common_subsequences(String s, String t) {
        // Code here
        int m = s.length();
        int n = t.length();
        int dp[][] = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
       public int minInsertions(String s) {
        StringBuilder s2=new StringBuilder(s);
        return s.length()- gall_longest_common_subsequences(s,s2.reverse().toString());
    }
       public int minDistance(String word1, String word2) {
        return  word1.length() + word2.length()-2*(gall_longest_common_subsequences(word1,word2));
    }
       public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int dp[][] = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        StringBuilder ans=new StringBuilder();
        int i=m;
        int j=n;
        while(i>0 && j>0){
          if(str1.charAt(i-1)==str2.charAt(j-1)){
            ans.append(str1.charAt(i-1));
            i--;
            j--;
          }
          else if(dp[i-1][j]>dp[i][j-1]){
                ans.append(str1.charAt(i-1));
                i--;
            }
            else{ 
              ans.append(str2.charAt(j-1));
              j--;
            }
        }
        while(i>0){
           ans.append(str1.charAt(i-1));
           i--;
        }
        while(j>0){
            ans.append(str2.charAt(j-1));
            j--;
        }
        return ans.reverse().toString();
    }
       public int numDistinct(String s, String t) {
        return pall_longest_common_subsequences(s,t);
    }
       public int pall_longest_common_subsequences(String s, String t) {
        // Code here
        int m = s.length();
        int n = t.length();
        int dp[][] = new int[m+1][n+1];
        for (int i = 0; i < m+1 ; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n+1 ; i++) {
            dp[0][i] = 0;
        }
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
       public int miniDistance(String word1, String word2) {
        int dp[][]=new int[word1.length()][word2.length()];
        return backtrack(word1,word2,word1.length()-1,word2.length()-1,dp);
    }
       static int backtrack(String s,String t,int m, int n,int dp[][]){
        if(m<0){
            return n+1;
        }
        if(n<0){
            return m+1;
        }
        if(dp[m][n]!=0){
            return dp[m][n];
        }
        int mini=Integer.MIN_VALUE;
        if(s.charAt(m)==t.charAt(n)){
           return dp[m][n]=backtrack(s,t,m-1,n-1,dp);
        }
        else{
            int insert=1+backtrack(s,t,m,n-1,dp);
            int del=1+backtrack(s,t,m-1,n,dp);
            int rep=1+backtrack(s,t,m-1,n-1,dp);
            mini= Math.min(insert,Math.min(del,rep));
        }
        return dp[m][n]= mini;
    }
       public boolean isMatch(String s, String p) {
        boolean dp[][]=new boolean[s.length()+1][p.length()+1];
        return backtrack(s,p,s.length(),p.length(),dp);
    }
       static boolean backtrack(String s,String t,int m,int n,boolean[][] dp){
          dp[0][0]= true;
        for (int j = 1; j <= t.length(); j++) {
        if (t.charAt(j - 1) == '*') {
            dp[0][j] = dp[0][j - 1];
        } else {
            break; // If there's a character other than '*' in the pattern, break.
        }
    }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){ 
               if(s.charAt(i-1)==t.charAt(j-1) || t.charAt(j-1)=='?'){
                   dp[i][j]= dp[i-1][j-1];
                }
                else if(t.charAt(j-1)=='*'){
                      dp[i][j]= dp[i-1][j] || dp[i][j-1];
                }
                else{
                    dp[i][j]=false;
                }
             }
       }
       return dp[m][n];
    }
       public int maxProfit11(int[] prices) {
        int dp[]=new int[2];
        int next[]=new int[2];
        for(int i=prices.length-1;i>=0;i--){
                 dp[0]=Math.max (-prices[i]+next[1],next[0]);
                 dp[1]=Math.max (prices[i]+next[0],next[1]);
                 next=dp;
        }
        return next[0];
     }
       public int maxProfit111(int[] prices) {
        int dp[][][]=new int[prices.length+1][2][3];
        for(int i=prices.length-1;i>=0;i--){
                for(int k=1;k<=2;k++){
                         dp[i][0][k]=Math.max(-prices[i]+dp[i+1][1][k],dp[i+1][0][k]);
                         dp[i][1][k]=Math.max(prices[i]+dp[i+1][0][k-1],dp[i+1][1][k]);
            }
        }
        return dp[0][0][2];
    }
       public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        List<Integer> tail = new ArrayList<>();
        tail.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i]>tail.get(tail.size()-1)){
                  tail.add(nums[i]);
            }
            else{
                int ind=Collections.binarySearch(tail,nums[i]);
                if (ind < 0) {
                    ind = -ind - 1;
                }
                tail.set(ind,nums[i]);
            }
        }
        return tail.size();
    }
       public ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]) {
        int dp[] =new int[n];
        int hash[]=new int[n];
        Arrays.fill(dp,1);
        int lastIndex=0;
        int maxi=1;
        for(int i=0;i<n;i++){
            hash[i]=i;
            for(int prev=0;prev<i;prev++){
                if(arr[prev]<arr[i] && 1+dp[prev]>dp[i]){
                    dp[i]=1+dp[prev];
                    hash[i]=prev;
                }
            }
            if(dp[i]>maxi){
                maxi=dp[i];
                lastIndex=i;
            }
        }
        ArrayList<Integer> res=new ArrayList<>();
        res.add(arr[lastIndex]);
       while(hash[lastIndex]!=lastIndex){
            lastIndex=hash[lastIndex];
            res.add(arr[lastIndex]);
        }
        Collections.reverse(res);
        return res;
    }
       public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        return l1ongestIncreasingSubsequence(nums.length,nums);

    }
       public List<Integer> l1ongestIncreasingSubsequence(int n, int arr[]) {
        int dp[] =new int[n];
        int hash[]=new int[n];
        Arrays.fill(dp,1);
        int lastIndex=0;
        int maxi=1;
        for(int i=0;i<n;i++){
            hash[i]=i;
            for(int prev=0;prev<i;prev++){
                if(arr[i]%arr[prev]==0 && 1+dp[prev]>dp[i]){
                    dp[i]=1+dp[prev];
                    hash[i]=prev;
                }
            }
            if(dp[i]>maxi){
                maxi=dp[i];
                lastIndex=i;
            }
        }
        List<Integer> res=new ArrayList<>();
        res.add(arr[lastIndex]);
       while(hash[lastIndex]!=lastIndex){
            lastIndex=hash[lastIndex];
            res.add(arr[lastIndex]);
        }
        Collections.reverse(res);
        return res;
    }
       public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->{
        return a.length()-b.length();
});
        return longestIncreasingSubsequence(words.length, words);
    }
       public int longestIncreasingSubsequence(int n, String arr[]) {
        int dp[] =new int[n];
        Arrays.fill(dp,1);
        int maxi=1;
        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(solve(arr[prev],arr[i]) && 1+dp[prev]>dp[i]){
                    dp[i]=1+dp[prev];
                }
            }
            if(dp[i]>maxi){
                maxi=dp[i];
            }
        }
        return maxi;
    }
       static boolean solve(String s1,String s2){
        if(s1.length()+1!=s2.length()){
            return false;
        }
        int first=0;
        int second=0;
        while(second<s2.length()){
            if(first<s1.length() && s1.charAt(first)==s2.charAt(second)){
                first++;
                second++;
            }
            else{
                second++;
            }
        }
        return (first==s1.length() && second==s2.length());
    }
       public static int LongestBitonicSequence(int n, int[] arr) {
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        // Initialize both arrays with 1, as each element itself is a subsequence of length 1
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        // Calculate the lengths of increasing subsequences
        for (int i = 0; i < n; i++) {
            for (int prevIndex = 0; prevIndex < i; prevIndex++) {
                if (arr[prevIndex] < arr[i]) {
                    dp1[i] = Math.max(dp1[i], 1 + dp1[prevIndex]);
                }
            }
        }

        // Reverse the direction of nested loops and calculate the lengths of decreasing subsequences
        for (int i = n - 1; i >= 0; i--) {
            for (int prevIndex = n - 1; prevIndex > i; prevIndex--) {
                if (arr[prevIndex] < arr[i]) {
                    dp2[i] = Math.max(dp2[i], 1 + dp2[prevIndex]);
                }
            }
        }

        int maxi = 0;

        // Calculate the length of the longest bitonic subsequence
        for (int i = 0; i < n; i++) {
            if(dp1[i]!=1 && dp2[i]!=1)
                   maxi = Math.max(maxi, dp1[i] + dp2[i] - 1);
        }

        return maxi;
    }
       public int findNumberOfLIS(int[] nums) {
        return l11ongestIncreasingSubsequence(nums.length,nums);
    }
       public int l11ongestIncreasingSubsequence(int n, int arr[]) {
        int dp[] =new int[n];
        int cnt[]=new int[n];
        Arrays.fill(cnt,1);
        Arrays.fill(dp,1);
        int maxi=1;
        int maxcount=0;
        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(arr[prev]<arr[i] && 1+dp[prev]>dp[i]){
                    dp[i]=1+dp[prev];
                    cnt[i]=cnt[prev];
                }
                else if(arr[prev]<arr[i] && 1+dp[prev]==dp[i]){
                      cnt[i]+=cnt[prev];
                }
            }
            if(dp[i]>maxi){
                maxi=dp[i];
            }
        }
        for(int i=0;i<dp.length;i++){
            if(dp[i]==maxi){
                maxcount+=cnt[i];
            }
        }
        return maxcount;
    }
       public int minCut(String s) {
        int[] dp=new int[s.length()+1];
       return backtrack(s,0,dp)-1;
    }
       static int backtrack(String s,int ind,int dp[]){
        for(int i=s.length()-1;i>=ind;i--){
            int mincost=Integer.MAX_VALUE;
            for(int j=i;j<s.length();j++){ 
            if(ispalindrome(s,i,j)){
               int cost=1+dp[j+1];
                mincost=Math.min(mincost,cost);
            }
        }
        dp[i]=mincost;
      }
        return dp[0];
    }
       static boolean ispalindrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
       public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[]=new int[arr.length+1];
        return backtrack(arr,k,0,dp);
    }
       static int backtrack(int arr[],int k,int ind,int[] dp){
        for(int j=arr.length-1;j>=0;j--){ 
        int maxsum=0;
        int maxi=Integer.MIN_VALUE;
        int len=0;
        int sum=0;
        for(int i=j;i<Math.min(j+k,arr.length);i++){
            len++;
            maxi=Math.max(maxi,arr[i]);
            sum=(len*maxi)+dp[i+1];
            maxsum=Math.max(maxsum,sum);
        }
        dp[j]=maxsum;
    }
        return dp[0];
    }
       public int countSquares(int[][] matrix) {
        int dp[][]=new int[matrix.length][matrix[0].length];
        int cnt=0;
         for(int i=0;i<matrix.length;i++){
            dp[i][0]=matrix[i][0];
            cnt+=dp[i][0];
         }
         for(int i=1;i<matrix[0].length;i++){
            dp[0][i]=matrix[0][i];
            cnt+=dp[0][i];
         }
         for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]==1){
                    dp[i][j]=Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]))+1;
                     cnt+=dp[i][j];
                }
            }
         }
         return cnt;

    }
      public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return minCost(cost,n);
       }
        private static int minCost(int[] cost, int n) {
        int dp[] = new int[n];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<n;i++){
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[n-1], dp[n-2]);
      }
      
    public static void main(String[] args) {
        System.out.println(fibonacci1(5));
    }
}
