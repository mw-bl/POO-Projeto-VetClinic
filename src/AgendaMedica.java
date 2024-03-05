import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.ClienteController;
import controller.ConsultaController;
import controller.PetController;
import controller.VeterinarioController;

import models.Cliente;
import models.Consulta;
import models.Pet;
import models.Veterinario;

public class AgendaMedica {
    public static void agendarConsulta(Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        // Exibir lista de veterinários
        System.out.println("Lista de Veterinários:");
        ArrayList<Veterinario> veterinarios = VeterinarioController.selectData(conn);
        for (Veterinario vet : veterinarios) {
            System.out.println(vet.getId() + ". " + vet.getNome() + " - " + vet.getEspecialidade());
        }

        // Selecionar veterinário
        System.out.print("Selecione o ID do Veterinário: ");
        int veterinarioId = scanner.nextInt();

        // Exibir lista de clientes (tutores)
        System.out.println("\nLista de Clientes:");
        ArrayList<Cliente> clientes = ClienteController.selectData(conn);
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getId() + ". " + cliente.getNome());
        }

        // Selecionar cliente (tutor)
        System.out.print("Selecione o ID do Cliente (Tutor): ");
        int clienteId = scanner.nextInt();

        // Exibir lista de pets do cliente selecionado
        Cliente cliente = ClienteController.getClienteById(conn, clienteId);

        System.out.println("\nLista de Pets do Cliente:");
        ArrayList<Pet> petsDoCliente = PetController.selectPetsByTutor(conn, cliente);
        for (Pet pet : petsDoCliente) {
            System.out.println(pet.getId() + ". " + pet.getNome() + " - " + pet.getEspecie());
        }

        // Selecionar pet
        System.out.print("Selecione o ID do Pet: ");
        int petId = scanner.nextInt();

        // Definir data e hora da consulta
        System.out.print("Digite a data e hora da consulta (formato: yyyy-MM-dd HH:mm:ss): ");
        String dataHora = scanner.next();

        // Inserir notas/médicamentos
        System.out.print("Digite notas ou medicamentos para a consulta: ");
        String notas = scanner.next();

        // Criar instância de Consulta
        Consulta consulta = new Consulta();
        consulta.setVeterinario(VeterinarioController.getVeterinarioById(conn, veterinarioId));
        consulta.setPet(PetController.getPetById(conn, petId));
        consulta.setDataHora(dataHora);
        consulta.setNotas(notas);

        // Agendar consulta
        ConsultaController.insertData(conn, consulta);
    }

    public static void listarConsultas(Connection conn) throws SQLException {
        ArrayList<Consulta> consultas = ConsultaController.selectData(conn);

        System.out.println("\nLista de Consultas:");
        for (Consulta consulta : consultas) {
            System.out.println("ID: " + consulta.getId());
            System.out.println("Data e Hora: " + consulta.getDataHora());
            System.out.println("Veterinário: " + consulta.getVeterinario().getNome());
            System.out.println("Pet: " + consulta.getPet().getNome());
            System.out.println("Notas/Medicamentos: " + consulta.getNotas());
            System.out.println("------------------------------");
        }
    }

    public static void consultarConsultasPorCliente(Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        // Exibir lista de clientes
        System.out.println("\nLista de Clientes:");
        ArrayList<Cliente> clientes = ClienteController.selectData(conn);
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getId() + ". " + cliente.getNome());
        }

        // Selecionar cliente
        System.out.print("Selecione o ID do Cliente para consultar consultas: ");
        int clienteId = scanner.nextInt();

        // Exibir consultas do cliente selecionado
        ArrayList<Consulta> consultasDoCliente = ConsultaController.readConsultasByCliente(conn, clienteId);
        if (!consultasDoCliente.isEmpty()) {
            System.out.println("\nLista de Consultas do Cliente:");
            for (Consulta consulta : consultasDoCliente) {
                System.out.println("Consulta ID: " + consulta.getId());
                System.out.println("Data/Hora: " + consulta.getDataHora());
                System.out.println("Veterinário: " + consulta.getVeterinario().getNome());
                System.out.println("Pet: " + consulta.getPet().getNome());
                System.out.println("Notas: " + consulta.getNotas());
                // Adicione outras informações conforme necessário
                System.out.println("-------------------------");
            }
        } else {
            System.out.println("Nenhuma consulta encontrada para este cliente.");
        }
    }
}
