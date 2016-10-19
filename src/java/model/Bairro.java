/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author lber
 */
@Entity
@Table(name="Bairro")
public class Bairro implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name="nome",length=25,nullable=false)    
    private String nome;
    
    @Column(name="total_ovos",length=10,nullable=false)  
    private int  total_ovos;
    
    @Column(name="total_larvas",length=10,nullable=false)
    private int total_larvas;
    
    @Column(name="taxa_eclusao",length=10,nullable=false)
    private float taxa_eclosao;
    
    @Column(name="lista_palheta",length=20,nullable=false)
    @OneToMany
    private List<Palheta> listaPalheta;
    
    @Column(name="bairro_risco",length=5,nullable=false)
    private int bairro_risco;

    public Bairro(String nome, int total_ovos, int total_larvas, float taxa_eclosao, int bairro_risco) {
        this.nome = nome;
        this.total_ovos = total_ovos;
        this.total_larvas = total_larvas;
        this.taxa_eclosao = taxa_eclosao;
        this.bairro_risco = bairro_risco;
    }
    
    public Bairro() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTotal_ovos() {
        return total_ovos;
    }

    public void setTotal_ovos(int total_ovos) {
        this.total_ovos = total_ovos;
    }

    public int getTotal_larvas() {
        return total_larvas;
    }

    public void setTotal_larvas(int total_larvas) {
        this.total_larvas = total_larvas;
    }

    public float getTaxa_eclosao() {
        return taxa_eclosao;
    }

    public void setTaxa_eclosao(float taxa_eclosao) {
        this.taxa_eclosao = taxa_eclosao;
    }

    public List<Palheta> getListaPalheta() {
        return listaPalheta;
    }

    public void setListaPalheta(List<Palheta> listaPalheta) {
        this.listaPalheta = listaPalheta;
    }

    public int getBairro_risco() {
        return bairro_risco;
    }

    public void setBairro_risco(int bairro_risco) {
        this.bairro_risco = bairro_risco;
    }

   


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bairro other = (Bairro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }



}
