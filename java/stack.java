import java.util.LinkedList;
import java.util.Queue;
// public class stack {
//     int arr[] = new int[100];
//     int top1 = -1;          
//     int top2 = arr.length; 
//     void push1(int x) {
//         top1++;   // aage sa aage badhate jao
//         arr[top1] = x;
//     }// Function to push an integer into the stack2.
//     void push2(int x) {
//         top2--;    // pich sa dalna hai
//         arr[top2] = x;
//     } // Function to remove an element from top of the stack1.
//     int pop1() {
//         if(top1 == -1){
//             return -1;
//         }
//         else return arr[top1--];
//     }   // Function to remove an element from top of the stack2.
//     int pop2() {
//         if(top2 == arr.length){
//             return -1;
//         }
//         else return arr[top2++];
//     }
//     int top() {
//         return arr[top1];  
//     }
    // public class stack{
    //        Stack<node> s;
    //        class node{
    //         int val, min;
    //         public node(int val,int min){
    //             this.val=val;
    //             this.min=min;
    //        }
    //     }
    //        public stack(){
    //         this.s=new Stack<node>();
    //        }
    //        void push(int x){
    //            if(s.isEmpty()){
    //             this.s.push(new node(x,x));
    //            }
    //            else{
    //             int min=(Math.min(this.s.peek().min, x));
    //             this.s.push(new node(x,min));
    //            }
    //        }
    //        int pop(){
    //         return this.s.pop().val;
    //        }
    //        int peek(){
    //         return this.s.peek().val;
    //        }
    //        int getminn(){
    //         return this.s.peek().min;
    //        }
    // class stack {
    //     Stack<Integer> input,output;
    
    //     public stack() {
    //         input = new Stack<>();
    //         output = new Stack<>();
            
    //     }
        
    //     public void push(int x) {
    //         input.push(x);
    //     }
        
    //     public int pop() {
    //         if(output.empty() != true)
    //             return output.pop();
    //         else{
    //             while(input.empty() == false)
    //                 output.push(input.pop());
    //         }
    //         return output.pop();
    //     }
        
    //     public int peek() {
    //         if(output.empty() != true)
    //             output.peek();
    //         else{
    //             while(input.empty() == false)
    //                 output.push(input.pop());
    //         }
    //         return output.peek();
    //     }
        
    //     public boolean empty() {
    //         return input.empty() && output.empty();
    //     }
    class stack {
        Queue<Integer> q1;
        Queue<Integer> q2;
        public stack() {
            q1=new LinkedList<>();
            q2=new LinkedList<>();
        }
        
        public void push(int x) {
            q1.add(x);
            
        }
        
        public int pop() {
            int temp=0;
            while(!q1.isEmpty()){
            temp =q1.peek();      
            q2.add(q1.poll());
            }
            while(q2.size()>1){
                q1.add(q2.poll());
            }
            q2.poll();
            return temp;
        }
        
        public int top() {
            int temp=0;
            while(!q1.isEmpty()){
            temp =q1.peek();      
            q2.add(q1.poll());
            }
            while(!q2.isEmpty()){
                q1.add(q2.poll());
            }
    
            return temp;
        }
        
        public boolean empty() {
            if(q1.size()==0){
                return true;
            }
            return false;
        }
    
    
    






public static void main(String[] args) {
    stack s = new stack();
  s.push(-1);
  s.push(10);
  s.push(-4);
  s.push(0);
//   System.out.println(s.getminn());
//   System.out.println(s.pop());
//   System.out.println(s.pop());
//   System.out.println(s.getminn());
    }
}
