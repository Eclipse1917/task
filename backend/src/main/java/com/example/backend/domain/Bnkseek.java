package com.example.backend.domain;

import com.example.backend.jsonView.View;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonView(View.ShortBnkseek.class)
public class Bnkseek {

    @NotNull
    private String vkey;
    @JsonView(View.FullBnkseek.class)
    @Size(max = 4)
    private String real;
    @JsonView(View.FullBnkseek.class)
    @Size(max = 2)
    private String pzn;
    @JsonView(View.FullBnkseek.class)
    @Size(max = 1)
    @NotNull
    @NotEmpty
    private String uer;
    @JsonView(View.FullBnkseek.class)
    @Size(max = 2)
    @NotNull
    @NotEmpty
    private String rgn;
    @JsonView(View.FullBnkseek.class)
    @Size(max = 6)
    private String ind;
    @JsonView(View.FullBnkseek.class)
    @Size(max = 1)
    private String tnp;
    @JsonView(View.FullBnkseek.class)
    @Size(max = 25)
    private String nnp;
    @Size(max = 30)
    private String adr;
    @JsonView(View.FullBnkseek.class)
    @Size(max = 9)
    private String rkc;
    @Size(max = 45)
    @NotNull
    @NotEmpty
    private String namep;
    @JsonView(View.FullBnkseek.class)
    @Size(max = 30)
    @NotNull
    @NotEmpty
    private String namen;
    @JsonView(View.FullBnkseek.class)
    @Size(max = 9)
    private String newks;
    @JsonView(View.FullBnkseek.class)
    @Size(max = 6)
    private String permfo;
    @JsonView(View.FullBnkseek.class)
    @Size(max = 2)
    @NotNull
    @NotEmpty
    private String srok;
    @JsonView(View.FullBnkseek.class)
    @Size(max = 7)
    private String at1;
    @JsonView(View.FullBnkseek.class)
    @Size(max = 7)
    private String at2;
    @Size(max = 25)
    private String telef;
    @JsonView(View.FullBnkseek.class)
    @Size(max = 9)
    private String regn;
    @JsonView(View.FullBnkseek.class)
    @Size(max = 8)
    private String okpo;
    @JsonView(View.FullBnkseek.class)
    private Date dtIzm;
    @JsonView(View.FullBnkseek.class)
    @Size(max = 6)
    private String cks;
    @JsonView(View.FullBnkseek.class)
    @Size(max = 20)
    private String ksnp;
    @JsonView(View.FullBnkseek.class)
    private Date dateIn;
    @JsonView(View.FullBnkseek.class)
    private Date dateCh;
    @JsonView(View.FullBnkseek.class)
    @Size(max = 8)
    private String vkeydel;
    @JsonView(View.FullBnkseek.class)
    private Date dtIzmr;
    @NotNull
    @NotEmpty
    @Size(max = 9)
    private String newnum;
}
