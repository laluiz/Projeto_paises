package model;

import java.util.ArrayList;
import java.util.List;

public class Pais {
    private String codigoISO;
    private String nome;
    private long populacao;
    private double dimensao;
    private List<Pais> fronteiras;

    // Construtor
    public Pais(String codigoISO, String nome, double dimensao) {
        this.codigoISO = codigoISO;
        this.nome = nome;
        this.dimensao = dimensao;
        this.fronteiras = new ArrayList<>();
    }

    // Getters e Setters
    public String getCodigoISO() {
        return codigoISO;
    }

    public void setCodigoISO(String codigoISO) {
        this.codigoISO = codigoISO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(long populacao) {
        this.populacao = populacao;
    }

    public double getDimensao() {
        return dimensao;
    }

    public void setDimensao(double dimensao) {
        this.dimensao = dimensao;
    }

    public List<Pais> getFronteiras() {
        return fronteiras;
    }

    // Métodos
    public boolean equals(Pais outro) {
        return this.codigoISO.equals(outro.getCodigoISO());
    }

    public boolean ehLimitrofe(Pais outro) {
        return fronteiras.contains(outro);
    }

    public double densidadePopulacional() {
        return populacao / dimensao;
    }

    public List<Pais> vizinhosComuns(Pais outro) {
        List<Pais> comuns = new ArrayList<>();
        for (Pais pais : fronteiras) {
            if (outro.ehLimitrofe(pais)) {
                comuns.add(pais);
            }
        }
        return comuns;
    }

    public void adicionarFronteira(Pais outro) {
        if (!this.equals(outro) && fronteiras.size() < 40 && !fronteiras.contains(outro)) {
            fronteiras.add(outro);
            outro.fronteiras.add(this); // Adicionar reciprocamente
        }
    }
}
