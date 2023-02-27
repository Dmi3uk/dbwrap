package com.daky.registerclientservice.dbwrap.services;

import com.daky.registerclientservice.dbwrap.dto.SkillData;
import com.daky.registerclientservice.dbwrap.entries.Skill;
import com.daky.registerclientservice.dbwrap.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("skillService")
public class SkillServiceImpl implements RegisterService<SkillData, SkillData, Long> {

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public SkillData create(SkillData skillData) {
        Skill skill = populateSkillEntity(skillData);
        return populateSkillData(skillRepository.save(skill));
    }

    @Override
    public List<SkillData> getAll() {
        List<SkillData> skills = new ArrayList<>();
        List<Skill> skillList = skillRepository.findAll();
        skillList.forEach(skill -> {
            skills.add(populateSkillData(skill));
        });
        return skills;
    }

    @Override
    public Optional<SkillData> getById(Long skillId) {
        Optional<Skill> skill = skillRepository.findById(skillId);
        if(skill.isEmpty()) {
            return null;
        }
        return Optional.of(populateSkillData(skill.get()));
    }

    @Override
    public boolean update(SkillData skillData, Long skillId) {
        if (skillRepository.existsById(skillId)) {
            Skill skill = populateSkillEntity(skillData);
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

    /**
     * Internal method to convert Customer JPA entity to the DTO object
     * for frontend data
     * @param skill
     * @return skillData
     */
    private SkillData populateSkillData(final Skill skill) {
        SkillData skillData = new SkillData();
        skillData.setId(skill.getId());
        skillData.setTitle(skill.getTitle());
        return skillData;
    }

    /**
     * Method to map the front end customer object to the JPA customer entity.
     * @param skillData
     * @return skill
     */
    private Skill populateSkillEntity(SkillData skillData) {
        Skill skill = new Skill();
        skill.setTitle(skillData.getTitle());
        return skill;
    }
}
