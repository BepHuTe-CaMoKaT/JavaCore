package main.lesson03Streams;

import main.lesson03Streams.Repository.SkillRepository;

public class Main {
    public static void main(String[] args) throws Exception {
        SkillRepository skillRepository = new SkillRepository();
        System.out.println(skillRepository.getById(2L));

    }


}
