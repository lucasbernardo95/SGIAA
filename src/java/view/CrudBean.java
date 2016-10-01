/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.GenericDAO;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import util.ErroSistema;
import util.MessageUtil;

/**
 *
 * @author lber
 */
public abstract class CrudBean<E, D extends GenericDAO> {
    
    private String estadoTela = "buscar";//Inserir, Editar, Buscar

    private E entidade;
    private List<E> entidades;
    
    public void novo() throws InstantiationException, IllegalAccessException {
        novaEntidade();
        mudarParaInseri();
    }

    public void salvar() throws ErroSistema { 
        getDao().merge(entidade);
        entidade = null;
        MessageUtil.MensagemSucesso("Salvo com sucesso!");
        mudarParaBusca();
    }
    
    public void editar(E entidade) throws ErroSistema {
        this.entidade = entidade;
        getDao().merge(entidade);//Método merge serve para atualizar ou salvar um objeto passado no banco
        MessageUtil.MensagemSucesso("Alterado com sucesso!");
        mudarParaEdita();
    }
    
    public void deletar(E entidade) throws ErroSistema {
        getDao().deletar(entidade);
        entidades.remove(entidade);
        MessageUtil.MensagemSucesso("Deletado com sucesso!");
    }
    
    public void buscar() throws ErroSistema {
        entidades = getDao().listar();
        if (entidades == null || entidades.size() < 1) {
            MessageUtil.MensagemSucesso("Não há nada cadastrado!");
        }
    }

    //getters e setters
    public E getEntidade() {
        return entidade;
    }
    
    public void setEntidade(E entidade) {
        this.entidade = entidade;
    }
    
    public List<E> getEntidades() {
        return entidades;
    }
    
    public void setEntidades(List<E> entidades) {
        this.entidades = entidades;
    }

    /**
     * Resposável por instanciar um objeto DAO do tipo D passado no diamante.
     */
    public abstract D getDao();

    //Cria um objeto do tipo E passado no diamante
    public void novaEntidade() throws InstantiationException, IllegalAccessException{
        Class<E> classe = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
        entidade = classe.newInstance();
    }

    //Metodos para controle da tela
    public boolean isInseri() {
        return "inserir".equals(estadoTela);
    }
    
    public boolean isEdita() {
        return "editar".equals(estadoTela);
    }
    
    public boolean isBusca() {
        return "buscar".equals(estadoTela);
    }
    
    public void mudarParaInseri() {
        estadoTela = "inserir";
    }
    
    public void mudarParaEdita() {
        estadoTela = "editar";
    }
    
    public void mudarParaBusca() {
        estadoTela = "buscar";
    }
}
