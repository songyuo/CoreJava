package ch05.reflection;

import java.lang.reflect.*;
import java.util.Scanner;

public class ReflectionTest {

    public static void main(String[] args) throws ClassNotFoundException {
        //read class name from command line args or user input
        String name;
        if(args.length>0){
            name = args[0];
        }
        else {
            var in = new Scanner(System.in);
            name = in.next();
            in.close();
        }

        //print class name and superclass name
        Class<?> cl = Class.forName(name);
        Class<?> superClass = cl.getSuperclass();
        String modifiers = Modifier.toString(cl.getModifiers());
        if(modifiers.length()>0) System.out.print(modifiers + " ");
        System.out.println("class " + name);
        if(superClass != null && superClass != Object.class) System.out.println("extends " + superClass.getName());
        System.out.println("\n{\n");
        printConstructors(cl);
        System.out.println();
        printMethods(cl);
        System.out.println();
        printFields(cl);
        System.out.println();
        System.out.print("}");
    }

    public static void  printConstructors(Class<?> cl){
        Constructor<?>[] constructors = cl.getDeclaredConstructors();
        for(var c : constructors){
            String name = c.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(c.getModifiers());
            if(modifiers.length()>0) System.out.print(modifiers + " ");
            System.out.print(name + "(");
            Class<?>[] parameters = c.getParameterTypes();
            for(int i=0; i<parameters.length; ++i){
                System.out.print(parameters[i].getName());
                if(i!=parameters.length-1){
                    System.out.print(", ");
                }
            }
            System.out.println(");");
        }
    }

    public static void printMethods(Class<?> cl){
        Method[] methods = cl.getDeclaredMethods();
        for(var method : methods){
            System.out.print("  ");
            String modifier = Modifier.toString(method.getModifiers());
            if(modifier.length()>0) System.out.print(modifier+" ");
            String returnTypeName = method.getReturnType().getName();
            System.out.print(returnTypeName + " " + method.getName() + " (");
            Class<?>[] parameters = method.getParameterTypes();
            for(int i=0; i<parameters.length;i++){
                if(i>0){
                    System.out.print(", ");
                }
                System.out.print(parameters[i].getName());
            }
//            Parameter[] parameters1 = method.getParameters();
//            for(int i=0;i<parameters1.length;i++){
//                if(i>0){
//                    System.out.print(", ");
//                }
//                System.out.print(parameters1[i].getType().getName()+" " + parameters1[i].getName());
//            }
            System.out.println(");");
        }
    }

    public static void printFields(Class<?> cl){
        Field[] fields = cl.getDeclaredFields();

        for(Field field : fields){
            System.out.print("  ");
            Class<?> type = field.getType();
            String name = field.getName();
            String modifiers = Modifier.toString(field.getModifiers());
            if(modifiers.length()>0){
                System.out.print(modifiers + " ");
            }
            System.out.println(type.getName() + " " + name + ";");
        }
    }
}
