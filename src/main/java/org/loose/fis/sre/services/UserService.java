package org.loose.fis.sre.services;


import org.loose.fis.sre.model.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Base64;

public class UserService {
    private static ArrayList<User> users = new ArrayList<>();

    public static void loadUsers(){
        try{
            JSONParser jp = new JSONParser();
            FileReader fr = new FileReader("src/main/resources/usernames.json");
            Object obj = jp.parse(fr);
            JSONArray ja = (JSONArray)obj;

            for(Object user:ja){
                JSONObject o = (JSONObject)user;

                users.add(new User(o.get("username").toString(),o.get("password").toString(),o.get("role").toString()));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static String checkCredentials(String i, String p){
        for(User u:users) {
            if (u.getUsername().equals(i) && u.getPassword().equals(p))
                return u.getRole();
        }
        return "error";
    }

    public static String encodePassword(String password){
        String result = Base64.getEncoder().encodeToString(password.getBytes());

        return result;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }
}
