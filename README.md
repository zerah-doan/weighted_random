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
How this algorithm works:
* Add up all the weight
* Randomly pick a number from 1 to sum of weights
* Iterate over versions, subtract random weight by version weight
* Compare result to 0, if less than or equal to zero then get that version

The larger the weight the more likely to be less than zero

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
So the trategy is to set a very high weight for a specific version and expect that version will be retunred most of the time. OR set 0 weight for a version and expect that version will never be returned.


### Automated
Automation can overcome the limitation of manual test that we can loop for thousand times and compare actual result with given weight.
BUT we have to accept the fact that randomness is relative so the result of randomness may have deviation. In my test code i set the deviation = 10%/sum of weights



