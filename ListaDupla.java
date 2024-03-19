public class ListaDupla {

    //os elementos primeiro e último sao de controle da classe e portanto, nao estao disponiveis ao usuario
    private NoDuplo primeiro;
    private NoDuplo ultimo;

    //construtor é padrão

    public boolean estaVazia(){
        return primeiro == null; // se o atributo primeiro estiver null, significa que nao tem nenhum elemento na lista
    }

    public void insereInicio(int info){
        NoDuplo novo = new NoDuplo(info);

        if(estaVazia()){
            ultimo = novo;
        }else{
            novo.setProximo(primeiro);
            primeiro.setAnterior(novo);
        }
        primeiro = novo;
    }

    public void insereFim(int info){
        NoDuplo novo = new NoDuplo(info);
        if(estaVazia()){
            primeiro = novo;
        }else{
            novo.setAnterior(ultimo);
            ultimo.setAnterior(novo);
        }
        ultimo = novo;
    }

    public int removeInicio(){

        int info = primeiro.getInfo();

        primeiro = primeiro.getProximo(); //entramos na caixinha do primeiro e pegamos o endereço do segundo - agora a variavel primeiro referencia o segundo elemento da lista

        if(primeiro == null){ //tem um único elemento. como tem só int, para nao devolvermos -1, deixamos a responsabilidade de testar se a lista está vazia para a aplicação
            ultimo = null;
        }else{
           primeiro.setAnterior(null); // apagamos o endereço do antigo primeiro da caixinha do segundo (o novo primeiro), cortando as amarras daquele primeiro elemento com a lista.
        }

        return info;
    }
}

//tarefa: implementar o removeFim e o toString.
