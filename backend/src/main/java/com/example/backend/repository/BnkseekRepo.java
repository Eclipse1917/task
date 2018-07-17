package com.example.backend.repository;

import com.example.backend.domain.*;

import java.util.List;
import java.util.Map;

public interface BnkseekRepo {
    List<Bnkseek> getAll();

    Bnkseek findByVkey(String vkey);

    List<Bnkseek> findByRgn(String rgn);

    List<Bnkseek> findByPzn(String pzn);

    void addBnkseek(Bnkseek bnkseek);

    void delete(String vkey);

    void addBnkseekOnFile(Map map);


    void editBnkseek(Bnkseek bnkseek, String vkey);

    List<Pzn> getPZN();

    List<Reg> getREG();

    List<Tnp> getTNP();

    List<Uer> getUER();

    List<Bnkseek> findByNewnum(String newnum);
}
