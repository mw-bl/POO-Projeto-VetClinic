import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.TutorController;
import controller.ConsultaController;
import controller.PetController;
import controller.VeterinarioController;

import db.Conexao;

import models.Tutor;
import models.Consulta;
import models.Pet;
import models.Veterinario;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = Conexao.getConexaoMySQL()) {
 
            // Cadastrar um tutor
            Tutor tutor = new Tutor();
            tutor.setNome("Marcos");
            tutor.setTelefone("12345678");
            tutor.setEmail("marcos.willian09@aluno.ifce.edu.br");
            tutor.setDataNascimento("2003-06-29");
            TutorController.insertData(conn, tutor);

            // Cadastrar um pet associado ao tutor
            Pet pet = new Pet();
            pet.setNome("Rex");
            pet.setEspecie("Cachorro");
            pet.setRaca("Labrador");
            pet.setIdade(3);

            Tutor tutorExistente = new Tutor();
            tutorExistente.setId(1);
            pet.setTutor(tutorExistente);
            PetController.insertData(conn, pet);

            // Cadastrar um veterinário
            Veterinario veterinario = new Veterinario();
            veterinario.setNome("Dr. Ana Souza");
            veterinario.setEspecialidade("Clínico Geral");
            veterinario.setTelefone("987654321");
            VeterinarioController.insertData(conn, veterinario);
            int petId = 1;  // Substitua pelo ID do pet desejado
            int veterinarioId = 1;  // Substitua pelo ID do veterinário desejado
            
            // Agendar uma consulta
            String dataHora = "2024-03-15 10:30:00";
            Consulta consulta = new Consulta(dataHora, veterinarioId, petId, "Acompanhamento pós-cirúrgico");
            ConsultaController.insertData(conn, consulta);
            
            // Atualizar um tutor
            int tutorId = 1;  // Substitua pelo ID do tutor desejado
            Tutor tutorParaAtualizar = TutorController.getTutorById(conn, tutorId);

            // Verificando se o tutor foi encontrado
            if (tutorParaAtualizar != null) {
                // Atualizando os dados do tutor
                tutorParaAtualizar.setNome("Jessica");
                tutorParaAtualizar.setTelefone("8899236-4893");
                tutorParaAtualizar.setEmail("jessica.email@example.com");
                tutorParaAtualizar.setDataNascimento("2000-01-01");

                // Chamando o método de atualização
                TutorController.updateData(conn, tutorId, tutorParaAtualizar);
                System.out.println("Tutor atualizado com sucesso.");
            } else {
                System.out.println("Tutor não encontrado.");
            }


            int petId = 1;  // Substitua pelo ID do pet desejado
            Pet petParaAtualizar = PetController.getPetById(conn, petId);

            // Verificando se o pet foi encontrado
            if (petParaAtualizar != null) {
                // Atualizando os dados do pet
                petParaAtualizar.setNome("Lola");
                petParaAtualizar.setEspecie("Passaro");
                petParaAtualizar.setRaca("Calopsita");
                petParaAtualizar.setIdade(4);

                // Chamando o método de atualização
                PetController.updateData(conn, petId, petParaAtualizar);
                System.out.println("Pet atualizado com sucesso.");
            } else {
                System.out.println("Pet não encontrado.");
            }

            int veterinarioId = 1;  // Substitua pelo ID do veterinário desejado
            Veterinario veterinarioParaAtualizar = VeterinarioController.getVeterinarioById(conn, veterinarioId);
        
            // Verificando se o veterinário foi encontrado
            if (veterinarioParaAtualizar != null) {
                // Atualizando os dados do veterinário
                veterinarioParaAtualizar.setNome("Dr. Mateus Silva");
                veterinarioParaAtualizar.setEspecialidade("Clinico Geral");
                veterinarioParaAtualizar.setTelefone("8899675-4892");
        
                // Chamando o método de atualização
                VeterinarioController.updateData(conn, veterinarioId, veterinarioParaAtualizar);
                System.out.println("Veterinário atualizado com sucesso.");
            } else {
                System.out.println("Veterinário não encontrado.");
            }

            int tutorId = 1;  // Substitua pelo ID do tutor desejado
            ArrayList<Consulta> consultasDoTutor = ConsultaController.readConsultasByTutor(conn, tutorId);

            // Verificando se há consultas para o tutor
            if (!consultasDoTutor.isEmpty()) {
                // Escolhendo uma consulta para atualizar (suponha que a primeira seja escolhida)
                Consulta consultaParaAtualizar = consultasDoTutor.get(0);

                // Atualizando os dados da consulta
                consultaParaAtualizar.setDataHora("2024-03-15 12:00:00");
                consultaParaAtualizar.setNotas("Retorno");

                // Chamando o método de atualização
                ConsultaController.updateData(conn, consultaParaAtualizar);
                System.out.println("Consulta atualizada com sucesso.");
            } else {
                System.out.println("Nenhuma consulta encontrada para este tutor.");
            }

        } catch (SQLException s) {
            s.printStackTrace();
        }
    }
}