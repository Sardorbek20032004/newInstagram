package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Comment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class IOFileReadAndWrite<T> {
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public ArrayList<T> fileRead(String PATH) {
        String s = read(PATH);
        Type typeToken = new TypeToken<ArrayList<T>>() {}.getType();
        ArrayList<T> t = gson.fromJson(s, typeToken);
        return t != null ? t : new ArrayList<>();
    }
    public void fileWrite(ArrayList<T> t, String PATH) {
        String s = gson.toJson(t);
        try (FileWriter fileWriter = new FileWriter(PATH)) {
            fileWriter.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String read(String PATH) {
        StringBuilder str = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                str.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }
}
