package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class MapColoring extends Graph{
    MapColoring(ArrayList<String> list) {
        super(list);
    }

    public int getIndexFromXY(int x, int y){
        return x;
    }

    public boolean solveCycleGraph(int posx, int posy, int v)throws IndexOutOfBoundsException, Error{
        try {
            if(allAssign())
                return true;
            if(alist.get(getIndexFromXY(posx,posy)).get(0).isCycleset()){

                System.out.println("trovato un cycleset: "+alist.get(getIndexFromXY(posx,posy)).get(0).getData());
                if(alist.get(getIndexFromXY(posx,posy)).get(0).assignment != null){//se è già stato caricato un valore input
                    System.out.println("di input e vado avanti");

                    if(avanti(posx,posy,v))
                        return false;
                }
                else if (alist.get(getIndexFromXY(posx,posy)).get(0).possibleAssignement != null){// se è tornato indietro o è passato al primo
                    if (getIndexFromXY(posx,posy)>alist.size()-1)
                        return false;
                    if(isSafe(posx,posy, (String) alist.get(getIndexFromXY(posx,posy)).get(0).possibleAssignement))  {//prox riga
                        System.out.println("già assegnato e valido, al prox");
                        controlAllElements();
                        if(avanti(posx,posy,v))
                            return false;
                    }
                    else{
                        if(!isSafe(posx,posy, (String) alist.get(getIndexFromXY(posx,posy)).get(0).possibleAssignement)){
                            System.out.println("ha già possible assignemnt non valido");
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
                        controlAllElements();
                        controlAllElements();

                        avanti(posx,posy,v);
                    }else{//torno indietro
                        //solveCycleGraph(posx,posy-1,v);
                        ripristino(exploringnodes.get(exploringnodes.size()-1));
                    }
                }
            }else{
                System.out.println(alist.get(getIndexFromXY(posx,posy)).get(0).getData()+" non è cycleset, vado avanti");

                avanti(posx,posy,v);
            }
        }catch (IndexOutOfBoundsException ignored){
            return false;
        }
        catch (Error i ){
            System.out.println("Error, problema non risolvibile");
            niente();
            return false;
        }
        return false;
    }


    public boolean avanti(int posx,int posy, int v){
        if (allAssign()){
            return true;
        }
        if (getIndexFromXY(posx,posy)>alist.size()-1)
            return true;
        if(posx+1 < alist.size())
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

    public void printMapColoring(){
        for (java.util.LinkedList<Node> nodes : alist) {
            System.out.println(nodes.get(0).getData() + " cycleset " + nodes.get(0).isCycleset() + " value " + nodes.get(0).possibleAssignement);
        }
    }

}


