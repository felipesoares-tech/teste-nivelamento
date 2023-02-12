package br.com.felipesoarestech.Ficharios;
import br.com.felipesoarestech.Modelos.Veiculo;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
public class Fichario {
    private final ArrayList<Veiculo> veiculos;
    private final Scanner sc;

    public Fichario(ArrayList<Veiculo> veiculos) {
        this.veiculos = veiculos;
        sc = new Scanner(System.in);
    }

    private Optional<Veiculo> buscaVeiculoPlaca(String placa){
        Optional<Veiculo> veiculo = Optional.of(new Veiculo(placa));
        return veiculos.contains(veiculo.get()) ? Optional.ofNullable(veiculos.get(veiculos.indexOf(veiculo.get()))) : Optional.empty();
    }

    private boolean editarVeiculo(Veiculo veiculo, String valor,int param){
        switch (param){
            case 1 -> {
                if (!veiculos.contains(new Veiculo(valor))){
                    veiculo.setPlaca(valor);
                    return true;
                }
            }
            case 2 -> {
                veiculo.setMarca(valor);
                return true;
            }
            case 3 ->{
                veiculo.setModelo(valor);
                return true;
            }
        }
        return false;
    }

    private boolean editarVeiculo(Veiculo veiculo, int valor,int param){
        switch (param){
            case 4 ->{
                veiculo.setAnoFabricacao(valor);
                return true;
            }
            case 5 -> {
                veiculo.setAnoModelo(valor);
                return true;
            }
        }
        return false;
    }

    private boolean editarVeiculo(Veiculo veiculo, float valor){
        veiculo.setPreco(valor);
        return true;
    }

