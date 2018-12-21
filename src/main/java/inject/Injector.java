package inject;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {

    public void inject(Object o) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        Class<?> aClass = o.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            Annotation annotation = field.getAnnotation(Inject.class);

            if (annotation != null) {
                field.setAccessible(true);
                String s1 = field.getType().getName();
                Properties prop = new Properties();
                try {
                    prop.load(new FileInputStream("C:/Users/frlvr/Documents/lab1/src/main/resources/config.properties"));
                    String s2 = prop.getProperty(s1);

                    field.set(o, Class.forName(s2).newInstance());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
