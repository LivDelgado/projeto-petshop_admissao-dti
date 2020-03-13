/**
 * @author 
 * Lívia Delgado
 */

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PetshopController {
    
    private static PetshopService psService;

    public PetshopController() {
        psService = new PetshopService();
    }
    
    
    /**
     * O método monta uma String de saída exibindo o nome da melhor Petshop
     * para o caso e o preço final dos banhos.
     * 
     * 
     * @param data data dos banhos
     * @param qtdP quantidade de cachorros pequenos
     * @param qtdG quantidade de cachorros grandes
     * 
     * @return String
     */
    public String selecionaMelhorPetshop(String data, int qtdP, int qtdG) {
        double precoFinal = 0.0;
        double preco = 0.0;
        
        List<Petshop> melhoresPetshops = new ArrayList();
        Petshop petshopEscolhida;
        
        
        int dia = Integer.parseInt(data.substring(0,2));
        int mes = Integer.parseInt(data.substring(3,5)) - 1; // java Calendar começa no mês 0
        int ano = Integer.parseInt(data.substring(6,10));
        
        // teste dos parâmetros
        if (qtdP < 0 || qtdG < 0) {
            return "Número de cães inválido";
        } else if (dia < 1 || mes < 1 || mes > 12) {
            return "Data inválida";
        }
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(ano, mes, dia);
        Date dataD = calendar.getTime();
        
        for (Petshop ps : psService.listaPetshops()) {
            preco = psService.calculaPrecoBanho(ps, dataD, qtdP, qtdG);
            
            if (precoFinal == 0.0 || preco < precoFinal) {
            
                melhoresPetshops = new ArrayList();
                melhoresPetshops.add(ps);
                precoFinal = preco;
            
            } else if (preco == precoFinal) {
                
                melhoresPetshops.add(ps);
                
            }
        }
        
        if (melhoresPetshops.size() > 1) {
            petshopEscolhida = psService.comparaDistancia(melhoresPetshops);
        } else {
            petshopEscolhida = melhoresPetshops.get(0);
        }
        
        return "Petshop mais adequada: " + petshopEscolhida.getNome() + 
                "\nPreço: " + precoFinal;
    }   
}
