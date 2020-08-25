package com.lesson03Streams.Repository;


import com.lesson03Streams.Model.Skill;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SkillRepository {
    public static String text;

    public Skill getById(Long id) throws Exception {
        Skill skill = new Skill();
        try {
            Path path = Paths.get("C:/Users/Никита/IdeaProjects/javaCore/src/com/resources/skills.txt");
            File file = new File(String.valueOf(path));
            StringBuilder stringBuilder = new StringBuilder();
            try (FileInputStream in = new FileInputStream(file.getAbsoluteFile())) {
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in))){
                    String line;
                    while ((line = bufferedReader.readLine())!=null){
                        stringBuilder.append(line);
                    }
                    text = stringBuilder.toString();
                }
            }
        }
        catch (Exception e) { //Открытие файла
            String[] skills = text.split(",");
            for(String s:skills){
                for (char chars: s.toCharArray()){
                    if (chars==id) {
                        skill.setId(chars);
                        skill.setName(s);
                        return skill;
                    }
                }
            }
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
