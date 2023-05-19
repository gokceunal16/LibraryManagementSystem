package com.example.library.api;

import com.example.library.model.Table;
import com.example.library.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
public class HomeController {
    private final DBService dbService;

    @Autowired
    public HomeController(DBService dbService) {
        this.dbService = dbService;
    }

    @GetMapping(value = "/tables")
    @ResponseBody
    public List<Table> getTables(){

        return dbService.getTables();
    }


}
