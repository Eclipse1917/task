package com.example.backend.service;

import com.example.backend.domain.Bnkseek;
import com.example.backend.repository.BnkseekRepo;
import org.jamel.dbf.DbfReader;
import org.jamel.dbf.structure.DbfRow;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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
    public List<Bnkseek> findByBic(String bic) {
        return bnkseekRepo.findByBic(bic);
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
    public void addbnkseek(Bnkseek bnkseek) {
        bnkseekRepo.addBnkseek(bnkseek);
    }

    @Override
    public void delete(String vkey) {
        bnkseekRepo.delete(vkey);
    }

    @Override
    public void uploadFile(File uploadFile) {
        try {
            File file = uploadFile;
            DbfReader reader = new DbfReader(file, Charset.forName("cp866"));
            for (int i = 0; i < reader.getRecordCount(); i++) {
                DbfRow row = reader.nextRow();
                Map map = new HashMap();
                for (int j = 0; j < reader.getHeader().getFieldsCount(); j++) {

                    if (reader.getHeader().getField(j).getDataType().byteValue == 67) {
                        map.put(reader.getHeader().getField(j).getName().toLowerCase(), row.getString(reader.getHeader().getField(j).getName()));
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
            e.getMessage();
        }
    }

    @Override
    public Bnkseek getByVkey(String vkey) {
        return bnkseekRepo.getByVkey(vkey);
    }

    @Override
    public void editBnkseek(Bnkseek bnkseek, String vkey) {
        bnkseekRepo.editBnkseek(bnkseek,vkey);
    }
}

