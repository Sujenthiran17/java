import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class slidingwindow {
    static int  sumarrayofK(int ar[],int k){
        int wsum=0;
        int maxsum=Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            wsum+=ar[i]; 
        }
        for(int i=k;i<ar.length;i++){
            wsum=wsum -ar[i-k]+ar[i];
            maxsum=Math.max(maxsum,wsum);
        }
        return maxsum;
    }
    static double findMaxAverage(int[] ar, int k) {
        double wsum=0;
        double maxsum=Double.NEGATIVE_INFINITY;
        for (int i = 0; i < k; i++) {
            wsum+=(ar[i]); 
        }
        maxsum=Math.max(maxsum,wsum/k);
        for(int i=k;i<ar.length;i++){
            wsum=(wsum -ar[i-k]+ar[i]);
            maxsum=Math.max(maxsum,wsum/k);
        }
        return maxsum;
    }
    static List<Integer> arraycountdstnct(int ar[],int k){
        List<Integer> list=new ArrayList<>();
        Map<Integer,Integer> M=new HashMap<>();
        for (int i = 0; i < k; i++) {
            M.put(ar[i], M.getOrDefault(ar[i], 0)+1);    
        }
        list.add(M.size());
        for (int i = k; i < ar.length; i++) {
            if(M.get(ar[i-k]) == 1){
                    M.remove(ar[i-k]);
            }
            else{
                M.put(ar[i-k], M.get(ar[i-k])-1);
            }
            M.put(ar[i], M.getOrDefault(ar[i], 0)+1);
                
            list.add(M.size());
        }
        return list;
    }
    static int[] arraynegatve(int[] ar,int n,int k){
        Queue<Integer> q=new LinkedList<>();
        int res[]=new int[n-k+1];
        for (int j = 0; j < k; j++) {
            if(ar[j]<0){
                q.offer(ar[j]);
            }
        }
        res[0]=(q.isEmpty()) ? 0 :q.peek();
        int ind=1;
       for (int i = k; i < n ; i++) {
               if(ar[i-k]<0){
                q.poll();
               }
               if(ar[i]<0){
                q.offer(ar[i]);
               }
               res[ind++]=(q.isEmpty()) ? 0 :q.peek();
       }
       return res;
    }
    static int[] max_of_subarrays(int ar[], int n, int k) {
     Deque<Integer> D=new ArrayDeque<>();
     int index=0;
     int[] res=new int[n-k+1];
     while (index<k) {
        while(!D.isEmpty() && ar[D.peekLast()]<=ar[index]){
            D.pollLast();
        }
        D.offerLast(index);     
        index++;
     }
     res[0]=ar[D.peekFirst()];
     for (int i = 1; i < n-k+1; i++) {
           if(!D.isEmpty() && D.peekFirst()<=i-1){
            D.pollFirst();
           }
           while(!D.isEmpty() && ar[D.peekLast()]<=ar[i+k-1]){
            D.pollLast();
        }
        D.offerLast(i+k-1);     
        res[i]=ar[D.peekFirst()];
     }
     return res;
     }
    static int strcountdstnct(String S,int k){
        List<Integer> list=new ArrayList<>();
        Map<Character,Integer> M=new HashMap<>();
        for (int i = 0; i < k; i++) {
            M.put(S.charAt(i), M.getOrDefault(S.charAt(i), 0)+1);    
        }
        list.add(M.size());
        for (int i = k; i < S.length(); i++) {
            if(M.get(S.charAt(i-k)) == 1){
                    M.remove(S.charAt(i-k));
            }
            else{
                M.put(S.charAt(i-k), M.get(S.charAt(i-k))-1);
            }
            M.put(S.charAt(i), M.getOrDefault(S.charAt(i), 0)+1);
                
            list.add(M.size());
        }
        int count =0;
        for (int i : list) {
            if(i==k-1){
                count++;
            }
        }
        return count;
        
    }
    static int max_of_min_subarrays(int ar[], int n, int k) {
        Deque<Integer> D=new ArrayDeque<>();
        int index=0;
        int[] res=new int[n-k+1];
        while (index<k) {
           while(!D.isEmpty() && ar[D.peekLast()]>=ar[index]){
               D.pollLast();
           }
           D.offerLast(index);     
           index++;
        }
        res[0]=ar[D.peekFirst()];
        for (int i = 1; i < n-k+1; i++) {
              if(!D.isEmpty() && D.peekFirst() < i-1){
               D.pollFirst();
              }
              while(!D.isEmpty() && ar[D.peekLast()]>=ar[i+k-1]){
               D.pollLast();
           }
           D.offerLast(i+k-1);     
           res[i]=ar[D.peekFirst()];
        }
        int max=Integer.MIN_VALUE;
        for (int i : res) {
            max=Math.max(max, i);
        }
        return max;
        }
    static int[] max_of_min_window(int ar[], int n) {
                Stack<Integer> s=new Stack<>();
                int[] left=new int[n];
                int right[]=new int[n];
                for (int i = 0; i < n; i++) {
                    left[i]=-1;
                    right[i]=n;
                }
                for (int i = 0; i < n; i++) {
                    while (!s.isEmpty() && ar[s.peek()] >=ar[i] ) {
                        s.pop();  
                    }
                    if(!s.isEmpty()){
                        left[i]=s.peek();
                    }
                    s.push(i);
                }
                s.clear(); 
                for (int i = n-1; i >=0; i--) {
                    while (!s.isEmpty() && ar[s.peek()] >=ar[i] ) {
                        s.pop();
                        
                    }
                    if(!s.isEmpty()){
                        right[i]=s.peek();
                    }
                    s.push(i);
                }
                int[] ans=new int[n+1];
                for (int i = 0; i < n; i++) {
                    int len=right[i] -left[i]-1;
                    ans[len]=Math.max(ans[len], ar[i]);
                }
                for (int i = n-1; i >=1; i--) {
                    ans[i] =Math.max(ans[i], ans[i + 1]);
                }
            
          return ans;
            
        }
    static ArrayList<Integer> possumarray(int ar[], int target){
        ArrayList<Integer> a=new ArrayList<>();
            int start=0;
            int csum=0;
            for (int end =0; end < ar.length; end++) {
                csum+=ar[end];
                while(csum>target && start<=end){
                    csum-=ar[start];
                    start++;
                }
                if(csum==target && start<=end){
                    a.add(start+1);
                    a.add(end+1);
                    return a;
                }
            }
            a.add(-1);
            return a;
    }  
    static int[] sumArray(int ar[] ,int target){
        HashMap<Integer,Integer> M=new HashMap<>();
        int start=0;
        int csum=0;
        for (int i = 0; i < ar.length; i++) {
             csum+=ar[i];
             if(csum==target){
                return new int[] {1,i+1};
             }
            
             if(M.containsKey(csum-target)){
                start=M.get(csum-target)+1;
                return new int[] {start +1,i+1};
             }
             M.put(csum, i);           
        }
        return null;
    } 
    static int lenOfLongSubarr (int ar[], int n, int target) {
        HashMap<Integer,Integer> M=new HashMap<>();
        int csum=0;
        int maxlen=0;
        for (int i = 0; i < n; i++) {
             csum+=ar[i];
             if(csum==target){
                maxlen=i+1;
             }
             if(M.containsKey(csum-target)){
                maxlen=Math.max(maxlen, i-M.get(csum-target));  
             }
             if(!M.containsKey(csum)){
                 M.put(csum, i);           
             }
        }
        return maxlen;
    }
    static int findSubString( String str) {
       Set<Character> s=new HashSet<>();
        for (char c:str.toCharArray()) {
            s.add(c); 
        }
        int len=s.size();
        Map<Character,Integer> m=new HashMap<>();
        int i=0;
        int j=0;
        int ans=str.length();
        while(i<str.length()){
            m.put(str.charAt(i),m.getOrDefault(str.charAt(i), 0)+1);
            if(m.size()==len){
               while(m.get(str.charAt(j))> 1){
                m.put(str.charAt(j),m.getOrDefault(str.charAt(j), 0)-1);
                j++;
               }
               ans=Math.min(ans,i-j+1);
            }
            i++;
        }
        return ans;      
    }
    static int smallestSubstring010(String  str) {
        if (str == null || str.length() < 3) {
            return -1; // Edge case: string is too short to contain 3 unique characters
        }
        Set<Character> s=new HashSet<>();
        for (char c:str.toCharArray()) {
            s.add(c); 
        }
        if(s.size()!=3){
            return -1;
        }
        int len=s.size();
        Map<Character,Integer> m=new HashMap<>();
        int i=0;
        int j=0;
        int ans=str.length();
        while(i<str.length()){
            m.put(str.charAt(i),m.getOrDefault(str.charAt(i), 0)+1);
            if(m.size()==len){
               while(m.get(str.charAt(j))> 1){
                m.put(str.charAt(j),m.getOrDefault(str.charAt(j), 0)-1);
                j++;
               }
               ans=Math.min(ans,i-j+1);
            }
            i++;
        }
        return ans;      
    }
    static String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        int l=0;
        int r=0;
        int minlength=Integer.MAX_VALUE;
        int formed=0;
        String mwindow="";
        Map<Character,Integer> m=new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            m.put(t.charAt(i), m.getOrDefault(t.charAt(i), 0)+1);
         }
         Map<Character,Integer> window=new HashMap<>();
         while(r < s.length()){
            char c=s.charAt(r);
                  window.put(c, window.getOrDefault(c, 0)+1);
                  if (m.containsKey(c) && window.get(c) == m.get(c)) {
                    formed++;
                  } 
                while( l<=r && formed==m.size() ){
                    char st=s.charAt(l);
                   if(minlength > r-l+1){ 
                    minlength=Math.min(minlength,r-l+1);                                             
                    mwindow = s.substring(l, r + 1);
                   }
                window.put(st, window.get(st)-1);
                if (m.containsKey(st) && window.get(st) < m.get(st)) {
                        formed--;
                } 
                l++;                 
                }
                r++;
         }
         return mwindow;
     }
    static int lengthOfLongestSubstring(String s) {
            int maxlen=0;
            //  for(int r=0,l=0;r<s.length();r++){
            //   int index=s.indexOf(s.charAt(r),l);
            //   if(index!=r){
            //       l=index+1;
            //   }
            //     maxlen=Math.max(maxlen,r-l+1);   
            // }
            // return maxlen;
            Map<Character,Integer> m=new HashMap<>();
            int l=0;int r=0;
            while(r<s.length()){
               char c=s.charAt(r);
                if(m.containsKey(c) && m.get(c)>=l){
                    l=m.get(c)+1;
                }
                maxlen=Math.max(maxlen,r-l+1);
                m.put(c, r);
                r++;
            }
            return maxlen;
        }
    static int maxLen(int[] arr, int n){
        HashMap<Integer, Integer> hM= new HashMap<>();
        int sum = 0;
        int max_len = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == 0) ? -1 : 1;
        }
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0) {
                max_len = i + 1;
            }
            if (hM.containsKey(sum)) {
             max_len  = Math.max(max_len,i-hM.get(sum));
            }
            else 
                hM.put(sum, i);
        }
        return max_len;
    }   
    static boolean anagram(String a,String p){
        if(a.length()!=p.length()){
            return false;
        }
        Map<Character,Integer> pmap=new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            pmap.put(p.charAt(i), pmap.getOrDefault(p.charAt(i), 0)+1);
        }
        for (int i = 0; i < a.length(); i++) {
            if(!pmap.containsKey(a.charAt(i)) || pmap.get(a.charAt(i))==0){
                return false;
            }
            pmap.put(a.charAt(i), pmap.getOrDefault(a.charAt(i), 0)-1);
        }

       return true;
    }
    static boolean mapMatch(Map<Character,Integer> map1,Map<Character,Integer> map2){
        return map1.equals(map2);
    }  
    static ArrayList<Integer> countAnagrams(String text, String word) {
        ArrayList<Integer> list=new ArrayList<>();
        Map<Character,Integer> w=new HashMap<>();
        Map<Character,Integer> t=new HashMap<>();
        for(int i=0;i<word.length();i++){
            w.put(word.charAt(i), w.getOrDefault(word.charAt(i), 0)+1);
        }
        for (int i = 0; i < word.length(); i++) {
            t.put(text.charAt(i), t.getOrDefault(text.charAt(i), 0)+1);
        }
        if(mapMatch(w, t)){
              list.add(0);
        }
        for (int i = word.length(); i < text.length(); i++) {
            t.put(text.charAt(i), t.getOrDefault(text.charAt(i), 0)+1);
            if(t.get(text.charAt(i-word.length()))==1){
                t.remove(text.charAt(i-word.length()));
            }
            else{
                t.put(text.charAt(i-word.length()), t.getOrDefault(text.charAt(i-word.length()), 0)-1);
            }
            if(mapMatch(w, t)){
                list.add(i-word.length()+1);
            }
        }
       return list;
      }
    static int longestOnes(int[] nums, int k) {
        int i=0,j=0,maxlen=0;
         while(i<nums.length){
             if(nums[i]==0){
                 k--;
             }
             if(k<0){
                 if(nums[j]==0){
                     k++;
                 }
                 j++;
             }
             maxlen = Math.max(maxlen, i - j + 1); 
             i++;
         }
       return maxlen;  
     }
    static int basketfruit(int ar[] ,int k){
        Map<Integer,Integer> m=new HashMap<>();
        int r=0;
        int l=0;
        int maxfruit=0;
        while(r<ar.length){
            m.put(ar[r], m.getOrDefault(ar[r], 0)+1);
            while(m.size()>2){
                if(m.get(ar[l])==1){
                    m.remove(ar[l]);
                }
                else{
                    m.put(ar[l], m.getOrDefault(ar[l], 0)-1);
                }
                l++;
            }
            maxfruit=Math.max(maxfruit,r-l+1);
            r++;
        }
        return maxfruit;
    }
    static int nicesubarray(int[] arr,int k){
    HashMap<Integer, Integer> hM= new HashMap<Integer, Integer>();
    int sum = 0;
    int count=0;
    int n=arr.length;
    for (int i = 0; i < n; i++) {
        arr[i] = (arr[i]%2== 0) ? 0 : 1;
    }
    for (int i = 0; i < n; i++) {
        sum += arr[i];
        if (sum == k) {
            count++;
        }
        if (hM.containsKey(sum)) {
            count+=hM.get(sum-k);
        }
        hM.put(sum, hM.getOrDefault(sum,0)+1);
    }
    return count;

    }
    static int characterReplacement(String s, int k) {
        Map<Character,Integer> m=new HashMap<>();
          int l=0;int r=0;
          int maxlen=0;
          while(r<s.length()){
           m.put(s.charAt(r), m.getOrDefault(s.charAt(r), 0)+1);
            while(((r-l+1)-Collections.max(m.values()))>k){
                   m.put(s.charAt(l), m.getOrDefault(s.charAt(l), 0)-1);
                    l++;                 
           }     
           maxlen=Math.max(maxlen, r-l+1);
           r++;
          }
          return maxlen;
   }    
    static String minwindowsubsequeString(String s,String t)  { 
        int n = s.length();
        int m = t.length();
        int startIndex = 0, i = 0, j = 0;
        int ans = Integer.MAX_VALUE;
        String x = "";
        while(j<n){
            char a = s.charAt(j);
            char b = t.charAt(i);
            if(i==0 && a!=b){
                startIndex++;
            }
            if(a==b){
                i++;
            }
             if( i==m){
                
                if(j-startIndex+1<ans){
                    ans = (j-startIndex+1);
                    x = s.substring(startIndex,j+1);
                }
                i=0;
                startIndex=j;
                startIndex++;
            
          }
            j++;
        }
        return x;
    }
    static int kdistinctsubarray(int ar[] ,int k){
        return kdistinctsubarrayexam(ar, k-1)-kdistinctsubarrayexam(ar, k);
    }
    static int kdistinctsubarrayexam(int ar[] , int k){
     Map<Integer,Integer> m=new HashMap<>();
     int r=0;
     int l=0;
     int ans=0;
     while(r<ar.length){
        m.put(ar[r], m.getOrDefault(ar[r], 0)+1);
        while(m.size()>k){
            if(m.get(ar[l])==1){
                m.remove(ar[l]);
                l++;
            }
            else{
               m.put(ar[l], m.getOrDefault(ar[l], 0)-1);
              l++;
            }
        }
        ans+=r-l+1;
        r++;
     }
     return ans;
   }
    static int almost(int nums[],int goal){  
    int ans=0;
    int i=0;
    int j=0;
    int sum=0;
   while(i<nums.length){
       sum+=nums[i];
       while(j<=i&&sum>goal){
        sum-=nums[j];
        j++;
       }
       ans+=i-j+1;
       i++;
   } 
   return ans;
}
    static int numSubarraysWithSum(int[] nums, int goal) {
       return almost(nums,goal)-almost(nums,goal-1);
   }
    static int maxScore(int[] C, int K) {
        int total = 0;
        for (int i = 0; i < K; i++) total += C[i];
        int best = total;
        for (int i = K - 1, j = C.length - 1; i >= 0; i--, j--) {
            total += C[j] - C[i];
            best = Math.max(best, total);
        }
        return best;
    } 
    static int minSubArrayLen(int target, int[] nums) {
    int r=0;
    int l=0;
    int sum=0;
    int minlen=Integer.MAX_VALUE;
    while(r<nums.length){
        sum+=nums[r];
        while(sum>=target){
            minlen=Math.min(minlen,r-l+1);
            sum-=nums[l];
            l++;
        }
        r++;
    }
     return (minlen == Integer.MAX_VALUE) ? 0 : minlen;
}
    static boolean checkInclusionpermutaton(String s1, String s2) {
    // Early return if s1 is longer than s2
    if (s1.length() > s2.length()) return false;

    // Create frequency map for s1
    HashMap<Character, Integer> s1Map = new HashMap<>();
    for (char c : s1.toCharArray()) {
        s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
    }

    // Create frequency map for the current window in s2
    HashMap<Character, Integer> s2Map = new HashMap<>();
    int left = 0; // Left pointer of the sliding window
    int right = 0; // Right pointer of the sliding window
    
    // Expand the window to include characters up to the length of s1
    while (right < s2.length()) {
        char rightChar = s2.charAt(right);
        s2Map.put(rightChar, s2Map.getOrDefault(rightChar, 0) + 1);
        
        // If the window size exceeds s1 length, shrink it from the left
        if (right - left + 1 > s1.length()) {
            char leftChar = s2.charAt(left);
            s2Map.put(leftChar, s2Map.get(leftChar) - 1);
            if (s2Map.get(leftChar) == 0) {
                s2Map.remove(leftChar);
            }
            left++;
        }

        // Compare the maps to see if they are equal
        if (s2Map.equals(s1Map)) {
            return true;
        }

        // Move the right pointer to expand the window
        right++;
    }

    // If no permutation is found, return false
    return false;
    
}
    // 25 problems
    static public int longestSquareStreak(int[] nums) {
         Arrays.sort(nums);
         Map<Integer,Integer> m=new HashMap<>();
         for(int i: nums){
            int root=(int)Math.sqrt(i);
            if((root*root==i) && m.containsKey(root)){
                m.put(i,m.getOrDefault(root,0)+1);
            }
            else{
                m.put(i,1);
            }
         }
        int longestStreak = 0;
        for (int streakLength : m.values()) {
            longestStreak = Math.max(longestStreak, streakLength);
        }
        return longestStreak == 1 ? -1 : longestStreak;
    }
    static public int maxVowels(String s, int k) {
        int maxVowelCount = 0;
        int currentVowelCount = 0;
        int n = s.length();
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < k && i < n; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                currentVowelCount++;
            }
        }
        maxVowelCount = currentVowelCount;
        for (int i = k; i < n; i++) {
            if (vowels.indexOf(s.charAt(i - k)) != -1) {
                currentVowelCount--;
            }
            if (vowels.indexOf(s.charAt(i)) != -1) {
                currentVowelCount++;
            }
            maxVowelCount = Math.max(maxVowelCount, currentVowelCount);
        }
        return maxVowelCount;
        }
    static public int longestConsecutive(int[] nums) {
            Set<Integer> numSet = new HashSet<>();
            for (int num : nums) {
                numSet.add(num);
            }
            int longest = 0;
            for (int num : nums) {
                if (!numSet.contains(num - 1)) {
                    int length = 1;
                    while (numSet.contains(num + length)) {
                        length++;
                    }
                    longest = Math.max(longest, length);
                }
            }
            return longest;        
        }
    static public long maximumSubarraySum(int[] nums, int k) {
        long res = 0;
        Map<Integer, Integer> m = new HashMap<>();
        long curSum = 0;    
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            curSum += nums[r];
            m.put(nums[r],m.getOrDefault(nums[r], 0) + 1);           
            if (r - l + 1 > k) {
                m.put(nums[l], m.get(nums[l]) - 1);
                if (m.get(nums[l]) == 0) {
                    m.remove(nums[l]);
                }
                curSum -= nums[l];
                l++;
            }    
            if (m.size() == k) {
                res = Math.max(res, curSum);
            }
        } 
        return res;
    }
    public static int[] findXSum(int[] nums, int k, int x) {
         int n = nums.length;
         int[] result = new int[n - k + 1];
         // Frequency map to count the occurrences of each element in the current window
         Map<Integer, Integer> freqMap = new HashMap<>();  
         // Fill the initial frequency map for the first window of size k
         for (int i = 0; i < k; i++) {
             freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
         }    
         int ind=0;
         // Process each sliding window
         for (int i = k; i <n; i++) {
             // Create a list of frequency map entries and sort them
             List<Map.Entry<Integer, Integer>> freqList = new ArrayList<>(freqMap.entrySet());   
             // Sort first by frequency (descending), and then by value (descending)
             freqList.sort((a, b) -> b.getValue() != a.getValue() ? b.getValue() - a.getValue() : b.getKey() - a.getKey());
             System.out.println(freqList);
             // Calculate the x-sum (sum of top x frequent elements)
             int sum = 0;
             for (int j = 0; j < x && j < freqList.size(); j++) {
                 int value = freqList.get(j).getKey();
                 int frequency = freqList.get(j).getValue();        
                 // Add the element's value multiple times based on its frequency
                 for (int f = 0; f < frequency; f++) {
                     sum += value;
                 }
             }
             result[ind++] = sum;     
             // Move the sliding window: remove the element going out and add the new element coming in
             if (i < n) {
                 int outgoing = nums[i-k];
                 int incoming = nums[i];       
                 // Decrease the count of the outgoing element
                 freqMap.put(outgoing, freqMap.get(outgoing) - 1);
                 if (freqMap.get(outgoing) == 0) {
                     freqMap.remove(outgoing);
                 }
                 // Add the incoming element
                 freqMap.put(incoming, freqMap.getOrDefault(incoming, 0) + 1);
             }
         }
         return result;
     }
    //3318
    static public int minimumDifference(int[] nums, int k) {
        if(k==1){
            return 0;
        }
        Arrays.sort(nums);
        int ans=Integer.MAX_VALUE;
        int i=0;
        int j=k-1;
        while(j<nums.length){
            ans=Math.min(ans,nums[j]-nums[i]);
            i++;
            j--;
        }
        return ans;
    }
    static public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length, l = 0;

        // Find the first nums[l] that satisfies all conditions
        while ((l < n) && ((nums[l] % 2 == 1) || (nums[l] > threshold))) {
            l++;
        }
        
        // Case when nums.length == 1 and nums[0] is odd
        if (l == n)     
            return 0;

        int maxLen = 1, r = l + 1, mod = 0;
        while (r < n) {
            mod = (r - l) % 2;
            if (nums[r] > threshold 
            || (mod == 1 && nums[r] % 2 == nums[l] % 2)   // Two consecutive elements have the same parity
            || (mod == 0 && nums[r] % 2 != nums[l] % 2))  // Two consecutive elements have different parity
            {
                // Find the next nums[l] that satisfies all conditions
                // because nums[r] does not satisfy
                l = r;
                while (l < n && (nums[l] > threshold || nums[l] % 2 == 1)) {
                    l++;
                }
                r = l + 1;
            } else {
                maxLen = Math.max(maxLen, r - l + 1);
                r++;
            }
        }

        return maxLen;
    }   
    public List<String> wordSubsets(String[] words1, String[] words2) { 
        Map<Character, Integer> maxFreq = new HashMap<>();
      
      for (String word : words2) {
          Map<Character, Integer> wordFreq = new HashMap<>();
          for (char c : word.toCharArray()) {
              wordFreq.put(c, wordFreq.getOrDefault(c, 0) + 1);
          }
          
          // Update the global maxFreq map with the maximum frequency required for each character
          for (Map.Entry<Character, Integer> entry : wordFreq.entrySet()) {
              char c = entry.getKey();
              int count = entry.getValue();
              maxFreq.put(c, Math.max(maxFreq.getOrDefault(c, 0), count));
          }
      }

      // Step 2: Check each word in words1
      List<String> result = new ArrayList<>();
      
      for (String word : words1) {
          Map<Character, Integer> wordFreq = new HashMap<>();
          for (char c : word.toCharArray()) {
              wordFreq.put(c, wordFreq.getOrDefault(c, 0) + 1);
          }

          // Check if the word is universal by comparing frequencies
          boolean isValid = true;
          for (Map.Entry<Character, Integer> entry : maxFreq.entrySet()) {
              char c = entry.getKey();
              int requiredCount = entry.getValue();
              if (wordFreq.getOrDefault(c, 0) < requiredCount) {
                  isValid = false;
                  break;
              }
          }

          if (isValid) {
              result.add(word);
          }
      }
      
      return result;
  }
    public static void main(String[] args) {
        int arr[]={-8, 2, 3, -6, 10};
        int res[]=arraynegatve(arr, arr.length, 2);
        for(int i :res){
            System.out.println(i);
        }
         
   
    
    }
    }