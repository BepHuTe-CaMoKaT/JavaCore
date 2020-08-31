package com.lesson03Streams.Repository;


import com.lesson03Streams.Model.Skill;

import java.io.*;

import java.util.Arrays;
import java.util.List;

public class SkillRepository {
    public static String text;

    public Skill getById(Long id) throws Exception {
        Skill skill = new Skill();
        try {
            File file = new File("C:/Users/Никита/IdeaProjects/javaCore/src/com/resources/skills.txt");
            StringBuilder stringBuilder = new StringBuilder();
            try (FileInputStream in = new FileInputStream(file)) {
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in))) {
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line);
                    }
                    text = stringBuilder.toString();

                    String[] skills = text.split("/");
//                    String temp = Arrays.toString(skills);
//                    String[] sk = temp.split(" ");
                    for (String s: skills){
                        s.split(" ");
                        if (s[0]==id){
                            skill.setId(Long.parseLong(skills[0]));
                            skill.setName(skills[1]);
                        }

                    }
                }
            }
        } catch (Exception e) { //Открытие файла

            throw new Exception();
        }
        return skill;
    }

    public List<Skill> getAll() {
        return null;
    }

    public boolean save(Skill skill) {

        return false;
    }

    public Skill update(Skill skill) {
        return null;
    }

    public void deleteById(Long id) {

    }


}
