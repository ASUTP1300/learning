package yndx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OSystem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        br.readLine();

        Writer writer = new FileWriter("output.txt");

        List<OS> osList = new ArrayList<>();
        List<OS> removeOs = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        int i = 0;
        String[] nums;
        while (i < n) {
            nums = br.readLine().split(" ");
            OS os = new OS(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));

            removeOs = osList.stream().filter(os2 -> (os2.x1 <= os.x2 && os2.x2 >= os.x1)).collect(Collectors.toList());
            osList.add(os);
            removeOs.forEach(osList::remove);
            i++;
        }

        writer.write(String.valueOf(osList.size()));
        writer.flush();
        System.out.println(removeOs);
        System.out.println(osList);
    }

    static class OS {
        private int x1;
        private int x2;

        public OS(int x1, int x2) {
            this.x1 = x1;
            this.x2 = x2;
        }
    }
}
