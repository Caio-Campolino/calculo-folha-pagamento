import java.util.Scanner;

public class SalarioLiquido {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Informações do funcionário
        System.out.print("Informe o salário bruto: ");
        double salarioBruto = sc.nextDouble();
        
        System.out.print("Informe o valor do vale transporte: ");
        double valeTransporte = sc.nextDouble();
        
        System.out.print("Informe o valor do vale alimentação: ");
        double valeAlimentacao = sc.nextDouble();
        
        // Cálculo dos descontos
        double inss = calcularINSS(salarioBruto);
        double fgts = calcularFGTS(salarioBruto);
        double irrf = calcularIRRF(salarioBruto, inss);
        
        // Cálculo do salário líquido
        double salarioLiquido = salarioBruto + valeAlimentacao + valeTransporte - inss - irrf - fgts;
        
        System.out.println("O salário líquido é: R$" + salarioLiquido);
        
        sc.close();
    }
    
    public static double calcularINSS(double salarioBruto) {
        double inss = 0.0;
        if (salarioBruto <= 1100.0) {
            inss = salarioBruto * 0.075;
        } else if (salarioBruto <= 2203.48) {
            inss = salarioBruto * 0.09;
        } else if (salarioBruto <= 3305.22) {
            inss = salarioBruto * 0.12;
        } else if (salarioBruto <= 6433.57) {
            inss = salarioBruto * 0.14;
        } else {
            inss = 751.99;
        }
        return inss;
    }
    
    public static double calcularFGTS(double salarioBruto) {
        return salarioBruto * 0.08;
    }
    
    public static double calcularIRRF(double salarioBruto, double inss) {
        double baseCalculo = salarioBruto - inss;
        double irrf = 0.0;
        if (baseCalculo <= 1903.98) {
            irrf = 0.0;
        } else if (baseCalculo <= 2826.65) {
            irrf = baseCalculo * 0.075 - 142.80;
        } else if (baseCalculo <= 3751.05) {
            irrf = baseCalculo * 0.15 - 354.80;
        } else if (baseCalculo <= 4664.68) {
            irrf = baseCalculo * 0.225 - 636.13;
        } else {
            irrf = baseCalculo * 0.275 - 869.36;
        }
        return irrf;
    }
}
