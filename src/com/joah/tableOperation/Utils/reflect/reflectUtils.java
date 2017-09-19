package com.joah.tableOperation.Utils.reflect;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

public class reflectUtils {

    /**
     * 把从表单获取的数据转换为一个类对象
     * @param map Map<String,String[]>
     * @param clazz 实体类的名字
     * @param <T> 类名
     * @return 返回实体类的对象
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     * @throws IntrospectionException
     */
    public  static <T> T paramsToBean(Map<String, String[]> map,Class<T> clazz) throws IllegalAccessException, InstantiationException, InvocationTargetException, IntrospectionException {
        // 创建对象
        T o = clazz.newInstance();
//        System.out.println("user 对象: "+o);
        // 得到所有的属性的值
        Field[] declaredFields = clazz.getDeclaredFields();
        // 遍历所有的属性
        for (Field declaredField : declaredFields) {
            String name = declaredField.getName();
            // 得到属性描述对象
            PropertyDescriptor propertyDescriptor=new PropertyDescriptor(name,clazz);
            // 得到写入方法对象
            Method writeMethod = propertyDescriptor.getWriteMethod();
            // 得到 map 的键的集合
            Set<String> set = map.keySet();
            // 便利 map 的键
            for(String key : set){
                // 比较 map 里面的键的值 和 对应属性的名字
                if(key.equals(name)){
                    // 执行 写方法
                    // 由于 request.getParameterMap()返回的是一个Map<string,string[]>
                    //                  值其实只有一个所以直接接 string[0]
                    writeMethod.invoke( o, map.get(key)[0]);
                }
            }
        }
//        System.out.println("user 对象: "+o);
        return o;
    }

    /**
     * 把一个Map<String,String> 转换为一个对象
     * @param map 一个String,String的 Map
     * @param clazz 实体类的名字
     * @param <T> 实体类
     * @return 返回实体类的对象
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws IntrospectionException
     * @throws InvocationTargetException
     */
    public static <T> T mapToBean(Map<String,String> map,Class<T> clazz) throws IllegalAccessException, InstantiationException, IntrospectionException, InvocationTargetException {
        // 得到对象
        T o = clazz.newInstance();

        Field[] declaredFields = clazz.getDeclaredFields();
        // 遍历所有属性
        for (Field declaredField : declaredFields) {
            // 得到属性名
            String name = declaredField.getName();
            // 根据 属性名和类名 得到属性描述对象
            PropertyDescriptor propertyDescriptor= new PropertyDescriptor(name,clazz);
            // 得到属性的写入方法对象
            Method writeMethod = propertyDescriptor.getWriteMethod();
            // 得到Map的键的集合
            Set<String> strings = map.keySet();
            // 遍历所有的键
            for(String key : strings){
                // 如果属性名 和 map的键相对应
                if(name.equals(key)){
                    String value = map.get(key);
                    // 传入参数, 执行写入方法
                    writeMethod.invoke(o,value);
                }
            }
        }
        return o;
    }
}