    public void cadastrarVeiculo(){
        System.out.print("Informe a placa do veículo: ");
        String placa = sc.nextLine();

        System.out.print("Informe a marca do veiculo: ");
        String marca = sc.nextLine();

        System.out.print("Informe o modelo do veiculo: ");
        String modelo = sc.nextLine();

        System.out.print("Informe o ano de fabricação: ");
        int anoFabricacao = sc.nextInt();

        System.out.print("Informe o ano modelo do veículo: ");
        int anoModelo = sc.nextInt();

        System.out.print("Informe o preço do veículo: ");
        float preco = sc.nextFloat();
        sc.skip("\n");

        Veiculo veiculo = new Veiculo(marca,modelo,placa,anoFabricacao,anoModelo,preco);

        if(!veiculos.contains(veiculo)){
            if (veiculos.add(veiculo))
                System.out.println("Veículo cadsatrado com sucesso !");
            else
                System.out.println("Erro ao cadastrar o veículo");
        }else
            System.out.println("Erro: Veículo já cadastrado !!");

    }
    public void excluirVeiculo(){
        System.out.println("Informe a placa do veículo: ");
        String placa = sc.nextLine();

        Optional<Veiculo> veiculo =  buscaVeiculoPlaca(placa);

        if (veiculo.isPresent()){
            System.out.print("Tem certeza que deseja excluir o veiculo de placa "+veiculo.get().getPlaca()+" ? [S/n]: ");
            String resp = sc.nextLine();

            if (resp.equalsIgnoreCase("S")){
                if (veiculos.remove(veiculo.get()))
                    System.out.println("Veículo removido com sucesso !!");
                else
                    System.out.println("Erro ao remover o veículo !!");
            }
        }else
            System.out.println("Veículo não encontrado !!");
    }
    public void consultarVeiculo(){
        System.out.println("Informe a placa do veículo: ");
        String placa = sc.nextLine();

        Optional<Veiculo> veiculo =  buscaVeiculoPlaca(placa);
        System.out.println(veiculo.isPresent() ? veiculo.get() : "Veículo não encontrado !!");
    }
    public void alterarVeiculo() {
        System.out.print("Informe a placa do veículo o qual deseja alterar: ");
        String placa = sc.nextLine();

        Optional<Veiculo> veiculo = buscaVeiculoPlaca(placa);

        if (veiculo.isPresent()) {
            System.out.println("-- ALTERAR VEÍCULO --");
            System.out.println("[1] - PLACA");
            System.out.println("[2] - MARCA");
            System.out.println("[3] - MODELO");
            System.out.println("[4] - ANO FABRICAÇÃO");
            System.out.println("[5] - ANO MODELO");
            System.out.println("[6] - PREÇO");
            System.out.println("[0] - CANCELAR");
            System.out.print(":");
            int opcao = sc.nextInt();
            sc.skip("\n");
            switch (opcao) {
                case 1 -> {
                    System.out.print("Informe a placa do veículo" + " " + "[" + veiculo.get().getPlaca() + "]: ");
                    String novaPlaca = sc.nextLine();

                    System.out.print("Confirmar alterações ? [S/n]: ");
                    String resp = sc.nextLine();
                    if (resp.equalsIgnoreCase("S"))
                        System.out.println(editarVeiculo(veiculo.get(), novaPlaca, opcao) ? "Placa alterada com sucesso!" : "Erro ao alterar veículo!!");
                }
                case 2 -> {
                    System.out.print("Informe a marca do veículo" + " " + "[" + veiculo.get().getMarca() + "]: ");
                    String marca = sc.nextLine();

                    System.out.print("Confirmar alterações ? [S/n]: ");
                    String resp = sc.nextLine();

                    if (resp.equalsIgnoreCase("S"))
                        System.out.println(editarVeiculo(veiculo.get(), marca, opcao) ? "Marca alterada com sucesso" : "Erro ao alterar marca do veículo");


                }
                case 3 -> {
                    System.out.print("Informe o modelo do veículo" + " " + "[" + veiculo.get().getModelo() + "]: ");
                    String modelo = sc.nextLine();

                    System.out.print("Confirmar alterações ? [S/n]: ");
                    String resp = sc.nextLine();

                    if (resp.equalsIgnoreCase("S"))
                        System.out.println(editarVeiculo(veiculo.get(), modelo, opcao) ? "Modelo alterado com sucesso!" : "Errro ao alterar o modelo do veículo !!");

                }

                case 4 -> {
                    System.out.print("Informe o ano de fabricação do veículo" + " " + "[" + veiculo.get().getAnoFabricacao() + "]: ");
                    int anoFabricacao = sc.nextInt();
                    sc.skip("\n");

                    System.out.print("Confirmar alterações ? [S/n]: ");
                    String resp = sc.nextLine();

                    if (resp.equalsIgnoreCase("S"))
                        System.out.println(editarVeiculo(veiculo.get(), anoFabricacao, opcao) ? "Ano fabricação alterado com sucesso !!" : "Erro ao alterar o ano de fabricacação !!");

                }

                case 5 -> {
                    System.out.print("Informe o ano modelo do veículo" + " " + "[" + veiculo.get().getAnoModelo() + "]: ");
                    int anoModelo = sc.nextInt();
                    sc.skip("\n");

                    System.out.print("Confirmar alterações ? [S/n]: ");
                    String resp = sc.nextLine();

                    if (resp.equalsIgnoreCase("S"))
                        System.out.println(editarVeiculo(veiculo.get(), anoModelo, opcao) ? "Ano modelo alterado com sucesso !!" : "Erro ao alterar o ano modelo !!");

                }

                case 6 -> {
                    System.out.print("Informe o preço do veículo" + " " + "[" + veiculo.get().getPreco() + "]: ");
                    float preco = sc.nextFloat();
                    sc.skip("\n");

                    System.out.print("Confirmar alterações ? [S/n]: ");
                    String resp = sc.nextLine();

                    if (resp.equalsIgnoreCase("S"))
                        System.out.println(editarVeiculo(veiculo.get(), preco) ? "Preço alterado com sucesso !!" : "Erro ao alterar o preço do veíciulo !!");
                }
            }
        }else
            System.out.println("Veículo não encontrado !!");
    }
    public void imprimirVeiculos(){
        System.out.println(!veiculos.isEmpty() ? veiculos : "Nenhum veículo cadastrado!");
    }

}
