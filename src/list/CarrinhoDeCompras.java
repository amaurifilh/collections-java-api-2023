package list;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> listaDeItens;

    public CarrinhoDeCompras() {
        this.listaDeItens = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        Item item = new Item(nome, preco, quantidade);
        this.listaDeItens.add(item);
    }

    public void removerItem(String nome){
        List<Item> listaDeItensRemover = new ArrayList<>();
        if(!listaDeItens.isEmpty()){
            for(Item i : listaDeItens){
                if(i.getNome().equalsIgnoreCase(nome)){
                    listaDeItensRemover.add(i);
                }
            }
        listaDeItens.removeAll(listaDeItensRemover);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public double calcularValorTotal(){
        double valorTotal = 0d;
        
        if(!listaDeItens.isEmpty()){
            for (Item item : listaDeItens){
            double valorItem = item.getPreco() * item.getQuantidade();
            valorTotal += valorItem;
            }
            return valorTotal;
        }else {
            throw new RuntimeException("A Lista está vazia!");
        }
    }

    public void exibirItens() {
        if (!listaDeItens.isEmpty()){
            System.out.println(this.listaDeItens);
        } else {
            System.out.println("A Lista está vazia!");
        }
    }
    
    @Override
    public String toString(){
        return "CarrinhoDeCompras{" +
                "itens=" + listaDeItens + 
                 '}';
    }

    public static void main(String[] args) {
        CarrinhoDeCompras minhaCompras = new CarrinhoDeCompras();

        minhaCompras.adicionarItem("Feijao", 4d, 1);
        minhaCompras.adicionarItem("Arroz", 3d, 2);
        minhaCompras.adicionarItem("Feijao", 4d, 1);
        minhaCompras.adicionarItem("Fubá", 2d, 6);
    
        minhaCompras.exibirItens();

        minhaCompras.removerItem("Feijao");

        System.out.println("O valor da compra é = " + minhaCompras.calcularValorTotal());
    }
}