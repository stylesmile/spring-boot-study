package com.lht.demoSrping;

import com.lht.demoSrping.service.AService;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class Application {

    private static ConcurrentHashMap<String, Object> context = new ConcurrentHashMap();

    public static void main(String[] args) {
        //先实现包扫描效果

        //获取当前启动类路径，扫描启动类路径下所有class文件
        File f = new File(Application.class.getResource("/").getPath());
        System.out.println(f);

        recursionFile(f, "");//bean new 过程

        context.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v.getClass().getName());
        });

        InterSet();//相互set

        System.out.println("开始测试");
        //测试效果
        AService aService = (AService) context.get("AServiceImpl");
        System.out.println(aService.a());

    }

    private static void InterSet() {
        //相互set过程
        context.forEach((k, v) -> {
            Stream.of(v.getClass().getDeclaredFields()).forEach(field -> {
                if (field.getAnnotation(MyAutowired.class) != null) {
                    //根据名字匹配
                    Object o = context.get(field.getName());
                    if (null != o) {
                        try {
                            field.setAccessible(true);
                            field.set(v, o);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    } else {
                        //根据接口 父类匹配
                        context.forEach((k1, v2) -> {
                            if (field.getType().isInstance(v2)) {
                                try {
                                    field.setAccessible(true);
                                    field.set(v, v2);
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }
            });
        });
    }


    public static void recursionFile(File file, String pac) {
        if (file.isDirectory()) {
            Stream.of(file.list()).forEach(value -> {
                File f = new File(file.getAbsoluteFile() + File.separator + value);
                recursionFile(f, null == pac || pac == "" ? value : pac + "." + value);
            });
        } else {
            if (file.getName().endsWith(".class")) {
                Class cls = null;
                Object obj = null;
                try {
                    cls = Class.forName(pac.substring(0, pac.indexOf(".class")));
                    if (cls.isInterface()) {
                        return;//接口不能实例化
                    }
                    //obj = cls.newInstance();
                    obj = cls.getDeclaredConstructor().newInstance();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                if (null == obj) {
                    return;//注释无法实例化
                }
                if (obj.getClass().getAnnotation(MyComponent.class) != null) {
                    context.put(file.getName().substring(0, file.getName().indexOf(".class")), obj);
                }
            }
        }
    }


}
