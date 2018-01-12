# Requirements:
* Describe your strategy to solve the task and how you test your code to make sure it
works as expected.
* Implement a function to take an array w[] as input and return a message version number
that satisfies weighted random condition.
* Write tests to cover your code, make sure that the weighted random condition is satisfied
and all edge cases are checked properly.
* Your code should be production ready, well organised and well tested.


# Answer
## Startegy to implement task
Base on inputed array of weight to generate a pool, then randomly select an element in that pool
```
Example:
Inputed array of weight: [0, 3, 1, 8]
It means
* There are 4 versions (N = 4)
* Weight of version 1 is 0 (w[1] = 0)
* Weight of version 2 is 3 (w[2] = 3)
* Weight of version 3 is 1 (w[3] = 1)
* Weight of version 4 is 8 (w[4] = 8)
So the pool will be [2, 2, 2, 3, 4, 4, 4, 4, 4, 4, 4, 4]
Then randonly select an elelment of pool => solved
```

## Strategy to test
To check the random algorithm is weighted correctly, we can do it both way: manual or auto test.

### Manual
Because of limitation of manual test, in order to test this algorithm we have to wisely select input data
```
Example of test data:
* [1, 0, 1000] => expected result: most of time, the result will be message version 3
* [9999, 1] => expected result: most of time, the result will be message version 1
* ...
```
So the trategy is to set a very high weight for a specific version and expect that version will be retunred most of the time

### Automated
Automation can overcome the limitation of manual test

//TO DO

