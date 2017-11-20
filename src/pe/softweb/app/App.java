package pe.softweb.app;

import java.util.List;
import pe.softweb.models.Animal;

public class App {

    public static void main(String[] args) {
        Animal a = new Animal();
        List <Animal> lista = a.listar();
        for (int i = 0; i < lista.size(); i++){
            //System.out.println(lista.get(i));
        }
        
        //Animal a2 = new Animal("koki", "chihuagua nerviositus", 2.01, 2);
        //a2.crear();
        //System.out.println(a2);
        //Animal a3 = new Animal(132, "Koki", "chihuagua nerviositus", 2.01, 3);
        //a3.editar();
        
        Animal a3 = new Animal();
        a3.setId(132);
        a3.eliminar();
    } 
}
