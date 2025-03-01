
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class stringnumber {
    public int maxDepth(String s) {
        int ans = 0;
      int openBrackets = 0;

      for (Character c : s.toCharArray()) {
          if (c == '(') {
              openBrackets++;
          } else if (c == ')') {
              openBrackets--;
          }

          ans = Math.max(ans, openBrackets);
      }

      return ans;
  }
    public String largestOddNumber(String nums) {
        for(int i=nums.length()-1;i>=0;i--){
            if((nums.charAt(i)-'0')%2==1){
                return nums.substring(0,i+1);
            }
        }
        return "";
    }
    static int substrings(String s, String x)
    // {
    //     int count=0;
    //    for(int i=0;i<s.length()-x.length() +1;i++){
    //     count=0;
    //        for(int j=0;j<x.length();j++){
    //            if(s.charAt(i+j)==x.charAt(j)){
    //                count++;
    //            }
    //        }
    //        if(count==x.length()) return i;
    //    }
    //    return -1;    
    // }
    {
        int n = s.length();
        int m = x.length();
        if (m > n) return -1;
        for (int i = 0; i <= n - m; i++) {
            if (s.substring(i, i + m).equals(x)) {
                return i;             
            }
        }
        return -1;
    }
    static String sortString(String arr) {
        // Step 1: Initialize count array for 26 letters
        int[] count = new int[26];
        // Step 2: Count occurrences of each letter
        for (int i = 0; i < arr.length(); i++) {
            count[arr.charAt(i) - 'a']++;
        }
        // Step 3: Build the sorted string
        StringBuilder sortedString = new StringBuilder();
        // Traverse the count array
        for (int i = 0; i < 26; i++) {
            // Append character ('a' + i) count times
            while (count[i] > 0) {
                sortedString.append((char) ('a' + i));
                count[i]--;
            }
        } 
        return sortedString.toString();
    }
    static int sumstring(String s){
        int sum=0;
        for (int i = 0; i < s.length(); i++) {
                if(Character.isDigit(s.charAt(i))){
                    // sum+=Character.getNumericValue(s.charAt((i)));
                    sum+=(s.charAt(i)-'0');
                }    
        }
        return sum;
    }
     static int sumstring2(String s){
        String temp="0";
        int sum=0;
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                temp+=ch;
            }
            else{
                    sum+=Integer.parseInt(temp);
                    temp="0";
            }   
        }
        sum+=Integer.parseInt(temp);
        return sum;
    }
    static String addBinary(String a, String b){
      StringBuilder sb = new StringBuilder();
      int carry = 0;
      int i = a.length() - 1;
      int j = b.length() - 1;
      while (i >= 0 || j >= 0 || carry == 1) {
        if(i >= 0)
          carry += a.charAt(i--) - '0';
        if(j >= 0)
          carry += b.charAt(j--) - '0';
        sb.append(carry % 2);
        carry /= 2;
      }
      return sb.reverse().toString();
    }
    static String addStrings(String num1, String num2){
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += num2.charAt(j--) - '0';
            }
            result.append(sum % 10);
            carry = sum / 10;
        }
        return result.reverse().toString();
    }
    static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1 + len2];

        // Multiply each digit and store results in the result array
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';
                int sum = digit1 * digit2 + result[i + j + 1];
                result[i + j + 1] = sum % 10; // Place the current digit
                result[i + j] += sum / 10; // Carry over
            }
        }  
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }
        return sb.toString();
    }
    static public int titleToNumber(String s) {
        int res=0;
        for(int i=0;i<s.length();i++){
            res=res*26+(s.charAt(i)-'A'+1);
        }
        return res;
    }
    static String convertToTitle(int columnNumber) {
        StringBuilder str = new StringBuilder();
            while (columnNumber > 0) {
              int index = (columnNumber - 1) % 26;
              str.insert(0, (char)('A' + index));
              columnNumber = (columnNumber-1) / 26;
            }
            return str.toString();
        }
    static int sqroot(int n){
        for (int i = 0; i < n/2; i++) {
            if(i*i==n){
                return i;
            }            
        }
        return -1;
    }
    static boolean isSubsequence(String s, String t) {
        if(s.length()==0){
            return true;
        }
        if (s.length() > t.length()){
            return false;
        }
        int i=0;
        int j=0;
        while(i<t.length()){
            if(s.length()>j && s.charAt(j)==t.charAt(i)){
                j++;
            }
            i++;
        }
        return j==s.length();
    }
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)){
            return true;
        }
        int count=0;
        int i=0;
        int first=0;
        int second=0;
        while(i<s1.length()){
            if(s1.charAt(i)!=s2.charAt(i)){
                count++;
            if(count>2){
                return false;
            }
            else{
                if(count==1){
                    first=i;
                }
                if(count==2){
                    second=i;
                }
            }
            }
            i++;
        }
        return (s1.charAt(first)==s2.charAt(second)) && (s2.charAt(first)==s1.charAt(second));
    }
    static  boolean isPalindrome(String s) {
        int l=0;
        int r=s.length()-1;
        while(l<r){
            if(!Character.isLetterOrDigit(s.charAt(l))){
                   l++;
            }
            else if(!Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }
            else{
            if(Character.toLowerCase(s.charAt(l))!=Character.toLowerCase(s.charAt(r))){
                return false;
            }
            l++;
            r--;
            }
        }
        return true;
    }
    static  boolean validPalindrome(String s) {
        int left=0;
        int right=s.length()-1;
         while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                // Try skipping left character
                if (ispal(s, left + 1, right)) {
                    return true;
                }
                // Try skipping right character
                if (ispal(s, left, right - 1)) {
                    return true;
                }
                // If neither skipping works, return false
                return false;
            }
        }
        return true;       
    }
    public static boolean ispal(String s,int l,int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            else{
                l++;
                r--;
           }
        }
        return true;
    }
    static public int myAtoi(String s) {
        s=s.trim();
        if(s.isEmpty()){
            return 0;
        }
        int sign=1;
        long ans=0;
        int i=0;
          if (s.charAt(0) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(0) == '+') {
            i++;
        }
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            ans=ans*10+(s.charAt(i)-'0');
            if(sign==-1 && -ans<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            if(sign==1 && ans>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            i++;
        }
         return (int)(sign*ans);
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Find the shortest string in the array
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        // Binary search on the prefix length
        int low = 0, high = minLength;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isCommonPrefix(strs, mid)) {
                low = mid + 1;  // Try for a longer prefix
            } else {
                high = mid - 1;  // Try for a shorter prefix
            }
        }

        // Return the prefix up to the high length
        return strs[0].substring(0,high);
    }
    private static boolean isCommonPrefix(String[] strs, int len) {
        String prefix = strs[0].substring(0, len);
        for (String str : strs) {
            if (!str.startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }
    public String intToRoman(int num) {
        String ones[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String tens[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String hrns[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String ths[] = {"","M","MM","MMM"};
        
        return ths[num / 1000] + hrns[(num % 1000) / 100] + tens[(num % 100) / 10] + ones[num % 10];
    }
    static String toLowerCase(String s) {
        String new_s="";
        for(int i=0; i<s.length();i++){
            if (s.charAt(i)<='Z' && s.charAt(i)>='A'){
                char c=(char)(s.charAt(i)+32);
                new_s+=c;
            }
            else{
               new_s+=s.charAt(i);
            }
        }
        return new_s;
    }
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;
        HashMap<Character, Character> hm = new HashMap<>();
        int i =0; 
        while(i < s.length()){
            if(hm.containsKey(s.charAt(i))){
                if(hm.get(s.charAt(i)) != t.charAt(i))
                    return false;
            }else if(hm.containsValue(t.charAt(i))){
                return false;
            }
            
            hm.put(s.charAt(i), t.charAt(i));
            i++;                
        }
        return true;
    }
    static boolean wordPattern(String pattern, String s) {
        Map<Character, String> mp = new HashMap<>();   
        String arr[] = s.split(" ");
        if (arr.length != pattern.length())
            return false;
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (mp.containsKey(ch)) {
                if (!mp.get(ch).equals(arr[i])) {
                    return false;
                }
            } 
            else {
                if (mp.containsValue(arr[i])) {
                    return false;
                }
                mp.put(ch, arr[i]);
            }
        }
        return true;
    }
    static String reverseVowels(String s) {
        char[] word = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        String vowels = "aeiouAEIOU";       
        while (start < end) {
            if(start < end && vowels.indexOf(word[start]) == -1) {
                start++;
            }
            else if(start < end && vowels.indexOf(word[end]) == -1) {
                end--;
            }
            else{
            char temp = word[start];
            word[start] = word[end];
            word[end] = temp;
            start++;
            end--;
            }
        }
        return String.valueOf(word);
    }
    static int firstUniqChar(String s) {
        Map<Character,Integer> m=new HashMap<>();
        for(int i=0;i<s.length();i++){
          m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0)+1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (m.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
    static char findTheDifference(String s, String t) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans ^= s.charAt(i);
            ans ^= t.charAt(i);
        }
        ans ^= t.charAt(t.length() - 1);
        return (char) ans;
    }
    static List<String> fizzBuzz(int n) {
        List<String>arr=new ArrayList<>(n);
        for(int i=1;i<=n;i++){
            if(i%3==0&&i%5==0){
                arr.add("FizzBuzz");
            }
            else if(i%3==0){
                arr.add("Fizz");
            }
            else if(i%5==0){
                arr.add("Buzz");
            }
            else{
                arr.add(String.valueOf(i));
            }
        }
        return arr;
    }
    static  List<List<String>> groupAnagrams(String[] strs) {
        // HashMap to group anagrams
        Map<String, List<String>> ans = new HashMap<>();

        // Process each string in the array
        for (String s : strs) {
            // Convert string to character array and sort it
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            // Create a key based on sorted characters
            String key = new String(chars);
            
            // If key is not in the map, add it with a new list
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }
            // Add the original string to the corresponding list
            ans.get(key).add(s);
        }

        // Convert map values to a list and return
        return new ArrayList<>(ans.values());
    }
    static  int longestPalindrome(String s) {
        int oddCount = 0; // Count of characters with odd frequency
       HashMap<Character, Integer> frequencyMap = new HashMap<>();        
       for (char ch : s.toCharArray()) {
           frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
           if (frequencyMap.get(ch) % 2 == 0)
               oddCount--;
           else
               oddCount++;
       }
       if (oddCount > 1)
           return s.length() - oddCount + 1;
       return s.length();
   }
    static int maxProfit(int[] prices) {
        int max = 0;
        int buy = prices[0];
        int len = prices.length;
        for(int i = 1;i<len; i++){
            if(buy < prices[i]) max += prices[i] - buy;
            buy = prices[i];
        }
        return max;
    }
//    30 problems
     static void reverse(char[] str,int i,int j){ 
    while(i<j){
        char temp = str[i]; 
        str[i] = str[j]; 
        str[j] = temp;  
        i++; 
        j--;
    }
}
     public static String reverseStr(String s, int k) {
   
   char[]str = s.toCharArray();  
   int n = str.length;
   int i=0; 
   while(i<n){ 
    int j= Math.min(i+k-1 , n-1); 
    reverse(str, i , j); 
    i += 2*k;
   }  
   return new String(str); 
}  
     static String reverseWords(String s) {
    char[] arr = s.toCharArray();
    int i=0;
    int j=0;
    while(j<arr.length){
        if(arr[j]==' ') {
            reverse(arr,i, j-1);
            i = j+1;
        }
        j++;
    }
    reverse(arr,i, j-1);
    return String.valueOf(arr);
}
     static boolean checkRecord(String s) {
    int ca=0;
    int cl=0;
    int i=0;
    while(i<s.length()){
        if(s.charAt(i)=='A'){
            ca++;
            if(ca>=2){
                return false;
            }
        }
        if(s.charAt(i)=='L'){
            cl++;
            if(cl>=3){
                return false;
            }
        }
        else{
            cl=0;
        }
        i++;
    }
    return true;
}
     static  boolean rotateString(String s, String goal) {    
       if (s.length()!= goal.length()) return false; 
       return (s + s).contains(goal);
   }
     public long minimumSteps(String s) { // 2938... daly ques
    long swap = 0;
    int black = 0; 
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '0') 
            swap += (long) black; 
        else
            black++; 
    }
    return swap; 
}
     public static String encode(String s) {
    StringBuilder res=new StringBuilder();
    int count=1;
    for(int i=0;i<s.length();i++){
        if(i<s.length()-1 && s.charAt(i)==s.charAt(i+1)){
            count++;
        }
        else{
            res.append(s.charAt(i)).append(count);
            count=1;
        }
    }
    
    return res.toString();
  }
     public static void countCurrency(int amount){
      int[] notes = new int[]{ 2000, 500, 200, 100, 50, 20, 10, 5, 1 };
      int[] noteCounter = new int[9];
    
      // count notes using Greedy approach
      for (int i = 0; i < 9; i++) {
          if (amount >= notes[i]) {
              noteCounter[i] = amount / notes[i];
              amount = amount % notes[i];
          }
      }
    
      // Print notes
      System.out.println("Currency Count ->");
      for (int i = 0; i < 9; i++) {
          if (noteCounter[i] != 0) {
              System.out.println(notes[i] + " : "
                  + noteCounter[i]);
          }
      }
    }
     public static String longestDiverseString(int a, int b, int c) { // 1405 daly
        StringBuilder sb = new StringBuilder();

        int contA = 0, contB = 0, contC = 0;
        int total = a + b + c;
        for (int i = 0; i < total; i++) {
            if ((a >= b && a >= c && contA != 2) || ((contB == 2 || contC == 2) && a > 0)) {
                sb.append("a");
                a--;
                contA++;
                contB = 0;
                contC = 0;
            } else if ((b >= a && b >= c && contB != 2) || ((contA == 2 || contC == 2) && b > 0)) {
                sb.append("b");
                b--;
                contB++;
                contA = 0;
                contC = 0;
            } else if ((c >= a && c >= b && contC != 2) || ((contA == 2 || contB == 2) && c > 0)) {
                sb.append("c");
                c--;
                contC++;
                contA = 0;
                contB = 0;
            }
        }
        return sb.toString(); 
    }
     public static String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
       int i = 0;
       while (i < word1.length() || i < word2.length()) {
           if (i < word1.length()) {
               result.append(word1.charAt(i));
           }
           if (i < word2.length()) {
               result.append(word2.charAt(i));
           }
           i++;
       }
       return result.toString();
   }
     public static String gcdOfStrings(String str1, String str2) {
    // Check if concatenated strings are equal or not, if not return ""
    if (!(str1 + str2).equals(str2 + str1))
        return "";
    // If strings are equal than return the substring from 0 to gcd of size(str1), size(str2)
    int gcd = gcd(str1.length(), str2.length());
    return str1.substring(0, gcd);
}
     private static int gcd(int a, int b) {
       return b == 0 ? a : gcd(b, a % b);
     }
     public static List<Boolean> kidsWithCandies(int[] candies, int extra) {
        int max=Integer.MIN_VALUE;
        List<Boolean> res=new ArrayList<>();
        for(int i=0;i<candies.length;i++){
            max=Math.max(max,candies[i]);
        }
         for(int i=0;i<candies.length;i++){
            if(candies[i]+extra >=max){
                res.add(true);
            }
            else{
                res.add(false);
            }
        }
        return res;

    }
     public static int compress(char[] chars) {
        int index = 0;
        int start = 0;
        while(start < chars.length){
            int end = start;
            while(end < chars.length && chars[start] == chars[end]){
                end++;
            }
            int count = end - start;
            chars[index++] = chars[start];
            if(count >= 2){
                char ch=String.valueOf(count).charAt(0);
                    chars[index++] = ch;
                
            }
            start = end;
        }
        return index;
    }
     public static boolean increasingTriplet(int[] nums) {
       int min1 = Integer.MAX_VALUE;
       int min2 = Integer.MAX_VALUE;
       for(int n : nums) {
           if(n <= min1) min1 = n;
           else if(n <= min2) min2 = n;
           else return true;
       }
       return false;
    }
     public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
	   //Initializing the Count
        int count=0;
        for(int i=0,j=nums.length-1; i<j;){
		//if Integer at i and j = equal, increament the Count and move the pointer
            if(nums[i]+nums[j]==k){
                count +=1;
                j--;
                i++;
            }
			// if the Integers at i and j are greater the k, we need the decrease the sum so we move the j pointer by -1 
            else if(nums[i]+nums[j]>k){
                j--;
            }  
            else {
                i++;
            }
        }
		return count;
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        // Create a HashMap to store character counts
        HashMap<Character, Integer> dictionary = new HashMap<>();
        // Iterate through the characters in the magazine
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            dictionary.put(c, dictionary.getOrDefault(c,0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (dictionary.containsKey(c) && dictionary.get(c) > 0) {
                dictionary.put(c, dictionary.get(c) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
       
       for (char c : s.toCharArray()) {
           if (c == '*') {
               sb.deleteCharAt(sb.length() - 1); // Remove last character
           } else {
               sb.append(c); // Add current character
           }
       }
       
       return sb.toString();
   }
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> M=new HashMap<>();
        Set<Integer> s=new HashSet<>();
        for(int i:arr){
            M.put(i,M.getOrDefault(i,0)+1);
        }
        for(int j:M.values()){
            if(s.contains(j)){
                return false;
            }
            s.add(j);
        }
        return true;
    }
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>(); 
   // Add elements from nums1 to set1
   for (int num : nums1) {
       set1.add(num);
   }
   
   // Add elements from nums2 to set2
   for (int num : nums2) {
       set2.add(num);
   }
   
   // Find unique elements in nums1 (not in nums2)
   List<Integer> uniqueToNums1 = new ArrayList<>();
   for (int num : set1) {
       if (!set2.contains(num)) {
           uniqueToNums1.add(num);
       }
   }
   
   // Find unique elements in nums2 (not in nums1)
   List<Integer> uniqueToNums2 = new ArrayList<>();
   for (int num : set2) {
       if (!set1.contains(num)) {
           uniqueToNums2.add(num);
       }
   }
   
   // Prepare the result
   List<List<Integer>> result = new ArrayList<>();
   result.add(uniqueToNums1);
   result.add(uniqueToNums2);
   
   return result;
   }
    public String makeFancyString(String s) {
    int sameCount = 0;
    StringBuilder sb = new StringBuilder();
    char prev = s.charAt(0);
    for (char cur : s.toCharArray()) {
        if (cur == prev) {
            sameCount++;
        }
        else {
            sameCount = 1;
        }
        if (sameCount < 3) sb.append(cur);
        prev = cur;
    }
    return sb.toString();
}
    public boolean isCircularSentence(String s) {
      for(int i=0;i<s.length()-1;i++){
        if((s.charAt(i)==' ') && s.charAt(i-1)!=s.charAt(i+1)){
            return false;
        }     
     }         
     return s.charAt(0)==s.charAt(s.length()-1);
}
    public String largestNumber(int[] nums) {
    String[] numStrs = new String[nums.length];
   for (int i = 0; i < nums.length; i++) {
       numStrs[i] = String.valueOf(nums[i]);
   }

   // Sort the strings based on custom comparator
   Arrays.sort(numStrs, (a, b) -> (b + a).compareTo(a + b));

   if (numStrs[0].equals("0")) {
       return "0";
   }

   // Concatenate the sorted array to form the largest number
   StringBuilder result = new StringBuilder();
   for (String numStr : numStrs) {
       result.append(numStr);
   }

   return result.toString();
}
    public String fractionToDecimal(int n, int d) {
    if (n == 0) return "0";
    StringBuilder result = new StringBuilder();
    if (n < 0 ^ d < 0) {
        result.append("-");
    }
    long numerator = Math.abs((long) n);
    long denominator = Math.abs((long) d);
    result.append(numerator / denominator);
    long remainder = numerator % denominator;
    if (remainder == 0) {
        return result.toString();
    }
    result.append(".");
    Map<Long, Integer> remainderMap = new HashMap<>();
    while (remainder != 0) {
        // Check if this remainder has been seen before
        if (remainderMap.containsKey(remainder)) {
            // Found a repeating fraction
            int index = remainderMap.get(remainder);
            result.insert(index, "(");
            result.append(")");
            break;
        }
        
        // Store the index of the remainder
        remainderMap.put(remainder, result.length());
        
        // Update remainder
        remainder *= 10;
        result.append(remainder / denominator);
        remainder %= denominator;
    }  
    return result.toString();
   }
    public String decodeString(String s) {
        Stack<String> stack=new Stack<>();
        StringBuilder ans=new StringBuilder();
        int count=0;
        for(char i:s.toCharArray()){
            if(Character.isDigit(i)){
               count=count*10+(i-'0');
            }
            else if(i=='['){
                stack.push(ans.toString());
                ans=new StringBuilder();
                stack.push(String.valueOf(count));
                count=0;
            }
            else if(i==']'){
                String str=ans.toString();
                ans=new StringBuilder(str.repeat(Integer.parseInt(stack.pop())));
                ans=new StringBuilder(new StringBuilder(stack.pop()).append(ans));
            }
            else{
               ans.append(i);
            }
        }
        return ans.toString();
         
    }
    public static int[] findlps(String pattern){
        int[] lps=new int[pattern.length()];
        int i=1;
        int length=0;
        while(i<pattern.length()){
            if(pattern.charAt(i)==pattern.charAt(length)){
                length++;
                lps[i]=length;
                i++;
            }
            else{
                if(length!=0){
                   length=lps[length-1];
                }
                else{
                    i++;
                }
            }
        }
        return lps;
    }
    public static int kmp(String text,String pattern){
         int[] lps=findlps(pattern);
         int j=0;
         int i=0;
         while(i<text.length()){
             if(text.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
             }
             if(j==pattern.length()){
                return i-pattern.length();
             }
             else if(i<text.length() && text.charAt(i)!=pattern.charAt(j)){
                if(j!=0){
                    j=lps[j-1];
                }
                else{
                    i++;
                }
             }
         }
         return -1;
    }
    public static int findlps(String txt,String s){
        String pattern=s+'#'+txt;
        int[] lps=new int[pattern.length()];
        int i=1;
        int length=0;
        while(i<pattern.length()){
            if(pattern.charAt(i)==pattern.charAt(length)){
                length++;
                lps[i]=length;
                i++;
            }
            else{
                if(length>0){
                   length=lps[length-1];
                }
                else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps[pattern.length()-1];
    }
    public String shortestPalindrome(String s) {
        int count=findlps(new StringBuilder(s).reverse().toString(), s);
        return new StringBuilder(s.substring(count)).reverse().toString() + s;
    }
   
    public static void main(String[] args) {
        System.out.println(kmp("abcabca", "abc"));
    }
    
}
