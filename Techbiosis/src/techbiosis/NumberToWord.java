/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techbiosis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;

/**
 *
 * @author nelsonalmeida
 */
public class NumberToWord {
    
    
    private static final String[] specialNames = {
        "",
        " thousand",
        " million",
        " billion"
    };
    
    private static final String[] tensNames = {
        "",
        " ten",
        " twenty",
        " thirty",
        " forty",
        " fifty",
        " sixty",
        " seventy",
        " eighty",
        " ninety"
    };
    
    private static final String[] numNames = {
        "",
        " one",
        " two",
        " three",
        " four",
        " five",
        " six",
        " seven",
        " eight",
        " nine",
        " ten",
        " eleven",
        " twelve",
        " thirteen",
        " fourteen",
        " fifteen",
        " sixteen",
        " seventeen",
        " eighteen",
        " nineteen"
    };
    
    private String convertLessThanOneThousand(int number) {
        String current;
     
        //Se o resto da divisão do numero inserido por 100 for menor que 20 é porque o numero é inferior a 20
        //Logo colocamos o correspondente nome em current e de seguida dividimos o numero por 100
        //Este passo é necessário porque os numeros ate 20 são sempre diferentes de construir
        if (number % 100 < 20){
            current = numNames[number % 100];
            number /= 100;
        }
        //Se não for inferior a 20 encontra-se o resto da divisão por 10 do number para saber o valor das unidades
        //divide-se por 10 para eliminar esta casa
        //volta se a encontrar o resto da divisão por 10 do novo numero para encontrar o correspondente "tensNames"
        //volta-se a dividir por 10 para eliminar esta casa novamente
        else {
            current = numNames[number % 10];
            number /= 10;
            
            current = tensNames[number % 10] + current;
            number /= 10;
        }
        
        //se depois das respetivas divisões o number for igual a zero é porque o valor é inferior a 100
        //Por isso nao acrescenta o "numNames[number] + " hundred"" returnando somente o current
        if (number == 0) return current;
        
        //se nao retorna o numero inferior a 1000 e superior a 100 em texto
        return numNames[number] + " hundred" + current;
    }
    
    
    /**
     * Função principal para converter
     * @param number
     * @return current
     */
    public String convert(int number) {

        //Se o nr for zero retorna logo "zero"
        if (number == 0) { return "zero"; }
        
        String current = "";
        int place = 0;
        
        //Se não for zero obtemos o resto da divisão por 1000
        //porque em ingles os numeros por escrito sao divididos desta forma 
        do {
            int n = number % 1000;
            
            //Se "n" for diferente de zero é porque não é numero certo (1000, 2000....) 
            if (n != 0){
                //Recorremos a "convertLessThanOneThousand()" para descobrir resto do numero a baixo de 1000,2000,...
                String s = convertLessThanOneThousand(n);
                
                //na primeira passagem o place corresponde a "" na segunda ja vai corresponder a "thousand"
                current = s + specialNames[place] + current;
            }
            
            //"place" é utilizada para saber a posição do proximo "specialNames"
            place++;
            //Divide o numero total por 1000 para voltar a repetir o processo enquanto for maior do que 0
            number /= 1000;
        } while (number > 0);
        
        //retorna uma string com o numero por escrito
        return current;
    }
    
    public static void main(String[] args) throws IOException {
        NumberToWord ntw = new NumberToWord();
        
        System.out.println("TESTES:");
        System.out.println("542: " + ntw.convert(542));
        System.out.println("23212: " + ntw.convert(23212));
        System.out.println("1049875: " + ntw.convert(1049875));
        
        System.out.println("Agora digite um numero: ");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();
        
        int num = parseInt(input);
        
        System.out.println(num + ": " + ntw.convert(num));

    }
}