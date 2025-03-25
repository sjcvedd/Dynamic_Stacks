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
    nodo next;
    nodo(){
    }
    nodo(String valor){
        this.dato = valor;
    }
}
class pila{
    nodo top;
    pila aux;
    boolean isEmpty(){ // comprobar si existen elementos en la pila o no
        return top == null;// si top esta asignado es porque existe un elemento al menos
    }
    void push(nodo elemento){ // insertar un elemento nuevo al tope de la pila
        if (this.isEmpty()){ // Si no existe nada almacenado en la pila asigna a top el elemento entrante
            top = elemento;
        }else{ // si ya existen elementos agregados se adjuntan los elementos actuales de la pila al
            elemento.next = this.top; // nodo que esta entrando, y este elemento pasa a ser TOP
            this.top = elemento;
        }
    }
    nodo pop(){
        if (!this.isEmpty()){
            nodo temp = new nodo();
            temp.dato = this.top.dato; // asigno los datos de top al nodo temporal
            this.top = this.top.next;
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
                break;
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
