package project2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class RatingSummaryTest {

	public RatingSummary rs;
	
	@BeforeEach
	public void setup() {
		rs = new RatingSummary("A1EE2E3N7PW666", 2);
	}

	/**
	 * Tests the createList method by making 3 different lists.
	 * First one of them with large positive values.
	 * The second one with large negative values.
	 * The last one with zeros
	 */
	@Test
	public void testCreateList() {
		List<Float> test = new ArrayList<Float>();
		test.add(Float.valueOf(10000));
		test.add(Float.valueOf(20000));
		test.add(Float.valueOf(30000));
		test.add(Float.valueOf(40000));
		Assertions.assertTrue(test.equals(rs.createList(10000,20000,30000,40000)));

		List<Float> test2 = new ArrayList<Float>();
		test2.add(Float.valueOf(-100000));
		test2.add(Float.valueOf(-90000));
		test2.add(Float.valueOf(-80000));
		test2.add(Float.valueOf(-70000));
		Assertions.assertTrue(test2.equals(rs.createList(-100000,-90000,-80000,-70000)));

		List<Float> test3 = new ArrayList<Float>();
		test3.add(Float.valueOf(0));
		test3.add(Float.valueOf(0));
		test3.add(Float.valueOf(0));
		test3.add(Float.valueOf(0));
		Assertions.assertTrue(test3.equals(rs.createList(0,0,0,0)));
	}


	@Test
	void testRatingSummaryStringLongListOfFloat() {
		String actualOutput = "A1EE2E3N7PW666,2,2.0,2.0,2.0,2.0\n";
		rs.setList(2, 2, 2, 2);
		Assertions.assertTrue(actualOutput.equals(rs.toString()));
	}

	/**
	 * Tests the toString method 4 different times. In addition different constructors where used in each test.
	 */
	@Test
	void testToString() {
		rs = new RatingSummary("A1EE2E3N7PW666", 5);
		String expectedResult = "A1EE2E3N7PW666,5,\n";
		Assertions.assertEquals(expectedResult, rs.toString());

		List<Float> listTest = new ArrayList<Float>();
		listTest.add(Float.valueOf(1));
		listTest.add(Float.valueOf(2));
		listTest.add(Float.valueOf(3));
		listTest.add(Float.valueOf(4));
		rs = new RatingSummary("B1EE2E3N7PW666", 5, listTest);
		expectedResult = "B1EE2E3N7PW666,5,1.0,2.0,3.0,4.0\n";
		Assertions.assertEquals(expectedResult, rs.toString());

		rs = new RatingSummary("B1EE2E3N7PW666", 4, 3, 2, 1, 0);
		expectedResult = "B1EE2E3N7PW666,4,3.0,2.0,1.0,0.0\n";
		Assertions.assertEquals(expectedResult, rs.toString());

		List<Rating> listRawRatingTest = new ArrayList<>();
		Rating ratingTest1 = new Rating("A1EE2E3N7PW666","B000GFDAUG",  5);
		Rating ratingTest2 = new Rating("AGZ8SM1BGK3CK","B000GFDAUG",  4);
		Rating ratingTest3 = new Rating("AQNPK1Q7HIAP3","B000GOYLNC",  3);
		Rating ratingTest4 = new Rating("AQNPK1Q7HIAP3","B007427XS4",  2);
		Rating ratingTest5 = new Rating("A1EE2E3N7PW666","B007427XS4",  5);
		listRawRatingTest.add(ratingTest1);
		listRawRatingTest.add(ratingTest2);
		listRawRatingTest.add(ratingTest3);
		listRawRatingTest.add(ratingTest4);
		listRawRatingTest.add(ratingTest5);
		rs = new RatingSummary("B1EE2E3N7PW666", listRawRatingTest);
		expectedResult = "B1EE2E3N7PW666,0,NaN,NaN,NaN,NaN\n";
		Assertions.assertEquals(expectedResult, rs.toString());
	}

	/**
	 * Tests the avgScore method 4 different times.
	 */
	@Test
	public void testAvgScore() {
		List<Rating> listRawRatingTest = new ArrayList<>();
		Rating ratingTest1 = new Rating("A1EE2E3N7PW666","B000GFDAUG",  5);
		Rating ratingTest2 = new Rating("AGZ8SM1BGK3CK","B000GFDAUG",  4);
		Rating ratingTest3 = new Rating("AQNPK1Q7HIAP3","B000GOYLNC",  3);
		Rating ratingTest4 = new Rating("AQNPK1Q7HIAP3","B007427XS4",  2);
		Rating ratingTest5 = new Rating("A1EE2E3N7PW666","B007427XS4",  5);
		listRawRatingTest.add(ratingTest1);
		listRawRatingTest.add(ratingTest2);
		listRawRatingTest.add(ratingTest3);
		listRawRatingTest.add(ratingTest4);
		listRawRatingTest.add(ratingTest5);

		rs = new RatingSummary("A1EE2E3N7PW666", listRawRatingTest);
		rs.collectStats(listRawRatingTest);
		Float expectedResult = 1.0f;
		Assertions.assertEquals(expectedResult, rs.avgScore());

		rs = new RatingSummary("AGZ8SM1BGK3CK", listRawRatingTest);
		rs.collectStats(listRawRatingTest);
		expectedResult = 0.5f;
		Assertions.assertEquals(expectedResult, rs.avgScore());

		rs = new RatingSummary("B000GFDAUG", listRawRatingTest);
		rs.collectStats(listRawRatingTest);
		expectedResult = 0.16666651f;
		Assertions.assertEquals(expectedResult, rs.avgScore());

		rs = new RatingSummary("HHHHHHHHHH", listRawRatingTest);
		rs.collectStats(listRawRatingTest);
		expectedResult = 0.0f/0.0f; // This makes Java produce a NaN result
		Assertions.assertEquals(expectedResult, rs.avgScore());

	}

	/**
	 * Tests the stDevScore method 4 different times.
	 */
	@Test
	public void testStDevScore() {
		List<Rating> listRawRatingTest = new ArrayList<>();
		Rating ratingTest1 = new Rating("A1EE2E3N7PW666","B000GFDAUG",  5);
		Rating ratingTest2 = new Rating("AGZ8SM1BGK3CK","B000GFDAUG",  4);
		Rating ratingTest3 = new Rating("AQNPK1Q7HIAP3","B000GOYLNC",  3);
		Rating ratingTest4 = new Rating("AQNPK1Q7HIAP3","B007427XS4",  2);
		Rating ratingTest5 = new Rating("A1EE2E3N7PW666","B007427XS4",  5);
		listRawRatingTest.add(ratingTest1);
		listRawRatingTest.add(ratingTest2);
		listRawRatingTest.add(ratingTest3);
		listRawRatingTest.add(ratingTest4);
		listRawRatingTest.add(ratingTest5);

		rs = new RatingSummary("A1EE2E3N7PW666", listRawRatingTest);
		rs.collectStats(listRawRatingTest);
		Float expectedResult = 1.2247449f;
		Assertions.assertEquals(expectedResult, rs.stDevScore());

		rs = new RatingSummary("AGZ8SM1BGK3CK", listRawRatingTest);
		rs.collectStats(listRawRatingTest);
		expectedResult = 0.5f;
		Assertions.assertEquals(expectedResult, rs.stDevScore());

		rs = new RatingSummary("B000GFDAUG", listRawRatingTest);
		rs.collectStats(listRawRatingTest);
		expectedResult = 0.028595477f;
		Assertions.assertEquals(expectedResult, rs.stDevScore());

		rs = new RatingSummary("HHHHHHHHHH", listRawRatingTest);
		rs.collectStats(listRawRatingTest);
		expectedResult = 0.0f/0.0f; // This makes Java produce a NaN result
		Assertions.assertEquals(expectedResult, rs.stDevScore());
	}

	/**
	 * Tests the calculateSD method 3 different times.
	 */
	@Test
	public void testCalculateSD() {
		List<Double> testNum = new ArrayList<>();
		testNum.add(1.0);
		testNum.add(5.0);
		testNum.add(10.0);
		testNum.add(20.0);
		testNum.add(15.0);
		testNum.add(9.0);
		Float testMean = 10f;
		Float expectedResult = 6.2182527f;
		Assertions.assertEquals(expectedResult, rs.calculateSD(testNum,testMean));

		testNum.removeAll(testNum);
		testNum.add(-1000.0);
		testNum.add(-322.0);
		testNum.add(-3451.0);
		testNum.add(-92.0);
		testNum.add(-1.0);
		testNum.add(-73213100.0);
		testMean = -12202994.333333f;
		expectedResult = 27284548.74f;
		Assertions.assertEquals(expectedResult, rs.calculateSD(testNum,testMean));

		testNum.removeAll(testNum);
		testNum.add(0.0);
		testMean = 0.0f;
		expectedResult = 0.0f;
		Assertions.assertEquals(expectedResult, rs.calculateSD(testNum,testMean));
	}

	// From class AbstractRatingSummary
	/**
	 * Tests the SetDegreeLong method 4 different times.
	 * First test uses a small number.
	 * Second test uses a large negative number.
	 * Third test uses zero.
	 * Last test uses positive large number.
	 */
	@Test
	void testSetDegreeLong() {
		rs.setDegree(3);
		Assertions.assertEquals(3,rs.getDegree());

		rs.setDegree(-785654);
		Assertions.assertEquals(-785654,rs.getDegree());

		rs.setDegree(0);
		Assertions.assertEquals(0,rs.getDegree());

		rs.setDegree(89656);
		Assertions.assertEquals(89656,rs.getDegree());
	}
}
