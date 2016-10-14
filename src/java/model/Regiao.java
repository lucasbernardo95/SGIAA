package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author lber
 */
@Entity
@Table(name="Regiao")
public class Regiao implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private Integer id;
    
    @Column(name="nome",length=10,nullable=false)
    private String nome;
    
    @Column(name="regiao_risco",length=5,nullable=false)
    private int regiao_risco;

    //Adicionar atributos    

    public Regiao() {
    }

    public Regiao( String nome, int regiao_risco) {
        this.nome = nome;
        this.regiao_risco = regiao_risco;
    }
    
    

    //Adicionar getters e setters

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

    public int getRegiao_risco() {
        return regiao_risco;
    }

    public void setRegiao_risco(int regiao_risco) {
        this.regiao_risco = regiao_risco;
    }
   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final Regiao other = (Regiao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
