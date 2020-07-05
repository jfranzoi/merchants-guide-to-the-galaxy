# The Merchant’s Guide to the Galaxy

Sample command-line application to solve "The Merchant’s Guide to the Galaxy" coding problem.

To run it, execute:

```
./run.sh merchants.txt
```

## Requirements

This is a **Java 8** console application, built and run with **maven**.

## Notes

See [TODO](TODO.md) to follow development steps. For an overall view of the application, see **acceptance** tests. See individual **unit** tests for deailed behaviour examples.

I tried to split the problem in two iterations:

* first, achieve and end-to-end version, using **Arabic** `numerals`, simpler to implement. For example, I've used it for testing other responsibilities in isolation, such as `actions` and `prices`. 
* then, implement **Roman** `numerals`, and bind to main `application`. This was the very first moment when **acceptance** tests were executed, providing feedback on the complete problem.

In `dummies` **test** package you can find such simpler implementation of application roles (as for **Arabic** numerals, and **in-memory** I/O).

*Resulting* design is composed of a main `application` object, delegating each `content` line processing to matching `actions`. Each action can then prepare shared state (being `commands`) or add info to `result` (being `queries`). Matching action is detected applying a regexp `pattern` on line content. A `fallback` action is provided, to handle unrecognized line content.

Final notes, given examples to support were very simple:

* prices are represented by `big decimals`, but no particular rounding was required
* **Roman** `numerals` implementation is very basic, no special rules on symbols subtraction

Feel free to provide any feedback!