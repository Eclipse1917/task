package com.example.backend.controller;

import com.example.backend.domain.Bnkseek;
import com.example.backend.jsonView.View;
import com.example.backend.service.BnkseekService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/bnkseek")
public class RestControllerBnkseek {

    private final BnkseekService bnkseekService;

    public RestControllerBnkseek(BnkseekService bnkseekService) {
        this.bnkseekService = bnkseekService;
    }

    @GetMapping
    @JsonView(View.ShortBnkseek.class)
    public List<Bnkseek> getAll(){
        return bnkseekService.getAll();
    }

    @GetMapping("/{vkey}")
    @JsonView(View.FullBnkseek.class)
    public Bnkseek getByVkey(@PathVariable String vkey){
        return bnkseekService.getByVkey(vkey);
    }

    @PutMapping("/{vkey}")
    public void editBnkseek(@RequestBody Bnkseek bnkseek, @PathVariable String vkey){
        bnkseekService.editBnkseek(bnkseek,vkey);
    }

    @GetMapping(path = "bic")
    @JsonView(View.ShortBnkseek.class)
    public List<Bnkseek> findByBic(@RequestParam String bic){
        return bnkseekService.findByBic(bic);
    }

    @GetMapping(path = "rgn")
    @JsonView(View.ShortBnkseek.class)
    public List<Bnkseek> findByRgn(@RequestParam String rgn){
        return bnkseekService.findByRgn(rgn);
    }

    @GetMapping(path = "pzn")
    @JsonView(View.ShortBnkseek.class)
    public List<Bnkseek> findByPzn(@RequestParam String pzn){
        return bnkseekService.findByPzn(pzn);
    }

    @PostMapping
    public void addbnkseek(@RequestBody Bnkseek bnkseek){
        bnkseekService.addbnkseek(bnkseek);
    }

    @DeleteMapping("/{vkey}")
    public void deleteBnkseek(@PathVariable String vkey){
        bnkseekService.delete(vkey);
    }
    @PostMapping("/upload")
    public void uploadPhoto(@RequestParam File uploadFile) {
        if (!(uploadFile.length() == 0)) {
            bnkseekService.uploadFile(uploadFile);
        }
    }
}
