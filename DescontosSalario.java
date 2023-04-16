import java.util.Scanner;

public class DescontosSalario {
   public static void main(String[] args) {
      
      Scanner scanner = new Scanner(System.in);
      
      System.out.print("Informe o valor do salário bruto: ");
      double salarioBruto = scanner.nextDouble();
      
      double inss = calcularINSS(salarioBruto);
      double fgts = calcularFGTS(salarioBruto);
      double irrf = calcularIRRF(salarioBruto);
      
      double salarioLiquido = salarioBruto - inss - irrf;
      
      System.out.println("O valor do salário bruto é: R$" + salarioBruto);
      System.out.println("O valor do desconto de INSS é: R$" + inss);
      System.out.println("O valor do desconto de FGTS é: R$" + fgts);
      System.out.println("O valor do desconto de IRRF é: R$" + irrf);
      System.out.println("O valor do salário líquido é: R$" + salarioLiquido);
      
      scanner.close();
   }
   
   public static double calcularINSS(double salarioBruto) {
      double inss = 0.0;
      
      if (salarioBruto <= 1100.0) {
         inss = 0.075 * salarioBruto;
      } else if (salarioBruto <= 2203.48) {
         inss = 0.09 * salarioBruto;
      } else if (salarioBruto <= 3305.22) {
         inss = 0.12 * salarioBruto;
      } else if (salarioBruto <= 6433.57) {
         inss = 0.14 * salarioBruto;
      } else {
         inss = 751.99;
      }
      
      return inss;
   }
   
   public static double calcularFGTS(double salarioBruto) {
      return 0.08 * salarioBruto;
   }
   
   public static double calcularIRRF(double salarioBruto) {
      double irrf = 0.0;
      
      double baseCalculo = salarioBruto - calcularINSS(salarioBruto);
      
      if (baseCalculo <= 1903.98) {
         irrf = 0.0;
      } else if (baseCalculo <= 2826.65) {
         irrf = 0.075 * baseCalculo - 142.80;
      } else if (baseCalculo <= 3751.05) {
         irrf = 0.15 * baseCalculo - 354.80;
      } else if (baseCalculo <= 4664.68) {
         irrf = 0.225 * baseCalculo - 636.13;
      } else {
         irrf = 0.275 * baseCalculo - 869.36;
      }
      
      return irrf;
   }
}
