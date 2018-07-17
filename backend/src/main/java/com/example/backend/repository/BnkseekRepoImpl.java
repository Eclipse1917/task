package com.example.backend.repository;

import com.example.backend.domain.*;
import com.example.backend.exception.BnkseekNotFound;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.*;

@Repository
public class BnkseekRepoImpl implements BnkseekRepo {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<Bnkseek> bnkseekRowMapper;
    private final String sqlSelect = "select\n" +
            "b.vkey, b.real,b.pzn, uer, rgn, b.ind, tnp, b.nnp,\n" +
            "b.adr, b.rkc, b.namep, b.namen, b.newks, b.permfo, b.srok, b.at1, b.at2, b.telef, b.regn, b.okpo,\n" +
            "b.dt_izm, b.cks, b.ksnp, b.date_in, b.date_ch, b.vkeydel, b.dt_izmr, b.newnum\n" +
            "from bnkseek b ";

    public BnkseekRepoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        bnkseekRowMapper = ((rs, i) -> new Bnkseek(
                rs.getString("vkey"),
                rs.getString("real"),
                rs.getString("pzn"),
                rs.getString("uer"),
                rs.getString("rgn"),
                rs.getString("ind"),
                rs.getString("tnp"),
                rs.getString("nnp"),
                rs.getString("adr"),
                rs.getString("rkc"),
                rs.getString("namep"),
                rs.getString("namen"),
                rs.getString("newks"),
                rs.getString("permfo"),
                rs.getString("srok"),
                rs.getString("at1"),
                rs.getString("at2"),
                rs.getString("telef"),
                rs.getString("regn"),
                rs.getString("okpo"),
                rs.getDate("dt_izm"),
                rs.getString("cks"),
                rs.getString("ksnp"),
                rs.getDate("date_in"),
                rs.getDate("date_ch"),
                rs.getString("vkeydel"),
                rs.getDate("dt_izmr"),
                rs.getString("newnum")));
    }

    @Override
    public List<Bnkseek> getAll() {
        return jdbcTemplate.query(
                sqlSelect + " order by b.vkey",
                bnkseekRowMapper);
    }

    @Override
    public Bnkseek findByVkey(String vkey) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("vkey", vkey);
        Bnkseek bnkseek;
        try {
            bnkseek = jdbcTemplate.queryForObject(sqlSelect + " where b.vkey = :vkey", param, bnkseekRowMapper);
        } catch (Exception e) {
            throw new BnkseekNotFound("Bank not found by vkey: " + vkey);
        }
        return bnkseek;
    }

    @Override
    public List<Bnkseek> findByRgn(String rgn) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("rgn", "%" + rgn + "%");
        return jdbcTemplate.query(sqlSelect + " where b.rgn = any (select rgn from reg where reg.name ILIKE :rgn )",
                param, bnkseekRowMapper);
    }

    @Override
    public List<Bnkseek> findByPzn(String pzn) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("pzn", pzn);
        return jdbcTemplate.query(sqlSelect + " where b.pzn = :pzn", param, bnkseekRowMapper);
    }

    @Override
    public void addBnkseek(Bnkseek bnkseek) {
        Map<String, Object> param = new HashMap<String, Object>();
        bnkseek.setDateIn(new Date());
        bnkseek.setDtIzm(new Date());
        param.put("real", bnkseek.getReal());
        param.put("pzn", bnkseek.getPzn());
        param.put("uer", bnkseek.getUer());
        param.put("rgn", bnkseek.getRgn());
        param.put("ind", bnkseek.getInd());
        param.put("tnp", bnkseek.getTnp());
        param.put("nnp", bnkseek.getNnp());
        param.put("adr", bnkseek.getAdr());
        param.put("rkc", bnkseek.getRkc());
        param.put("namep", bnkseek.getNamep());
        param.put("namen", bnkseek.getNamen());
        param.put("srok", bnkseek.getSrok());
        param.put("telef", bnkseek.getTelef());
        param.put("regn", bnkseek.getRegn());
        param.put("okpo", bnkseek.getOkpo());
        param.put("dt_izm", bnkseek.getDtIzm());
        param.put("ksnp", bnkseek.getKsnp());
        param.put("date_in", bnkseek.getDateIn());
        param.put("date_ch", bnkseek.getDateCh());
        param.put("newnum", bnkseek.getNewnum());
        jdbcTemplate.update("insert  into bnkseek (real, pzn, uer, rgn, ind, tnp, nnp, adr, rkc, namep,namen," +
                "srok,telef, regn, okpo, dt_izm, ksnp, date_in, date_ch, newnum)\n" +
                "    values (:real, :pzn, :uer, :rgn, :ind, :tnp, :nnp, :adr, :rkc, :namep, :namen, :srok, :telef, " +
                ":regn, :okpo, :dt_izm, :ksnp, :date_in, :date_ch, :newnum)", param);
    }

    @Override
    public void delete(String vkey) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("vkey", vkey);
        jdbcTemplate.update("delete from bnkseek where vkey = :vkey", param);
    }

    @Override
    public void addBnkseekOnFile(Map map) {
        jdbcTemplate.update("insert into bnkseek (vkey,real, pzn, uer, rgn, ind, tnp, nnp, adr, rkc, namep," +
                " namen, newks, permfo, srok, at1, at2, telef, regn, okpo, dt_izm, cks, ksnp, date_in, date_ch, " +
                "vkeydel, dt_izmr, newnum)\n" +
                "    values (:vkey,:real, :pzn, :uer, :rgn, :ind, :tnp, :nnp, :adr, :rkc, :namep, :namen, :newks," +
                " :permfo, :srok, :at1, :at2, :telef, :regn, :okpo, :dt_izm, :cks, :ksnp, :date_in, :date_ch," +
                " :vkeydel, :dt_izmr, :newnum) on conflict (vkey) do nothing", map);
    }

    @Override
    public void editBnkseek(Bnkseek bnkseek, String vkey) {
        Map<String, Object> param = new HashMap<String, Object>();
        bnkseek.setDtIzm(new Date());
        param.put("vkey", vkey);
        param.put("real", bnkseek.getReal());
        param.put("pzn", bnkseek.getPzn());
        param.put("uer", bnkseek.getUer());
        param.put("rgn", bnkseek.getRgn());
        param.put("ind", bnkseek.getInd());
        param.put("tnp", bnkseek.getTnp());
        param.put("nnp", bnkseek.getNnp());
        param.put("adr", bnkseek.getAdr());
        param.put("rkc", bnkseek.getRkc());
        param.put("namep", bnkseek.getNamep());
        param.put("namen", bnkseek.getNamen());
        param.put("srok", bnkseek.getSrok());
        param.put("telef", bnkseek.getTelef());
        param.put("regn", bnkseek.getRegn());
        param.put("okpo", bnkseek.getOkpo());
        param.put("dt_izm", bnkseek.getDtIzm());
        param.put("ksnp", bnkseek.getKsnp());
        param.put("date_ch", bnkseek.getDateCh());
        param.put("newnum", bnkseek.getNewnum());
        jdbcTemplate.update("update bnkseek set real = :real, pzn = :pzn, uer = :uer, rgn = :rgn, ind = :ind," +
                " tnp = :tnp, nnp = :nnp, adr = :adr, rkc = :rkc, namep = :namep, namen = :namen, srok = :srok, " +
                "telef = :telef, regn = :regn, okpo = :okpo, dt_izm = :dt_izm, ksnp = :ksnp, date_ch = :date_ch, " +
                "newnum = :newnum where bnkseek.vkey = :vkey", param);
    }

    @Override
    public List<Pzn> getPZN() {

        return jdbcTemplate.query("select pzn,name from pzn ", (rs, rowNum) -> new Pzn(
                rs.getString("pzn"),
                rs.getString("name")));
    }

    @Override
    public List<Reg> getREG() {
        return jdbcTemplate.query("select rgn,name from reg ", (rs, rowNum) -> new Reg(
                rs.getString("rgn"),
                rs.getString("name")));
    }

    @Override
    public List<Tnp> getTNP() {
        return jdbcTemplate.query("select tnp,fullname from tnp ", (rs, rowNum) -> new Tnp(
                rs.getString("tnp"),
                rs.getString("fullname")));
    }

    @Override
    public List<Uer> getUER() {
        return jdbcTemplate.query("select uer,uername from uer ", (rs, rowNum) -> new Uer(
                rs.getString("uer"),
                rs.getString("uername")));
    }

    @Override
    public List<Bnkseek> findByNewnum(String newnum) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("newnum", newnum);
        return jdbcTemplate.query(sqlSelect + " where b.newnum = :newnum", param, bnkseekRowMapper);
    }
}
