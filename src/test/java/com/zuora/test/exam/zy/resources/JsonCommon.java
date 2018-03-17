package com.zuora.test.exam.zy.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by kaiser_zhao on 3/14/18.
 *
 * TODO: use this class to map json to Java Object
 */
public class JsonCommon {

    public static ObjectMapper objectMapper;

    public static void main(String... strs){

        // test scalar with vector/vector properties
        String jsonStrContactListList = "{\"id\": 981,\"name\": \"premium subscriptions\",\"contacts\": [{" +
                "\"id\": 2363,\"type\": \"PERSON\", \"properties\": [{" +
                "                        \"type\": \"SYSTEM\"," +
                "                        \"name\": \"first_name\"," +
                "                        \"value\": \"John\"" +
                "                    }]}]}";
        Deal dealWithListList = readValue(jsonStrContactListList, Deal.class);
        System.out.println(dealWithListList.getId());
        System.out.println(dealWithListList.getName());
        System.out.println(dealWithListList.getContacts().size());
        System.out.println(dealWithListList.getContacts().get(0).getId());
        System.out.println(dealWithListList.getContacts().get(0).getProperties().get(0).getName());
    }

    /**
     * Generate Object
     *
     * @param jsonStr
     * @param valueType
     * @param <T>
     * @return
     */
    public static <T> T readValue(String jsonStr, Class<T> valueType) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }

        try {
            return objectMapper.readValue(jsonStr, valueType);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static <T> T readValue(String jsonStr, TypeReference<T> valueTypeRef){
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }

        try {
            return objectMapper.readValue(jsonStr, valueTypeRef);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}