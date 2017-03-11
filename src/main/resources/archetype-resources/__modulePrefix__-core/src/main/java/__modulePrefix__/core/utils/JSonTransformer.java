package ${groupId}.${modulePrefix}.core.utils;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * JSonTransformer
 */
public abstract class JSonTransformer {

    private static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

    private JSonTransformer() {
        super();
    }

    /**
     * Convert object to json, if object is null then the method will return
     * null.
     *
     * @param object
     *            object
     * @return Json string
     */
    public static String convertToJson(final Object object) {

        String json = null;

        if (object != null) {
            json = gson.toJson(object);
        }
        return json;
    }

    /**
     * Converter from json file to an object, if json is empty then the method
     * will be return a null object
     *
     * @param json
     *            Json
     * @param clazz
     *            Classe
     * @param <T>
     *            T
     * @return Object
     */
    public static <T> T convertToObject(final String json, final Class<T> clazz) {

        T object = null;

        if (StringUtils.isNotEmpty(json)) {
            object = gson.fromJson(json, clazz);
        }

        return object;
    }
}