import br.com.felipesoarestech.ficharios.Fichario;
import br.com.felipesoarestech.modelos.Veiculo;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int opcao;
		ArrayList<Veiculo> veiculos = new ArrayList<>();
		Fichario fichario = new Fichario(veiculos);
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("-- SISTEMA DE VEÍCULOS --");
			System.out.println("[1] - CADASTRAR");
			System.out.println("[2] - CONSULTAR");
			System.out.println("[3] - ALTERAR");
			System.out.println("[4] - DELETAR");
			System.out.println("[5] - IMPRIMIR");
			System.out.println("[0] - SAIR");
			System.out.print(": ");
			opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				fichario.cadastrarVeiculo();
				break;
			case 2:
				fichario.consultarVeiculo();
				break;
			case 3:
				fichario.alterarVeiculo();
				break;
			case 4:
				fichario.excluirVeiculo();
				break;
			case 5:
				fichario.imprimirVeiculos();
				break;
			default:
				if (opcao != 0)
					System.out.println("Opcao inválida !!");
				break;
			}

		} while (opcao != 0);
		sc.close();
	}
}
