package com.springmsa.rebels.controller;

import com.springmsa.rebels.dao.RebelsDao;
import com.springmsa.rebels.model.Rebels;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/rebels")
public class RebelsController {

    @Autowired
    private RebelsDao dao;

    @Operation(summary = "GET rebel with ID")
    @GetMapping("/{id}")
    public Rebels searchRebelById(@PathVariable int id) {
        return dao.findById(id);
    }

    @Operation(summary = "POST rebel")
    @PostMapping()
    public Rebels addRebels(@RequestBody Rebels rebels){
       return dao.save(rebels);

    }
}
