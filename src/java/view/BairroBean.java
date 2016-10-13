package view;

import dao.BairroDAO;
import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.Bairro;

/**
 *
 * @author lber
 */
@ManagedBean
@ApplicationScoped
public class BairroBean implements Serializable {

    private BairroDAO bdao;
    
    public BairroDAO getDao() {
        if(bdao == null)
            bdao = new BairroDAO();
        return bdao;
    }

    public Bairro getNovaEntidade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
