package freelancer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProcessFileIO {


    public static void main(String[] args) throws IOException {

        //reading file name SampleData.txt from current directory
        String userDirectory = new File("").getAbsolutePath()+"\\SampleData.txt";
        Scanner scanner = new Scanner(new File(userDirectory));
        List<List<String>> numericRowsList=new ArrayList<>();
        while (scanner.hasNext())
        {
            String row=scanner.next();
            String[] col=row.split(",");
            List<String> numericValues=new ArrayList<>();
            for (int i=0;i<col.length;i++)
            {
                String colWise=col[i];
                String numericStr="";
                for (int j=0;j<colWise.length();j++)
                {
                    char c=colWise.charAt(j);
                   if(c>=47 && c<=57)
                       numericStr +=c;
                }
                if (!numericStr.isEmpty())
                    numericValues.add(numericStr);
            }
            numericRowsList.add(numericValues);
        }
        //Writing a file
        File fout = new File("OutputReport.txt");
        FileOutputStream fos = new FileOutputStream(fout);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        List<Integer> oddNumeric=new ArrayList<>();
        for (int i = 0; i < numericRowsList.size(); i++) {
            oddNumeric.add(numericRowsList.get(i).stream().map(s -> {
                int n=Integer.parseInt(s);
                if(n%2!=0)
                {
                    return 1;
                }
                return 0;
            }).reduce((integer, integer2) -> integer+integer2).get());
            bw.write(String.join(",", numericRowsList.get(i)));
            bw.newLine();
        }
        System.out.println(oddNumeric);
        bw.close();

    }
}
