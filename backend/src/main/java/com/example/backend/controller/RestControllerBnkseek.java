package com.example.backend.controller;

import com.example.backend.domain.*;
import com.example.backend.jsonView.View;
import com.example.backend.service.BnkseekService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URLDecoder;
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


    @PutMapping("/{vkey}")
    public void editBnkseek(@RequestBody Bnkseek bnkseek, @PathVariable String vkey){
        bnkseekService.editBnkseek(bnkseek,vkey);
    }

    @GetMapping("/{vkey}")
    @JsonView(View.FullBnkseek.class)
    public Bnkseek findByVkey(@PathVariable String vkey) {
        return bnkseekService.findByVkey(vkey);
    }

    @GetMapping("/rgn")
    @JsonView(View.ShortBnkseek.class)
    public List<Bnkseek> findByRgn(@RequestParam String rgn){
        return bnkseekService.findByRgn(rgn);
    }

    @GetMapping("/pzn")
    @JsonView(View.ShortBnkseek.class)
    public List<Bnkseek> findByPzn(@RequestParam String pzn){
        return bnkseekService.findByPzn(pzn);
    }

    @GetMapping("/newnum")
    @JsonView(View.ShortBnkseek.class)
    public List<Bnkseek> findByNewnum(@RequestParam String newnum) {
        return bnkseekService.findByNewnum(newnum);
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
    public void uploadFile(@RequestParam MultipartFile file) {
        if (!file.isEmpty()) {
            bnkseekService.uploadFile(file);
        }
    }

    @GetMapping("/getPzn")
    public List<Pzn> getPZN() {
        return bnkseekService.getPZN();
    }

    @GetMapping("/getReg")
    public List<Reg> getREG() {
        return bnkseekService.getREG();
    }

    @GetMapping("/getTnp")
    public List<Tnp> getTNP() {
        return bnkseekService.getTNP();
    }

    @GetMapping("/getUer")
    public List<Uer> getUER() {
        return bnkseekService.getUER();
    }

}
