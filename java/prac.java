import java.util.*;

public class prac {
    public ArrayList<Integer> max_of_subarrays(int arr[], int k) {
        Deque<Integer> q=new ArrayDeque<>();
        ArrayList<Integer> l=new ArrayList<>();
        for(int i=0;i<k;i++){
                while(!q.isEmpty() && arr[q.peekLast()]<arr[i]){
                   q.pollLast(); 
            }
            q.offerLast(i);
        }
        if(!q.isEmpty()){
            l.add(arr[q.peekFirst()]);
        }
        for(int i=k;i<arr.length;i++){
            while(!q.isEmpty() && q.peekFirst()<i-k){
                q.pollFirst();
            }
            while(!q.isEmpty() && arr[q.peekLast()]<arr[i]){
                   q.pollLast(); 
                }
                q.offerLast(i);
                if(!q.isEmpty()){
                   l.add(arr[q.peekFirst()]);
                }
            
        }
        return l;
    }
//     Sliding Window Maximum/Minimum.
// First Non-Repeating Character in a Stream.
// Palindrome Checking.
// Maximum/Minimum in Sliding Window with Priority Queue/Deque.
// Trapping Rain Water.
// Monotonic Queue.
// Reversing First k Elements of Queue.
// Max/Min Queue.
// Balanced Parentheses Checking.
public static String smallestWindow(String s2, String s1) {
    if (s1 == null || s1.length() == 0 || s1 == null || s2.length() == 0) {
        return "";
    }
    String minw="";
    Map<Character,Integer> m=new HashMap<>();
    for(int i=0;i<s1.length();i++){
        m.put(s1.charAt(i),m.getOrDefault(s1.charAt(i),0)+1);
    }
    Map<Character,Integer> win=new HashMap<>();
    int minlength=Integer.MAX_VALUE;
    int formed=0;
    int i=0;
    int j=0;
    while(i<s2.length()){
        win.put(s2.charAt(i),win.getOrDefault(s2.charAt(i),0)+1);
        if(m.containsKey(s2.charAt(i))&&win.get(s2.charAt(i)).intValue()==m.get(s2.charAt(i)).intValue()){
            formed++;
        }
        while(j<=i && formed==m.size()){
            if(minlength>i-j+1){
                minlength=Math.min(minlength,i-j+1);
                minw=s1.substring(j,i+1);
            }
            win.put(s2.charAt(j),win.get(s2.charAt(j))-1);
            if(m.containsKey(s2.charAt(i))&&win.get(s2.charAt(i)).intValue() < m.get(s2.charAt(i)).intValue()){
                formed--;
            }
        j++;
    }
    i++;
    }
    return minw;
}
static boolean equi(Map<Character,Integer> w,Map<Character,Integer> t){
    return w.equals(t);
}

static int search(String pat, String txt) {
    if(pat.length()<txt.length()){
        return 0;
    }
     int count=0;
     Map<Character,Integer> w=new HashMap<>();
     Map<Character,Integer> t=new HashMap<>();
     for(int i=0;i<txt.length();i++){
         char s=txt.charAt(i);
         w.put(s,w.getOrDefault(s,0)+1);
     }
     for(int i=0;i<txt.length();i++){
         t.put(pat.charAt(i),t.getOrDefault(pat.charAt(i),0)+1);
     }
     if(equi(w,t)){
         count++;
     }
     for(int i=txt.length();i<pat.length();i++){
         t.put(pat.charAt(i),t.getOrDefault(pat.charAt(i),0)+1);
         if(t.get(pat.charAt(i-txt.length()))==1){
             t.remove(pat.charAt(i-txt.length()));
         }
         else{
              t.put(pat.charAt(i-txt.length()),t.getOrDefault(pat.charAt(i-txt.length()),0)-1);
         }
         if(equi(w,t)){
             count++;
         }
     }
     return count;
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
    System.out.println(search("forxxorfxdofr", "for"));
}
}
