package BasicJava.lesson_6_1;

import javax.lang.model.element.Element;
import java.util.*;

/**
 *
 * Created by btow on 21.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!

//        Collection<?> collection = new ArrayList<>();
//        Object object = new String("Hello!");
//
//        collection.addAll(Arrays.asList(object));
//        boolean objectAdded = collection.add(object);
//        Iterator<?> it = collection.iterator();
//        Integer collectionSize = collection.size();
//        boolean collectionContainsObject = collection.contains(object);
//        Object[] words = collection.toArray();
//        collection.clear();
//        boolean jbjectRemovedFromCollection = collection.remove(object);
//
//        Set<String> set = new LinkedHashSet<>();
//// add some elements to the set
//        Iterator<String> iterator = set.iterator();

    }

    public static <T extends Element> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {

        Set<? extends T> firstSet = new HashSet<T>(set1),
                secondSet = new HashSet<T>(set2),
                retainSet = new HashSet<T>(set2);
        Set<T> result = new HashSet<T>(set1);

        boolean retainSetContainsDatas = retainSet.retainAll(firstSet);
        boolean resultContainsAllUnicalElementsOfFirstAndSecondSets = result.addAll(secondSet);
        boolean resultContainsSymmetricDifferenceOfFirstAndSecondSets = result.removeAll(retainSet);
        boolean stopFlag = retainSetContainsDatas
                & resultContainsAllUnicalElementsOfFirstAndSecondSets
                & resultContainsSymmetricDifferenceOfFirstAndSecondSets;

        if (!stopFlag) {
            result = null;
        }
        return result;

    }
}
