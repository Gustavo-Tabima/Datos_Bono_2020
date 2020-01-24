package test;

import java.util.ArrayList;
/**
 * 
 * En este código hago uso de las pruebas realizadas por el usuario le99 en su repositorio de 
 * GitHub: "estructuras de datos"
 * https://github.com/le99/estructurasDatos/blob/master/desempennoArrayList/src/test/Main.java
 * 
 * **/
public class Main {
	static int DATOS_A_INSERTAR = 50*1000*1000;
	static int DATOS_A_ELIMAR = 1000;

	public static void main(String[] args) {

		long start;
		long finish;
		ArrayList<Integer> datos = new ArrayList<>();
		start = System.currentTimeMillis();

		for(int n = 0; n < DATOS_A_INSERTAR; n++) {
			datos.add(n);
		}
		finish = System.currentTimeMillis();
		System.out.println("Tiempo para insertar al final (Usando Add ) " + DATOS_A_INSERTAR + " datos: " + (finish - start)/1000 + "s");

		start = System.currentTimeMillis();
		for(int n = 0; n < DATOS_A_ELIMAR; n++) {
			datos.remove(datos.size()-1);
		}
		finish = System.currentTimeMillis();
		System.out.println("Tiempo para eliminar al final (Usando Remove ) " + DATOS_A_ELIMAR + " datos: " + (finish - start) + "ms");


		start = System.currentTimeMillis();
		for(int n = 0; n < DATOS_A_ELIMAR; n++) {
			datos.remove(0);
		}
		finish = System.currentTimeMillis();
		System.out.println("Tiempo para eliminar al comienzo (usando Remove)" + DATOS_A_ELIMAR + " datos: " + (finish - start) + "ms");


		//Este método tiene la función de añadir los datos al inicio del Arraylist

		start = System.currentTimeMillis();
		for(int n = 0; n < DATOS_A_INSERTAR; n++) {
			datos.add(0);
		}
		finish = System.currentTimeMillis();
		System.out.println("Tiempo para añadir al comienzo (Usando add) " + DATOS_A_INSERTAR + " datos: " + (finish - start) + "ms");

		



		//Aquí ingreso todos los datos en una posición elejida al azar, la teoría es que para insertar
		//estos datos se requiere primero que se copien todos los datos existentes en otra posición y 
		//que además se deben agregar los otros elementos, por eso añadir cosas a la cabeza del array o 
		//una posición espécífica es más lento, según lo prueba el siguiente código
		// tiempo aproximado: 21234 seg -casi 7 horas- (Toma bastante bastante tiempo)

		start = System.currentTimeMillis();

		for(int i = 0; i< DATOS_A_INSERTAR;i++) {

			int posicionAleatoria = (int) Math.random()*100;
			datos.add(posicionAleatoria,i);


			if(i == DATOS_A_INSERTAR) {
				System.out.println("POR FIN HEMOS TERMINADO");
			}
		}

		finish = System.currentTimeMillis();
		System.out.println("Tiempo para insertar (Usando Add en una posición generada al azar) " + DATOS_A_INSERTAR + " datos: " + (finish - start)/1000 + "s");

		//Ahora usaré el mismo metodo de posiciones aleatorias para remover un elemento del arreglo en una posición generada al azar

		start = System.currentTimeMillis();

		for(int i = 0; i< DATOS_A_ELIMAR;i++) {

			int posicionAleatoria = (int) Math.random()*100;
			datos.remove(posicionAleatoria);


			if(i == DATOS_A_INSERTAR) {
				System.out.println("POR FIN HEMOS TERMINADO");
			}
		}

		finish = System.currentTimeMillis();
		System.out.println("Tiempo para eliminar (Usando Add en una posición generada al azar) " + DATOS_A_ELIMAR + " datos: " + (finish - start)/1000 + "s");

		
		try {
			//Este método tiene la función de tomar un arreglo hecho e introducirlo a el nuevo arraylist
			start = System.currentTimeMillis();


			ArrayList<Integer> datos2 = new ArrayList<>();

			datos2.addAll(datos);	



			finish = System.currentTimeMillis();

			System.out.println("Tiempo para insertar un arreglo lleno (Usando AddAll..) " + DATOS_A_INSERTAR + " datos: " + (finish - start)/1000 + "s");
		} catch (Exception e) {
			System.out.println("Al hacer esta prueba con todas las demás genera un error, sin embargo el tiempo es 1 segundo aproximadamente..");
		}
		
		
	}

}
