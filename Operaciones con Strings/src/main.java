import java.util.Scanner;

public class main {
 public static void main(String[] args) {
  Scanner op = new Scanner(System.in);
  int option;
  System.out.println("OPERACIONES CON STRINGS");
  System.out.println("  1.     Tamaño de cadena ingresada");
  System.out.println("  2.     Subcadena");
  System.out.println("  3.     Comparacion de Palabras");
  System.out.println("  4.     Comparacion de Tamaño");
  System.out.println("  5.     Salir");
  System.out.println("Seleccione una de las opciones  descritas");
  option = op.nextInt();

  switch (option) {
   case 1:
    System.out.println("TAMAÑO DE CADENA INGRESADA");
    System.out.println("ingrese una cadena de texto para conocer su tamaño");
    String text;
    Scanner letter = new Scanner(System.in);
    text = letter.nextLine();
    int letters;
    letters = text.length();
    System.out.println("El texto ingresado tiene un tamaño de: " + letters + "  caracteres.");
    break;
   case 2:
    System.out.println("SUBCADENA");
    System.out.println("Ingrese una cadena de texto");
    Scanner text2 = new Scanner(System.in);
    String words;
    words = text2.nextLine();
    int letters2;
    letters2 = words.length();
    System.out.println("ingrese el tamaño de la Subcadena que desea que se le muestre:");
    int numbers;
    Scanner number = new Scanner(System.in);
    numbers = number.nextInt();
    if (letters2 > numbers) {
     String subs;
     subs = words.substring(0, numbers);
     System.out.println("la subcadena resultante es:");
     System.out.println("  " + subs + "  ");
    } else {
     System.out.println("la subcadena solicitada es mayor a la cadena inicial");
    }
    break;
   case 3:
    System.out.println("COMPARACION DE PALABRAS:");
    System.out.println("Ingrese la primera palabra a comparar");
    Scanner w1 = new Scanner(System.in);
    String word1;
    word1 = w1.nextLine();
    System.out.println("Ingrese la segunda palabra a comparar");
    Scanner w2 = new Scanner(System.in);
    String word2;
    word2 = w2.nextLine();
    System.out.println("Desea Ignorar las mayusculas");
    System.out.println("1.     Si");
    System.out.println("2.     No");
    int comp;
    Scanner c_op = new Scanner(System.in);
    comp = c_op.nextInt();
   if (comp==1) {
    word1 = word1.toLowerCase();
    word2 = word2.toLowerCase();
    if (word1 == word2) {
     System.out.println("las palabras ingresadas son iguales");
    } else {
     System.out.println("las palabras ingresadas son son iguales");
    }
   }
    if (comp == 2) {
     if (word1 == word2) {
      System.out.println("las palabras ingresadas son iguales");
     } else {
      System.out.println("Las palabras ingresadas no son iguales");
     }
    }
    break;
    case 4:
     System.out.println("COMPARACION DE TAMAÑOS DE TEXTOS");
     System.out.println("Ingrese el primer texto a comparar su tamaño");
     Scanner t1 = new Scanner(System.in);
     String text1;
     text1 = t1.nextLine();
     System.out.println("Ingrese la segunda palabra a comparar");
     Scanner t2 = new Scanner(System.in);
     String text3;
     text3 = t2.nextLine();
     System.out.println("Desea Ignorar los espacios");
     System.out.println("1.     Si");
     System.out.println("2.     No");
     int comp_l;
     Scanner l_op = new Scanner(System.in);
     comp_l = l_op.nextInt();
     switch (comp_l) {
      case 1:
       text1 = text1.replaceAll("\\s", "");
       text3 = text3.replaceAll("\\s", "");
       int text1_l, text3_l;
       text1_l = text1.length();
       text3_l = text3.length();
       if (text1_l == text3_l) {
        System.out.println("los textos igresados son iguales.");
       } else {
        System.out.println("las palabras ingresadas no son iguales porque:");
        System.out.println("El primer texto ingresado tiene:   " + text1_l + " caracteres.");
        System.out.println("El segundo texto ingresado tiene:   " + text3_l + " caracteres.");
       }
       break;
      case 2:
       int text1_l2, text3_l2;
       text1_l2 = text1.length();
       text3_l2 = text3.length();
       if (text1_l2 == text3_l2) {
        System.out.println("los textos ingresados son iguales");
       } else {
        System.out.println("Los textos ingresados no son iguales porque:");
        System.out.println("El primer texto ingresado tiene:   " + text1_l2 + " caracteres.");
        System.out.println("El segundo texto ingresado tiene:   " + text3_l2 + " caracteres.");
       }
       break;
      case 5:
       System.out.println("Saliendo del programa");
       break;
      default:
       System.out.println("la opcion ingresada no es valida");
break;

     }
   }
  }
 }
