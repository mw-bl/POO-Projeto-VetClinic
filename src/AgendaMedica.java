import java.sql.Connection;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Scanner;

import controller.TutorController;
import controller.ConsultaController;
import controller.PetController;
import controller.VeterinarioController;

import models.Tutor;
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

        // Exibir lista de tutores
        System.out.println("\nLista de Tutores:");
        ArrayList<Tutor> tutores = TutorController.selectData(conn);
        for (Tutor tutor : tutores) {
            System.out.println(tutor.getId() + ". " + tutor.getNome());
        }

        // Selecionar tutor
        System.out.print("Selecione o ID do Tutor: ");
        int tutorId = scanner.nextInt();

        // Exibir lista de pets do tutor selecionado
        Tutor tutor = TutorController.getTutorById(conn, tutorId);

        System.out.println("\nLista de Pets do Tutor:");
        ArrayList<Pet> petsDoTutor = PetController.selectPetsByTutor(conn, tutor);
        for (Pet pet : petsDoTutor) {
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
        consulta.setVeterinarioId(VeterinarioController.getVeterinarioById(conn, veterinarioId).getId());
        consulta.setPetId(PetController.getPetById(conn, petId).getId());
        consulta.setDataHora(dataHora);
        consulta.setNotas(notas);


        // Agendar consulta
        ConsultaController.insertData(conn, consulta);
    }

}
