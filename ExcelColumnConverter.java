import java.io.*;
import java.util.*;

public class ExcelColumnConverter {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("entrada.txt"));
        int casos = Integer.parseInt(br.readLine());

        for (int i = 0; i < casos; i++) {
            String coluna = br.readLine();
            int valor = xls2Dec(coluna);
            System.out.println(coluna + "=" + valor);
        }
    }

    public static int xls2Dec(String coluna) {
        int total = 0;
        for (int i = 0; i < coluna.length(); i++) {
            char letra = coluna.charAt(i);
            total = total * 26 + (letra - 'A' + 1);
        }
        return total;
    }
}
