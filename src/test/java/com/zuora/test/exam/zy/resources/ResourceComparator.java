package com.zuora.test.exam.zy.resources;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by kaiser_zhao on 3/18/18.
 * <p>
 * Using reflection to compare two objects
 */
public class ResourceComparator {

    public static <T> boolean compareResources(Object source, Object target, Class<T> clazz) {
        // if object is null, return false
        if (source == null || target == null) {
            return false;
        }

        // if not instance of clazz, return false
        if (!source.getClass().equals(clazz) || !target.getClass().equals(clazz)) {
            return false;
        }

        Field[] fileds = clazz.getDeclaredFields();

        for (Field f : fileds) {
            Class<?> type = f.getType();
            System.out.println(type);
            f.setAccessible(true);

            try {
                // list
                if (type.equals(List.class)) {

                    List val1 = (List) (f.get(source));
                    List val2 = (List) (f.get(source));
                    if (isEmpty(val1)) {
                        if (!isEmpty(val2)) {
                            return false;
                        } else {
                            continue;
                        }
                    }
                    if (isEmpty(val2)) {
                        if (!isEmpty(val1)) {
                            return false;
                        } else {
                            continue;
                        }
                    }

                    if (val1.size() != val2.size()) {
                        return false;
                    }

                    Iterator i1 = val1.iterator();
                    Iterator i2 = val2.iterator();
                    Class<?> itemClazz = val1.getClass();
                    while (i1.hasNext() && i2.hasNext()) {
                        if (!compareResources(i1.next(), i2.next(), itemClazz)) {
                            return false;
                        }
                    }
                }
                // Integer
                else if (type.equals(Integer.class)) {
                    Integer val1 = (Integer) (f.get(source));
                    Integer val2 = (Integer) (f.get(source));
                    if (val1 == null) {
                        if (val2 != null && val2 != 0) {
                            return false;
                        }
                    } else if (val1.equals(0) && (val2 != null && !val2.equals(0))) {
                        return false;
                    } else {
                        if (!val1.equals(val2)) {
                            return false;
                        }
                    }
                }
                // Long
                else if (type.equals(Long.class)) {
                    Long val1 = (Long) (f.get(source));
                    Long val2 = (Long) (f.get(source));
                    if (val1 == null) {
                        if (val2 != null && val2 != 0) {
                            return false;
                        }
                    } else if (val1.equals(0) && (val2 != null && !val2.equals(0))) {
                        return false;
                    } else {
                        if (!val1.equals(val2)) {
                            return false;
                        }
                    }
                }
                // String
                else if (type.equals(String.class)) {
                    String val1 = (String) (f.get(source));
                    String val2 = (String) (f.get(source));
                    if (isStringEmpty(val1)) {
                        if (!isStringEmpty(val2)) {
                            return false;
                        }
                    }
                    if(isStringEmpty(val2)){
                        if (!isStringEmpty(val1)) {
                            return false;
                        }
                    }

                    if(!val1.equals(val2)){
                        return false;
                    }
                }
                // Boolean
                else if(type.equals(Boolean.class)){
                    //TODO:
                }
                // normal class
                else{

                    if(!compareResources(f.get(source),f.get(target),f.getClass())){
                        return false;
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    private static boolean isStringEmpty(String str){
        if(str == null){
            return true;
        }else if(str.trim().equals("")){
            return true;
        }
        return false;
    }

    public final static void main(String... strings) {
        Deal deal = new Deal();
        List cs = new ArrayList<Contact>();
        Contact c = new Contact();
        cs.add(c);
        deal.setContacts(cs);
        //      compareResources(deal, deal, Deal.class);
        System.out.println(new Integer(1) == 1);
    }

    private static boolean isEmpty(List list) {
        if (list == null || list.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
