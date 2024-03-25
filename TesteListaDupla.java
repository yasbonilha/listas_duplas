import java.util.Random;

public class TesteListaDupla {
    public static void main(String[] args) {
        Random random = new Random();
        ListaDupla lDupla = new ListaDupla();

        do {

            if (random.nextBoolean()) { // verdadeiro: insere
                if (random.nextBoolean()) { // verdadeiro inicio
                    lDupla.insereInicio(random.nextInt(10));
                    System.out.println("insere inicio");

                } else { // falso no final
                    lDupla.insereFim(10);
                    System.out.println("insere fim");

                }
            } else if(!lDupla.estaVazia()) { //falso: remove, se não estiver vazia para não tomar uma null pointer
                if (random.nextBoolean()){ // remove no fim 
                    System.out.println(lDupla.removeFim() + "saiu do final");

                } else { // remove no inicio
                    System.out.println(lDupla.removeInicio() + "saiu do inicio");

                }
            }
            System.out.println(lDupla);
        } while (!lDupla.estaVazia());

        
    }
}
