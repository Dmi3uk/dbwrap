package com.daky.registerclientservice.dbwrap.controllers;

import com.daky.registerclientservice.dbwrap.dto.MasterData;
import com.daky.registerclientservice.dbwrap.dto.SkillData;
import com.daky.registerclientservice.dbwrap.services.RegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
public class SkillController {
    @Resource(name = "skillService")
    private RegisterService registerService;


    @PostMapping(value = "/skills")
    public ResponseEntity<?> create(@RequestBody SkillData skillData) {
        registerService.create(skillData);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/skills")
    public ResponseEntity<List<SkillData>> getAllSkills() {
        final List<SkillData> skills = registerService.getAll();

        return skills != null &&  !skills.isEmpty()
                ? new ResponseEntity<>(skills, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/skills/{id}")
    public ResponseEntity<?> getSkillByID(@PathVariable(name = "id") long id) {
        final Optional<SkillData> skill = registerService.getById(id);

        return skill != null
                ? new ResponseEntity<>(skill, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/skills/{id}")
    public ResponseEntity<?> updateSkill(@PathVariable(name = "id") long id, @RequestBody SkillData skillData) {
        final boolean updated = registerService.update(skillData, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/skills/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable(name = "id") long id) {

        return registerService.delete(id)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
