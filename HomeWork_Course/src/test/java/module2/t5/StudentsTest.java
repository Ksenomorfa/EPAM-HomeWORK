package module2.t5;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static module2.t5.Subject.*;
import static org.junit.Assert.*;

/**
 * Huge test class for few test with students list. We have one list of results for all
 * students which we can compare in some reasons.
 */
public class StudentsTest {
    Student student1;
    Student student2;
    Student student3;
    Student student4;
    Result results[];

    RateComparator rateComparator;
    StudentComparator studentComparator;
    SubjectComparator subjectComparator;
    BiComparator biComparator;
    List<Result> expectedList;
    @Before
    public void init() {
        student1 = new Student("Petrov P.");
        student2 = new Student("Ivanov I.");
        student3 = new Student("Sidorov S.");
        student4 = new Student("Kirov K.");

        results = new Result[]{
                new Result(student1, PHYSICS, 4),
                new Result(student2, PHYSICS, 5),
                new Result(student3, PHYSICS, 2),
                new Result(student4, PHYSICS, 3),
                new Result(student1, COSMOLOGY, 3),
                new Result(student2, COSMOLOGY, 4.5),
                new Result(student3, COSMOLOGY, 5),
                new Result(student4, COSMOLOGY, 3.5),
                new Result(student4, CHEMISTRY, 3.8),
                new Result(student1, CHEMISTRY, 5),
                new Result(student2, CHEMISTRY, 5),
                new Result(student3, CHEMISTRY, 4.2),
        };
        rateComparator = new RateComparator();
        studentComparator = new StudentComparator();
        subjectComparator = new SubjectComparator();
        biComparator = new BiComparator(subjectComparator, rateComparator);
        expectedList = new ArrayList<>();
    }

    @Test
    public void testRateComparatorInResults() {
        expectedList.add(results[10]);
        Arrays.sort(results, rateComparator);
        assertEquals(expectedList.get(0),results[0]);
    }

    @Test
    public void testStudentComparatorInResults() {
        expectedList.add(results[1]);
        Arrays.sort(results, studentComparator);
        assertEquals(expectedList.get(0),results[0]);
    }

    @Test
    public void testSubjectComparatorInResults() {
        expectedList.add(results[0]);
        Arrays.sort(results, subjectComparator);
        assertEquals(expectedList.get(0),results[0]);
    }

    @Test
    public void testTop3StudentsInPhysics() {
        Arrays.sort(results, biComparator);

        List<Result> topList = new ArrayList<>();
        for (Result result : results) {
            if (result.getSubject() == PHYSICS)
                topList.add(result);
        }
        topList = topList.subList(0, 3);

        expectedList.add(results[0]);
        expectedList.add(results[1]);
        expectedList.add(results[2]);

        assertArrayEquals(expectedList.toArray(), topList.toArray());
    }

    @Test
    public void testStudentsWithNormalBallsInChemistry() {
        Arrays.sort(results, biComparator);

        List<Result> normalList = new ArrayList<>();
        for (Result result : results) {
            if ((result.getSubject() == CHEMISTRY) &&
                    (result.getRate().intValue() >= 4))
                normalList.add(result);
        }

        expectedList.add(results[4]);
        expectedList.add(results[5]);
        expectedList.add(results[6]);

        assertArrayEquals(expectedList.toArray(), normalList.toArray());
    }
}