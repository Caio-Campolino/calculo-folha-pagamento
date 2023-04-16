import java.util.Scanner;

public class BeneficiosSalario {
   public static void main(String[] args) {
      
      Scanner scanner = new Scanner(System.in);
      
      System.out.print("Informe o valor do salário base: ");
      double salarioBase = scanner.nextDouble();
      
      System.out.print("Informe o número de dias úteis trabalhados no mês: ");
      int diasTrabalhados = scanner.nextInt();
      
      System.out.print("Informe o valor do vale transporte: ");
      double valorValeTransporte = scanner.nextDouble();
      
      System.out.print("Informe o valor do vale alimentação: ");
      double valorValeAlimentacao = scanner.nextDouble();
      
      double descontoValeTransporte = 0.06 * salarioBase * diasTrabalhados; // 6% do salário base multiplicado pelo número de dias úteis trabalhados
      double valorValeAlimentacaoMensal = valorValeAlimentacao * diasTrabalhados; // valor do vale alimentação multiplicado pelo número de dias úteis trabalhados
      
      double salarioTotal = salarioBase - descontoValeTransporte + valorValeAlimentacaoMensal;
      
      System.out.println("O valor do salário base é: R$" + salarioBase);
      System.out.println("O valor do desconto do vale transporte é: R$" + descontoValeTransporte);
      System.out.println("O valor do vale alimentação mensal é: R$" + valorValeAlimentacaoMensal);
      System.out.println("O valor do salário total é: R$" + salarioTotal);
      
      scanner.close();
   }
}
