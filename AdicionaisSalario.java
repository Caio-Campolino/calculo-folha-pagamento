import java.util.Scanner;

public class AdicionaisSalario {
   public static void main(String[] args) {
      
      Scanner scanner = new Scanner(System.in);
      
      System.out.print("Informe o valor do salário base: ");
      double salarioBase = scanner.nextDouble();
      
      System.out.print("O funcionário recebe adicional de periculosidade? (S/N): ");
      String opcaoPericulosidade = scanner.next();
      
      System.out.print("O funcionário recebe adicional de insalubridade? (S/N): ");
      String opcaoInsalubridade = scanner.next();
      
      double adicionalPericulosidade = 0;
      if (opcaoPericulosidade.equalsIgnoreCase("S")) {
         adicionalPericulosidade = salarioBase * 0.3; // 30% do salário base
      }
      
      double adicionalInsalubridade = 0;
      if (opcaoInsalubridade.equalsIgnoreCase("S")) {
         adicionalInsalubridade = salarioBase * 0.2; // 20% do salário base
      }
      
      double salarioTotal = salarioBase + adicionalPericulosidade + adicionalInsalubridade;
      
      System.out.println("O valor do salário base é: R$" + salarioBase);
      System.out.println("O valor do adicional de periculosidade é: R$" + adicionalPericulosidade);
      System.out.println("O valor do adicional de insalubridade é: R$" + adicionalInsalubridade);
      System.out.println("O valor do salário total é: R$" + salarioTotal);
      
      scanner.close();
   }
}
