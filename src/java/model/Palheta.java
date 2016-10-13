package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

/**
 *
 * @author lber
 */
@Entity
@Table(name="Palheta")
public class Palheta implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name="coordenada_x",length=10,nullable=false)    
    private float coordenada_x ;
    
    @Column(name="coordenada_y",length=10,nullable=false)
    private float coordenada_y ;
    
    @Column(name="ovos_palheta",length=5,nullable=false)
    private int ovos_palheta ;
    
    @Column(name="eclosao_palheta",length=5,nullable=false)
    private int eclosao_palheta;
    
    @Column(name="ipo",length=5,nullable=false)
    private float ipo;
    
    @Column(name="ido",length=5,nullable=false)
    private float ido;

    public Palheta(float coordenada_x, float coordenada_y, int ovos_palheta, int eclosao_palheta, float ipo, float ido) {
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

    public float getCoordenada_x() {
        return coordenada_x;
    }

    public void setCoordenada_x(float coordenada_x) {
        this.coordenada_x = coordenada_x;
    }

    public float getCoordenada_y() {
        return coordenada_y;
    }

    public void setCoordenada_y(float coordenada_y) {
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

    public float getIpo() {
        return ipo;
    }

    public void setIpo(float ipo) {
        this.ipo = ipo;
    }

    public float getIdo() {
        return ido;
    }

    public void setIdo(float ido) {
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
