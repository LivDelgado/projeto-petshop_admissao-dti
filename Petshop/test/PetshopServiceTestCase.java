
//import org.junit.After;
import java.util.Calendar;
import java.util.Date;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lívia
 */
public class PetshopServiceTestCase {
    private static PetshopService psService;
    
    private Petshop ps1;
    private Petshop ps2;
    private Petshop ps3;
    
    @BeforeClass
    public static void setUpClass() {
        psService = new PetshopService();
    }
    
    @AfterClass
    public static void tearDownClass() {
        psService = null;
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
    public void testeCalculaPrecoBanho1 () {
        int qtdP = 3;
        int qtdG = 2;
        
        int ano = 2018;
        int mes = 11; // dezembro
        int dia = 17; // dia útil
        
        Date data;
        Calendar calendar = Calendar.getInstance();
        calendar.set(ano, mes, dia);
        data = calendar.getTime();
        
        /*
            preço esperado: 
                20 * 3 + 40 * 2
                60 + 80 = 140
        */
        double precoBanhoEsperado = 140.0;
        double precoObtido = psService.calculaPrecoBanho(ps1, data, qtdP, qtdG);
        
        assertEquals(precoBanhoEsperado, precoObtido, 0.00);
    }
    
    @Test
    public void testeCalculaPrecoBanho2 () {
        int qtdP = 2;
        int qtdG = 2;
        
        int ano = 2018;
        int mes = 11; // dezembro
        int dia = 16; // fim de semana
        
        Date data;
        Calendar calendar = Calendar.getInstance();
        calendar.set(ano, mes, dia);
        data = calendar.getTime();
        
        /*
            preço esperado: 
                24 * 2 + 48 * 2
                48 + 96 = 144
        */
        double precoBanhoEsperado = 144.0;
        double precoObtido = psService.calculaPrecoBanho(ps1, data, qtdP, qtdG);

        assertEquals(precoBanhoEsperado, precoObtido, 0.00);
    }
    
    @Test
    public void testeCalculaPrecoBanho3 () {
        int qtdP = 2;
        int qtdG = 2;
        
        int ano = 2018;
        int mes = 11; // dezembro
        int dia = 17; // dia útil
        
        Date data;
        Calendar calendar = Calendar.getInstance();
        calendar.set(ano, mes, dia);
        data = calendar.getTime();
        
        /*
            preço esperado: 
                15 * 2 + 50 * 2
                30 + 100 = 130
        */
        double precoBanhoEsperado = 130.0;
        double precoObtido = psService.calculaPrecoBanho(ps2, data, qtdP, qtdG);
        
        assertEquals(precoBanhoEsperado, precoObtido, 0.00);
    }
    
    @Test
    public void testeCalculaPrecoBanho4 () {
        int qtdP = 2;
        int qtdG = 2;
        
        int ano = 2018;
        int mes = 11; // dezembro
        int dia = 16; // fim de semana
        
        Date data;
        Calendar calendar = Calendar.getInstance();
        calendar.set(ano, mes, dia);
        data = calendar.getTime();
        
        /*
            preço esperado: 
                20 * 2 + 55 * 2
                40 + 110 = 150
        */
        double precoBanhoEsperado = 150.0;
        double precoObtido = psService.calculaPrecoBanho(ps2, data, qtdP, qtdG);

        assertEquals(precoBanhoEsperado, precoObtido, 0.00);
        
    }
    
    @Test
    public void testeCalculaPrecoBanho5 () {
        int qtdP = 2;
        int qtdG = 2;
        
        int ano = 2018;
        int mes = 11; // dezembro
        int dia = 17; // não importa o dia, o preço é igual em todos
        
        Date data;
        Calendar calendar = Calendar.getInstance();
        calendar.set(ano, mes, dia);
        data = calendar.getTime();
        
        /*
            preço esperado: 
                30 * 2 + 45 * 2
                60 + 90 = 150
        */
        double precoBanhoEsperado = 150.0;
        double precoObtido = psService.calculaPrecoBanho(ps3, data, qtdP, qtdG);
        
        assertEquals(precoBanhoEsperado, precoObtido, 0.00);
    }
    
    @Test
    public void testeComparaDist () {
        Petshop psMenorDist = ps3;
        assertEquals(psMenorDist, psService.comparaDistancia(psService.listaPetshops()));
    } 
}
