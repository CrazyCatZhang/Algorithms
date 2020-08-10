# Stack

## 1. Basic Introduction

 - ##### The stack is an ordered list of FILO-FirstInLastOut.

 - ##### A stack is a special linear table that restricts the insertion and deletion of elements in the linear table to the same end of the linear table. The end that allows insertion and deletion is the changing end, called the top of the stack (Top), and the other end is the fixed end, called the bottom of the stack (Bottom).

 - ##### According to the definition of the stack, the first element placed in the stack is at the bottom of the stack, and the last element placed is at the top of the stack, while the deleted element is just the opposite. The last element placed is the first to be deleted, and the first element is deleted last.

## 2. Applications

 - ##### Subroutine call: Before jumping to the subroutine, the address of the next instruction will be stored on the stack. After the subroutine is executed, the address will be fetched to return to the original program.

 - ##### Handling recursive calls: similar to subroutine calls, except that in addition to storing the address of the next instruction, data such as parameters and area variables are also stored on the stack.

 - ##### Expression conversion [infix expression to postfix expression] and evaluation

 - ##### Traversal of binary tree

 - ##### Graphics depth first search

## 3. Experiment

 - ##### [ArrayStack](https://github.com/CrazyCatZhang/Algorithms/tree/master/AlgsAndDs/Datastructures/src/com/catzhang/stack/arraystack)

 - ##### [Calculator](https://github.com/CrazyCatZhang/Algorithms/tree/master/AlgsAndDs/Datastructures/src/com/catzhang/stack/calculator)

 - ##### [ReversePolishNotation](https://github.com/CrazyCatZhang/Algorithms/tree/master/AlgsAndDs/Datastructures/src/com/catzhang/stack/reversepolishnotation)





