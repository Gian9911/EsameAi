package com.company;
import java.util.ArrayList;
import java.util.Objects;

public class Sudoku extends Graph{

    Sudoku(ArrayList<String> list) {
        super(list);
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){

                String t = String.valueOf(i)+j;
                addNode(new SudokuNode(t,i,j));
            }
        }
        addEdge();
    }
    Sudoku(ArrayList<String> list, String g) {
        super(list);
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){

                String t = String.valueOf(i)+j;
                addNode(new SudokuNode(t,i,j));
            }
        }
        addEdge();
        alist.get(getIndexFromXY(0,0)).get(0).assignment = String.valueOf(1);
        propagate(getIndexFromXY(0,0));//
        alist.get(getIndexFromXY(0,6)).get(0).assignment = String.valueOf(9);
        propagate(getIndexFromXY(0,6));//

        alist.get(getIndexFromXY(0,7)).get(0).assignment = String.valueOf(5);
        propagate(getIndexFromXY(0,7));//

        alist.get(getIndexFromXY(1,0)).get(0).assignment = String.valueOf(5);
        propagate(getIndexFromXY(1,0));//

        alist.get(getIndexFromXY(2,2)).get(0).assignment = String.valueOf(6);
        propagate(getIndexFromXY(2,2));

        alist.get(getIndexFromXY(2,0)).get(0).assignment = String.valueOf(3);
        propagate(getIndexFromXY(2,0));

        alist.get(getIndexFromXY(2,1)).get(0).assignment = String.valueOf(8);
        propagate(getIndexFromXY(2,1));

        alist.get(getIndexFromXY(2,3)).get(0).assignment = String.valueOf(1);
        propagate(getIndexFromXY(2,3));

        alist.get(getIndexFromXY(2,4)).get(0).assignment = String.valueOf(5);
        propagate(getIndexFromXY(2,4));

        alist.get(getIndexFromXY(2,5)).get(0).assignment = String.valueOf(9);
        propagate(getIndexFromXY(2,5));

        alist.get(getIndexFromXY(3,0)).get(0).assignment = String.valueOf(8);
        propagate(getIndexFromXY(3,0));

        alist.get(getIndexFromXY(3,2)).get(0).assignment = String.valueOf(3);
        propagate(getIndexFromXY(3,2));

        alist.get(getIndexFromXY(3,4)).get(0).assignment = String.valueOf(2);
        propagate(getIndexFromXY(3,4));

        alist.get(getIndexFromXY(3,5)).get(0).assignment = String.valueOf(4);
        propagate(getIndexFromXY(3,5));

        alist.get(getIndexFromXY(4,3)).get(0).assignment = String.valueOf(3);
        propagate(getIndexFromXY(4,3));

        alist.get(getIndexFromXY(4,4)).get(0).assignment = String.valueOf(8);
        propagate(getIndexFromXY(4,4));

        alist.get(getIndexFromXY(4,7)).get(0).assignment = String.valueOf(6);
        propagate(getIndexFromXY(4,7));

        alist.get(getIndexFromXY(4,8)).get(0).assignment = String.valueOf(2);
        propagate(getIndexFromXY(4,8));

        alist.get(getIndexFromXY(5,1)).get(0).assignment = String.valueOf(2);
        propagate(getIndexFromXY(5,1));

        alist.get(getIndexFromXY(5,2)).get(0).assignment = String.valueOf(1);
        propagate(getIndexFromXY(5,2));

        alist.get(getIndexFromXY(5,8)).get(0).assignment = String.valueOf(3);
        propagate(getIndexFromXY(5,8));

        alist.get(getIndexFromXY(6,2)).get(0).assignment = String.valueOf(5);
        propagate(getIndexFromXY(6,2));

        alist.get(getIndexFromXY(6,4)).get(0).assignment = String.valueOf(3);
        propagate(getIndexFromXY(6,4));

        alist.get(getIndexFromXY(6,5)).get(0).assignment = String.valueOf(6);
        propagate(getIndexFromXY(6,5));

        alist.get(getIndexFromXY(6,7)).get(0).assignment = String.valueOf(1);
        propagate(getIndexFromXY(6,7));

        alist.get(getIndexFromXY(7,0)).get(0).assignment = String.valueOf(2);
        propagate(getIndexFromXY(7,0));

        alist.get(getIndexFromXY(7,1)).get(0).assignment = String.valueOf(3);
        propagate(getIndexFromXY(7,1));

        alist.get(getIndexFromXY(7,3)).get(0).assignment = String.valueOf(7);
        propagate(getIndexFromXY(7,3));

        alist.get(getIndexFromXY(7,5)).get(0).assignment = String.valueOf(5);
        propagate(getIndexFromXY(7,5));

        alist.get(getIndexFromXY(7,8)).get(0).assignment = String.valueOf(9);
        propagate(getIndexFromXY(7,8));

        alist.get(getIndexFromXY(8,4)).get(0).assignment = String.valueOf(4);
        propagate(getIndexFromXY(8,4));

        alist.get(getIndexFromXY(8,8)).get(0).assignment = String.valueOf(5);
        propagate(getIndexFromXY(8,8));

    }

    public Sudoku(ArrayList<String> list,int number1, int number2) {
        super(list);
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){

                String t = String.valueOf(i)+j;
                addNode(new SudokuNode(t,i,j));
            }
        }
        addEdge();
        alist.get(getIndexFromXY(0,2)).get(0).assignment = String.valueOf(8);
        propagate(getIndexFromXY(0,2));//
        alist.get(getIndexFromXY(0,3)).get(0).assignment = String.valueOf(1);
        propagate(getIndexFromXY(0,3));//

        alist.get(getIndexFromXY(0,5)).get(0).assignment = String.valueOf(2);
        propagate(getIndexFromXY(0,5));//
        alist.get(getIndexFromXY(1,8)).get(0).assignment = String.valueOf(6);
        propagate(getIndexFromXY(1,8));//

        alist.get(getIndexFromXY(2,0)).get(0).assignment = String.valueOf(2);
        propagate(getIndexFromXY(2,0));//

        alist.get(getIndexFromXY(2,3)).get(0).assignment = String.valueOf(7);
        propagate(getIndexFromXY(2,3));

        alist.get(getIndexFromXY(2,5)).get(0).assignment = String.valueOf(4);
        propagate(getIndexFromXY(2,5));

        alist.get(getIndexFromXY(2,6)).get(0).assignment = String.valueOf(5);
        propagate(getIndexFromXY(2,6));

        alist.get(getIndexFromXY(2,8)).get(0).assignment = String.valueOf(3);
        propagate(getIndexFromXY(2,8));

        alist.get(getIndexFromXY(3,2)).get(0).assignment = String.valueOf(6);
        propagate(getIndexFromXY(3,2));

        alist.get(getIndexFromXY(3,6)).get(0).assignment = String.valueOf(9);
        propagate(getIndexFromXY(3,6));

        alist.get(getIndexFromXY(3,8)).get(0).assignment = String.valueOf(1);
        propagate(getIndexFromXY(3,8));

        alist.get(getIndexFromXY(4,1)).get(0).assignment = String.valueOf(2);
        propagate(getIndexFromXY(4,1));

        alist.get(getIndexFromXY(4,5)).get(0).assignment = String.valueOf(5);
        propagate(getIndexFromXY(4,5));

        alist.get(getIndexFromXY(4,6)).get(0).assignment = String.valueOf(6);
        propagate(getIndexFromXY(4,6));

        alist.get(getIndexFromXY(5,0)).get(0).assignment = String.valueOf(1);
        propagate(getIndexFromXY(5,0));

        alist.get(getIndexFromXY(5,1)).get(0).assignment = String.valueOf(7);
        propagate(getIndexFromXY(5,1));

        alist.get(getIndexFromXY(5,2)).get(0).assignment = String.valueOf(9);
        propagate(getIndexFromXY(5,2));

        alist.get(getIndexFromXY(5,5)).get(0).assignment = String.valueOf(3);
        propagate(getIndexFromXY(5,5));

        alist.get(getIndexFromXY(6,0)).get(0).assignment = String.valueOf(4);
        propagate(getIndexFromXY(6,0));

        alist.get(getIndexFromXY(6,4)).get(0).assignment = String.valueOf(5);
        propagate(getIndexFromXY(6,4));

        alist.get(getIndexFromXY(6,7)).get(0).assignment = String.valueOf(1);
        propagate(getIndexFromXY(6,7));

        alist.get(getIndexFromXY(8,1)).get(0).assignment = String.valueOf(6);
        propagate(getIndexFromXY(8,1));

        alist.get(getIndexFromXY(8,6)).get(0).assignment = String.valueOf(3);
        propagate(getIndexFromXY(8,6));

        alist.get(getIndexFromXY(8,8)).get(0).assignment = String.valueOf(5);
        propagate(getIndexFromXY(8,8));
    }


    public Sudoku(ArrayList<String> list,int number) {
        super(list);
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){

                String t = String.valueOf(i)+j;
                addNode(new SudokuNode(t,i,j));
            }
        }
        addEdge();
        alist.get(getIndexFromXY(0,2)).get(0).assignment = String.valueOf(8);
        propagate(getIndexFromXY(0,2));//
        alist.get(getIndexFromXY(0,3)).get(0).assignment = String.valueOf(1);
        propagate(getIndexFromXY(0,3));//

        alist.get(getIndexFromXY(0,5)).get(0).assignment = String.valueOf(2);
        propagate(getIndexFromXY(0,5));//
        alist.get(getIndexFromXY(1,8)).get(0).assignment = String.valueOf(6);
        propagate(getIndexFromXY(1,8));//

        alist.get(getIndexFromXY(2,0)).get(0).assignment = String.valueOf(2);
        propagate(getIndexFromXY(2,0));//

        alist.get(getIndexFromXY(2,3)).get(0).assignment = String.valueOf(7);
        propagate(getIndexFromXY(2,3));

        alist.get(getIndexFromXY(2,5)).get(0).assignment = String.valueOf(4);
        propagate(getIndexFromXY(2,5));

        alist.get(getIndexFromXY(2,6)).get(0).assignment = String.valueOf(5);
        propagate(getIndexFromXY(2,6));

        alist.get(getIndexFromXY(2,8)).get(0).assignment = String.valueOf(3);
        propagate(getIndexFromXY(2,8));

        alist.get(getIndexFromXY(3,2)).get(0).assignment = String.valueOf(6);
        propagate(getIndexFromXY(3,2));

        alist.get(getIndexFromXY(3,6)).get(0).assignment = String.valueOf(9);
        propagate(getIndexFromXY(3,6));

        alist.get(getIndexFromXY(3,8)).get(0).assignment = String.valueOf(1);
        propagate(getIndexFromXY(3,8));

        alist.get(getIndexFromXY(4,1)).get(0).assignment = String.valueOf(2);
        propagate(getIndexFromXY(4,1));

        alist.get(getIndexFromXY(4,5)).get(0).assignment = String.valueOf(5);
        propagate(getIndexFromXY(4,5));

        alist.get(getIndexFromXY(4,6)).get(0).assignment = String.valueOf(6);
        propagate(getIndexFromXY(4,6));

        alist.get(getIndexFromXY(5,0)).get(0).assignment = String.valueOf(1);
        propagate(getIndexFromXY(5,0));

        alist.get(getIndexFromXY(5,1)).get(0).assignment = String.valueOf(7);
        propagate(getIndexFromXY(5,1));

        alist.get(getIndexFromXY(5,2)).get(0).assignment = String.valueOf(9);
        propagate(getIndexFromXY(5,2));

        alist.get(getIndexFromXY(5,5)).get(0).assignment = String.valueOf(3);
        propagate(getIndexFromXY(5,5));

        alist.get(getIndexFromXY(6,0)).get(0).assignment = String.valueOf(4);
        propagate(getIndexFromXY(6,0));

        alist.get(getIndexFromXY(6,4)).get(0).assignment = String.valueOf(5);
        propagate(getIndexFromXY(6,4));

        alist.get(getIndexFromXY(6,7)).get(0).assignment = String.valueOf(1);
        propagate(getIndexFromXY(6,7));

        alist.get(getIndexFromXY(8,1)).get(0).assignment = String.valueOf(6);
        propagate(getIndexFromXY(8,1));

        alist.get(getIndexFromXY(8,6)).get(0).assignment = String.valueOf(3);
        propagate(getIndexFromXY(8,6));

        alist.get(getIndexFromXY(8,8)).get(0).assignment = String.valueOf(5);
        propagate(getIndexFromXY(8,8));
    }

    public int getIndexFromXY(int x, int y){
            return getIndexOfNode(alist.get(x*9+y).get(0));//x*10+y-i
    }

    public void setCellAssignment(int x, int y, int value){ alist.get(getIndexFromXY(x,y)).get(0).possibleAssignement=value;}

    private void addEdge() {
        for(int y = 0; y < 9; y++){//riga
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j != y ){
                    alist.get(getIndexFromXY(i, y)).add(alist.get(getIndexFromXY(i, j)).get(0));
                    }
                }
            }
        }
        for(int x = 0; x < 9; x++){//colonna
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (i != x )
                        alist.get(getIndexFromXY(x, j)).add(alist.get(getIndexFromXY(i, j)).get(0));
                }
            }
        }
        int t1 = 0,t2 = 0,z1 = 0,z2 = 0;
        for(int x = 0; x < 9; x++){
            for(int y = 0; y < 9; y++){
                if (x == 0 || x == 3 || x == 6){
                    t1 = x+1;
                    t2 = x+2;
                }
                if (x==1 || x == 4 || x == 7){
                    t1 = x+1;
                    t2 = x-1;
                }
                if (x==2 || x == 5 || x == 8){
                    t1 = x-1;
                    t2 = x-2;
                }

                if (y == 0 || y == 3 || y == 6){
                    z1 = y+1;
                    z2 = y+2;
                }
                if (y==1 || y == 4 || y == 7){
                    z1 = y+1;
                    z2 = y-1;
                }
                if (2==y || y == 5 || y == 8){
                    z1 = y-1;
                    z2 = y-2;
                }
                alist.get(getIndexFromXY(x, y)).add(alist.get(getIndexFromXY(t1, z1)).get(0));
                alist.get(getIndexFromXY(x, y)).add(alist.get(getIndexFromXY(t1, z2)).get(0));
                alist.get(getIndexFromXY(x, y)).add(alist.get(getIndexFromXY(t2, z1)).get(0));
                alist.get(getIndexFromXY(x, y)).add(alist.get(getIndexFromXY(t2, z2)).get(0));
            }
        }
    }

    public void printSudoku(){
        for(int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if( alist.get(getIndexFromXY(i,j)).get(0).assignment!=null)
                System.out.print(alist.get(getIndexFromXY(i,j)).get(0).assignment);
                else if( alist.get(getIndexFromXY(i,j)).get(0).possibleAssignement!=null)
                    System.out.print(alist.get(getIndexFromXY(i,j)).get(0).possibleAssignement);
                else if( alist.get(getIndexFromXY(i,j)).get(0).assignment==null &&
                        alist.get(getIndexFromXY(i,j)).get(0).assignment==null)
                    System.out.print(0);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public boolean solveCycleGraph(int posx, int posy, int v)throws IndexOutOfBoundsException, Error{
        try {
            if(allAssign())
                return true;

            printSudoku();
            if (allAssign())
                return true;
            if(alist.get(getIndexFromXY(posx,posy)).get(0).isCycleset()){
                System.out.println("trovato un cycleset: "+alist.get(getIndexFromXY(posx,posy)).get(0).getData());

                if(alist.get(getIndexFromXY(posx,posy)).get(0).assignment != null){//se è già stato caricato un valore input
                    System.out.println("di input e vado avanti");

                    if(avanti(posx,posy,v))
                        return true;


                }
                else if (alist.get(getIndexFromXY(posx,posy)).get(0).possibleAssignement != null){// se è tornato indietro o è passato al primo
                    if (getIndexFromXY(posx,posy)>alist.size()-1)
                        return true;
                    if(isSafe(posx,posy, (String) alist.get(getIndexFromXY(posx,posy)).get(0).possibleAssignement))  {//prox riga
                        System.out.println("già assegnato e valido, al prox");
                        controlAllElements();
                      if(!avanti(posx,posy,v))
                          return true;


                    }
                    else{
                        System.out.println("son finito qui...");
                        if(!isSafe(posx,posy, (String) alist.get(getIndexFromXY(posx,posy)).get(0).possibleAssignement)){
                            System.out.println("ha già passignemnt non valido");
                            ripristino(exploringnodes.get(exploringnodes.size()-1));

                        }
                        else{
                            avanti(posx,posy,0);
                            System.out.println("ha pass valido");
                        }
                    }
                }
                else if(alist.get(getIndexFromXY(posx,posy)).get(0).possibleAssignement == null && //caso di interesse
                        alist.get(getIndexFromXY(posx,posy)).get(0).assignment == null){
                    alist.get(getIndexFromXY(posx,posy)).get(0).printDomain();
                    exploringnodes.add(getIndexFromXY(posx,posy));

                    System.out.println("inserisco un valore valido");
                    if (alist.get(getIndexFromXY(posx,posy)).get(0).getValues().size()==0){
                        ripristino(exploringnodes.get(exploringnodes.size()-1));
                    }
                    //inserisco un valore valido
                    int val = 0;

                    while(!isSafe(posx,posy,alist.get(getIndexFromXY(posx,posy)).get(0).getValues().get(val)) &&
                            val < alist.get(getIndexFromXY(posx,posy)).get(0).getValues().size()){
                        val++;
                    }
                    //lo propago
                    System.out.println("propago");
                    propagate(getIndexFromXY(posx,posy));
                    //controllo se i linkati cycle hanno dominio 1 allora assegno e propago
                    consequences(getIndexFromXY(posx,posy));
                    System.out.println("conseguenze");

                    if(controlAllElements()) {//controllo non ci siano elementi con dominio.size == 0
                        System.out.println("???");
                        controlAllElements();
                        controlAllElements();

                        avanti(posx,posy,v);
                    }else{//torno indietro
                        System.out.println("!!!");
                        //solveCycleGraph(posx,posy-1,v);
                        ripristino(exploringnodes.get(exploringnodes.size()-1));
                    }
                }
            }else{
                System.out.println(alist.get(getIndexFromXY(posx,posy)).get(0).getData()+" non è cycleset, vado avanti");

                avanti(posx,posy,v);
            }
        }catch (IndexOutOfBoundsException ignored){
        }
        catch (Error i ){
            System.out.println("Error, problema non risolvibile");
            niente();
            return false;
        }
        return true;
    }


        public boolean avanti(int posx,int posy, int v){
            if (allAssign()){
                System.out.println("fine");
                return true;
            }
            if (getIndexFromXY(posx,posy)>alist.size()-1)
                return true;

            if(posy < alist.get(posx).size())
                solveCycleGraph(posx,posy+1,v);
            else if(posx+1 < alist.size())
                solveCycleGraph(posx+1,0,v);
            else
                return false;
            return true;
        }

        public boolean isSafe(int posx,int posy,String value){
            System.out.println("ho questo value: "+value);
            if(alist.get(getIndexFromXY(posx,posy)).get(0).possibleAssignement!=null){
                Object myValue = alist.get(getIndexFromXY(posx,posy)).get(0).possibleAssignement;
                for(int i = 1; i < alist.get(getIndexFromXY(posx,posy)).size();i++) {
                    if (alist.get(getIndexFromXY(posx,posy)).get(i).possibleAssignement == myValue ||
                            alist.get(getIndexFromXY(posx,posy)).get(i).assignment==myValue)
                        return false;

                }
                return true;
            }
            for(int i = 1; i < alist.get(getIndexFromXY(posx,posy)).size();i++) {
            if(Objects.equals(alist.get(getIndexFromXY(posx, posy)).get(i).assignment, value) |
                    alist.get(getIndexFromXY(posx,posy)).get(i).possibleAssignement == value){
                    System.out.println("assegnamento uguale al nodo: "+alist.get(getIndexFromXY(posx, posy)).get(i).getData());
                return false;
            }

            else if (alist.get(getIndexFromXY(posx,posy)).get(i).getValues().size() == 1 &&
                    alist.get(getIndexFromXY(posx,posy)).get(i).assignment==null &&
                            alist.get(getIndexFromXY(posx,posy)).get(i).possibleAssignement==null){
                System.out.println("senza valori: "+  alist.get(getIndexFromXY(posx,posy)).get(i).getData());
                return false;
            }
        }
            System.out.println("valore valido: "+value);
            alist.get(getIndexFromXY(posx,posy)).get(0).possibleAssignement=value;
            alist.get(getIndexFromXY(posx,posy)).get(0).printDomain();
        return true;
        }
}
