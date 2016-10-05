package view;

import dao.BairroDAO;
import java.io.Serializable;
import model.Bairro;

/**
 *
 * @author lber
 */
public class BairroBean extends CrudBean<Bairro, BairroDAO> implements Serializable {

    private BairroDAO bdao;
    
    @Override
    public BairroDAO getDao() {
        if(bdao == null)
            bdao = new BairroDAO();
        return bdao;
    }
    
}
