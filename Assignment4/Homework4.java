//
// Homework4.java
// Nicholas Schantz
// Implement an algorithm that uses stacks to add numbers of any size.
//

class Homework4 {
    //question a
    public static void addLargeNumbers(String num1, String num2) {
        // put num1 on a stack
        Stack<String> stack1 = new Stack<String>();
        for (int chpos = 0; chpos < num1.length(); chpos++) {
            String str1 = String.valueOf(num1.charAt(chpos));
            stack1.push(str1);
        }
        // put num2 on a stack
        Stack<String> stack2 = new Stack<String>();
        for (int chpos = 0; chpos < num2.length(); chpos++) {
            String str2 = String.valueOf(num2.charAt(chpos));
            stack2.push(str2);
        }

        int result = 0;
        Stack<String> result_stack = new Stack<String>();
        while (!(stack1.isEmpty() && stack2.isEmpty())) {
            // pop numeral from each non-empty stack and add to result
            if(!stack1.isEmpty()) {
                result += Integer.parseInt(stack1.pop());
            }
            if (!stack2.isEmpty()) {
                result += Integer.parseInt(stack2.pop());
            }
            // push unit part of addition to the result stack
            result_stack.push(Integer.toString(result % 10));

            // store the carry part of the addition in result
            result = result / 10;
        }
        // push result onto the result stack if it is not zero
        if (result != 0) {
            result_stack.push(Integer.toString(result));
        }
        // pop numbers from the result stack and display them
        while (!result_stack.isEmpty()) {
            System.out.print(result_stack.pop());
        }
        System.out.print("\n");
    }
    
    // question b
    public static void main(String[] args){
        // demonstrate adding at least three pairs of large numbers
        Homework4.addLargeNumbers("71962291457978654321687652138765132", "454750642987965465213216579846541");
        Homework4.addLargeNumbers("90404792516587621321687632135498413621", "299790265978645312465789465231465978564231");
        Homework4.addLargeNumbers("62266024195195498498798978645621612615", "29442068743253452357466785678678987465123645");
        Homework4.addLargeNumbers("1987463216874632138746321035746325103", "4987621320687632513254168541320354");
    }
}
