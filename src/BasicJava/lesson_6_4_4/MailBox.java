package BasicJava.lesson_6_4_4;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * The class contains overridden method get()
 * Created by btow on 28.11.2016.
 */
public class MailBox<V>
        extends LinkedHashMap<String, List<V>> {

    public MailBox() {

        super(new HashMap<String, List<V>>());

    }

    @Override
    public List<V> get(Object key) {

        ParameterizedType parameterizedType = (ParameterizedType) this.values().getClass().getGenericSuperclass();
        List list = setParametersList(parameterizedType);
        list = super.getOrDefault(key, list);
        return list;

    }

    private List setParametersList(ParameterizedType parameterizedType) {

        return ((Class) parameterizedType.getActualTypeArguments()[0]).toString().equals("String")
                ? new ArrayList<String>() : new ArrayList<Integer>();

    }

}
