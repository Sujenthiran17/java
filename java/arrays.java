import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class arrays {
   static boolean sortOrNot(int ar[]){
        for (int i = 1; i < ar.length; i++) {
            if(ar[i]<ar[i-1]){
                 return false;
            }
        }
        return true;
    }
   static int removeDuplicates(int[] nums) {
        int k=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
               nums[k]=nums[i];
                k++;
            }
        }
        return k;
}
   static  boolean containsNearbyDuplicate(int[] nums, int k) { 
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)) {
            return true;
        }
        map.put(nums[i], i);
    }
    return false;
}
   static int[] productExceptSelf(int[] nums) {
    int[] prod=new int[nums.length];
    for(int i=0;i<nums.length;i++){
       prod[i]=1;
    }
    int temp=1;
    for(int i=0;i<nums.length;i++){
        prod[i]=temp;
        temp*=nums[i];
    }
    temp=1;
     for(int i=nums.length-1;i>=0;i--){
        prod[i]*=temp;
        temp*=nums[i];
    }
    return prod;
}
   public int maxAscendingSum(int[] nums) {
    int maxi=nums[0];
    int sum=nums[0];
    for(int i=1;i<nums.length;i++){
        if(nums[i]>nums[i-1]){
            sum+=nums[i];
        }
        else{
            sum=nums[i];
        }
        maxi=Math.max(maxi,sum);
    }
    return maxi;
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
   static void rotate(int ar[] ,int k){
       if(k<0){
        k=k+ar.length;
       } 
        k=k%ar.length;
        reverse_array(ar,0,k-1);
        reverse_array(ar,k,ar.length-1);
        reverse_array(ar,0,ar.length-1);
    }
   static void moveZeroes(int[] nums) {
        //twopointer
       int n=nums.length;
       if(n==0 || n==1){
           return;
       }
       int nz=0,z=0;
       while(nz<n){
           if(nums[nz]!=0){
               int temp=nums[nz];
               nums[nz]=nums[z];
               nums[z]=temp;
               nz++;
               z++;
           }
           else{
            nz++;
           }
       }
   }
   static void subarray(int[] ar){
    for (int i = 0; i < ar.length; i++) {
        for (int j = i; j < ar.length; j++) {
            for (int k = i; k<=j; k++) {
                System.out.print(ar[k] + " ");
            }
            System.out.println();
        }
    }
   }
   static void inversearray(int ar[]){
    int b[]=new int[ar.length];
    for (int i = 0; i < ar.length; i++) {
        int v=ar[i];
        b[v]=i;
    }
    for (int i = 0; i < ar.length; i++) {
        System.out.print(b[i] + " ");
    } 
   }
   static void leaderArray(int ar[]){
     int currentLead=ar[ar.length-1];
     System.out.println(currentLead);
     for (int i = ar.length-2; i >0; i--) {
        if(ar[i]>currentLead){
            currentLead=ar[i];
            System.out.println(currentLead);
        }   
     }
    }
   static void frequency(int ar[]){
    //      int freq=1;
    //      int i=1;
    //   while(i<ar.length){
    //      while(i<ar.length && ar[i]==ar[i-1]){
    //         freq++;
    //         i++;
    //      }
    //      System.out.println(ar[i-1] + " "+ freq);
    //      freq=1;
    //      i++;
    //     }
    //     if(ar[i-1]!=ar[i-2]){
    //         System.out.println(ar[i-1] + " "+ freq);
    //      }
    Map<Integer,Integer> m=new HashMap<>();
    for (int i = 0; i < ar.length; i++) {
        m.put(ar[i], m.getOrDefault(ar[i], 0)+1);
    }
    System.out.println(m);
    
     }
    //  for (int i = 0; i < ar.length; i++) { used for range 1 to n and to rint 0 freq
    //     ar[i]=m.getOrDefault(i+1,0);
    // }
    static int trapwater(int ar[]){
//     int ans=0;
//     for(int i=1;i<=ar.length-2;i++){
//         int lb=ar[i];
//         for(int j=0;j<i;j++){
//             if(ar[j]>lb){
//                 lb=ar[j];
//             }
//         }
//         int rb=ar[i];
//         for(int j=i+1;j<ar.length;j++){
//             if(ar[j]>rb){
//                 rb=ar[j];
//             }
//         }
//         int wl=Math.min(lb,rb);
//         int tw=wl-ar[i];
//         ans+=tw;
//     }
//     return ans;
//    }
    // int res=0;
    // int lb[]=new int[ar.length];
    // int rb[]=new int[ar.length];
    // lb[0]=ar[0];
    // for (int i = 1; i < ar.length-1; i++) {
    //    lb[i]=Math.max(lb[i-1],ar[i]);
    // }
    // rb[ar.length-1]=ar[ar.length-1];
    // for (int i = ar.length-2; i >=0; i--) {
    //     rb[i]=Math.max(ar[i],rb[i+1]);
    //  }
    //  for (int i = 1; i < ar.length-1; i++) {
    //     res=res+Math.min(rb[i],lb[i])-ar[i];
        
    //  }
    //  return res;
    // }
    int res=0;
    int l=0;
    int r=ar.length-1;
    int lb=ar[0];
    int rb=ar[ar.length-1];
    while(l<=r){
        if(lb<=rb){
            if(ar[l]>=lb){
                lb=ar[l];
            }
            else{
                res=res+lb-ar[l];
            }
            l++;
        }
         else{
                if(ar[r]>=rb){
                    rb=ar[r];
                }
                else{
                    res=res+rb-ar[r];
                }
                r--;
            }

         }
         return res;
        }
    static int findMaxConsecutiveOnes(int[] nums) {
            int count=0;
            int maxcount=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0){
                    count=0;
                }
                else{
                   count++;
                   maxcount= Math.max(maxcount,count);
                }
            }
            return maxcount;
        }
    static int maxSubArray(int[] nums) {
    //kadanes algo
    int sum=nums[0];
    int maxsum=nums[0];
    for(int i=1;i<nums.length;i++){
        if(sum>=0){
            sum=sum+nums[i];           
        }
        else{
            sum=nums[i];
        }
        maxsum=Math.max(sum,maxsum);
    }
    return maxsum;
    
}
    static int maxProductSubarray(int[] nums) {
         double pref=1;
         double suf=1;
         double maxprod=Integer.MIN_VALUE;
          for(int i=0;i<nums.length;i++){
              if(pref==0){
               pref=1;
              }
              if(suf==0){
                suf=1;
              }
            pref=pref*nums[i];
            suf=suf*nums[nums.length-1-i];
            maxprod=Math.max(maxprod,Math.max(pref,suf));
    }
    return (int)maxprod;
}
    static int majorityElement(int[] nums) {
    int maj=nums[0];
    int count=1;
    for(int i=1;i<nums.length;i++){
        if(nums[i]==maj){
            count++;
        }
        else{
            count--;
        }
        if(count==0){
            maj=nums[i];
            count=1;
        }
    }
    return maj;
}
    static int alteroddeve(int ar[]){
    int count=1;
    int maxcount=1;
    for (int i = 1; i < ar.length; i++) {
        if((ar[i]%2==0 && ar[i-1]%2!=0 )|| (ar[i]%2!=0 && ar[i-1]%2==0)){
            count++;
            maxcount=Math.max(maxcount, count);
        }
        else{
            count=1;
        }    
    }
    return maxcount;
   }
    static boolean canBeEqual(int[] target, int[] arr) {
    // Arrays.sort(target);
    // Arrays.sort(arr);
    // for (int i = 0; i < arr.length; i++) {
    //     if(arr[i]!=target[i]){
    //         return false;
    //     } 
    //     }
    //     return true;     
    // }
            int[] arr1 = new int[1001];
            for(int i = 0;i<arr.length;i++){
                arr1[arr[i]]++;
                arr1[target[i]]--;
            }
            for(int i = 0;i< 1001;i++)
                if(arr1[i] != 0)
                    return false;
            return true;
        }
    static int noOfflip(int ar[]){
        int count=0;
    for (int i = 1; i < ar.length; i++) {
        if(ar[i]!=ar[i-1]){
            if(ar[i]!=ar[0]){
                count++;
            }
        }
    }
    return count;
   } 
    static int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int prefix = 0;
            for (int j = i; j < n; j++) {
                prefix += nums[j];
                arr.add(prefix);
            }
        }
        Collections.sort(arr);
        int result = 0;
        int MOD = 1000000007;
        for (int i = left - 1; i < right; i++) {
            result = (result + arr.get(i)) % MOD;
        }
        return result;
    }
    static int removeDuplicates2(int[] nums) {
        int n = nums.length;
       if(n<=2){
         return n;
       }
            int j = 2;
        for(int i=2; i<n; i++){
         if(nums[i] != nums[j-2]){
            nums[j] = nums[i];
              j++;
           } 
           }
        return j;
        }
    static public int[] rearrangeArray(int[] nums) {
        int ans[]=new int[nums.length];
        int pos=0;
        int neg=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                ans[pos]=nums[i];
                pos+=2;
            }
            else{
                ans[neg]=nums[i];
                neg+=2;
            }
        }
        return ans;
    }
    static  public int subarraySum(int[] arr, int k) {
        Map<Integer, Integer> hM= new HashMap<Integer, Integer>();
        int sum = 0;
        int count=0;
        int n=arr.length;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == k) {
                count++;
            }
            if (hM.containsKey(sum-k)) {
                count+=hM.get(sum-k);
            } 
            hM.put(sum, hM.getOrDefault(sum,0)+1);
        }
        return count;
        }
    static  public List<Integer> majorityElement11(int[] nums) {
        int ele1=Integer.MIN_VALUE;
        int ele2=Integer.MIN_VALUE;
        int c1=0;
        int c2=0;
        for(int i=0;i<nums.length;i++){
            if(c1==0 && nums[i]!=ele2){
                c1=1;
                ele1=nums[i];
            }
            else if(c2==0 && nums[i]!=ele1){
                c2=1;
                ele2=nums[i];
            }
            else if(nums[i]==ele1){
                c1++;
            }
            else if(nums[i]==ele2){
                c2++;
            }
            else{
                c1--;
                c2--;
            }
        }
        List<Integer> ans=new ArrayList<>();
        c1=0;c2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==ele1){
                c1++;
            }
            if(nums[i]==ele2){
                c2++;
            }
        }
        if(c1>nums.length/3){
            ans.add(ele1);
        }
        if(c2>nums.length/3){
            ans.add(ele2);
        }
        return ans;
    }
    static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int total = nums[i] + nums[j] + nums[k];

                if (total > 0) {
                    k--;
                } else if (total < 0) {
                    j++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    
                    j++;
                     k--;
                    while (nums[j] == nums[j-1] && j < k) {
                        j++;
                    }
                     while (nums[k] == nums[k+1] && j < k) {
                      k--;  
                    }
                }
            }
        }
        return res;      
    }
    static int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
     int closestSum = nums[0] + nums[1] + nums[2]; 
    for (int i = 0; i < nums.length; i++) {
        if (i > 0 && nums[i] == nums[i-1]) {
            continue;
        }
        
        int j = i + 1;
        int k = nums.length - 1;

        while (j < k) {
            int total = nums[i] + nums[j] + nums[k];
             if(Math.abs(target-total) < Math.abs(target-closestSum)) {
                closestSum=total;
               } 
            else if (total > target) {
                k--;
            } else{
                j++;
            } 
            }
        }
    return closestSum ;      
}
    static int countTriplet(int nums[], int n) {
    Arrays.sort(nums);
    int count = 0;
    for (int i = n-1; i >-1; i--) {
      int j = 0;
      int k = i -1;
      while (j < k) {
        int total =  nums[j] + nums[k];
         if(nums[i]-total==0) {
            count++;
            j++;
            k--;
            
           } 
        else if (total > nums[i]) {
            k--;
        } else{
            j++;
        } 
        }
    }
return count;      
}
    static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
         if (nums == null || nums.length < 4) {
            return new ArrayList<>() ;
        }
        // long sum=0;
        // if (nums.length== 4) {
        //     for (int i = 0; i < nums.length; i++) {
        //         sum+=nums[i];
        //     }
        //     if(sum==target){
        //         res.add(Arrays.asList(nums[0],nums[1], nums[2], nums[3]));
        //     }  
        //     else{
        //         new ArrayList<>();
        //     }  
        //     return res;
        // }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int n = i+1; n < nums.length-2; n++) {
            if (n!=i+1 && nums[n] == nums[n-1]) {
                continue;
            }
            
            int j = n + 1;
            int k = nums.length - 1;

            while (j < k) {
                long total =(long) nums[i] +(long)nums[n] + (long)nums[j] + (long)nums[k];

                if (total > target) {
                    k--;
                } else if (total < target) {
                    j++;
                } else {
                    res.add(Arrays.asList(nums[i],nums[n], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j-1]) {
                        j++;                        
                    }
                     while (j < k && nums[k] == nums[k+1]) {
                      k--;                   
                    }
                }
            }
            }
        }
        return res;   
    }     
    static  int maxSubarraySumCircular(int[] nums) {
        int maxKadane = kadane(nums);
        int totalSum = 0;
        int minSubarraySum =nums[0];
        int currentMinSum = 0;
        for (int num : nums) {
            totalSum += num;
            currentMinSum = Math.min(currentMinSum + num, num);
            minSubarraySum = Math.min(minSubarraySum, currentMinSum);
        }
        int maxCircular = totalSum - minSubarraySum;
        return maxCircular > 0 ? Math.max(maxKadane, maxCircular): maxKadane;
    }   
    private static int kadane(int[] nums) {
       int sum=nums[0];
        int maxsum=nums[0];
        for(int i=1;i<nums.length;i++){
            if(sum>=0){
                sum=sum+nums[i];           
            }
            else{
                sum=nums[i];
            }
            maxsum=Math.max(sum,maxsum);
        }
        return maxsum;
    }
    static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 != 10) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }   
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;        
    }
