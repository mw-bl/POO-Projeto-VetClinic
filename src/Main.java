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
                        System.out.println("Digite o nome do tutor:");
                        String nome = scanner.nextLine();
                        System.out.println("Digite o telefone do tutor:");
                        String telefone = scanner.nextLine();
                        System.out.println("Digite o email do tutor:");
                        String email = scanner.nextLine();
                        System.out.println("Digite a data de nascimento do tutor (no formato YYYY-MM-DD):");
                        String dataNascimento = scanner.nextLine();
                    
                        Tutor novoTutor = new Tutor(nome, telefone, email, dataNascimento);
                    
                        TutorController.insertData(conn, novoTutor);
                        System.out.println("Tutor adicionado!");
                    break;

                    case 2:
                        // Ler todos os tutores
                        ArrayList<Tutor> tutoresList = TutorController.selectData(conn);

                        System.out.println("Lista de Tutores:");
                        for (Tutor tutor : tutoresList) {
                            System.out.println("ID: " + tutor.getId());
                            System.out.println("Nome: " + tutor.getNome());
                            System.out.println("Telefone: " + tutor.getTelefone());
                            System.out.println("Email: " + tutor.getEmail());
                            System.out.println("Data de Nascimento: " + tutor.getDataNascimento());
                            System.out.println("---------------------------");
                        }
                        break;

                    case 3:
                        // Atualizar informações de um tutor
                        System.out.println("Digite o ID do tutor que deseja atualizar:");
                        int tutorIdParaAtualizar = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.println("Digite o novo nome do tutor:");
                        String novoNome = scanner.nextLine();
                        System.out.println("Digite o novo telefone do tutor:");
                        String novoTelefone = scanner.nextLine();
                        System.out.println("Digite o novo email do tutor:");
                        String novoEmail = scanner.nextLine();
                        System.out.println("Digite a nova data de nascimento do tutor (no formato YYYY-MM-DD):");
                        String novaDataNascimento = scanner.nextLine();

                        Tutor tutorParaAtualizar = new Tutor();
                        tutorParaAtualizar.setId(tutorIdParaAtualizar);
                        tutorParaAtualizar.setNome(novoNome);
                        tutorParaAtualizar.setTelefone(novoTelefone);
                        tutorParaAtualizar.setEmail(novoEmail);
                        tutorParaAtualizar.setDataNascimento(novaDataNascimento);

                        TutorController.updateData(conn, tutorIdParaAtualizar, tutorParaAtualizar);
                        System.out.println("Dados do tutor atualizados!");
                        break;

                    case 4:
                        // Excluir um tutor
                        System.out.println("Digite o ID do tutor que deseja excluir:");
                        int tutorIdParaExcluir = scanner.nextInt();
                        scanner.nextLine();

                        TutorController.deleteData(conn, tutorIdParaExcluir);
                        System.out.println("Tutor excluído com sucesso.");
                        break;

                    case 5:
                        // Adicionar um novo pet
                        System.out.println("Digite o nome do pet:");
                        String nomePet = scanner.nextLine();
                        System.out.println("Digite a espécie do pet:");
                        String especiePet = scanner.nextLine();
                        System.out.println("Digite a raça do pet:");
                        String racaPet = scanner.nextLine();
                        System.out.println("Digite a idade do pet:");
                        int idadePet = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Digite o ID do tutor do pet:");
                        int tutorIdPet = scanner.nextInt();
                        scanner.nextLine();

                        Tutor tutorPet = new Tutor();
                        tutorPet.setId(tutorIdPet);

                        Pet novoPet = new Pet(nomePet, especiePet, racaPet, idadePet, tutorPet);

                        PetController.insertData(conn, novoPet);
                        System.out.println("Pet adicionado com sucesso.");
                        break;
                    case 6:
                        // Ler todos os pets
                        ArrayList<Pet> petsList = PetController.selectData(conn);

                        System.out.println("Lista de Pets:");
                        for (Pet pet : petsList) {
                            System.out.println("ID: " + pet.getId());
                            System.out.println("Nome: " + pet.getNome());
                            System.out.println("Especie: " + pet.getEspecie());
                            System.out.println("Raça: " + pet.getRaca());
                            System.out.println("Idade: " + pet.getIdade());
                        }
                        break;

                    case 7:
                        // Atualizar informações de um pet
                        System.out.println("Digite o ID do pet que deseja atualizar:");
                        int petIdParaAtualizar = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Digite o novo nome do pet:");
                        String novoNomePet = scanner.nextLine();
                        System.out.println("Digite a nova especie do pet:");
                        String novaEspeciePet = scanner.nextLine();
                        System.out.println("Digite a nova raça do pet:");
                        String novaRacaPet = scanner.nextLine();
                        System.out.println("Digite a nova idade do pet:");
                        String novaIdadePet = scanner.nextLine();

                        Pet petAtualizado = new Pet();
                        petAtualizado.setId(petIdParaAtualizar);
                        petAtualizado.setNome(novoNomePet);
                        petAtualizado.setEspecie(novaEspeciePet);
                        petAtualizado.setRaca(novaRacaPet);
                        petAtualizado.setIdade(novaIdadePet);

                        PetController.updateData(conn, petIdParaAtualizar, petAtualizado);
                        System.out.println("Pet atualizado com sucesso.");
                        break;

                    case 8:
                        // Excluir um pet
                        System.out.println("Digite o ID do pet que deseja excluir:");
                        int petIdParaExcluir = scanner.nextInt();
                        scanner.nextLine();
                    
                        PetController.deleteData(conn, petIdParaExcluir);
                        System.out.println("Pet excluído com sucesso.");

                    case 9:
                        // Adicionar um novo veterinário
                        System.out.println("Digite o nome do veterinário:");
                        String nomeVeterinario = scanner.nextLine();
                        System.out.println("Digite a especialidade do veterinário:");
                        String especialidadeVeterinario = scanner.nextLine();
                        System.out.println("Digite o telefone do veterinário:");
                        String telefoneVeterinario = scanner.nextLine();

                        Veterinario novoVeterinario = new Veterinario(nomeVeterinario, especialidadeVeterinario, telefoneVeterinario);

                        VeterinarioController.insertData(conn, novoVeterinario);
                        System.out.println("Veterinário adicionado com sucesso.");
                        break;

                    case 10:
                        // Ler todos os veterinários
                        ArrayList<Veterinario> veterinariosList = VeterinarioController.selectData(conn);
                        
                        System.out.println("Lista de Veterinários:");
                        for (Veterinario vet : veterinariosList) {
                            System.out.println("ID: " + vet.getId());
                            System.out.println("Nome: " + vet.getNome());
                            System.out.println("Especialidade: " + vet.getEspecialidade());
                            System.out.println("Telefone: " + vet.getTelefone());
                        }
                        break;
                    case 11:
                        // Atualizar informações de um veterinário
                        System.out.println("Digite o ID do veterinário que deseja atualizar:");
                        int veterinarioIdParaAtualizar = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Digite o novo nome do veterinário:");
                        String novoNomeVeterinario = scanner.nextLine();
                        System.out.println("Digite a nova especialidade do veterinário:");
                        String novaEspecialidadeVeterinario = scanner.nextLine();
                        System.out.println("Digite o novo telefone do veterinário:");
                        String novoTelefoneVeterinario = scanner.nextLine();

                        Veterinario veterinarioAtualizado = new Veterinario();
                        veterinarioAtualizado.setId(veterinarioIdParaAtualizar);
                        veterinarioAtualizado.setNome(novoNomeVeterinario);
                        veterinarioAtualizado.setEspecialidade(novaEspecialidadeVeterinario);
                        veterinarioAtualizado.setTelefone(novoTelefoneVeterinario);

                        VeterinarioController.updateData(conn, veterinarioIdParaAtualizar, veterinarioAtualizado);
                        System.out.println("Veterinário atualizado com sucesso.");
                        break;

                    case 12:
                        // Excluir um veterinário
                        System.out.println("Digite o ID do veterinário que deseja excluir:");
                        int veterinarioIdParaExcluir = scanner.nextInt();
                        scanner.nextLine(); 

                        VeterinarioController.deleteData(conn, veterinarioIdParaExcluir);
                        System.out.println("Veterinário excluído com sucesso.");
                        break;

                    case 13:
                        // Adicionar uma nova consulta
                        System.out.println("Digite a data e hora da consulta (no formato 'yyyy-MM-dd HH:mm:ss'):");
                        String dataHoraConsulta = scanner.nextLine();
                        System.out.println("Digite o nome do veterinário para a consulta:");
                        String NomeVeterinario = scanner.nextLine();
                        scanner.nextLine();
                        System.out.println("Digite o nome do pet para a consulta:");
                        String NomePet = scanner.nextLine();
                        scanner.nextLine(); 
                        System.out.println("Digite notas para a consulta:");
                        String notasConsulta = scanner.nextLine();

                        Consulta novaConsulta = new Consulta();
                        novaConsulta.setDataHora(dataHoraConsulta);
                        novaConsulta.setNomeVeterinario(NomeVeterinario);
                        novaConsulta.setNomePet(NomePet);
                        novaConsulta.setNotas(notasConsulta);

                        ConsultaController.insertData(conn, novaConsulta);
                        System.out.println("Consulta agendada com sucesso.");
                        break;

                    case 14:
                        // Ler todas as consultas
                        ArrayList<Consulta> consultasList = ConsultaController.selectData(conn);

                        System.out.println("Lista de Consultas:");
                        for (Consulta consulta : consultasList) {
                            System.out.println("ID: " + consulta.getId());
                            System.out.println("Data e Hora: " + consulta.getDataHora());
                            System.out.println("Nome do Veterinário: " + consulta.getNomeVeterinario());
                            System.out.println("Nome do Pet: " + consulta.getNomePet());
                            System.out.println("Notas: " + consulta.getNotas());
                        }
                        break;

                    case 15:
                        // Atualizar a consulta
                        System.out.println("Digite o ID da consulta que deseja atualizar:");
                        int consultaIdParaAtualizar = scanner.nextInt();
                        scanner.nextLine(); 

                        System.out.println("Digite a nova data e hora da consulta (no formato 'yyyy-MM-dd HH:mm:ss'):");
                        String novaDataHoraConsulta = scanner.nextLine();
                        System.out.println("Digite o novo nome do veterinário para a consulta:");
                        String novoNomeVeterinarioConsulta = scanner.nextLine();
                        scanner.nextLine(); 
                        System.out.println("Digite o novo nome do pet para a consulta:");
                        String novoNomePetConsulta = scanner.nextLine();
                        scanner.nextLine(); 
                        System.out.println("Digite as novas notas para a consulta:");
                        String novasNotasConsulta = scanner.nextLine();

                        Consulta consultaAtualizada = new Consulta();
                        consultaAtualizada.setId(consultaIdParaAtualizar);
                        consultaAtualizada.setDataHora(novaDataHoraConsulta);
                        consultaAtualizada.setNomeVeterinario(novoNomeVeterinarioConsulta);
                        consultaAtualizada.setNomePet(novoNomePetConsulta);
                        consultaAtualizada.setNotas(novasNotasConsulta);

                        ConsultaController.updateData(conn, consultaAtualizada);
                        System.out.println("Consulta atualizada com sucesso.");
                        break;

                    case 16:
                        // Excluir a consulta
                        System.out.println("Digite o ID da consulta que deseja excluir:");
                        int consultaIdParaExcluir = scanner.nextInt();
                        scanner.nextLine();

                        ConsultaController.deleteData(conn, consultaIdParaExcluir);
                        System.out.println("Consulta excluída com sucesso.");
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
