package com.lesson03Streams;

import com.lesson03Streams.Repository.SkillRepository;

public class Main {
    public static void main(String[] args) throws Exception {
        SkillRepository skillRepository = new SkillRepository();
        System.out.println(skillRepository.getById(1L));

    }


}
