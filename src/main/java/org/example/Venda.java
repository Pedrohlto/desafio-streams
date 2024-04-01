package org.example;

public final class Venda {

    private String idVenda;
    private String produto;
    private String vendedor;
    private int quantidadeVendida;
    private double precoUnitario;
    private String formaPagamento;

    public Venda(String idVenda, String produto, String vendedor, int quantidadeVendida, double precoUnitario, String formaPagamento) {
        this.idVenda = idVenda;
        this.produto = produto;
        this.vendedor = vendedor;
        this.quantidadeVendida = quantidadeVendida;
        this.precoUnitario = precoUnitario;
        this.formaPagamento = formaPagamento;
    }

    public String getIdVenda() {
        return idVenda;
    }

    public String getProduto() {
        return produto;
    }

    public String getVendedor() {
        return vendedor;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public String getFormaPagamento() {return formaPagamento;}
}
