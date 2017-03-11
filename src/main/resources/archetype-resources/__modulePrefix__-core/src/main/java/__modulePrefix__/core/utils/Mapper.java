package ${groupId}.${modulePrefix}.core.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

/**
 * Util class to converter both object each others.
 *
 * @param <T>
 * @param <O>
 */
public abstract class Mapper<T, O> {

    /**
     * Converter to from <O> to <T>.
     * 
     * @param rigth
     *            Object <O>
     * @return <T> after conversion
     */
    public abstract T from(final O rigth);

    /**
     * Converter to from <T> to <O>.
     * 
     * @param left
     *            Object <T>
     * @return <O> after conversion
     */
    public abstract O to(final T left);

    /**
     * Method to convert a list of <O> in a list of <T>. If list is null or
     * empty, method will return empty list
     * 
     * @param rigthList
     *            List to conversion
     * @return List after conversion
     */
    public List<T> fromList(final List<O> rigthList) {

        List<T> returnList = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(rigthList)) {
            for (final O rigth : rigthList) {
                returnList.add(from(rigth));
            }
        }

        return returnList;
    }

    /**
     * Method to convert a list of <T> in a list of <O>. If list is null or
     * empty, method will return empty list
     * 
     * @param leftList
     *            List to conversion
     * @return List after conversion
     */
    public List<O> toList(final List<T> leftList) {

        List<O> returnList = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(leftList)) {
            for (final T left : leftList) {
                returnList.add(to(left));
            }
        }

        return returnList;
    }

}