package com.example.backend.service;

import com.example.backend.domain.Bnkseek;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface BnkseekService {
    List<Bnkseek> getAll();

    List<Bnkseek> findByBic(String bic);

    List<Bnkseek> findByRgn(String rgn);

    List<Bnkseek> findByPzn(String pzn);

    void addbnkseek(Bnkseek bnkseek);

    void delete(String vkey);

    void uploadFile(File uploadFile);
}
