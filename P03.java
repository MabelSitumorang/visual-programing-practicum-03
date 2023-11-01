// 12S23011 - Mabel Christoffel A.S

import java.util.*;
import java.lang.Math;

public class P03 {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String[] tugas = new String[10], keterangan = new String[10];
        String[] nIM = new String[10];
        String[] matkul = new String[10];
        String[] dosen = new String[10];
        String[] waktu = new String[10];
        String[] identitas = new String[10];
        double[] kesulitan = new double[10];
        double[] deadline = new double[10];
        String[] status = new String[10];
        double[] prioritas = new double[10], prioritaslagi = new double[10];
        int i, j;
        int jumlah;
        int[] ordertask = new int[10];

        for (i = 0; i <= 9; i++) {
            tugas[i] = input.nextLine();
            if (!tugas[i].equals("---")) {
                nIM[i] = input.nextLine();
                matkul[i] = input.nextLine();
                dosen[i] = input.nextLine();
                waktu[i] = input.nextLine();
                identitas[i] = input.nextLine();
                kesulitan[i] = Double.parseDouble(input.nextLine());
                deadline[i] = Double.parseDouble(input.nextLine());
                status[i] = input.nextLine();
                prioritas[i] = kesulitan[i] * (1 / deadline[i]);
                if (prioritas[i] > 3) {
                    keterangan[i] = "Penting! Anda harus mengerjakan tugas ini segera.";
                } else {
                    if (prioritas[i] <= 3 && prioritas[i] >= 1.5) {
                        keterangan[i] = "Tugas ini memiliki prioritas menengah.";
                    } else {
                        if (prioritas[i] < 1.5) {
                            keterangan[i] = "Tugas ini relatif ringan, namun jangan tunda terlalu lama.";
                        }
                    }
                }
                prioritaslagi[i] = prioritas[i];
                jumlah = i;
                ordertask[i] = i;
            } else {
                i = 10;
            }
        }
        for (i = 0; i <= jumlah - 2; i++) {
            for (j = 0; j <= jumlah - i - 2; j++) {
                if (prioritaslagi[j] > prioritaslagi[j + 1]) {
                    int temp;

                    temp = prioritaslagi[j];
                    prioritaslagi[j] = prioritaslagi[j + 1];
                    prioritaslagi[j + 1] = temp;
                    temp = ordertask[i];
                    ordertask[j] = ordertask[j + 1];
                    ordertask[j + 1] = temp;
                }
            }
        }
        for (i = jumlah; i >= 0; i--) {
            System.out.println("Prioritas: " + toFixed(prioritas[ordertask[i]],2));
            System.out.println(tugas[i] + "|" + nIM[i] + "|" + matkul[i] + "|" + dosen[i] + "|" + waktu[i] + "|" + identitas[i] + "|" + status[i] + "|" + keterangan[i]);
        }
    }
    
    private static String toFixed(double value, int digits) {
        return String.format("%." + digits + "f", value);
    }
}

