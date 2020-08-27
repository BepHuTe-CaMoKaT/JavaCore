package com.lesson03Streams.Repository;


import com.lesson03Streams.Model.Skill;

import java.io.*;

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

                    String[] skills = text.split(" ");
                    for (String s: skills) {
                        if (s.contains(id.toString())&&id.equals(Long.parseLong(s))) {
                            skill.setId(Long.parseLong(s));
                            skill.setName(s);
                            break;

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
