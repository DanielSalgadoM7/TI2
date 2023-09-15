//Daniel Salgado Magalhães -821429

public class Principal {
    public static void main(String[] args) {

        UsuarioDAO dao = new UsuarioDAO();
        dao.conectar();

        //Colocar os elementos na tabela      
        Usuario usuario = new Usuario (11, "daniel","daniel",'M');
        if(dao.inserirUsuario(usuario)==true) {
            System.out.println("Inserção com sucesso ->" + usuario.toString());
        }

        //Mostrar usuários do sexo masculino
        System.out.println("==== Mostrar usuários do sexo masculino === ");
        Usuario[] usuarios = dao.getUsuariosMasculinos();
        for(int i=0;i<usuarios.length;i++) {
            System.out.println(usuarios[i].toString());
        }

        // Atualizar usuario
        usuario.setSenha("Nova senha");
        dao.atualizarUsuario(usuario);

        //Mostrar usuários do sexo masculino
        System.out.println("==== Mostrar usuários do sexo masculino === ");
        usuarios = dao.getUsuarios();
        for(int i=0;i<usuarios.length;i++) {
            System.out.println(usuarios[i].toString());
        }

        //Excluir usuário
        dao.excluirUsuario(usuario.getCodigo());

        //Mostrar usuário
        usuarios = dao.getUsuarios();
        System.out.println("Mostrar usuários: ");
        for(int i = 0;i < usuarios.length;i++) {
            System.out.println(usuarios [ i ].toString());
        }

        dao.close();
    }
}
