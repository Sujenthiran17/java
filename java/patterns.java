public class patterns {
      static void pat1(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print("*"+ " ");
            }
            System.out.println();
        }
      }
      static void pat2(int n){
           for (int i = 0; i < n; i++) {
               for(int j=0;j<=i;j++){
                    System.out.print("*"+ " ");
               }
               System.out.println();
           }
      }           
      static void pat3(int n){
        for (int i = 1; i <= n; i++) {
            for(int j=1;j<=i;j++){
                 System.out.print(j+ " ");
            }
            System.out.println();
        }
      }
      static void pat4(int n){
        for (int i = 1; i <=n; i++) {
            for(int j=1;j<=i;j++){
                 System.out.print(i+ " ");
            }
            System.out.println();
        }
      }
      static void pat5(int n){
         for (int i = 0; i < n; i++) {
            for(int j=0;j<n-i;j++){
                System.out.print("*"+ " ");
            }
            System.out.println();
         }
      }
      static void pat6(int n){
        for (int i = 1; i<= n; i++) {
           for(int j=1;j<=n-i+1;j++){
               System.out.print(j+ " ");
           }
           System.out.println();
        }
     }
      static void pat7(int n){
        for (int i = 0; i < n; i++) {
            // space
            for (int j = 0; j <n-i-1; j++) {
                System.out.print(" ");
            }
            // star
            for (int j = 0; j <2*i+1; j++) {
                System.out.print("*");
            }
            // space
            for (int j = 0; j <n-i-1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        
      }
      static void pat8(int n){
        for (int i = 0; i < n; i++) {
            // space
            for (int j = 0; j <i; j++) {
                System.out.print(" ");
            }
            // star
            for (int j = 0; j <2*n-(2*i+1); j++) {
                System.out.print("*");
            }
            // space
            for (int j = 0; j <i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
      static void pat9(int n){
        for (int i = 0; i <=2*n-1; i++) {
            int start=i;
            if(i>n){
                start=2*n-i;
            }
            for (int j = 0; j < start; j++) {
                System.out.print(" *"+ " ");
            }
            System.out.println();
        }
      }
      static void pat10(int n){
        int start=-1;
        for (int i = 0; i < n; i++) {
            if(i%2==0){
                start=1;
            }
            else{
                start=0;
            }
            for(int j=0;j<=i;j++){
                 System.out.print(start+ " ");
                 start=1-start;
            }
            System.out.println();
        }
      }
      static void pat11(int n){
        int space=2*(n-1); 
        for (int i = 1; i <=n; i++) {
            // num
            for (int j = 1; j <=i; j++) {
                System.out.print(j);
            }
            // space
            for (int j = 1; j <=space; j++) {
                System.out.print(" ");
            }
            // num
            for (int j = i; j>=1; j--) {
                System.out.print(j);
            }
            System.out.println();  
            space-=2;
        }
      }
      static void pat12(int n){
        int count=1;
        for (int i = 0; i < n; i++) {
            for(int j=0;j<=i;j++){
                 System.out.print(count+ " ");
                 count++;
            }
            System.out.println();
        } 
      }
      static void pat13(int n){
        for (int i = 0; i < n; i++) {
            for(char j='A';j<='A'+i;j++){
                 System.out.print(j + " ");
            }
            System.out.println();
        }
      }
      static void pat14(int n){
        for (int i = 0; i < n; i++) {
            for(char j='A';j<'A'+n-i;j++){
                System.out.print(j+ " ");
            }
            System.out.println();
         }
      }
      static void pat15(int n){
        for (int i = 0; i < n; i++) {
            char ch=(char) ('A'+i);
            for(int j=0;j<=i;j++){
                 System.out.print(ch+ " ");    
            }
            System.out.println();
        }
      }
      static void pat16(int n){
      for (int i = 0; i < n; i++) {
        // space
        for (int j = 1; j <=n-i-1; j++) {
            System.out.print(" ");
        }
        // star
        char ch='A';
        int breakpoint=(2*i+1)/2;
        for (int j = 1; j <=2*i+1; j++) {
            System.out.print(ch);
            if(j<=breakpoint){
                ch++;
            }
            else{
                ch--;
            }
        }
        // space
        for (int j = 1; j <=n-i-1; j++) {
            System.out.print(" ");
        }
        System.out.println();
    }
}
      static void pat17(int n){
        for (int i = 0; i < n; i++) {
            char ch=(char) ('E'-i);
            for(int j=0;j<=i;j++){
                 System.out.print(ch+ " ");
                 ch++;
            }
            System.out.println();
        }
      }
      static void pat18(int n){
          for (int i = 0; i < n; i++) {
            // star
            for (int j = 0; j <n-i ; j++) {
                System.out.print("*");
            }
            // space
            for (int j = 0; j <2*i ; j++) {
                System.out.print(" ");
            }
            // star
            for (int j = 0; j <n-i ; j++) {
                System.out.print("*");
            }
            System.out.println();
          }
          int space=2*n-2;
          for (int i = 0; i < n; i++) {
            // star
            for (int j = 0; j <=i ; j++) {
                System.out.print("*");
            }
            // space
            for (int j = 0; j <space; j++) {
                System.out.print(" ");
            }
            // star
            for (int j = 0; j <=i ; j++) {
                System.out.print("*");
            }
            System.out.println();
            space-=2;
          }
      }
      static void pat19(int n){
        int space=2*n-2;
        for (int i = 1; i <=2*n-1; i++) {
            // star
            int star=0;
            if(i<=n){
                star=i;
            }
            else{
                star=2*n-i;
            }
            for (int j = 1; j <=star ; j++) {
                System.out.print("*");
            }
            // space
            for (int j = 1; j <=space ; j++) {
                System.out.print(" ");
            }
            // star
            for (int j = 0; j <star ; j++) {
                System.out.print("*");
            }
            System.out.println();
           if(i<n){
             space-=2;
           }
           else{
            space+=2;
           }
          }
      }
      static void pat20(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0||i==n-1||j==0||j==n-1){
                System.out.print("*" );
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println(" ");
        }
    }
      static void pat21(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<=n-i;j++){
                System.out.print(" ");
                
            }
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }
      static void pat22(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i*j<10){
                    System.out.print("0");
                }
                System.out.print(i*j + " ");
            }
            System.out.println(" ");
        }
    }
      static void pat23(int n){
        int count1=0;
        for(int i=1;i<=n;i++){
            count1=i;
            for(int j=1;j<=n;j++){
                
                System.out.print(count1 + " ");
                count1++;
            }
            System.out.println(" ");
        }
    }
      static void pat24(int n){
        for(int i=0;i<2*n-1;i++){
            for(int j=0;j<2*n-1;j++){
                int top=i;
                int bottom=(2*n-2)-i;
                int left=j;
                int right=(2*n-2)-j;
                System.out.print(n-Math.min(Math.min(top,bottom),Math.min(left, right))+" ");
            }
            System.out.println();
        }
      }    
    //   24 problem
      
      
      public static void main(String[] args) {
        pat20(4);
      }
}
