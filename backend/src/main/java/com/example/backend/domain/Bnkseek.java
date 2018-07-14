package com.example.backend.domain;

import com.example.backend.jsonView.View;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonView(View.ShortBnkseek.class)
public class Bnkseek {

    @NotNull
    private String vkey;
    @JsonView(View.FullBnkseek.class)
    private String real;
    private String pzn;
    @JsonView(View.FullBnkseek.class)
    private String uer;
    private String rgn;
    @JsonView(View.FullBnkseek.class)
    private String ind;
    @JsonView(View.FullBnkseek.class)
    private String tnp;
    @JsonView(View.FullBnkseek.class)
    private String nnp;
    private String adr;
    @JsonView(View.FullBnkseek.class)
    private String rkc;
    @JsonView(View.FullBnkseek.class)
    private String namep;
    @JsonView(View.FullBnkseek.class)
    private String namen;
    @JsonView(View.FullBnkseek.class)
    private String newks;
    @JsonView(View.FullBnkseek.class)
    private String permfo;
    @JsonView(View.FullBnkseek.class)
    private String srok;
    @JsonView(View.FullBnkseek.class)
    private String at1;
    @JsonView(View.FullBnkseek.class)
    private String at2;
    private String telef;
    @JsonView(View.FullBnkseek.class)
    private String regn;
    @JsonView(View.FullBnkseek.class)
    private String okpo;
    @JsonView(View.FullBnkseek.class)
    private Date dtIzm;
    @JsonView(View.FullBnkseek.class)
    private String cks;
    @JsonView(View.FullBnkseek.class)
    private String kznp;
    @JsonView(View.FullBnkseek.class)
    private Date dateIn;
    @JsonView(View.FullBnkseek.class)
    private Date dateCh;
    @JsonView(View.FullBnkseek.class)
    private String vkeydel;
    @JsonView(View.FullBnkseek.class)
    private Date dtIzmr;
    private String newnum;
}
