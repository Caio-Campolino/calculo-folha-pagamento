import java.util.Scanner;

public class SalarioPorHora {
   public static void main(String[] args) {
      
      Scanner scanner = new Scanner(System.in);
      
      System.out.print("Informe o valor do salário bruto: ");
      double salarioBruto = scanner.nextDouble();
      
      System.out.print("Informe o número de horas trabalhadas no mês: ");
      int horasTrabalhadas = scanner.nextInt();
      
      double salarioPorHora = salarioBruto / horasTrabalhadas;
      
      System.out.println("O valor do salário por hora é: R$" + salarioPorHora);
      
      scanner.close();
   }
}
