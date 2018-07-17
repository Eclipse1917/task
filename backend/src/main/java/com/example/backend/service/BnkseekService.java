package com.example.backend.service;

import com.example.backend.domain.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface BnkseekService {
    List<Bnkseek> getAll();

    Bnkseek findByVkey(String vkey);

    List<Bnkseek> findByRgn(String rgn);

    List<Bnkseek> findByPzn(String pzn);

    void addbnkseek(Bnkseek bnkseek);

    void delete(String vkey);

    void uploadFile(MultipartFile uploadFile);

    void editBnkseek(Bnkseek bnkseek, String vkey);

    List<Pzn> getPZN();

    List<Reg> getREG();

    List<Tnp> getTNP();

    List<Uer> getUER();

    List<Bnkseek> findByNewnum(String newnum);
}
