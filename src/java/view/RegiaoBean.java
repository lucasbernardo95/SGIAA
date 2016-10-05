package view;


import dao.RegiaoDAO;
import java.io.Serializable;

/**
 *
 * @author lber
 */
public class RegiaoBean extends CrudBean<RegiaoBean, RegiaoDAO> implements Serializable {

    private RegiaoDAO rdao;
    
    @Override
    public RegiaoDAO getDao() {
        if(rdao == null)
            rdao = new RegiaoDAO();
        return rdao;
    }
    
}
