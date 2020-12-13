/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name = "livro", catalog = "bd_relatorio_livraria", schema = "")

public class Livro implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlivro")
    private Integer idlivro;
    @Column(name = "nome")
    private String nome;
    @Column(name = "editora")
    private String editora;
    
    @OneToMany(mappedBy = "livro")
    private List<Compra> compras = new ArrayList<>();

    public Livro() {
    }

    public Livro(Integer idlivro) {
        this.idlivro = idlivro;
    }

    public Integer getIdlivro() {
        return idlivro;
    }

    public void setIdlivro(Integer idlivro) {
        Integer oldIdlivro = this.idlivro;
        this.idlivro = idlivro;
        changeSupport.firePropertyChange("idlivro", oldIdlivro, idlivro);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        String oldEditora = this.editora;
        this.editora = editora;
        changeSupport.firePropertyChange("editora", oldEditora, editora);
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlivro != null ? idlivro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livro)) {
            return false;
        }
        Livro other = (Livro) object;
        if ((this.idlivro == null && other.idlivro != null) || (this.idlivro != null && !this.idlivro.equals(other.idlivro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
