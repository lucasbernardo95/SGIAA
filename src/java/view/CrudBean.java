/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author lber_000
 */
public interface CrudBean {
    
    public abstract void novo();
    public abstract void salvar();
    public abstract void alterar();
    public abstract void buscar();
    public abstract void excluir();
}
