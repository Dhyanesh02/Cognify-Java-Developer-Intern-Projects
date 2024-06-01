# Palindrome Checker

## Description
This program checks whether a given word or phrase is a palindrome. A palindrome is a word or phrase that reads the same forwards and backwards, ignoring spaces, punctuation, and capitalization.

## Skills
- String manipulation
- Loops
- Conditional statements

## How It Works
The program:
1. **Cleans the input** by removing all non-alphanumeric characters and converting the remaining characters to lowercase.
2. **Checks if the cleaned string** reads the same forwards and backwards.
3. **Interacts with the user** to check multiple words or phrases until they decide to stop.

## Pseudocode

### Functions:

#### `isPalindrome(word)`
- Creates an empty StringBuffer called `word`.
- Iterates through each character in `word`:
  - If the character is a letter or digit, it appends it to `cleanedWord`.
- Converts `cleanedWord` to a lowercase string called `cleanedString`.
- Uses two pointers, `i` and `j`, to compare characters from the beginning and end of `cleanedString` moving towards the center.
- Returns `true` if all corresponding characters are equal, `false` otherwise.

#### `findMore(choice, condition)`
- If `choice` is "no", sets `condition` to `false` and prints a thank you message.
- Returns `condition`.

### Main Function:
- Prints a welcome message.
- Creates a Scanner object called `input`.
- Sets `condition` to `true`.
- While `condition` is `true`:
  - Prompts the user to enter a word or phrase.
  - Reads the line of input into `word`.
  - Calls `isPalindrome` to check if `word` is a palindrome and prints the result.
  - Asks the user if they want to check another word or phrase.
  - Reads the user's choice and converts it to lowercase.
  - Sets `condition` based on the result of `findMore(choice, condition)`.
  - Prints a separator line.
- Closes the Scanner object.

## Sample Input and Output

### Example 1:
 - Enter a word or phrase:
    - A man, a plan, a canal, Panama
    - The input is a palindrome.
### Example 2:
 - Enter a word or phrase:
    - Hello, World!
    - The input is not a palindrome.