package bushuev;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;


public class JsonTry {

    public Gson gson;

    public Gson getGsonObj(){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        gson = builder.create();
        return gson;
    }



    class Persone{
        public String name;
        public int age;
        public int dick;

        Persone(String newName,int newAge, int newDick){
            name = newName;
            age=newAge;
            dick = newDick;
        }
    }

}
