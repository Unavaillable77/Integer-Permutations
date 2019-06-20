# Integer-Permutations-Challenge
Two non-negative integers are called Similar if they can be obtained by each other by
rearranging the digits of their decimal representations.

Write the function:
```java
public static String solution(String input) throws NumberFormatException {
  return null;
}
```

That, given any String input, returns all the distinct Similar integers that can be formed by the
positive integers in descending order. Please keep in mind the efficiency
of your algorithm when writing the solution.

## For example:
- If the input provided is: “236”, then your solution should return "632,623,362,326,263,236"
as these are all the combination that can be made with integers that the string contains
- If the input provided is: “A 3B2 C6D”, then your solution should return
"632,623,362,326,263,236" as well, but this time notice that the provided string had
non-integers characters and whitespaces, so an extraction of integers was first made to
obtain the correct solution
- If the input provided does not contain any integers: “ABC”, then your solution should
return the appropriate error exception message.

## Solution
I've completed this challenge by firstly extracting all the integers from the String and putting them in a set.
That would then be run through an algortithem that: 
- Used a tree set in order to get rid of duplicates
- Gave each character a chance to be the first one in the permuted integer
- Removed said character and recursively did the same with the remaining characters until only 1 was left
- Outputed the integers to the tree set

Said set was then converted into an ArrayList which was sorted in a descending order as required by the challenge. 

Thank you! 
