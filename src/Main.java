import java.util.List;

public class Main {
    public static void main(String[] args) {
        TxtReader leitor = new TxtReader();
        List<String> nomes = leitor.lerNomesDeArquivo("female_names.txt");

        System.out.println("Total de nomes lidos: " + nomes.size());
        nomes.stream().limit(2500).forEach(System.out::println);
        }
}