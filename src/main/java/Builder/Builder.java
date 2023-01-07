package Builder;

import Comparator.Comparator;

public interface Builder {
    Object createObject();
    Object readObject();
    Object clone();
    Object parseObject(String ss);
    Comparator getComparator();
    String getName();
}
