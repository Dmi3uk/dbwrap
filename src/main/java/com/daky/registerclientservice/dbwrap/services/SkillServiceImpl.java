package com.daky.registerclientservice.dbwrap.services;

import com.daky.registerclientservice.dbwrap.converters.SkillConverterImpl;
import com.daky.registerclientservice.dbwrap.dto.SkillData;
import com.daky.registerclientservice.dbwrap.entries.Skill;
import com.daky.registerclientservice.dbwrap.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("skillService")
public class SkillServiceImpl implements AbstractRegisterService<SkillData, SkillData, Long> {

    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    SkillConverterImpl skillConverter;

    @Override
    public SkillData create(SkillData skillData) {
        Skill skill = skillConverter.populateEntity(skillData);
        return skillConverter.populateData(skillRepository.save(skill));
    }

    @Override
    public List<SkillData> getAll() {
        List<SkillData> skills = new ArrayList<>();
        List<Skill> skillList = skillRepository.findAll();
        skillList.forEach(skill -> {
            skills.add(skillConverter.populateData(skill));
        });
        return skills;
    }

    @Override
    public Optional<SkillData> getById(Long skillId) {
        Optional<Skill> skill = skillRepository.findById(skillId);
        if(skill.isEmpty()) {
            return null;
        }
        return Optional.of(skillConverter.populateData(skill.get()));
    }

    @Override
    public boolean update(SkillData skillData, Long skillId) {
        if (skillRepository.existsById(skillId)) {
            Skill skill = skillConverter.populateEntity(skillData);
            skill.setId(skillId);
            skillRepository.save(skill);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long skillId) {
        if (skillRepository.existsById(skillId)) {
            skillRepository.deleteById(skillId);
            return true;
        }
        return false;
    }
}
