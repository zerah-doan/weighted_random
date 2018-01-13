import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TestCase {

    @Test
    public void verifyNumberOfVersion() {
        /**
         * Equivalence partition test
         */
        int[] testData = new int[500];
        testData[499] = 1;

        //Verify function works properly (return value > 0) when there are 500 versions
        Assert.assertTrue(WeightedRandom.getRandomVersion(testData) > 0);

        /**
         * Boundary test
         */
        testData = new int[1];
        testData[0] = 1;
        //Verify function works properly (return value > 0) when there are 1 versions
        Assert.assertTrue(WeightedRandom.getRandomVersion(testData) > 0);

        testData = new int[1000];
        testData[999] = 1;
        //Verify function works properly (return value > 0) when there are 1000 versions
        Assert.assertTrue(WeightedRandom.getRandomVersion(testData) > 0);


        testData = new int[0];
        //Verify function will reject input data (return -1) when input data is invalid
        Assert.assertTrue(WeightedRandom.getRandomVersion(testData) == -1);

        testData = new int[1001];
        testData[1000] = 1;
        //Verify function will reject input data (return -1) when input data is invalid
        Assert.assertTrue(WeightedRandom.getRandomVersion(testData) == -1);
    }


    @Test
    public void verifyWeightOfVersion() {
        /**
         * Equivalence partition test
         */
        int[] testData = new int[2];
        testData[1] = 500000000;

        //Verify function works properly (return value > 0) when weight =  500000000
        Assert.assertTrue(WeightedRandom.getRandomVersion(testData) > 0);

        /**
         * Boundary test
         */
        testData = new int[2];
        testData[1] = 1;
        //Verify function works properly (return value > 0) when weight =  1
        Assert.assertTrue(WeightedRandom.getRandomVersion(testData) > 0);

        testData = new int[2];
        testData[1] = 1000000000;
        //Verify function works properly (return value > 0) when weight =  1000000000
        Assert.assertTrue(WeightedRandom.getRandomVersion(testData) > 0);


        testData = new int[2];
        testData[1] = -1;
        //Verify function will reject input data (return -1) when input data is invalid
        Assert.assertTrue(WeightedRandom.getRandomVersion(testData) == -1);

        testData = new int[2];
        testData[1] = 1000000001;
        //Verify function will reject input data (return -1) when input data is invalid
        Assert.assertTrue(WeightedRandom.getRandomVersion(testData) == -1);
    }

    @Test
    public void testWeightedRandomAlgorithm() {
        int[] testData = {10, 10, 20, 60};
        int[] actualCount = {0, 0, 0, 0};
        double acceptableDeviation = 0.1 * IntStream.of(testData).sum(); // deviation  10%

        int randVersion;
        for (int i = 0; i < IntStream.of(testData).sum(); i++) {
            randVersion = WeightedRandom.getRandomVersion(testData);
            actualCount[randVersion - 1] = actualCount[randVersion - 1] + 1;
        }
        //Randomness is relative so we verify result with acceptable deviation
        System.out.println(Arrays.toString(actualCount));
        for (int i = 0; i < testData.length; i++) {
            Assert.assertTrue(Math.abs(actualCount[i] - testData[i]) < acceptableDeviation);
        }
    }
}


