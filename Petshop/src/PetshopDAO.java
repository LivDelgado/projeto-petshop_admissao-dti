import java.util.ArrayList;
import java.util.List;

public class PetshopDAO {
    
    private static PetshopDAO instancia;
    private static List<Petshop> listaPetshops;

    public PetshopDAO() {
        this.listaPetshops = new ArrayList();
        
        // insere os dados informados no problema
        Petshop p1 = new Petshop(
                "Meu Canino Feliz", 20.00, 40.00, 20.00*1.2, 40.00*1.2, 2.0
        );
        Petshop p2 = new Petshop(
                "Vai Rex", 15.00, 50.00, 20.00, 55, 1.7
        );
        Petshop p3 = new Petshop(
                "ChowMara", 30.00, 45.00, 30.00, 45, 0.8
        );
        listaPetshops.add(p1);
        listaPetshops.add(p2);
        listaPetshops.add(p3);
    }
    
    public static PetshopDAO getInstance() {
        if (instancia == null) {
            instancia = new PetshopDAO();
        }
        
        return instancia;
    }
    
    /**
     * Insere uma nova Petshop à estrutura de dados.
     * 
     * @param ps petshop a inserir
     * 
     * @return boolean
     */
    public boolean inserePetshop(Petshop ps) {
        return (listaPetshops.add(ps));
    }

    /**
     * Exclui uma Petshop da estrutura de dados.
     *      
     * @param ps petshop a excluir
     * 
     * @return boolean
     */
    public boolean excluiPetshop(Petshop ps) {
        Petshop psEncontrada = buscaPetshop(ps.getNome());
        if (psEncontrada != null) {
            return (listaPetshops.remove(ps));
        } else {
            return false;
        }
    }
    
    /**
     * Edita uma Petshop na estrutura de dados.
     * 
     * @param psOld petshop a editar
     * @param psNew petshop alterada
     * 
     * @return boolean
     */
    public boolean editaPetshop(Petshop psOld, Petshop psNew) {
        if (listaPetshops.contains(psOld)) {
            listaPetshops.set(listaPetshops.indexOf(psOld), psNew);
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Busca uma Petshop na estrutura de dados.
     *      
     * @param nome nome da petshop a buscar
     * 
     * @return Petshop
     */
    public Petshop buscaPetshop(String nome) {
        for (Petshop ps : listaPetshops) {
            if (ps.getNome().equals(nome)) {
                return ps;
            }
        }
        return null;
    }
    
    /**
     * Lista todas as petshops.
     *      
     * @return 
     */
    public List<Petshop> listaPetshops() {
        return listaPetshops;
    }
}
