package com.vn.osp.notarialservices.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;

/**
 * Created by nmha on 3/24/2017.
 */
public class StringUtils {
    private static final Logger logger = Logger.getLogger(StringUtils.class);

    private static ObjectMapper om;

    public static ObjectMapper getObjectMapper() {
        if (om == null) {
            om = new ObjectMapper();
        }
        return om;
    }

    public static String getJson(Object object) {
        ObjectMapper mapper = getObjectMapper();
        if (object != null) {
            try {
                return mapper.writeValueAsString(object);
            } catch (JsonProcessingException e) {
                logger.error("Get JSON string error: " + e.getMessage());
                return null;
            }
        }else{
            return null;
        }
    }

    /**
     * author: manhpt
     * date: 26/06/2017
     * method strim() all value string of object
     */
    public static void trimAllFieldOfObject(Object item) {
        if (item == null) {
            return;
        }
        Field[] fields = item.getClass().getDeclaredFields();
        if (fields == null) {
            return;
        }

        for (Field f : fields) {
            if (f.getType().isPrimitive()) {
                continue;
            }
            if (f.getType().equals(String.class)) {
                try {
                    f.setAccessible(true);
                    String value = (String) f.get(item);
                    f.set(item, org.apache.commons.lang3.StringUtils.trimToNull(value));
                } catch (IllegalAccessException e) {
                }

            }
        }
    }

}
