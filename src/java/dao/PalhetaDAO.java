
package dao;

import java.util.List;
import model.Palheta;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author lber
 */
public class PalhetaDAO extends GenericDAO<Palheta>{
    public List<Palheta> buscarPalhetaPorBairro(Integer id){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Query consulta = sessao.createQuery("from Palheta where idBairro = :parametro");
        consulta.setString("parametro", ""+id);
        List<Palheta> lista = (List<Palheta>) consulta.list();
        sessao.close();
        return lista;
    }
}
