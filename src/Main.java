import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import db.Conexao;

import controller.TutorController;
import controller.VeterinarioController;
import controller.ConsultaController;
import controller.PetController;

import models.Consulta;
import models.Pet;
import models.Tutor;
import models.Veterinario;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = Conexao.getConexaoMySQL()) {

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Adicionar Tutor");
                System.out.println("2. Ler Todos os Tutores");
                System.out.println("3. Atualizar Tutor");
                System.out.println("4. Excluir Tutor");
                System.out.println("------------------------------");
                System.out.println("5. Adicionar Pet");
                System.out.println("6. Ler Todos os Pets");
                System.out.println("7. Atualizar Pet");
                System.out.println("8. Excluir Pet");
                System.out.println("------------------------------");
                System.out.println("9. Adicionar Veterinário");
                System.out.println("10. Ler Todos os Veterinários");
                System.out.println("11. Atualizar Veterinário");
                System.out.println("12. Excluir Veterinário");
                System.out.println("------------------------------");
                System.out.println("13. Adicionar Consulta");
                System.out.println("14. Ler Todas as Consultas");
                System.out.println("15. Atualizar Consulta");
                System.out.println("16. Excluir Consulta");
                System.out.println("------------------------------");
                System.out.println("17. Sair");
                System.out.println("Digite a opção desejada:");

                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha após a leitura do número

                switch (opcao) {
                    case 1:
                        // Adicionar um novo tutor
                        // System.out.println("Digite o nome do tutor:");
                        // String nomeTutor = scanner.nextLine();
                        // System.out.println("Digite o telefone do tutor:");
                        // String telefoneTutor = scanner.nextLine();
                        // System.out.println("Digite o email do tutor:");
                        // String emailTutor = scanner.nextLine();
                        // System.out.println("Digite a data de nascimento do tutor (no formato YYYY-MM-DD):");
                        // String dataNascimentoTutor = scanner.nextLine();

                        Tutor novoTutor = new Tutor("Jhon Doe", "8899325-6784", "jhondoe@email.com", "2003-06-29");
                        TutorController.insertData(conn, novoTutor);

                        System.out.println("Tutor adicionado com sucesso.");
                        break;

                    case 2:
                        // Ler todos os tutores
                        ArrayList<Tutor> tutores = TutorController.selectData(conn);
                        for (Tutor tutor : tutores) {
                            System.out.println(tutor);
                        }
                        break;

                    case 3:
                        // Atualizar informações de um tutor
                        Tutor tutorParaAtualizar = tutores.get(0);
                        tutorParaAtualizar.setNome("João da Silva");
                        tutorParaAtualizar.setTelefone("987-654-321");
                        TutorController.updateData(conn, tutorParaAtualizar.getId(), tutorParaAtualizar);
                        break;

                    case 4:
                        // Excluir um tutor
                        int tutorIdParaExcluir = tutores.get(0).getId();
                        TutorController.deleteData(conn, tutorIdParaExcluir);
                        break;

                    case 5:
                        // Adicionar um novo pet
                        Tutor tutor = new Tutor();
                        tutor.setId(1); // Substitua pelo ID do tutor existente
                        Pet novoPet = new Pet("Bolinha", "Cachorro", "Vira-lata", 3, tutor);
                        PetController.insertData(conn, novoPet);
                        break;

                    case 6:
                        // Ler todos os pets
                        ArrayList<Pet> pets = PetController.selectData(conn);
                        for (Pet pet : pets) {
                            System.out.println(pet);
                        }
                        break;

                    case 7:
                        // Atualizar informações de um pet
                        Pet petParaAtualizar = pets.get(0);
                        petParaAtualizar.setNome("Novo Nome");
                        petParaAtualizar.setRaca("Nova Raça");
                        PetController.updateData(conn, petParaAtualizar.getId(), petParaAtualizar);
                        break;

                    case 8:
                        // Excluir um pet
                        int petIdParaExcluir = pets.get(0).getId();
                        PetController.deleteData(conn, petIdParaExcluir);
                        break;

                    case 9:
                        // Adicionar um novo veterinário
                        Veterinario veterinario = new Veterinario(opcao, "Dr. Silva", "Cardiologia", "8899317-1426");
                        VeterinarioController.insertData(conn, veterinario);
                        break;

                    case 10:
                        // Ler todos os veterinários
                        ArrayList<Veterinario> veterinarios = VeterinarioController.selectData(conn);
                        for (Veterinario veterinario : veterinarios) {
                            System.out.println(veterinario);
                        }

                    case 11:
                        // Atualizar informações de um veterinário
                        Veterinario veterinarioParaAtualizar = veterinarios.get(0);
                        veterinarioParaAtualizar.setNome("Dr. Novo Nome");
                        veterinarioParaAtualizar.setEspecialidade("Nova Especialidade");
                        VeterinarioController.updateData(conn, veterinarioParaAtualizar.getId(), veterinarioParaAtualizar);
                        break;

                    case 12:
                        // Excluir um veterinário
                        int veterinarioIdParaExcluir = veterinarios.get(0).getId();
                        VeterinarioController.deleteData(conn, veterinarioIdParaExcluir);
                        break;

                    case 13:
                        // Adicionar uma nova consulta
                        Consulta novaConsulta = new Consulta();
                        novaConsulta.setDataHora("2024-03-08 10:00:00");
                        novaConsulta.setVeterinarioId(1);
                        novaConsulta.setPetId(1);
                        novaConsulta.setNotas("Consulta de rotina");
                        ConsultaController.insertData(conn, novaConsulta);
                        break;

                    case 14:
                        // Ler todas as consultas
                        ArrayList<Consulta> consultas = ConsultaController.selectData(conn);
                        for (Consulta consulta : consultas) {
                            System.out.println(consulta);
                        }
                        break;

                    case 15:
                        // Atualizar a consulta
                        Consulta consultaParaAtualizar = consultas.get(0);
                        consultaParaAtualizar.setNotas("Nova nota para a consulta");
                        ConsultaController.updateData(conn, consultaParaAtualizar);
                        break;

                    case 16:
                        // Excluir a consulta
                        int consultaIdParaExcluir = consultas.get(0).getId();
                        ConsultaController.deleteData(conn, consultaIdParaExcluir);
                        break;

                    case 17:
                        // Sair do programa
                        System.out.println("Programa encerrado.");
                        conn.close();
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}