import Builder.Builder;
import List.TList;
import org.junit.Before;
import org.junit.Test;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class TestingList {

    private Factory factory;
    private Builder builder;
    private TList actual, expected;

    @Before
    public void setUp() throws Exception {
        factory = new Factory();
        builder = factory.getBuilderByName("Integer");
        actual = new TList(builder);
        expected = new TList(builder);
    }

    /**
     * Набор содержит одинаковые значения
     */
    @Test
    public void identicalValuesTest() {
        for (int i = 0; i <= 10; i++) {
            actual.pushEnd(builder.parseObject(0 + ""));
            expected.pushEnd(builder.parseObject(0 + ""));
        }
        actual.sort(builder.getComparator());
        assertEquals(expected.toString(), actual.toString());
    }

    /**
     * Набор упорядочен в прямом порядке
     */
    @Test
    public void directOrderTest() {
        for (int i = 0; i <= 10; i++) {
            actual.pushEnd(builder.parseObject(i + ""));
        }
        for (int i = 0; i <= 10; i++) {
            expected.pushEnd(builder.parseObject(i + ""));
        }

        actual.sort(builder.getComparator());
        assertEquals(expected.toString(), actual.toString());
    }


    /**
     * Набор упорядочен в обратном порядке
     */
    @Test
    public void reverseOrderTest() {
        for (int i = 10; i >= 0; i--) {
            actual.pushEnd(builder.parseObject(i + ""));
        }
        for (int i = 0; i <= 10; i++) {
            expected.pushEnd(builder.parseObject(i + ""));
        }

        actual.sort(builder.getComparator());
        assertEquals(expected.toString(), actual.toString());
    }

    /**
     * Имеются повторяющиеся элементы
     */
    @Test
    public void duplicateElementsTest() {
        ArrayList<String> elements = new ArrayList<>(Arrays.asList("30", "30", "40", "10", "20"));
        for (String element : elements) {
            actual.pushEnd(builder.parseObject(element));
        }
        Collections.sort(elements);
        for (String element : elements) {
            expected.pushEnd(builder.parseObject(element));
        }

        actual.sort(builder.getComparator());
        assertEquals(expected.toString(), actual.toString());
    }

    /**
     * Несколько групп повторяющихся элементов
     */
    @Test
    public void multipleDuplicateElementsTest() {
        ArrayList<String> elements = new ArrayList<>(Arrays.asList("30", "30", "40", "20", "20"));
        for (String element : elements) {
            actual.pushEnd(builder.parseObject(element));
        }
        Collections.sort(elements);
        for (String element : elements) {
            expected.pushEnd(builder.parseObject(element));
        }

        actual.sort(builder.getComparator());
        assertEquals(expected.toString(), actual.toString());
    }

    /**
     * Экстремальное значение находится в начале
     */
    @Test
    public void extremeValueAtBegin() {
        ArrayList<Integer> values =  new ArrayList<>();
        values.add(9999999);
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);
        values.add(5);
        values.add(6);
        values.add(7);
        values.add(8);
        values.add(9);
        values.add(10);
        values.add(11);
        values.add(12);
        values.add(13);
        values.add(14);
        values.add(15);

        for (Integer value : values) {
            actual.pushEnd(builder.parseObject(value.toString()));
        }

        Collections.sort(values);
        for (Integer value : values) {
            expected.pushEnd(builder.parseObject(value.toString()));
        }

        actual.sort(builder.getComparator());
        assertEquals(expected.toString(), actual.toString());
    }

    /**
     * Экстремальное значение находится в середине
     */
    @Test
    public void extremeValueAtMiddle() {
        ArrayList<Integer> values =  new ArrayList<>();
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);
        values.add(5);
        values.add(6);
        values.add(7);
        values.add(9999999);
        values.add(8);
        values.add(9);
        values.add(10);
        values.add(11);
        values.add(12);
        values.add(13);
        values.add(14);
        values.add(15);

        for (Integer value : values) {
            actual.pushEnd(builder.parseObject(value.toString()));
        }

        Collections.sort(values);
        for (Integer value : values) {
            expected.pushEnd(builder.parseObject(value.toString()));
        }

        actual.sort(builder.getComparator());
        assertEquals(expected.toString(), actual.toString());
    }

    /**
     * Экстремальное значение находится в конце
     */
    @Test
    public void extremeValueAtEnd() {
        ArrayList<Integer> values =  new ArrayList<>();
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(10);
        values.add(11);
        values.add(12);
        values.add(13);
        values.add(4);
        values.add(5);
        values.add(6);
        values.add(7);
        values.add(8);
        values.add(9);
        values.add(14);
        values.add(15);
        values.add(9999999);

        for (Integer value : values) {
            actual.pushEnd(builder.parseObject(value.toString()));
        }

        Collections.sort(values);
        for (Integer value : values) {
            expected.pushEnd(builder.parseObject(value.toString()));
        }

        actual.sort(builder.getComparator());
        assertEquals(expected.toString(), actual.toString());
    }

    /**
     * Несколько совпадающих экстремальных значений
     */
    @Test
    public void multiplyExtremeValues() {
        ArrayList<Integer> values =  new ArrayList<>();
        values.add(9999999);
        values.add(2);
        values.add(3);
        values.add(4);
        values.add(5);
        values.add(6);
        values.add(7);
        values.add(9999999);
        values.add(9);
        values.add(10);
        values.add(11);
        values.add(12);
        values.add(13);
        values.add(14);
        values.add(15);
        values.add(9999999);

        for (Integer value : values) {
            actual.pushEnd(builder.parseObject(value.toString()));
        }

        Collections.sort(values);
        for (Integer value : values) {
            expected.pushEnd(builder.parseObject(value.toString()));
        }

        actual.sort(builder.getComparator());
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void sortPerformanceTest() {
        for (int i = 1; i < 1025; i *= 2) {
            int n = i * 100000;
            System.out.print(n + "\t");
            TList list = new TList(builder);

            for (int j = 0; j < n; j++) {
                list.pushEnd(builder);
            }

            long start = System.nanoTime();
            try {
                list.sort(builder.getComparator());
            } catch (StackOverflowError err) {
                System.out.println("Error stack");
            }
            long end = System.nanoTime();

            System.out.println((end - start) * 1.0 / 1_000_000);
        }
    }
}