//    30 problems
    public int pivotIndex(int[] nums) {
      int leftsum=0;
      int totalsum=0;
      for(int i:nums){
        totalsum+=i;
      }
      for(int i=0;i<nums.length;i++){
        totalsum=totalsum-nums[i];
         if(totalsum==leftsum){
           return i;
         }
       leftsum+=nums[i];
    }
    return -1;
}
    static public int largestAltitude(int[] gain){
        int currentAltitude = 0; 
        int maxAltitude = 0;      
        for (int g : gain) {
           currentAltitude += g; 
           maxAltitude = Math.max(maxAltitude, currentAltitude);
        }
       return maxAltitude;
}
    public int longestMonotonicSubarray(int[] nums) {
       if(nums.length==1){
        return 1;
        }
    int inc=1;
    int dec=1;
    int maxi=0;
    for(int i=1;i<nums.length;i++){
        if(nums[i]>nums[i-1]){
            inc++;
            dec=1;
        }
        else if(nums[i]<nums[i-1]){
            dec++;
            inc=1;
        }
        else{
            dec=1;
            inc=1;
        }
        maxi=Math.max(maxi,Math.max(inc,dec));
    }
    return maxi;
}
    static public boolean closeStrings(String word1, String word2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char ch : word1.toCharArray()) {
            freq1[ch - 'a']++;
        }

        for (char ch : word2.toCharArray()) {
            freq2[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0)) {
                return false;
            }
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }
    public int equalPairs(int[][] grid) {
        int i=0;
        int j=0;
        int ans=0;
        int n=grid.length;
        int tran[][]=new int[n][n];
        while(j<n){
         tran[j][i]=grid[i][j];
         i++;
         if(i>=n){
            i=0;
            j++;
         }
        }
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                System.out.print(tran[r][c]);
            }
            System.out.println();
        }
        i=0;
        j=0;
        while(i<n){
            if(Arrays.equals(grid[i],tran[j])){
                ans++;
            }
            j++;
            if(j>=n){
                j=0;
                i++;
            }
        }
        return ans;
    }
    public  static boolean isprime(int n){
        if(n==0|| n==1){
            return false;
        }
        if(n==2){
            return true;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static boolean primeSubOperation(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int largest=0;
        for(int i:nums){
            largest=Math.max(largest,i);
        }
        for(int i=0;i<largest;i++){
            if(isprime(i)){
                list.add(i);
            }
        }
       int index=findmaxprime(list,0,nums[0]);
       if (index != -1) {
            nums[0] -= list.get(index);
        }

        for (int i = 1; i < nums.length; i++) {
            index = findmaxprime(list, nums[i - 1], nums[i]);
            if (index == -1 && nums[i] <= nums[i - 1]) {
                return false;
            } else if (index != -1) {
                nums[i] -= list.get(index);
            }
        }
                
        return true;
    }
    public static int findmaxprime(List<Integer> primes,int prev,int curr){
        int left=0;
        int right=primes.size()-1;
        int mid=0;
        while(left<=right){
            mid=(left+right)/2;
            if(curr-primes.get(mid)<=prev){
                right=mid-1;
            }
            else {
                left=mid+1;
            }
        }
        mid = right;
        if (mid >= 0 && curr - primes.get(mid) <= prev) {
            return -1;
        }
        return mid;
    }
    public static int findLengthOfShortestSubarray(int[] arr) {
        int n=arr.length;
        int left=0;
        int right=n-1;
        while(left + 1 < n && arr[left]<=arr[left+1]){
            left++;
        }
         if (left == n - 1) return 0;
        while( right >0 && arr[right-1]<=arr[right]){
            right--;
        }
        int result=Math.min(n-left-1,right);
        int i=0;
        int j=right;
        while(i<=left && j<n){
            if(arr[i]<=arr[j]){
                result=Math.min(result,j-i-1);
                i++;
            }
            else{
                j++;
            }
        }
        return result;
    }
    static public int[] resultsArray(int[] nums, int k) {
        if (k == 1) {
            return nums; // If k is 1, every single element is a valid subarray
        }
        int length = nums.length;
        int[] result = new int[length - k + 1];
        Arrays.fill(result, -1); // Initialize results to -1
        int consecutiveCount = 1; // Count of consecutive elements
        for (int index = 0; index < length - 1; index++) {
            if (nums[index] + 1 == nums[index + 1]) {
                consecutiveCount++;
            } else {
                consecutiveCount = 1; // Reset count if not consecutive
            }

            // If we have enough consecutive elements, update the result
            if (consecutiveCount >= k) {
                result[index - k + 2] = nums[index + 1];
            }
        }
        return result;
    }
    public int[] decrypt(int[] code, int k) {
        int[] res=new int[code.length];
        if(k==0){
            return res;
        }
        int[] ans=new int[code.length*2];
        for(int i=0;i<code.length*2;i++){
                ans[i]=code[i%code.length];
        }
        int j=0;
        if(k>0){
            for(int i=0;i<code.length;i++){
                j=i;
                while(j-i<k){
                  res[i]+=ans[j+1];
                  j++;
                }
            }
        }
        if(k<0){
            for(int i=code.length;i<code.length*2;i++){
                j=i;
                while(i-j<Math.abs(k)){
                  res[i-code.length]+=ans[j-1];
                  j--;
                }
            }
        }
        return res;
    }
    public static int[] missnumandrep(int ar[],int n){
        int s1=(n*(n+1))/2;
        int sn1=(n*(n+1)*(2*n+1))/6;
        int sum=0;
        int sum2=0;
        for(int i:ar){
            sum+=i;
            sum2+=i*i;
        }
        long val1=s1-sum;
        long val2=sn1-sum2;
        val2=val2/val1;
        long x=(val1+val2)/2;
        long y=x-val1;
        return new int[] {(int)x,(int)y};
    }
    static boolean knows(int a,int b,int[][] mat){
        return mat[a][b]==1;
    }
    public int celebrity(int mat[][]) {
        int n=mat.length;
        int celeb=0;
        for(int i=0;i<n;i++){
            if(knows(celeb,i,mat)){
                celeb=i;
            }
        }
        for(int i=0;i<n;i++){
            if(i!=celeb){
                if(knows(celeb,i,mat) || !knows(i,celeb,mat)){
                    return -1;
                }
            }
        }
        return celeb;
    }
    public int[] queryResults(int limit, int[][] queries) {// 3160
        int n = queries.length;
        int[] result = new int[n];
        Map<Integer, Integer> colorMap = new HashMap<>();
        Map<Integer, Integer> ballMap = new HashMap<>();

        // Iterate through queries
        for (int i = 0; i < n; i++) {
            // Extract ball label and color from query
            int ball = queries[i][0];
            int color = queries[i][1];

            // Check if ball is already colored
            if (ballMap.containsKey(ball)) {
                // Decrement count of the previous color on the ball
                int prevColor = ballMap.get(ball);
                colorMap.put(prevColor, colorMap.get(prevColor) - 1);

                // If there are no balls with previous color left, remove color from color map
                if (colorMap.get(prevColor) == 0) {
                    colorMap.remove(prevColor);
                }
            }
            // Set color of ball to the new color
            ballMap.put(ball, color);

            // Increment the count of the new color
            colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);

            result[i] = colorMap.size();
        }
        return result;
    }
    public int maximumSum(int[] nums) { // 2342
        int[] mp = new int[82];
        Arrays.fill(mp, -1);
        int ans = -1;

        for (int num : nums) {
            int sumDigits = 0, temp = num;
            while (temp > 0) {
                sumDigits += temp % 10;
                temp /= 10;
            }

            if (mp[sumDigits] != -1)
                ans = Math.max(ans, num + mp[sumDigits]);

            mp[sumDigits] = Math.max(mp[sumDigits], num);
        }
        return ans;
    }
    public static void main(String[] args) {  
        int arr[]={1,1,0,0,1,0,0,1,0,1,1};    
        System.out.println(noOfflip(arr));  
    }
    
}
