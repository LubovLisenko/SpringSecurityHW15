package com.example.spring15.Controller;

import com.example.spring15.Entity.Note;
import com.example.spring15.Service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
@RequestMapping("/note")
@RequiredArgsConstructor
@RestController
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/list")
    public ModelAndView getAllList() {
        ModelAndView result = new ModelAndView("noteList");
        result.addObject("note", noteService.listAll());
        return result;
    }
    @GetMapping("/create")
    public ModelAndView formNote() {
        ModelAndView result = new ModelAndView("create");
        result.addObject("note", new Note());
        return result;
    }

    @PostMapping("/create")
    public ModelAndView addNote(@ModelAttribute("note") Note note) {
        noteService.add(note);;
        return new ModelAndView("redirect:/note/list");
    }

    @PostMapping("/delete")
    public ModelAndView deleteNote(@RequestParam Long id) {
        noteService.deleteById(id);
        return new ModelAndView("redirect:/note/list");
    }

    @GetMapping("/edit")
    public ModelAndView updateById(@RequestParam("id") Long id) {
        ModelAndView result = new ModelAndView("edit");
        result.addObject("note", noteService.getById(id));
        return result;
    }

    @PostMapping("/edit")
    public ModelAndView renameNote(@ModelAttribute("note") Note note) {
        noteService.update(note);
        return new ModelAndView("redirect:/note/list");
    }
}
