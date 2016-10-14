package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author lber
 */
@Entity
@Table(name="Palheta")
public class Palheta implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private Integer id;
    
    @Column(name="coordenada_x",length=10,nullable=false)    
    private int coordenada_x ;
    
    @Column(name="coordenada_y",length=10,nullable=false)
    private int coordenada_y ;
    
    @Column(name="ovos_palheta",length=5,nullable=false)
    private int ovos_palheta ;
    
    @Column(name="eclosao_palheta",length=5,nullable=false)
    private int eclosao_palheta;
    
    @Column(name="ipo",length=5,nullable=false)
    private double ipo;
    
    @Column(name="ido",length=5,nullable=false)
    private double ido;

    public Palheta(int coordenada_x, int coordenada_y, int ovos_palheta, int eclosao_palheta, double ipo, double ido) {
        this.coordenada_x = coordenada_x;
        this.coordenada_y = coordenada_y;
        this.ovos_palheta = ovos_palheta;
        this.eclosao_palheta = eclosao_palheta;
        this.ipo = ipo;
        this.ido = ido;
    }

    public Palheta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCoordenada_x() {
        return coordenada_x;
    }

    public void setCoordenada_x(int coordenada_x) {
        this.coordenada_x = coordenada_x;
    }

    public int getCoordenada_y() {
        return coordenada_y;
    }

    public void setCoordenada_y(int coordenada_y) {
        this.coordenada_y = coordenada_y;
    }

    public int getOvos_palheta() {
        return ovos_palheta;
    }

    public void setOvos_palheta(int ovos_palheta) {
        this.ovos_palheta = ovos_palheta;
    }

    public int getEclosao_palheta() {
        return eclosao_palheta;
    }

    public void setEclosao_palheta(int eclosao_palheta) {
        this.eclosao_palheta = eclosao_palheta;
    }

    public double getIpo() {
        return ipo;
    }

    public void setIpo(double ipo) {
        this.ipo = ipo;
    }

    public double getIdo() {
        return ido;
    }

    public void setIdo(double ido) {
        this.ido = ido;
    }

  

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Palheta other = (Palheta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
