/**
 * @author 
 * Lívia Delgado
 */

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PetshopService {
    
    private Date data;
    private int qtdPequenos;
    private int qtdGrandes;
    
    private PetshopDAO dao;

    public PetshopService() {
        dao = PetshopDAO.getInstance();
    }

    /**
     * 
     * @return Date
     */
    public Date getData() {
        return data;
    }

    /**
     * 
     * @param data
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * 
     * @return int
     */
    public int getQtdPequenos() {
        return qtdPequenos;
    }

    /**
     * 
     * @param qtdPequenos
     */
    public void setQtdPequenos(int qtdPequenos) {
        this.qtdPequenos = qtdPequenos;
    }

    /**
     * 
     * @return int
     */
    public int getQtdGrandes() {
        return qtdGrandes;
    }

    /**
     * 
     * @param qtdGrandes
     */
    public void setQtdGrandes(int qtdGrandes) {
        this.qtdGrandes = qtdGrandes;
    }
    
    /**
     * Insere uma nova Petshop à estrutura de dados.
     * 
     * @param ps petshop a inserir
     * 
     * @return boolean
     */
    public boolean inserePetshop(Petshop ps) {
        return dao.inserePetshop(ps);
    }

    /**
     * Exclui uma Petshop da estrutura de dados.
     *      
     * @param ps petshop a excluir
     * 
     * @return boolean
     */
    public boolean excluiPetshop(Petshop ps) {
        return dao.excluiPetshop(ps);
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
        return dao.editaPetshop(psOld, psNew);
    }
    
    /**
     * Busca uma Petshop na estrutura de dados.
     *      
     * @param nome nome da petshop a buscar
     * 
     * @return Petshop
     */
    public Petshop buscaPetshop(String nome) {
        return dao.buscaPetshop(nome);
    } 
    
    /**
     * Lista todas as petshops.
     *      
     * @return 
     */
    public List<Petshop> listaPetshops() {
        return dao.listaPetshops();
    }
    
    /**
     * O método calcula e retorna o preço total dos banhos.
     * 
     * @param ps petshop específica para cálculo do preço
     * @param data data dos banhos
     * @param qtdPequenos quantidade de cachorros pequenos
     * @param qtdGrandes quantidade de cachorros grandes
     * 
     * @return double
     */
    public Double calculaPrecoBanho(Petshop ps, Date data, 
            int qtdPequenos, int qtdGrandes) {
        double preco;
        
        setData(data);
        setQtdGrandes(qtdGrandes);
        setQtdPequenos(qtdPequenos);
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);
        
        if (diaSemana > 1 && diaSemana < 7) {
            preco = qtdPequenos * ps.getPrecoDiaUtilP();
            preco += qtdGrandes * ps.getPrecoDiaUtilG();
        } else {
            preco = qtdPequenos * ps.getPrecoFimSemanaP();
            preco += qtdGrandes * ps.getPrecoFimSemanaG();
        }
        
        return preco;
    }
    
    /**
     * O método retorna qual Petshop está a uma menor distância do cliente.
     * 
     * @param lista lista de Petshops para comparação
     * 
     * @return Petshop
     */
    public Petshop comparaDistancia (List<Petshop> lista) {
        double menor = 0.0;
        Petshop psMaisProx = null;
        
        for (Petshop ps : lista) {
            if (menor == 0.0) {
                menor = ps.getDistancia();
                psMaisProx = ps;
            } else if (ps.getDistancia() < menor) {
                menor = ps.getDistancia();
                psMaisProx = ps;
            }
        }
        
        return psMaisProx;
    }
}
