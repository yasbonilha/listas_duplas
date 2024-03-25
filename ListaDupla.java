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
        primeiro = novo; //independentemente da lista estar vazia ou nao, o novo sempre será o primeiro.
    }

    public void insereFim(int info){
        NoDuplo novo = new NoDuplo(info);
        if(estaVazia()){
            primeiro = novo;
        }else{
            novo.setAnterior(ultimo);
            ultimo.setProximo(novo);
        }
        ultimo = novo;
    }

    public int removeInicio(){

        int info = primeiro.getInfo();

        primeiro = primeiro.getProximo(); //entramos na caixinha do primeiro e pegamos o endereço do segundo - agora a variavel primeiro referencia o segundo elemento da lista

        if(primeiro == null){ //tem um único elemento. como tem só int, para nao devolvermos -1, deixamos a responsabilidade de testar se a lista está vazia para a aplicação
            ultimo = null;//esvaziou a lista
        }else{
           primeiro.setAnterior(null); // apagamos o endereço do antigo primeiro da caixinha do segundo (o novo primeiro), cortando as amarras daquele primeiro elemento com a lista.
        }

        return info; //devolvemos porque é o padrão
    }

    //tarefa: implementar o removeFim e o toString.
    public int removeFim(){

        int info = ultimo.getInfo();
        
        ultimo = ultimo.getAnterior();


        if(ultimo == null){
            primeiro = null;//esvaziou a lista
        }else{
           ultimo.setProximo(null);
        }

        return info;
    }

    @Override

    public String toString(){
        String s = "//<- ";
        if (estaVazia()) {
            s+= "lista vazia";
        } else {
            NoDuplo aux = primeiro;
            while (aux != null) {
                s += aux + "=";
                aux = aux.getProximo();
            }
            s+= "->//";
        }
        return s;
    }

    public void insereElementoPosicao(int info, int pos){ //vantagem de chamar outros métodos dentro do método: menos código, mais legibilidade de codigo. desvantagens = nao podemos criar o no antes de chamar o metodo
        if (estaVazia() || pos == 1){
            insereInicio(info);
        }
        else{ //encontrando a posição 
            NoDuplo aux = primeiro;
            int cont = 1;
            while (aux !=ultimo && cont < pos){
                aux = aux.getProximo();
                cont++;
            }
            if (aux == ultimo ){
                insereFim(info);
            } else {
                NoDuplo novo = new NoDuplo(info);
                novo.setAnterior(aux.getAnterior());
                
            }
        }
    }

}

//dumb knot - inicializar a lista com um nó vazio, que é apontado pelo primeiro e pelo último, e isso que caracteriza a lista como vazia
//podem existir diferentes implementações para a mesma especificação
//tokens são palavras computacionais
// as linked lists do java são feitas a partir da estrutura deque - que também é usada na própria parte livre da memória

