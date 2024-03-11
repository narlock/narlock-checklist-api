package com.narlock.simplechecklistapi.controller;

import com.narlock.simplechecklistapi.model.Checklist;
import com.narlock.simplechecklistapi.service.SimpleChecklistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/checklist")
@RequiredArgsConstructor
public class ChecklistController {

    private final SimpleChecklistService simpleChecklistService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Checklist createChecklist(@RequestBody Checklist checklist) {
        return simpleChecklistService.createChecklist(checklist);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Checklist getChecklist(@RequestParam(name = "name") String name, @RequestParam(name = "profileId") Integer profileId) {
        return simpleChecklistService.getChecklist(name, profileId);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public Checklist updateChecklistRepeat(@RequestParam(name = "name") String name, @RequestParam(name = "profileId") Integer profileId, @RequestParam(name = "repeatEvery") String repeatEvery) {
        return simpleChecklistService.updateChecklistRepeat(name, profileId, repeatEvery);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteChecklist(@RequestParam(name = "name") String name, @RequestParam(name = "profileId") Integer profileId) {
        simpleChecklistService.deleteChecklist(name, profileId);
    }
}
