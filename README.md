# rnp-calculator
## Requirements
The calculator has a stack that can contain real numbers.  
- The calculator waits for user input and expects to receive strings containing whitespace separated lists of numbers
- Numbers are pushed on to the stack. Operators operate numbers that pushed on to the stack.
- Available operators are +,  -, *, /, sqrt, undo, clear.
- Operators pop their parameters off the stack, and push results back onto stack. 
- The ‘clear’ operation removes all items from the stack.
- The ‘undo’ operation undoes the previous operationRecord.“undo undo ” will undo the previous two operations.
- sqrt performs a square root on the top item from stack.
- The ‘+’,‘ -’, ‘*’, ‘/’ operators perform addition, subtraction, multiplication and division respectively on the top two items from the stack.
- After processing an input string, the calculator displays current contents of stack as a space-separated list.
- Numbers should be stored on the stack to at least 15 decimal places of precision, but displayed to 10 decimal places (or less if it causes no loss of precision).
- All numbers should be formatted as plain decimal strings (ie. no engineering formatting).
- If an operation cannot find a sufficient number of parameters on the stack, warning is displayed:  
operation <operation> (position: pos>): insufficient parameters
- After displaying the warning, all further processing of string terminates and current state stack is displayed.
