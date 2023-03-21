package bushuev;

import com.google.gson.*;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;

public class MainClass {

    public static String parse(String jsonLine) {
        JsonElement jelement = new JsonParser().parse(jsonLine);
        JsonObject  jobject = jelement.getAsJsonObject();
        jobject = jobject.getAsJsonObject("data");
        JsonArray jarray = jobject.getAsJsonArray("translations");
        jobject = jarray.get(0).getAsJsonObject();
        return jobject.get("translatedText").getAsString();
    }

    public static void main(String[] args) {

        /*
        * JsonTry tmp = new JsonTry();

        Gson newObj = tmp.getGsonObj();

        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("test.json"));

            JsonTry.Persone man = newObj.fromJson(reader,JsonTry.Persone.class);
            Map<?, ?> map = gson.fromJson(reader, Map.class);
            System.out.println(man);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        * */

        Gson g = new Gson();
        Student p = g.fromJson("{\n" +
                "  \"name\": \"Victor Ivan\",\n" +
                "  \"age\": 19,\n" +
                "}\n", Student.class);

    }

    class Student {
        private String name;
        private int age;
        public Student(){}

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String toString() {
            return "Student [ name: "+name+", age: "+ age+ " ]";
        }
    }
}
