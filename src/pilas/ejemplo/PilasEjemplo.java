/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas.ejemplo;

/**
 *
 * @author Silver
 */


class nodo{
    String dato;
    nodo down;
    nodo(){
    }
    nodo(String valor){
        this.dato = valor;
    }
}
class pila{
    nodo top;
    pila aux;
    boolean isEmpty(){
        if(top == null){
            return true;
        }else{
            return false;
        }
    }
    void push(nodo elemento){
        if (this.isEmpty()){
            top = elemento;
        }else{
            elemento.down = this.top;
            this.top = elemento;
        }
    }
    nodo pop(){
        if (this.top!=null){
            nodo temp = new nodo();
            //System.out.println("Sale de La Pila: " + this.top.dato);
            temp.dato = this.top.dato; // asigno los datos de top al nodo temporal
            this.top = this.top.down;
            return temp;
        }else{
            System.out.println("Pila Vacía");
            return null;
        }
    }
    void destroy(String valor){
        aux = new pila();
        while (this.top!=null){
            if (this.top.dato.equals(valor)) {
                System.out.println("Eliminado " + this.pop().dato);
            }else{
            aux.push(this.pop()); // paso todos los elementos existentes de "this" a "aux"
            }
        }
        while (aux.top!=null){
            this.push(aux.pop());
        }
    }
    void edit(String valor , String nuevo){
        aux = new pila();
        while (this.top!=null){
            if (this.top.dato.equals(valor)) {
                System.out.println("Modificado \"" + this.top.dato +"\" por el valor \"" + nuevo +"\"");
                top.dato = nuevo;
            }else{
            aux.push(this.pop()); // paso todos los elementos existentes de "this" a "aux"
            }
        }
        while (aux.top!=null){
            this.push(aux.pop());
        }
    }
}

public class PilasEjemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        pila pi = new pila();
        pila aux = new pila();
        pi.push(new nodo("A"));
        pi.push(new nodo("B"));
        pi.push(new nodo("C"));
        pi.push(new nodo("D"));
        pi.push(new nodo("F"));
        pi.push(new nodo("G"));
        pi.push(new nodo("H"));
        
        pi.destroy( "G" );
        pi.destroy( "A" );
        pi.edit( "B" , "1" );
        
    }
    
}
