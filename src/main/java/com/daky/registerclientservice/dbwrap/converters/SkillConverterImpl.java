package com.daky.registerclientservice.dbwrap.converters;

import com.daky.registerclientservice.dbwrap.dto.SkillData;
import com.daky.registerclientservice.dbwrap.entries.Skill;
import org.springframework.stereotype.Component;

@Component
public class SkillConverterImpl implements AbstractConverter<SkillData, Skill> {

    @Override
    public SkillData populateData(final Skill skill) {
        SkillData skillData = new SkillData();
        skillData.setId(skill.getId());
        skillData.setTitle(skill.getTitle());
        return skillData;
    }

    @Override
    public Skill populateEntity(SkillData skillData) {
        Skill skill = new Skill();
        skill.setTitle(skillData.getTitle());
        return skill;
    }
}
