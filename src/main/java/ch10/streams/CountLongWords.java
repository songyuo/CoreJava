package ch10.streams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CountLongWords {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        //var contents = new String(Files.readAllBytes(Paths.get("./src/main/java/ch10/streams/alice.txt")), StandardCharsets.UTF_8);
        var contents = Files.readString(Paths.get("./src/main/java/ch10/streams/alice.txt"));
        List<String> words = List.of(contents.split("\\PL+"));
        //\\PL+意为一到多个非字母字符，PN+意为非数字字符，L指代Letter，N指代Number

        long count = 0;
        for(String w: words){
            if(w.length()>12){
                count++;
            }
        }
        System.out.println(count);

        /*
        1. filter方法的入参是一个预测函数式接口Predicate<? super T>
        2. count是一个终止操作，一个流调用终止操作后，将不再可用
         */
        count = words.stream().filter(w -> w.length() > 12).count();
        System.out.println(count);

        count = words.parallelStream().filter(w -> w.length()>12).count();
        System.out.println(count);
    }
}
