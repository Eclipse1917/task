package com.example.backend.repository;

import com.example.backend.domain.Bnkseek;

import java.util.List;
import java.util.Map;

public interface BnkseekRepo {
    List<Bnkseek> getAll();

    List<Bnkseek> findByBic(String bic);

    List<Bnkseek> findByRgn(String rgn);

    List<Bnkseek> findByPzn(String pzn);

    void addBnkseek(Bnkseek bnkseek);

    void delete(String vkey);

    void addBnkseekOnFile(Map map);
}
