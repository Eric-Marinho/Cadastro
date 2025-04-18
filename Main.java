import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserDAO userDAO = new UserDAO();

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Cadastrar");
            System.out.println("2. Login");
            System.out.println("3. Recuperar senha");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            if (opcao == 1) {
                System.out.print("Nome de usuário: ");
                String username = scanner.nextLine();

                System.out.print("Senha: ");
                String password = scanner.nextLine();

                User user = new User(username, password);
                if (userDAO.cadastrarUsuario(user)) {
                    System.out.println("✅ Cadastro realizado com sucesso!");
                }
            } else if (opcao == 2) {
                System.out.print("Nome de usuário: ");
                String username = scanner.nextLine();

                System.out.print("Senha: ");
                String password = scanner.nextLine();

                if (userDAO.autenticarUsuario(username, password)) {
                    System.out.println("✅ Login bem-sucedido!");
                } else {
                    System.out.println("❌ Nome de usuário ou senha incorretos.");
                }
            } else if (opcao == 3) {
                System.out.print("Nome de usuário: ");
                String username = scanner.nextLine();

                System.out.print("Nova senha: ");
                String novaSenha = scanner.nextLine();

                if (userDAO.redefinirSenha(username, novaSenha)) {
                    System.out.println("🔁 Senha redefinida com sucesso!");
                } else {
                    System.out.println("❌ Usuário não encontrado.");
                }
            } else if (opcao == 0) {
                System.out.println("👋 Encerrando o sistema...");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
