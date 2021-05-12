import java.util.Scanner;

public class Zoombies {
    public static void main(String[] args) {
        Scanner sumaarrays = new Scanner(System.in);
        int num1,num2,num3;
        System.out.print("Posa la allargada del priemr array: ");
        num1 = sumaarrays.nextInt();


        //creem la primera array que tindra el valor de la allargada
        int array1[] = new int[num1];
        //Fem un recorregut de la array per agafar els numeros que tindra adins
        for(int i=0; i<array1.length; i++){
            System.out.print("Introdueix els " +num1 +" numeros de la primera array");
            array1[i]=sumaarrays.nextInt();
        }
        //Hi ara fem el matiex per la segona array
        System.out.print("Ara introdueix la allargada de la segona array: ");
        num2 = sumaarrays.nextInt();
        int array2[] = new int[num2];
        for(int j=0; j<array2.length; j++){
            System.out.print("Introdueix els " +num2 +" numeros de la primera array");
            array2[j]=sumaarrays.nextInt();
        }
        //Ara fem que el num3 agafi la allargada de la primera array
        num3=num1;
        //Aqui diguem que si es mes garn la allargada del numero 2 agafi la allargada de la segona array
        if (num2 > num1)
            num3=num2;
        //Aqui fem la arraytotal que tindra la allargada mes gand de la array 1 o la 2
        int[] arraytotal = new int[num3];
        //Fem el recoregut del arraytotal per fer la operacio següent
        for(int n=0; n<arraytotal.length; n++){
            //Aqui el que fem es dir que si el array1 es mes grand que n gardi el valor de la n que sera el numero que hem introduït de l'array1
            int valorarray1 = 0;
            if (array1.length > n){
                valorarray1 = array1[n];
            }
            int valorarray2 = 0;
            //Aqui fem el mateix que el array1 pero amb el array2
            if (array2.length > n){
                valorarray2 = array2[n];
            }
            //i aqui fem la operacio de la suma dels valors de l'array 1 i 2
            arraytotal[n]=valorarray1+valorarray2;
            System.out.println("La suma de la posicio"+" "+n+" de la tercera array"+ " es: "+arraytotal[n]);
            sumaarrays.close();
        }

    }
}
