public class Contenedor{
	//ATRIUTOS
	private int id;
	private int Capacidad;

	//CONSTRUCTOR
	public Contenedor(int _id,int  _capacidad){
		this.id = _id;
		this.Capacidad = _capacidad; 
	}

	//GETTER
	public int getCapacidad(){
		return this.Capacidad;
	}

	synchronized public void terminarEjecucion(){
		notifyAll();
	} 

	//METODOS
	synchronized public void descargarUnaPiezaA(){
		notifyAll();
		try{
			if(Capacidad != 0){  
				Capacidad -= 1;  
				while(true){
					wait();
					break;
				}
			}
		}catch(InterruptedException e){
			System.out.println("Hilo principal interrumpido.");
		}
	}

	public void descargarUnaPiezaB(){
		if(Capacidad != 0){   Capacidad -= 1;   }
	}

}