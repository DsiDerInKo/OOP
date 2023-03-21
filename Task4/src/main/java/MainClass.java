import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import com.google.gson.*;
import com.google.gson.annotations.*;

public class MainClass {

    public static void main(String[] args) throws IOException {

        Gson gson = new Gson();

        Student obj = gson.fromJson(new FileReader("C:\\prog\\javaprod\\OOP\\Task4\\src\\main\\java\\test.json"), Student.class);
/*
String tmp = "{'query' : 'count'}";

//Object fig = gson.fromJson(tmp,String.class);

//System.out.println(fig);
System.out.println(obj);
obj.toString();
*
* (object mapper )
* */

        System.out.println(obj.toString());

        Student nikita = new Student("Nikita");
        Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
        String json = gson2.toJson(nikita);

    }

    class Food {
        private String type;
        private int amount;
    }

    static class Student {
        private final String name;
        private int age;

        @SerializedName("food")
        private List<Food> foodEaten;

        private transient int nut;

        public Student(String names) {
            name = names;
        }

        public String toString() {
            return "Student [name: " + name + ", age: " + age + ", foodEaten: " + foodEaten + " ]";
        }
    }

}