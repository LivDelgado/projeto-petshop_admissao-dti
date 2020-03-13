//import org.junit.After;
//import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lívia
 */
public class PetshopDAOTestCase {
    private static PetshopDAO psDAO;
    
    @BeforeClass
    public static void setUpClass() {
        psDAO = PetshopDAO.getInstance();
    }
    
    @AfterClass
    public static void tearDownClass() {
        psDAO = null;
    }
    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }

    @Test
    public void testeInsercao() {
        assertTrue(psDAO.inserePetshop(new Petshop("Happy Dog", 20.0, 40.0, 25.0, 45.0, 1.0)));
    }
    
    @Test
    public void testeExclusaoF() {
        Petshop psExcluir = new Petshop("PS", 15.0, 20.0, 30.0, 40.0, 2.0);
        assertFalse(psDAO.excluiPetshop(psExcluir));
    }

    @Test
    public void testeExclusaoT() {
        Petshop psExcluir = new Petshop("Meu Canino Feliz", 20.00, 40.00, 20.00*1.2, 40.00*1.2, 2.0);
        assertFalse(psDAO.excluiPetshop(psExcluir));
    }
    
    @Test
    public void testeBusca() {
        assertNotNull(psDAO.buscaPetshop("Vai Rex"));
    }
    
    @Test
    public void testeEdita() {
        Petshop newPS = new Petshop("ChowMara2000", 30.00, 45.00, 30.00, 45, 0.8);
        assertTrue(psDAO.editaPetshop(psDAO.buscaPetshop("ChowMara"), newPS));
    }
}
