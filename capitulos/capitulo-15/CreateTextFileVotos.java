import java.io.FileNotFoundException;
import java.nio.charset.Charset;
import java.util.Formatter;
import java.util.FormatterClosedException;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTextFileVotos{

    
    private static Formatter output;

    public static void main(String[] args) {
        //Locale.setDefault(Locale.US);   
    	System.out.println(Charset.defaultCharset().displayName());
        openFile();
        addRecords(); 
        closeFile();
    }

    public static void openFile(){
        try{
            output = new Formatter("votos.txt");
        }
        catch(SecurityException ex){
            System.err.println("Write permission denied. Terminating.");
            System.exit(1);
        }
        catch(FileNotFoundException ex){
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        } 
    }

    public static void addRecords(){
        Scanner input = new Scanner(System.in);
        System.out.print("continuar sim = [s] ou n�o = [n]: ");
        char choice = input.next().toLowerCase().charAt(0);      
        input.nextLine();
        while(choice == 's'){
            try{ 
                output.format("%s %d %n", 
                    input.nextLine(),  
                    input.nextInt()
                );       
                input.nextLine();                                         
            }
            catch(FormatterClosedException ex){
                System.err.println("Error writing to file. Terminating");
                break;
            }
            catch(NoSuchElementException ex){
                System.err.println("Invalid input. Please try again.");    
                input.nextLine();            
            }
            catch(Exception ex){
                System.err.println("Error. Try again");  
                input.nextLine();              
            }
            
            System.out.print("continuar sim = [s] ou n�o = [n]: ");
            choice = input.next().toLowerCase().charAt(0);
            input.nextLine();
            
        }
        input.close();
    }

    public static void closeFile(){
        if(output != null)
            output.close();
    }
}