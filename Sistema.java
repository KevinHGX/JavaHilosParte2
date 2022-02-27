
public class Sistema{
	public static void main(String[] args){
	//Objetos de tipó Contendor
	Contenedor contenedorA = new Contenedor(1000,30);
	Contenedor contenedorB = new Contenedor(1001,50);

	//Objetos de tipó Brazo Runnable
	BrazoRunnable Brazo1 = new BrazoRunnable(100,25,contenedorA,contenedorB,"Brazo1");

	Brazo1.setBandera(true);//Contenedor A
	
	BrazoRunnable Brazo2 = new BrazoRunnable(101,25,contenedorA,contenedorB,"Brazo2");

	Brazo2.setBandera(false);//Contenedor B

	//THREAD
	Brazo1.start();
	Brazo2.start();

	/*  RUNNABLE
		Thread HiloBrazo1 = new Thread(Brazo1);
		Thread HiloBrazo2 = new Thread(Brazo2);
		System.out.println("paso 1");
		HiloBrazo1.start();
		HiloBrazo2.start();
	*/
	
	}
}