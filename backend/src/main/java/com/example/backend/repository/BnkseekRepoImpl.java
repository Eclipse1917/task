package com.example.backend.repository;

import com.example.backend.domain.Bnkseek;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BnkseekRepoImpl implements BnkseekRepo {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<Bnkseek> bnkseekRowMapper;
    private final String sqlSelect = "select\n" +
            "b.vkey, b.real, p.name as pzn, u.uername as uer, r.name as rgn, b.ind, t.fullname as tnp, b.nnp,\n" +
            "b.adr, b.rkc, b.namep, b.namen, b.newks, b.permfo, b.srok, b.at1, b.at2, b.telef, b.regn, b.okpo,\n" +
            "b.dt_izm, b.cks, b.kznp, b.date_in, b.date_ch, b.vkeydel, b.dt_izmr, b.newnum\n" +
            "from bnkseek b\n" +
            "left join pzn p on b.pzn = p.pzn\n" +
            "left join reg r on b.rgn = r.rgn\n" +
            "left join tnp t on b.tnp = t.tnp\n" +
            "left join uer u on b.uer = u.uer";

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
                rs.getString("kznp"),
                rs.getDate("date_in"),
                rs.getDate("date_ch"),
                rs.getString("vkeydel"),
                rs.getDate("dt_izmr"),
                rs.getString("newnum")
        ));
    }

    @Override
    public List<Bnkseek> getAll() {
        return jdbcTemplate.query(
                sqlSelect,
                bnkseekRowMapper
        );
    }

    @Override
    public List<Bnkseek> findByBic(String bic) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("bic", bic);
        return jdbcTemplate.query(sqlSelect + " where b.newnum = :bic", param, bnkseekRowMapper);
    }

    @Override
    public List<Bnkseek> findByRgn(String rgn) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("rgn", rgn);
        return jdbcTemplate.query(sqlSelect + " where r.name ILIKE :rgn", param, bnkseekRowMapper);
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
        param.put("kznp", bnkseek.getKznp());
        param.put("date_in", bnkseek.getDateIn());
        param.put("date_ch", bnkseek.getDateCh());
        param.put("newnum", bnkseek.getNewnum());
        jdbcTemplate.update("insert  into bnkseek (real, pzn, uer, rgn, ind, tnp, nnp, adr, rkc, namep,namen," +
                "srok,telef, regn, okpo, dt_izm, kznp, date_in, date_ch, newnum)\n" +
                "    values (:real, :pzn, :uer, :rgn, :ind, :tnp, :nnp, :adr, :rkc, :namep, :namen, :srok, :telef, " +
                ":regn, :okpo, :dt_izm, :kznp, :date_in, :date_ch, :newnum)", param);
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
                " namen, newks, permfo, srok, at1, at2, telef, regn, okpo, dt_izm, cks, kznp, date_in, date_ch, " +
                "vkeydel, dt_izmr, newnum)\n" +
                "    values (:vkey,:real, :pzn, :uer, :rgn, :ind, :tnp, :nnp, :adr, :rkc, :namep, :namen, :newks," +
                " :permfo, :srok, :at1, :at2, :telef, :regn, :okpo, :dt_izm, :cks, :kznp, :date_in, :date_ch," +
                " :vkeydel, :dt_izmr, :newnum)", map);
    }

    @Override
    public Bnkseek getByVkey(String vkey) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("vkey",vkey);
        return jdbcTemplate.queryForObject(sqlSelect+ " where b.vkey = :vkey",param,bnkseekRowMapper);
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
        param.put("kznp", bnkseek.getKznp());
        param.put("date_ch", bnkseek.getDateCh());
        param.put("newnum", bnkseek.getNewnum());
        jdbcTemplate.update("update bnkseek set real = :real, pzn = :pzn, uer = :uer, rgn = :rgn, ind = :ind," +
                " tnp = :tnp, nnp = :nnp, adr = :adr, rkc = :rkc, namep = :namep, namen = :namen, srok = :srok, " +
                "telef = :telef, regn = :regn, okpo = :okpo, dt_izm = :dt_izm, kznp = :kznp, date_ch = :date_ch, " +
                "newnum = :newnum where bnkseek.vkey = :vkey", param);

    }
}
