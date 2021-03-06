package br.com.fiap.webapplication.DemoAplicacaoWeb.model;

//import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name="produto", sequenceName = "SQ_PRODUTO",allocationSize = 1)
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "produto")
    private int codigo;

    @NotBlank(message= "Nome obrigatório")
    @Size(max = 50)
    private String nome;

    @Min(value=0 ,message= "Preço não deve ser negativo ")
    private double preco;

    private boolean novo;

    //Muitos produtos para uma categoria
    @ManyToOne(targetEntity=Categoria.class,  fetch=FetchType.EAGER)
    private Categoria categoria;

    //Deve ser uma data do passado
    @Past
    private LocalDate dataFabricacao;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isNovo() {
        return novo;
    }

    public void setNovo(boolean novo) {
        this.novo = novo;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
