import java.sql.Connection;
import java.sql.SQLException;

import controller.ClienteController;
import controller.ConsultaController;
import controller.PetController;
import controller.VeterinarioController;

import db.Conexao;

import models.Cliente;
import models.Consulta;
import models.Pet;
import models.Veterinario;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = Conexao.getConexaoMySQL()) {
 
            // Cadastrar um cliente
            Cliente cliente = new Cliente();
            cliente.setNome("João da Silva");
            cliente.setTelefone("123456789");
            ClienteController.insertData(conn, cliente);

            // Cadastrar um pet associado ao cliente
            Pet pet = new Pet();
            pet.setNome("Rex");
            pet.setEspecie("Cachorro");
            pet.setRaca("Labrador");
            pet.setIdade(3);
            pet.setTutor(cliente);
            PetController.insertData(conn, pet);

            // Cadastrar um veterinário (se já não estiver inserido nos dados iniciais)
            Veterinario veterinario = new Veterinario();
            veterinario.setNome("Dr. Ana Souza");
            veterinario.setEspecialidade("Clínico Geral");
            veterinario.setTelefone("987654321");
            VeterinarioController.insertData(conn, veterinario);

            // Agendar uma consulta
            String dataHoraConsulta = "2024-03-15 10:30:00";
            Consulta consulta = new Consulta(dataHoraConsulta, veterinario, pet, "Acompanhamento pós-cirúrgico");
            ConsultaController.insertData(conn, consulta);

            // Listar todas as consultas
            AgendaMedica.listarConsultas(conn);

            // Consultar consultas por cliente
            AgendaMedica.consultarConsultasPorCliente(conn);

        } catch (SQLException s) {
            s.printStackTrace();
        }
    }
}