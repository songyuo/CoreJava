package ch05.objectAnalyzer;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ObjectAnalyzer {

    private final ArrayList<Object> visited = new ArrayList<>();

    /**Converts an object to a string representation that lists all fields
     * @param obj an object
     * @return a string with the object's class name and all fields names and values
     */
    public String toString(Object obj) throws ReflectiveOperationException{
        if(obj == null) return "null";
        if(visited.contains(obj)) return "...";
        visited.add(obj);
        Class<?> cl = obj.getClass();
        if(cl==String.class) return (String) obj;
        if(cl.isArray()){
            StringBuilder r = new StringBuilder(cl.getComponentType() + "[]{");
            for(int i=0;i< Array.getLength(obj);i++){
                if(i>0) r.append(",");
                Object val = Array.get(obj, i);
                if(cl.getComponentType().isPrimitive()){
                    r.append(val);
                }else{
                    r.append(toString(val));
                }
            }
            return r.append("}").toString();
        }
        StringBuilder r = new StringBuilder(cl.getName());
        do{
            r.append("[");
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            for(int i=0;i<fields.length;i++){
                var f = fields[i];
                if(Modifier.isStatic(f.getModifiers())) continue;
                if(r.charAt(r.length()-1)!='[') r.append(",");
                r.append(f.getName()+"=" +
                        "");
                Object val = f.get(obj);
                if(f.getType().isPrimitive()) r.append(val);
                else r.append(toString(val));
            }
            r.append("]");
            cl = cl.getSuperclass();
        }while(cl.getSuperclass()!=null);
        return r.toString();
    }
}
