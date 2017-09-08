/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techbiosis;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author nelsonalmeida
 */

public class PragmaticLottery {

    List<Integer> PossibleNumbers;
    List<Integer> winnerNumbers;
    

    public PragmaticLottery() {
        PossibleNumbers = new ArrayList<Integer>();
        winnerNumbers = new ArrayList<Integer>();
    }
    
    //Para adicionar as 60 bolas possiveis de sair
    public void addSixtyNumbers (){
        for(int i=0; i<60;i++){
            PossibleNumbers.add(i);
        }
    }

    public List<Integer> numberDraw(int number) {
        add(number);
        return winnerNumbers;
    }

    void add(int number) {
        //Se a lista vencvedora estiver vazia adiciona logo
        if(winnerNumbers.size() == 0) {
            winnerNumbers.add(number);
        } else {
            //Se nao estiver vazia faz o "addToExistingList" para colocar no local correcto para manter a ordem
            addToExistingList(number);
        }
    }

    private void addToExistingList(int number) {
        int i = 0;
        for(int num: winnerNumbers) {
            if(num > number) {
                break;
            }
            i++;
        }
        winnerNumbers.add(i, number);
    }
    
    public void playGame(){
        //inicializar as 60 possibilidades
        addSixtyNumbers();
        
        int availableBalls = 59;
        
        //Escolha aleatoria entre 5 a 15 de quantas bolas vão sair
        //No enunciado fala de 5, 7, 9, 15. Como não percebi bem esta parte assumi que podia ser entre 5 a 15 as bolas selecionadas
        Random randSelect = new Random();
        int randomSelected = randSelect.nextInt((15 - 5) + 1) + 5;
        
        //Escolha aleatoria de uma das bolas ainda em jogo
        Random randBall = new Random();
        for(int i=0; i<randomSelected; i++){
            int randomBall = randBall.nextInt((availableBalls - 0) + 1) + 0;
            //numberDraw para o desenhar a bola selecionada
            //Ao desenhar a bola tambem a retira das bolas possiveis de escolher e diminui o availableBalls
            numberDraw(PossibleNumbers.remove(randomBall)); 
            
            availableBalls--;
            
        }
        
        printResolt(randomSelected);
    }
    
    //Funcao para imprimir o resultado
    public void printResolt(int randomSelected){
        
        System.out.println("Entre 5 a 15 foi escolhido sortear " + randomSelected + " numeros!!\n");
        
        System.out.println("RESULTADOS:");
        for(int i = 0; i< randomSelected; i++){
            System.out.println("BOLA: "+ winnerNumbers.get(i));
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        PragmaticLottery pragLot = new PragmaticLottery();

        pragLot.playGame();
              
    }
    
}
