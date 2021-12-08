import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PersonTest {
    @BeforeMethod
    public void setUp() {
        System.out.println("Start test");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Stop test");
    }
    @DataProvider(name = "olderTeenager")
    Object[][] olderTeenager() {
        return new Object[][] {
                {20, false},
                {55, false}
        };
    }
    @DataProvider(name = "teenager")
    Object[][] teenager() {
        return new Object[][]{
                {13, true},
                {19, true},
                {15, true}
        };
    }
    @DataProvider(name = "youngerTeenager")
    Object[][] youngerTeenager() {
        return new Object[][] {
                {2, false},
                {12, false}
        };
    }
    @Test(dataProvider = "youngerTeenager")
    public void test1(int age, boolean expectedResult) {
        boolean result = Person.isTeenager(age);
        assertEquals(result,expectedResult);
    }
    @Test(dataProvider = "teenager")
    public void test2(int age, boolean expectedResult) {
        boolean result = Person.isTeenager(age);
        assertEquals(result,expectedResult);
    }
    @Test(dataProvider = "olderTeenager")
    public void test3(int age, boolean expectedResult) {
        boolean result = Person.isTeenager(age);
        assertEquals(result,expectedResult);
    }
}
