public class Brazo{

	public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
	//ATRIBUTOS
	private int Id;
	private int Num_P;
	private Contenedor contenedorA;
	private Contenedor contenedorB;

	private boolean banderaCapacidad = false;

	//CONSTRUCTOR
	public Brazo(int _id,int _num_P,Contenedor _contenedorA,Contenedor _contenedorB){
		this.Id = _id;
		this.Num_P = _num_P;
		this.contenedorA = _contenedorA;
		this.contenedorB = _contenedorB; 
	}

	//GETTER
	public int getNumP(){
		return this.Num_P;
	}

	public boolean getCapacidadB(){
		System.out.println("Capacidad Actual de A: "+this.contenedorA.getCapacidad());
		System.out.println("Capacidad Actual de B: "+this.contenedorB.getCapacidad());

		//AMBOS CONTENEDORES ESTAN VACIOS
		if(this.contenedorA.getCapacidad() == 0 && this.contenedorB.getCapacidad() == 0){
			this.contenedorA.terminarEjecucion();
			this.contenedorB.terminarEjecucion();
			return true;
		}else if(this.contenedorA.getCapacidad() == 0 || this.contenedorB.getCapacidad() == 0){//EL CONTENEDOR A ESTA VACIO
			System.out.println(ANSI_YELLOW+"--- NO HAY PIEZAS SUFICIENTES PARA CONTINUAR CON LA DESCARGA --- "+ANSI_WHITE);
			this.contenedorA.terminarEjecucion();
			this.contenedorB.terminarEjecucion();
			return true;
		}

		return false;
	} 

	//METODOS
	public void piezaCompletada(int index,String target){

		if((index%2) == 0){
			int numP = index/2;
			System.out.println(ANSI_YELLOW+target+": ha montado su producto "+numP+" de "+Num_P+ANSI_WHITE);
		}
	}

	public void Controlador(boolean bandera,int index,String target){
		if(bandera){
			this.contenedorA.descargarUnaPiezaA();
			System.out.println(target+ANSI_RED+": ha desmontado una pieza del Contenedor A"+ANSI_WHITE);
		}else{
			this.contenedorB.descargarUnaPiezaB();
			System.out.println(target+ANSI_CYAN+": ha desmontado una pieza del Contenedor B"+ANSI_WHITE);
		}

		piezaCompletada(index,target);

	}
}