package Builder;

import Comparator.Comparator;
import Comparator.ComparatorInteger;

public class BuilderInteger implements Builder {
    public static final String typename = new String("Integer");
    public int value;

    public BuilderInteger(int val) {
        value = val;
    }

    public BuilderInteger() {
    }


    @Override
    public Object createObject() {
        return null;
    }

    @Override
    public Object readObject() {
        return value;
    }

    @Override
    public Object parseObject(String ss) {
        return new BuilderInteger(Integer.parseInt(ss));
    }

    @Override
    public Comparator getComparator() {
        Comparator comparator = new ComparatorInteger();
        return comparator;
    }

    @Override
    public Object clone() {
        return null;
    }

    @Override
    public String getName() {
        return "Integer";
    }


    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
