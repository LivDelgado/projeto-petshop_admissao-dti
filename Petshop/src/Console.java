public class Console {

    public static void main(String[] args) {
        
        PetshopController controle = new PetshopController();
        
        System.out.println(
                controle.selecionaMelhorPetshop(
                    args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2])
                )
        );
        
        
    }
    
}
