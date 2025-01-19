import java.io.*;

public class ExcelColumnConverter {

    public static void main(String[] args) {
        // Verifica se o arquivo foi informado
        if (args.length < 1) {
            System.out.println("Por favor, forneça o caminho para o arquivo como argumento.");
            return;
        }

        // Pega o caminho do arquivo
        String filePath = args[0];

        try {
            // Lê o arquivo
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line = br.readLine(); // Lê o número de casos
            int numTests = Integer.parseInt(line);

            // Lê cada linha do arquivo e converte
            for (int i = 0; i < numTests; i++) {
                String cell = br.readLine().trim(); // Lê a célula
                int decimal = xls2Dec(cell); // Converte para decimal
                System.out.println(cell + "=" + decimal); // Exibe o resultado
            }

            br.close(); // Fecha o arquivo
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro no formato do arquivo: " + e.getMessage());
        }
    }

    // Função que converte a coluna do Excel para decimal
    public static int xls2Dec(String col) {
        int result = 0;
        for (int i = 0; i < col.length(); i++) {
            // Calcula o valor decimal com base nas letras
            result = result * 26 + (col.charAt(i) - 'A' + 1);
        }
        return result;
    }
}
