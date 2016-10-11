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
public class BairroBean extends CrudBean<Bairro, BairroDAO> implements Serializable {

    private BairroDAO bdao;
    
    @Override
    public BairroDAO getDao() {
        if(bdao == null)
            bdao = new BairroDAO();
        return bdao;
    }
    
}
