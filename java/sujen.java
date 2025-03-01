import java.util.HashMap;
import java.util.Map;

public class sujen {
    public static int  factorial(int n){
        if(n==0){
            return 1;
        }
        int fact=1;
        for(int i=1;i<=n;i++){
            fact=fact*i;
        }
        return fact;

    } 
    public static int No_Of_ele(int n){
          int count=0;
          while(n>0){
            n=n/10;
            count++;
          }
          return count;
  }  
    public static int TrailingZeroOfFact(int n){
        int res=0;
        int powerOF5=5;
        while(n>=powerOF5){
            res=res+n/powerOF5;
            powerOF5=powerOF5*5;
        }
        return res;
    }
    public static int Gcd(int n1,int n2){
        int min=0;
        if(n1>n2){
           min=n2;
        }
        else{
            min=n1;
        }
        for(int i=min;i>0;i--){
            if(n1%i==0&&n2%1==0){
                return i;
            }
        }
        return 1;
    }
    public static int AdvGcd(int a,int b){
        while(a!=0&&b!=0){
            if(a>b){
                a=a%b;
            }
            else{
                b=b%a;
            }
        }
        return (a!=0) ? a:b;
    }
    public static int Lcm(int a ,int b){
        return (a*b)/AdvGcd(a,b);
    }
    public static boolean Prime(int n){
        // if(n==0||n==1){
        //     return false; 
        // }
        // for(int i=2;i<=Math.sqrt(n);i++){
        //     if(n%i==0){
        //         return false;
        //     }
        // }
        // return true;
        if(n==0 || n==1){
            return false;
        }
        if(n==2 || n==3){
            return true;
        }
        if(n%2==0 || n%3==0){
            return false;
        }
        for(int i=5;i*i<=n;i=i+6){
            if(n%i==0 || n%(i+2)==0){
                return false;
            }
        }
        return true;
    }
    public static void AllPrimeNum(int n){
        // for(int i=2;i<=n;i++){
        //     if(Prime(i)==true){
        //         System.out.println(i);
        //     }
        // }
        boolean isprimee[]=new boolean[n+1];
        for(int i=2;i*i<=n;i++){
             if(isprimee[i]==false){
                for(int j=i*i;j<=n;j=j+i){
                    isprimee[j]=true;
                }
             }
        }
        for(int i=2;i<=n;i++){
                if(isprimee[i]==false)
                    System.out.println(i);
            }

    }
    public static void Divisor(int n){
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                System.out.println(i);
                System.out.println(n/i);

            }
        
        }
    }
    public static void primeFactors(int n){
        int i=2;
        while(i<=Math.sqrt(n)){
           while(n%i==0){
            System.out.println(i);
            n=n/i;
            }
            i++;
        }
    
           if(n>1){
             System.out.println(n);
           }   
}
    static int countPrimes(int n) {
        if (n <= 1) {
             return 0; // There are no primes less than 2
         }
 
         // Create a boolean array "isPrime[0..n-1]"
         boolean[] isPrime = new boolean[n];
         // Assume all numbers are prime initially
         for (int i = 2; i < n; i++) {
             isPrime[i] = true;
         }
 
         // Apply Sieve of Eratosthenes
         for (int i = 2; i * i < n; i++) {
             if (isPrime[i]) {
                 // Mark multiples of i as not prime
                 for (int j = i * i; j < n; j += i) {
                     isPrime[j] = false;
                 }
             }
         }
 
         // Count the number of primes
         int count = 0;
         for (int i = 2; i < n; i++) {
             if (isPrime[i]) {
                 count++;
             }
         }
 
         return count;
     } 
    public static String reverse_String(String str){
        String rev="";
        for(int i=0;i<str.length();i++){
          rev=str.charAt(i)+rev;
        }
        return rev;
    }
    static String reverseOnlyLetters(String s) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
              if(Character.isLetter(s.charAt(i))){
                  sb.append(s.charAt(i));
              }
        }
        sb.reverse();
        StringBuilder res=new StringBuilder();
        int j=0;
        for(int i=0;i<s.length();i++){
          if(!Character.isAlphabetic(s.charAt(i))){
              res.append(s.charAt(i));
          }
          else{
              res.append(sb.charAt(j));
              j++;
          }
        }
        return res.toString();
      }
    static public boolean isValid(String word) {
            if(word.length()<3){
                return false;
            }
            int letter = 0;
            int digit = 1;
            int vowel = 0;
            int sp =0;
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                if (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
                   vowel++;
                }
                else if ((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')) {
                    letter++;
                } 
                else if (ch>='0'&&ch<='9') {
                    digit++;
                } 
                else 
                {
                    sp++;
                }
            }
            if(letter > 0 && digit > 0 && vowel>0 && sp==0){
                return true;
            }    
            return false;
            }
    public static void palindrome(String str){
        
        if(str.equals(reverse_String(str))){
            System.out.println("It is palindrome");
        }
        else{
            System.out.println("not a Palindrome");
        }        
    }
    public static void OddEEven(int n){
        if(n%2==0){
            System.out.println("even");
        }
        else{
            System.out.println("false");
        }
    }
    public static int SumOfNatural(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=i;
        }
        return sum;
    }
    public static void fibonacci(int n){
       int n1=0;
       int n2=1;
       System.out.print(n1+" "+n2 + " ");
        for(int i=2;i<n;i++){
           int n3=n1+n2;
            System.out.print(n3 + " ");
            n1=n2;
            n2=n3;   
        }
    }
    static int nthFibonacci(int n){
        if(n==1||n==2){
            return 1;
        }
       int n1=0;
       int n2=1;
        for(int i=2;i<=n;i++){
            int n3=n1+n2;
            n1=n2;
            n2=n3%1000000007;   
        }
        return n2;
    }
    public static int reverse_num(int n){
        int rev=0;
        while(n>0){
        int rem=n%10;
        rev=(rev*10)+rem;
        n=n/10;
    }
    return rev;
   
}
    static long power(int N,int exp){ 
    int mod = 1000000007;
    long result = 1;
    long baseMod = N % mod;
    while (exp > 0) {
        if ((exp % 2) == 1) {  // If exp is odd
            result = (result * baseMod) % mod;
            exp-=1;
        }
        baseMod = (baseMod * baseMod) % mod;
        exp /= 2;
    }
    return result;
}
    public static boolean armstrong(int n){
        int digit=No_Of_ele(n);
        int temp=n;
        int last=0;
        int sum=0;
        while(temp>0){
            last=temp%10;
            sum=(int)(sum+Math.pow(last, digit));
            temp=temp/10;
        }
        if(n==sum){
            return true;
        }
        return false;
    }   
    static int countstring(String s){
        int count=0;
        char[] atr=s.toCharArray();
    for(char c: atr){
        if(c!=' '){
        count++;
        }
    }
    return count;
    }
    static int isPerfectNumber(long N) {
        long sum=1;
       if(N==1){
           return 0;
       }
       for(long i=2;i*i<=N;i++){
           if(N%i==0){
               sum+=i;
               if(i!=N/i){
                   sum+=N/i;
               }
           }
       }
       return (sum==N) ? 1:0;
   }
                  //   22 problems
    static int minSubarray(int[] nums, int p) { // /by p daly ques leetcode 1590
        long sum=0;
        for(int i=0;i<nums.length;i++){
             sum+=nums[i];
        }
        int target=(int)(sum%p);
        if(target==0){
            return 0;
        }
        long presum = 0;
        int minLength = nums.length;
        Map<Integer,Integer> M=new HashMap<>();
        M.put(0,-1);
        for(int i=0;i<nums.length;i++){
           presum+=nums[i];
           int curr=(int) (presum%p);
           int targetvalue=(curr-target+p)%p;
            if(M.containsKey(targetvalue)){
                minLength=Math.min(minLength,i-M.get(targetvalue));
            }
            M.put(curr,i);
        }
       return minLength==nums.length? -1:minLength;
    }
    
public static void main(String[] args) {
     
       Divisor(20);
     
    }
}