package com.example.spring15.Service;

import com.example.spring15.Entity.Note;
import com.example.spring15.Repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public List<Note> listAll(){
        return noteRepository.findAll();
    }

    public void add(Note note){
        noteRepository.save(note);
    }

    public Note getById(Long id){
        return   noteRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Write right Id"));
    }

//    public boolean exists(Long id){
//      return   noteRepository.existsById(id);
//    }

//    public List<Note> search(Long query){
//       //  дописать метод відео 1б 40 мін
//       return noteRepository.search(query);
//       // метод из нашего репозитория
//    }

    public void deleteById(Long id){
        noteRepository.deleteById(id);
    }

    public void update(Note note){
        getById(note.getId());
        noteRepository.save(note);
    }
}
