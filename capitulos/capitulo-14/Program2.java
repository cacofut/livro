import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Program2{

    public static void main(String[] args) {
        
        List<Product> list = new ArrayList<>();

        String path = "in.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            while(line != null){
                String[] fields = line.split(",");
                list.add(new Product(fields[0], Double.parseDouble(fields[1])));                
                line = br.readLine();
            }
            Product x = CalculationService.max(list);
            System.out.println("Max:");
            System.out.println(x);
        }
        catch(IOException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
}