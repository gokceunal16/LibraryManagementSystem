package com.example.library.api;

import com.example.library.service.GenericService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GenericController {
    private final GenericService genericService;

    public GenericController(GenericService genericService) {
        this.genericService = genericService;
    }

    @DeleteMapping(value = "/{entity}/{id}")
    @ResponseBody
    public void deleteAuthor(@PathVariable("entity") String entityName, @PathVariable("id") int id){

       genericService.deleteRecordById(id, entityName);
    }
}
