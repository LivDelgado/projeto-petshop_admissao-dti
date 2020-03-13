
//import org.junit.After;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lívia
 */
public class PetshopControllerTestCase {
    private static PetshopController psController;
    private static PetshopService psService;

    private Petshop ps1;
    private Petshop ps2;
    private Petshop ps3;
    
    @BeforeClass
    public static void setUpClass() {
        psController = new PetshopController();
        psService = new PetshopService();
    }
    
    @AfterClass
    public static void tearDownClass() {
        psController = null;
    }
    
    @Before
    public void setUp() {
        ps1 = psService.buscaPetshop("Meu Canino Feliz");
        ps2 = psService.buscaPetshop("Vai Rex");
        ps3 = psService.buscaPetshop("ChowMara");
    }
    
//    @After
//    public void tearDown() {
//    }
    
    @Test
    public void testeParametros1() {
        String data = "17/12/2018";
        int qtdP = -1;
        int qtdG = 2;
        
        String resultadoEsperado = 
                "Número de cães inválido";
        
        String resultadoObtido = psController.selecionaMelhorPetshop(data, qtdP, qtdG);
        
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
    @Test
    public void testeParametros2() {
        String data = "10/00/2018";
        int qtdP = 2;
        int qtdG = 2;
        
        String resultadoEsperado = 
                "Data inválida";
        
        String resultadoObtido = psController.selecionaMelhorPetshop(data, qtdP, qtdG);
        
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
    @Test
    public void testeParametros3() {
        String data = "00/00/2018";
        int qtdP = 2;
        int qtdG = 2;
        
        String resultadoEsperado = 
                "Data inválida";
        
        String resultadoObtido = psController.selecionaMelhorPetshop(data, qtdP, qtdG);
        
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
    @Test
    // caso em que uma petshop específica é melhor
    public void testeSelecao1() {
        String data = "17/12/2018"; // dia útil
        int qtdP = 3;
        int qtdG = 2;
        
        /*
            cálculo dos preços
                Meu Canino Feliz:
                   20 * 3 + 40 * 2 = 140
                Vai Rex:
                    15 * 3 + 50 * 2 = 145
                ChowMara:
                    30 * 3 + 45 * 2 = 180
        */
        
        String nome = "Meu Canino Feliz";
        double precoFinal = 140.0;
        
        String resultadoEsperado = 
                "Petshop mais adequada: " + nome + 
                "\nPreço: " + precoFinal;
        
        String resultadoObtido = psController.selecionaMelhorPetshop(data, qtdP, qtdG);
        
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    // caso em que o preço é o mesmo pra mais de uma Petshop e é necessário o desempate pela distância
    public void testeSelecao2() {
        String data = "17/12/2018"; // dia útil
        int qtdP = 4;
        int qtdG = 2;
        
        /*
            cálculo dos preços
                Meu Canino Feliz:
                   20 * 4 + 40 * 2 = 160
                Vai Rex:
                    15 * 4 + 50 * 2 = 160
                ChowMara:
                    30 * 4 + 45 * 2 = 210
        
                A distância de Vai Rex é de 1.7 Km e de Meu Canino Feliz é 2.0 Km
        */
        
        String nome = "Vai Rex";
        double precoFinal = 160.0;
        
        String resultadoEsperado = 
                "Petshop mais adequada: " + nome + 
                "\nPreço: " + precoFinal;
        
        String resultadoObtido = psController.selecionaMelhorPetshop(data, qtdP, qtdG);
        
        assertEquals(resultadoEsperado, resultadoObtido);
    }

}
