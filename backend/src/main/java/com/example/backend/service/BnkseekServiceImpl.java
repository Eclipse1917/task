package com.example.backend.service;

import com.example.backend.domain.*;
import com.example.backend.exception.ReadFileException;
import com.example.backend.repository.BnkseekRepo;
import org.jamel.dbf.DbfReader;
import org.jamel.dbf.structure.DbfRow;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BnkseekServiceImpl implements BnkseekService {
    private final BnkseekRepo bnkseekRepo;

    public BnkseekServiceImpl(BnkseekRepo bnkseekRepo) {
        this.bnkseekRepo = bnkseekRepo;
    }

    @Override
    public List<Bnkseek> getAll() {
        return bnkseekRepo.getAll();
    }

    @Override
    public Bnkseek findByVkey(String vkey) {
        return bnkseekRepo.findByVkey(vkey);
    }

    @Override
    public List<Bnkseek> findByRgn(String rgn) {
        return bnkseekRepo.findByRgn(rgn);
    }

    @Override
    public List<Bnkseek> findByPzn(String pzn) {
        return bnkseekRepo.findByPzn(pzn);
    }

    @Override
    public void addBnkseek(Bnkseek bnkseek) {
        bnkseekRepo.addBnkseek(bnkseek);
    }

    @Override
    public void delete(String vkey) {
        bnkseekRepo.delete(vkey);
    }

    @Override
    @Transactional
    public void uploadFile(MultipartFile uploadFile) {

        try {
            File file = new File(uploadFile.getOriginalFilename());
            file.createNewFile();
            FileOutputStream stream = new FileOutputStream(file);
            stream.write(uploadFile.getBytes());
            stream.close();
            DbfReader reader = new DbfReader(file, Charset.forName("cp866"));
            for (int i = 0; i < reader.getRecordCount(); i++) {
                DbfRow row = reader.nextRow();
                Map map = new HashMap();
                for (int j = 0; j < reader.getHeader().getFieldsCount(); j++) {
                    if (reader.getHeader().getField(j).getDataType().byteValue == 67) {
                        if (row.getString(reader.getHeader().getField(j).getName()).trim().length() == 0) {
                            map.put(reader.getHeader().getField(j).getName().toLowerCase(), null);
                        } else {
                            map.put(reader.getHeader().getField(j).getName().toLowerCase(), row.getString(reader.getHeader().getField(j).getName()));
                        }
                    } else if (reader.getHeader().getField(j).getDataType().byteValue == 68) {
                        if (row.getDate(reader.getHeader().getField(j).getName()).getTime() > 0) {
                            map.put(reader.getHeader().getField(j).getName().toLowerCase(), row.getDate(reader.getHeader().getField(j).getName()));
                        } else {
                            map.put(reader.getHeader().getField(j).getName().toLowerCase(), null);
                        }
                    }
                }
                bnkseekRepo.addBnkseekOnFile(map);
            }

        } catch (Exception e) {
            throw new ReadFileException(e.getMessage());
        }
    }

    @Override
    public void editBnkseek(Bnkseek bnkseek, String vkey) {
        bnkseekRepo.editBnkseek(bnkseek, vkey);
    }

    @Override
    public List<Pzn> getPZN() {
        return bnkseekRepo.getPZN();
    }

    @Override
    public List<Reg> getREG() {
        return bnkseekRepo.getREG();
    }

    @Override
    public List<Tnp> getTNP() {
        return bnkseekRepo.getTNP();
    }

    @Override
    public List<Uer> getUER() {
        return bnkseekRepo.getUER();
    }

    @Override
    public List<Bnkseek> findByNewnum(String newnum) {
        return bnkseekRepo.findByNewnum(newnum);
    }
}

