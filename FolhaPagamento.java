import java.util.Scanner;

public class FolhaPagamento {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Informações do funcionário
        System.out.print("Informe o nome do funcionário: ");
        String nomeFuncionario = sc.nextLine();
        
        System.out.print("Informe o número de horas trabalhadas: ");
        int horasTrabalhadas = sc.nextInt();
        
        System.out.print("Informe o valor da hora trabalhada: ");
        double valorHora = sc.nextDouble();
        
        // Cálculo do salário bruto
        double salarioBruto = calcularSalarioBruto(horasTrabalhadas, valorHora);
        System.out.println("Salário bruto: R$" + salarioBruto);
        
        // Cálculo dos adicionais de periculosidade e insalubridade
        boolean temPericulosidade = verificarAdicional("periculosidade", sc);
        double adicionalPericulosidade = calcularAdicional(temPericulosidade, salarioBruto, 0.3);
        System.out.println("Adicional de periculosidade: R$" + adicionalPericulosidade);
        
        boolean temInsalubridade = verificarAdicional("insalubridade", sc);
        double adicionalInsalubridade = calcularAdicional(temInsalubridade, salarioBruto, 0.1);
        System.out.println("Adicional de insalubridade: R$" + adicionalInsalubridade);
        
        // Cálculo dos benefícios
        System.out.print("Informe o valor do vale transporte: ");
        double valeTransporte = sc.nextDouble();
        
        System.out.print("Informe o valor do vale alimentação: ");
        double valeAlimentacao = sc.nextDouble();
        
        // Cálculo dos descontos
        double inss = calcularINSS(salarioBruto);
        System.out.println("Desconto de INSS: R$" + inss);
        
        double fgts = calcularFGTS(salarioBruto);
        System.out.println("Desconto de FGTS: R$" + fgts);
        
        double irrf = calcularIRRF(salarioBruto, inss);
        System.out.println("Desconto de IRRF: R$" + irrf);
        
        // Cálculo do salário líquido
        double salarioLiquido = salarioBruto + adicionalPericulosidade + adicionalInsalubridade
                                + valeTransporte + valeAlimentacao - inss - irrf - fgts;
        System.out.println("Salário líquido: R$" + salarioLiquido);
        
        sc.close();
    }
    
    public static double calcularSalarioBruto(int horasTrabalhadas, double valorHora) {
        return horasTrabalhadas * valorHora;
    }
    
    public static boolean verificarAdicional(String tipoAdicional, Scanner sc) {
        System.out.print("O funcionário tem adicional de " + tipoAdicional + "? (S/N) ");
        String resposta = sc.next().toUpperCase();
        return resposta.equals("S");
    }
    
    public static double calcularAdicional(boolean temAdicional, double salarioBruto, double percentual) {
        if (temAdicional) {
            return salarioBruto * percentual;
        } else {
            return 0.0;
        }
    }
}