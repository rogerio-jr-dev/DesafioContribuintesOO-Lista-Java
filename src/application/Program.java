package application;

import entities.TaxPayer;

import java.util.Locale;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        List<TaxPayer> list = new ArrayList<>();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Quantos contribuintes você vai digitar? ");
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                System.out.printf("Digite os dados do %do contribuinte:", i + 1);
                System.out.print("Renda anual com salário: ");
                double salaryYear = sc.nextDouble();
                System.out.print("Renda anual com prestação de serviço: ");
                double serviceYear = sc.nextDouble();
                System.out.print("Renda anual com ganho de capital: ");
                double capitalYear = sc.nextDouble();
                System.out.print("Gastos médicos: ");
                double medicalYear = sc.nextDouble();
                System.out.print("Gastos educacionais: ");
                double educationYear = sc.nextDouble();
                list.add(new TaxPayer(salaryYear, serviceYear, capitalYear, medicalYear, educationYear));
                System.out.println();
            }
            for (int j = 0; j < n; j++) {
                System.out.printf("Resumo do %do contribuinte: \n", j + 1);
                System.out.printf("Imposto bruto total: %.2f\n", list.get(j).grossTax());
                System.out.printf("Abatimento: %.2f\n", list.get(j).taxRebate());
                System.out.printf("Imposto devido:  %.2f\n", list.get(j).netTax());
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("An error occured: " + e.getMessage());
        }

    }
}
