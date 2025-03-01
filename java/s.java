
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Stack;
public class s {
    public static boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(char i : s.toCharArray()){
            if(i=='('){
                stack.push(')');
            }
            else if(i=='{'){
                stack.push('}');
            }
            else if(i=='['){
                stack.push(']');
            }
            else if(stack.isEmpty() || stack.pop()!=i){
                return false;
            }
        }
        return stack.isEmpty();
    }
    public static boolean isValid1(String s) {
        Stack<Character> stack=new Stack<>();
      for(char i : s.toCharArray()){
       if(i=='(' || i=='{'||i=='['){
           stack.push(i);
                     
       }  
       else{
        if(i==')'){
            if(stack.isEmpty() || stack.pop()!='('){
                return false;
            }
        }
        if(i==']'){
            if(stack.isEmpty() || stack.pop()!='['){
                return false;
            }
        }
        if(i=='}'){
            if(stack.isEmpty() || stack.pop()!='{'){
                return false;
            }
        } 
     }
   }
   return stack.isEmpty();
}
    public ArrayList<Integer> nextLargerElement(int[] ar) {
        ArrayList<Integer> res=new ArrayList<>();
        Stack<Integer> s=new Stack<>();
        for(int i=ar.length-1;i>=0;i--){
            while(!s.isEmpty() && s.peek()<=ar[i]){
                s.pop();
            }
            if(i>=0){
               if(s.isEmpty()){
                  res.add(-1);
               }
               else{
                  res.add(s.peek());
               }
            }
            s.push(ar[i]);
        }
        Collections.reverse(res);
        return res;
    }
    static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int nge[] = new int[n];
        Stack < Integer > st = new Stack < > ();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i % n]) {
                st.pop();
            }
            if (i < n) {
                if (!st.isEmpty()) nge[i] = st.peek();
                else nge[i] = -1;
            }
            st.push(nums[i % n]);
        }
        return nge;
    }
    static int[] calculateSpan(int[] price, int n) {
        // Result array to store spans
        int[] res = new int[n];
        // Stack to store indices of the price array
        Stack<Integer> stack = new Stack<>();

        // Iterate through each price
        for (int i = 0; i < n; i++) {
            // Pop indices from stack while current price is greater than or equal to price at stack's top index
            while (!stack.isEmpty() && price[i] >= price[stack.peek()]) {
                stack.pop();
            }
            // Calculate the span
            res[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            // Push current index onto stack
            stack.push(i);
        }

        return res;
    }
    static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        int[] nsr = new int[n];
        int[] nsl = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsr[i] = n;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        s.clear();
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        // Calculating the maximum area
        for (int i = 0; i < n; i++) {
            int width = nsr[i] - nsl[i] - 1;
            int area = width * heights[i];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
    public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
        int res[]=new int[queries];
        for(int i=0;i<queries;i++){
            int count=0;
            int index=indices[i]+1;
            for(int j=index;j<N;j++){
                if(arr[j]>arr[index]){
                    count++;
                }
            }
            res[i]=count;
        }
        return res;
      }
    static int Prec(char ch) {
        switch (ch) {
        case '+':
        case '-':
          return 1;
    
        case '*':
        case '/':
          return 2;
    
        case '^':
          return 3;
        }
        return -1;
      }
    static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        StringBuilder number = new StringBuilder();

        // Iterate through the infix expression
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            // If the character is a digit, build the number
            if (Character.isDigit(ch)) {
                number.append(ch); // Add the current digit to the number
            } else {
                // If we encountered a non-digit and have a complete number, add it to the postfix expression
                if (number.length() > 0) {
                    postfix.append(number.toString()).append(" "); // Separate numbers with a space
                    number.setLength(0); // Reset the number for the next operand
                }

                // If the character is '(', push it to the stack
                if (ch == '(') {
                    stack.push(ch);
                }
                // If the character is ')', pop from the stack to the postfix expression
                // until '(' is encountered
                else if (ch == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        postfix.append(stack.pop()).append(" ");
                    }
                    stack.pop(); // Pop '(' from the stack
                }
                // If the character is an operator, pop operators with higher or equal precedence
                // from the stack to the postfix expression, then push the current operator to the stack
                else {
                    while (!stack.isEmpty() && Prec(ch) <= Prec(stack.peek())) {
                        postfix.append(stack.pop()).append(" ");
                    }
                    stack.push(ch);
                }
            }
        }

        // If there's a number left in the StringBuilder, add it to the postfix expression
        if (number.length() > 0) {
            postfix.append(number.toString()).append(" ");
        }

        // Pop any remaining operators from the stack
        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString().trim();  // Remove any trailing spaces
    }
      static String infixtopost(String Str) {
        int i = 0;
        Stack<Character> s = new Stack<>();
        StringBuilder ans = new StringBuilder();
        
        while (i < Str.length()) {
            char ch = Str.charAt(i);
            
            if (Character.isLetterOrDigit(ch)) {
                ans.append(ch); // Append digit to result
            } else if (ch == '(') {
                    s.push(ch);
            } else if (ch == ')') {
                    while (!s.isEmpty() && s.peek() != '(') {
                        ans.append(s.pop());
                    }
                    s.pop();}
             else {
                    while (!s.isEmpty() && Prec(ch) <= Prec(s.peek())) {
                        ans.append(s.pop());
                    }
                    s.push(ch);
            }
            i++;
        }
        
        while (!s.isEmpty()) {
            if (s.peek() == '(')
                return "Invalid Expression";
            ans.append(s.pop());
        }
        return ans.toString();
    }
    static int evaluatePostFix1(String Str) {
        Stack<Integer> s = new Stack<>();
        
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < Str.length(); i++) {
            char ch = Str.charAt(i);
            
            if (Character.isDigit(ch)) {
                number.append(ch); // Build the complete number
            } else {
                if (number.length() > 0) {
                    s.push(Integer.parseInt(number.toString())); // Push the complete number
                    number=new StringBuilder(); // Reset for the next number
                }
                
                if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                    int operand2 = s.pop();
                    int operand1 = s.pop();
                    switch (ch) {
                        case '+':
                            s.push(operand1 + operand2);
                            break;
                        case '-':
                            s.push(operand1 - operand2);
                            break;
                        case '*':
                            s.push(operand1 * operand2);
                            break;
                        case '/':
                            s.push(operand1 / operand2);
                            break;
                    }
                }
            }
        }

        // In case there's a number left to push onto the stack
        if (number.length() > 0) {
            s.push(Integer.parseInt(number.toString()));
        }
        return s.pop(); // Return the final result
    }
    static String reversestr(String str){
        String rev="";
        for(int i=0;i<str.length();i++){
          rev=str.charAt(i)+rev;
        }
        return rev;
    }
    static String infixtoprefix(String S1){
        String ans="";
        Stack<Character> s=new Stack<>();
        String Str=reversestr(S1);
        char[] Str1=Str.toCharArray();
        for (int i = 0; i < Str.length(); i++) {
            if (Str1[i] == '(') {
              Str1[i]= ')';
              i++;
            } 
            else if (Str1[i] == ')') {
              Str1[i] = '(';
              i++;
            }
          }
        int i=0;
        while(i<Str1.length){
            if(Character.isLetterOrDigit(Str1[i])){
                ans+=Str1[i];
       }
       else if(Str1[i]=='('){
           s.push(Str1[i]);
       }
       else if(Str1[i]==')'){
           while(!s.isEmpty() && s.peek()!='('){
               ans+=s.pop();
           }
           s.pop();
       }
       else{
           while(!s.isEmpty() && Prec(Str1[i])<Prec(s.peek()) || (!s.isEmpty() && Prec(Str1[i])<=Prec(s.peek()) && Str1[i]=='^')){ 
               ans+=s.pop();
           }
           s.push(Str1[i]);
       }
            i++;
        }
        while (!s.isEmpty()) {
            if (s.peek() == '(')
              return "Invalid Expression";
            ans += s.pop();
          }
          String res=reversestr(ans);
         return res;
    }
    static String postToInfix(String Str) {
        Stack<String> s=new Stack<>();
        int i=0;
        while(i<Str.length()){
            if(Character.isLetterOrDigit(Str.charAt(i))){
                s.push(String.valueOf(Str.charAt(i)));
             }
             else{
                 String t1=s.pop();
                 String t2=s.pop();
                 String t3="(" + t2 + Str.charAt(i)+t1 +")";
                 s.push(t3);
             }
             i++;
        }
        return s.peek();
    }
    public static int evaluatePostFix(String Str){
        Stack<Integer> s=new Stack<>();
        int i=0;
        while(i<Str.length()){
            if(Character.isDigit(Str.charAt(i))){
                s.push((Str.charAt(i)-'0'));
             }
             else{
                 int operand2=s.pop();
                 int operand1=s.pop();
                  switch (Str.charAt(i)) {
                    case '+':
                        s.push(operand1 + operand2);
                        break;
                    case '-':
                        s.push(operand1 - operand2);
                        break;
                    case '*':
                        s.push(operand1 * operand2);
                        break;
                    case '/':
                        s.push(operand1 / operand2);
                        break;
                }
             }
             i++;
        }
        return (s.peek());
    }
    static int evalArithmetic(String s){
      String s1=infixtopost(s);
      return evaluatePostFix1(s1);
    }
    static String preToInfix(String Str) {
        Stack<String> s=new Stack<>();
        int i=Str.length()-1;
        while(i>=0){
            if(Character.isLetterOrDigit(Str.charAt(i))){
                s.push(String.valueOf(Str.charAt(i)));
             }
             else{
                 String t1=s.pop();
                 String t2=s.pop();
                 String t3="(" + t1 + Str.charAt(i)+t2 +")";
                 s.push(t3);
             }
             i--;
        }
        return s.peek();
    }
    static String postToPre(String Str) {
        Stack<String> s=new Stack<>();
        int i=0;
        while(i<Str.length()){
            if(Character.isLetterOrDigit(Str.charAt(i))){
                s.push(String.valueOf(Str.charAt(i)));
             }
             else{
                 String t1=s.pop();
                 String t2=s.pop();
                 String t3= Str.charAt(i)+t2 +t1;
                 s.push(t3);
             }
             i++;
        }
        return s.peek();
    }
    static String preToPost(String Str) {
        Stack<String> s=new Stack<>();
        int i=Str.length()-1;
        while(i>=0){
            if(Character.isLetterOrDigit(Str.charAt(i))){
                s.push(String.valueOf(Str.charAt(i)));
             }
             else{
                 String t1=s.pop();
                 String t2=s.pop();
                 String t3= t1 +t2 + Str.charAt(i);
                 s.push(t3);
             }
             i--;
        }
        return s.peek();
    }
    static int sumSubarrayMins(int[] A) {
        int n = A.length;
        int mod = (int)1e9+7;
        int[] ple = new int[n];
        int[] nle = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                stack.pop();
            }
            ple[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Clear stack to reuse for NLE
        stack.clear();

        // Fill nle (Next Less Element)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }
            nle[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long leftCount = i - ple[i]; 
            long rightCount = nle[i] - i;
            sum = (sum + A[i] * leftCount * rightCount) % mod;
        }

        return (int) sum;
    }
    static  int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int a : asteroids) {
            if (a > 0) {
                stack.push(a);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -a) {
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() < 0)  {
                    stack.push(a);
                }

                if (stack.peek() == -a) {
                    stack.pop();
                }
            }
        }

        int[] res = new int[stack.size()];
        int i = stack.size() - 1;

        while(!stack.isEmpty()) {
            res[i--] = stack.pop();
        }

        return res;   
    }
    static  String removeKdigits(String num, int k) {
        Stack<Character> s=new Stack<>();
        for(int i=0;i<num.length();i++){
           while(!s.isEmpty() && s.peek()>num.charAt(i) && k>0){
            s.pop();
            k--;
           }
           s.push(num.charAt(i));
        }
        while(k>0 && !s.isEmpty()){
            s.pop();
            k--;
        }
         StringBuilder res = new StringBuilder();
        while(!s.isEmpty()){
            res.append(s.pop());
        }
        if(res.length()==0){
            return "0";
        }
        res.reverse();
        while (res.length() > 0 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }
         return res.length() > 0 ? res.toString() : "0";
    }
    static String rev(String s){
        char c[]=s.toCharArray();
        Stack<Character> stack=new Stack<>();
        for (char i : c) {
            stack.push(i);
        }
        int i=0;
        char[] reverse = new char[s.length()];
        while(!stack.isEmpty()){
            reverse[i++]=stack.pop();
        }
        return new String(reverse);
    }
    static void removeMiddle(Stack<Integer> stack) {
        int size = stack.size();
        if (size == 0) {
            return; // If the stack is empty, do nothing
        }
        // Calculate the middle index
        int midIndex = size / 2;

        // Use a temporary stack to hold elements
        Stack<Integer> tempStack = new Stack<>();

        // Pop elements from original stack and push to temp stack
        for (int i = 0; i < size; i++) {
            if (i == midIndex) {
                // Skip the middle element
                stack.pop();
            } else {
                tempStack.push(stack.pop());
            }
        }
        // Push elements back to the original stack from temp stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }
    static void insertAtBottom(Stack<Integer> stack, int value) {
        if (stack.isEmpty()) {
            stack.push(value);
            return; // If stack is empty, push the new element
        } else {
            int top = stack.pop(); // Pop the top element
            insertAtBottom(stack, value); // Recursive call
            stack.push(top); // Push the popped element back
        }
    }
    static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return; // Base case
        }

        // Step 1: Pop the top element
        int top = stack.pop();

        // Step 2: Reverse the remaining stack
        reverseStack(stack);

        // Step 3: Insert the popped element at the bottom
        insertAtBottom(stack, top);
    }
    static void sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        while(!stack.isEmpty()){
            int temp=stack.pop();
            while(!tempStack.isEmpty() && tempStack.peek()<temp){
                stack.push(tempStack.pop());
            }
            tempStack.push(temp);
        }
        while(!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }
    }
    static String reduceRedundantBrackets(String expression) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char c : expression.toCharArray()) {
            if (c == ')') {
                StringBuilder temp = new StringBuilder();
                // Pop until we find the corresponding '('
                while (!stack.isEmpty() && stack.peek() != '(') {
                    temp.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop(); // Remove the '('
                }

                // Check if there's an operator inside the brackets
                if (temp.length() > 0 && containsOperator(temp.toString())) {
                    result.append('(').append(temp.reverse()).append(')');
                } else {
                    result.append(temp.reverse()); // No brackets needed
                }
            } else {
                stack.push(c);
            }
        }

        // Add any remaining characters in the stack to the result
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString(); // Reverse to get the correct order
    }
    private static boolean containsOperator(String s) {
        return s.contains("+") || s.contains("-") || s.contains("*") || s.contains("/");
    }
    static int minAddToMakeValid(String str) {
        int open = 0; // Count of unmatched opening brackets
        int close = 0; // Count of unmatched closing brackets

        for (char c : str.toCharArray()) {
            if (c == '(') {
                open++; // Increment for opening bracket
            } else if (c == ')') {
                if (open > 0) {
                    open--; // Match with an opening bracket
                } else {
                    close++; // Increment for unmatched closing bracket
                }
            }
        }

        // The cost to make the string valid is the sum of unmatched brackets
        return open + close;

    }
    //  int minAddToMakeValid(String s) {
    //     Stack<Character> stac = new Stack<>();
    //     int ans =0;
    //     for(int i=0; i<s.length(); i++){
    //         if(s.charAt(i)==')'){
    //             if(stac.isEmpty()){
    //                 ans++;
    //             } else{
    //                 stac.pop();
    //             }
    //         }else{
    //             stac.push(s.charAt(i));
    //         }
    //     }
    //     return ans+stac.size();
    // }
    static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0; // Handle empty matrix
        int maxArea = 0;
        int[][] pmat = new int[matrix.length][matrix[0].length];
    
        // Prepare the height matrix
        for (int i = 0; i < matrix[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix.length; j++) {
                sum = (matrix[j][i] == '1') ? sum + 1 : 0; // Increase height or reset
                pmat[j][i] = sum; // Fill the height matrix
            }
        }
    
        // Find the maximum area for each row in the height matrix
        for (int i = 0; i < matrix.length; i++) {
            maxArea = Math.max(maxArea, largestRectangleArea(pmat[i]));
        }
    
        return maxArea;
    }
    static boolean knows(int a,int b,int mat[][]){
        int res=mat[a][b];
        return res==1;
    }
    public static int celebrity(int mat[][]) {
        Stack<Integer> s=new Stack<>();
        for (int i = 0; i < mat.length; i++) {
            s.push(i);
        }
        while(s.size()>1){
            int a=s.pop();
            int b=s.pop();
            if(knows(a, b, mat)){
                s.push(b);
            }
            else{
                s.push(a);
            }
        }
        int candidate=s.pop();
        for (int i = 0; i < mat.length; i++) {
            if (i != candidate) {
                if (knows(candidate, i,mat) || !knows(i, candidate,mat)) {
                    return -1; // No celebrity found
                }
            }
        }
        
        return candidate;
    }
    static String reduced_String(int k, String s){
        // Your code goes here 
        Stack<Character> stk = new Stack<>();
        int i=0;
        while(i<s.length()){
            char ch = s.charAt(i++);
            stk.push(ch);
            int count=0;
            while(!stk.isEmpty() && stk.peek()==ch){
                count++;
                stk.pop();
            }
            
            if(count==k) continue;
            else {
                while(count>0){
                    stk.push(ch);
                    count--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch:stk){
           sb.append(ch); 
        }
        
        return sb.toString();
        
    }
    static int minchange (String s){
        // your code here       
       // If the length of the string is odd, return -1 as it's impossible to balance
        if (s.length() % 2 == 1) {
            return -1;
        }
        
        Stack<Character> st = new Stack<>();
        int count = 0;
        
        // Traverse through the string
        for (char e : s.toCharArray()) {
            if (e == '{') {
                st.push(e);
            } else {
                // If stack is empty, we need to reverse a bracket
                if (st.isEmpty()) {
                    count++;  // Increment reversal count
                    st.push('{');  // Push a corresponding '{' to balance later
                } else {
                    st.pop();  // Pop a matching '{' from the stack
                }
            }
        }
        
        // Add half of the remaining unbalanced '{' to count
        count += st.size() / 2;
        
        return count;
    }
    static String makeGood(String s) {
        StringBuilder result = new StringBuilder();
        int n = s.length();
        for(int i =0 ;i<n;i++){
            char curr = s.charAt(i);
            if(result.length()>0 && Math.abs(result.charAt(result.length()-1)-curr)==32){
                result.deleteCharAt(result.length()-1);
            }
            else{
                result.append(curr);
            }
        }   
        return result.toString();
    }
    static String reversePrefix(String word, char ch) {
        Stack<Character> stack = new Stack<>();
        StringBuilder str = new StringBuilder();
        boolean found = false;

        // Traverse the characters in the word
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);

            // Push the character onto the stack
            stack.push(currentChar);

            // If we find the character ch, we set found to true and break
            if (currentChar == ch) {
                found = true;
                break;
            }
        }

        // If we found the character, pop from the stack to reverse the prefix
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }

        // Append the rest of the string if the character was found
        if (found) {
            str.append(word.substring(str.length(), word.length()));
        } else {
            // If not found, just return the original word
            return word;
        }

        return str.toString();
    }
    static int minLength(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!st.isEmpty() &&((s.charAt(i)=='B' && st.peek()=='A') || s.charAt(i)=='D' && st.peek()=='C'))
            {
                st.pop();
            }
            else
            {
                st.push(s.charAt(i));
            }
        }
        return st.size();
    }
    static  String clearDigits(String str) {    
        Stack<Character> s = new Stack<>();
        StringBuilder s1=new StringBuilder();
        for(char i : str.toCharArray()){
          if(Character.isLetter(i)){
              s.push(i);
          }
          else{
              s.pop();
          }
        }
        while(!s.isEmpty()){
          s1.append(s.pop());
        }
        return s1.reverse().toString();
      }    
    static int[] finalPrices(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // Find the first smaller element to the right
            while (!s.isEmpty() && s.peek() > nums[i]) {
                s.pop();
            }

            // If stack is not empty, apply the discount
            if (!s.isEmpty()) {
                result[i] = nums[i] - s.peek();
            } else {
                result[i] = nums[i]; // No discount
            }

            // Push the current price onto the stack
            s.push(nums[i]);
        }
        return result;
    }
    static  String removeDuplicates(String s) {
        Stack<Character> stack=new Stack<>();
         stack.push(s.charAt(0));
        for(int i=1;i<s.length();i++){
           
            if(!stack.isEmpty() && s.charAt(i)==stack.peek()){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb=new StringBuilder();
        for(char a:stack){
            sb.append(a);
        }

        return sb.toString() ;
    } 
    static String removeOuterParentheses(String s) {
        Stack<Character> bracket = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(bracket.size()>0){
                    sb.append(s.charAt(i));
                }
                bracket.push(s.charAt(i));
            }else{
                bracket.pop();
                if(bracket.size()>0){
                    sb.append(s.charAt(i));
                }
            }
        }
        return sb.toString();
    }
    static boolean backspaceCompare(String s, String t) {
        return backspace(s).equals(backspace(t));
      }
    static String backspace(String s) {
        StringBuilder sb = new StringBuilder();
        for (final char c : s.toCharArray())
          if (c != '#')
            sb.append(c);
          else if (sb.length() != 0)
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
      }   
    static  int calPoints(String[] operations) {
        int n = operations.length;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            String str = operations[i];
            char ch = str.charAt(0);
            if(Character.isDigit(ch)  || ch=='-'){
                stack.push(Integer.parseInt(str));
            }
            else if(!stack.isEmpty()){
                if(ch == '+' && stack.size()>1){
                    int a = stack.pop();
                    int b = stack.peek();
                    stack.push(a);
                    stack.push(a+b);
                }
                else if(ch == 'D'){
                    int a = stack.peek();
                    stack.push(a*2);
                }
                else if(ch=='C'){
                    stack.pop();
                }
            }
        }
        int sum=0;
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;
    }
    static int calculator(String s) {
        int result = 0, len = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char prevOperation = '+';
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = (num * 10) + ( c - '0' );
            }

            if (isOperator(c) || i == len - 1) {
                if (prevOperation == '-') {
                    stack.push(-num);
                }
                if (prevOperation == '+') {
                    stack.push(num);
                }
                if (prevOperation == '*') {
                    stack.push(stack.pop() * num);
                }
                if (prevOperation == '/') {
                    stack.push(stack.pop() / num);
                }
                prevOperation = c;
                num = 0;
            }
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    static  String removeDuplicateLetters(String s) {
        int[] lastindex=new int[26];
        for(int i=0;i<s.length();i++){
            lastindex[s.charAt(i)-'a']=i;
        }
        boolean[] seen=new boolean[26];
        Stack<Integer> s1=new Stack<>();
        for(int i=0;i<s.length();i++){
            int curr=s.charAt(i)-'a';
            if(seen[curr]==true){
                continue;
            }
            while(!s1.isEmpty() && s1.peek()>curr && i<lastindex[s1.peek()]){
                seen[s1.pop()]=false;
            }
            s1.push(curr);
            seen[curr]=true;
        }
        StringBuilder sb = new StringBuilder();
        while (!s1.isEmpty())
            sb.append((char) (s1.pop() + 'a'));
        return sb.reverse().toString();
    }
    static boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int third = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < third) return true;
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                third = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
    static int findUnsortedSubarray(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int l = nums.length;
        int r = 0;

        for(int i = 0; i < nums.length; i++){
            while(!st.isEmpty() && nums[st.peek()] > nums[i] ){
                l = Math.min(l, st.pop());
            }
            st.push(i);
        }

        st.clear();
        for(int i = nums.length - 1; i >= 0; i--){
            while(!st.isEmpty() && nums[st.peek()] < nums[i] ){
                r = Math.max(r, st.pop());
            }
            st.push(i);
        }
        if(r - l > 0) {
            return r - l + 1;
        }
        else return 0;
    }
    static boolean checkValidString(String s) {
        Stack<Integer> wildCardStack = new Stack<>();
        Stack<Integer> openParenthesisStack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '('){
                openParenthesisStack.push(i);
            } else if(c == '*') {
                wildCardStack.push(i);
            } else {
                if(!openParenthesisStack.isEmpty()){
                    openParenthesisStack.pop();
                } else if(!wildCardStack.isEmpty()){
                    wildCardStack.pop();
                }else {
                    return false;
                }
            }
        }

        //  if(openParenthesisStack.size() > wildCardStack.size()) return false;
        //  else{
        //     return true;
        //  }

        while(!openParenthesisStack.isEmpty() && !wildCardStack.isEmpty()){
            if(openParenthesisStack.peek() < wildCardStack.peek()){
                openParenthesisStack.pop();
                wildCardStack.pop();
            } else {
                return false;
            }
        }

        return openParenthesisStack.isEmpty();
    }
    static  boolean validateStackSequences(int[] pushed, int[] popped) {
        int j = 0;//track the popped element using variable j
        Stack<Integer> s = new Stack<>();
        for(int i = 0 ; i < pushed.length; i ++){
            s.push(pushed[i]); //pushing the element into stack
            //peek() element is present in popped array then pop() the peek() element
            while(!s.isEmpty() && j != popped.length){
                if(s.peek() == popped[j]){
                    s.pop(); //pop the element 
                    j++; //increase the j pointer
                }else{
                    break;//break from the while loop not the for loop
                }
            }
        }
        return s.isEmpty();//check if the stack is empty or not if empty then all operation went successfull 
    }
    static int minDeletion(int[] nums) {
    return util1(nums);
}
    public static int util1(int[] arr) {
    Stack<Integer> s = new Stack<>();
    int operations = 0;
    for (int i : arr) {
        if (s.isEmpty() == false && (s.peek() == i && (s.size() - 1) % 2 == 0)) {
            operations++;
        } else {
            s.push(i);
        }
    }
    while (s.size() % 2 != 0) {
        operations++;
        s.pop();
    }
    return operations;
}
    static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isAlphabetic(ch)) {
                continue;
            }
            if (ch == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        HashSet<Integer> set = new HashSet<>(stack);
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    static int addMinimum(String word) {
        int count=0;
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            stack.push(ch);
        }
        while(!stack.empty()){
            if(!stack.empty() && stack.peek()=='c'){
                stack.pop();
            }
            else{
                count++;
            }
             if(!stack.empty() && stack.peek()=='b'){
                stack.pop();
            }
            else{
                count++;
            }
             if(!stack.empty() && stack.peek()=='a'){
                stack.pop();
            }
            else{
                count++;
            }
        }
        return count;
    }
    static int longestValidParentheses(String s) {
       int left=0;
       int right=0;
       int maxi=0;
       
       for(int i=0;i<s.length();i++){
           if(s.charAt(i)=='(')  left++;
           else right++;
           
           if(left==right) {
               maxi=Math.max(maxi,left*2);
           }
           else if (left<right){
               left=0;
               right=0;
           }
       }
       
       left=0;
       right=0;
       
       for(int i=s.length()-1;i>=0;i--){
           if(s.charAt(i)=='(')  left++;
           else right++;
           
           if(left==right) {
               maxi=Math.max(maxi,left*2);
           }
           else if (left>right){
               left=0;
               right=0;
           }
       }
       return maxi;
    }
    static public int calculate(String s) {
            int number = 0;
            int signValue = 1;
            int result = 0;
            Stack<Integer> operationsStack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    number = number * 10 + (c - '0');
                } else if (c == '+' || c == '-') {
                    result += number * signValue;
                    signValue = (c == '-') ? -1 : 1;
                    number = 0;
                } else if (c == '(') {
                    operationsStack.push(result);
                    operationsStack.push(signValue);
                    result = 0;
                    signValue = 1;
                } else if (c == ')') {
                    result += signValue * number;
                    result *= operationsStack.pop();
                    result += operationsStack.pop();
                    number = 0;
                }
            }
            return result + number * signValue;
        }
    static int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>(); 
        // Step 1: Build a decreasing stack of indices
        for (int i = 0; i < n; ++i) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }
        int maxWidth = 0; 
        // Step 2: Traverse from the end and find maximum width ramp
        for (int j = n - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                maxWidth = Math.max(maxWidth, j - stack.pop());
            }
        }
        return maxWidth;
    }
    public String removeOccurrences(String s, String part) {
        Stack<Character> stk = new Stack<>();
        int strLength = s.length();
        int partLength = part.length();

        // Iterate through each character in the string
        for (int index = 0; index < strLength; index++) {
            // Push current character to stack
            stk.push(s.charAt(index));
            

            // If stack size is greater than or equal to the part length, check for match
            if (stk.size() >= partLength && checkMatch(stk, part, partLength)) {
                // Pop the characters matching 'part' from the stack
                for (int j = 0; j < partLength; j++) {
                    stk.pop();
                }
            }
        }

        // Convert stack to string with correct order
        StringBuilder result = new StringBuilder();
        while (!stk.isEmpty()) {
            result.append(stk.pop());
        }
        result.reverse();

        return result.toString();
    }

    // Helper function to check if the top of the stack matches the 'part'
    private boolean checkMatch( Stack<Character> stk,String part,int partLength) {
        Stack<Character> temp = new Stack<>();
        temp.addAll(stk); // Copy the stack to avoid modifying the original

        // Iterate through part from right to left
        for (int partIndex = partLength - 1; partIndex >= 0; partIndex--) {
            // If current stack top doesn't match expected character
            if (temp.isEmpty() || temp.peek() != part.charAt(partIndex)) {
                return false;
            }
            temp.pop();
        }
        return true;
    }//1910
    // 50 problem
    
    
    
    public static void main(String[] args) {
        System.out.println(reduced_String(3, "suuujenthiraaan"));
    }
}