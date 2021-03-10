import java.util.Random;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        boolean exit = false;
        String awards[] = new String[5];
        awards[0]="Demadalla de Oro";
        awards[1]= "Medalla de Plata";
        awards[2]= "medalla de Bronce";
        awards[3] = "100 dollars";
        awards[4] = "50 dollars";
        System.out.println("JUEGO DE LA RULETA"+"\n"+"Deseas Jugar a la Ruleta");
        System.out.println("1.     Si"+"\n"+"2.     No");
        Scanner option = new Scanner(System.in);
        String op = option.nextLine();
        switch (op){
            case "1":
                System.out.println("Los Premios a Ganar son:"+"\n");
                for ( int i=0;i<5; i++){
                    System.out.println(awards[i]);
                }
                System.out.println("\n"+"Has Ganado:"+"\n");
                System.out.println(awards[new Random().nextInt(awards.length)]);
                break;
            case "2":
                System.out.println("Mas Suete la proxima");
                break;
            default:
                System.out.println("La opcion Ingresada es Invalida.");
                break;
        }
    }
}
