public class BrazoRunnable extends Thread{

	private Brazo brazo;
	String NumBrazo;
	//Especificar la bandera
	private boolean bandera;

	/*
	bandera:true -> contenedor A
	bandera:false -> contenedor B
	*/

	public BrazoRunnable(int _id,int _num_p,Contenedor _contenedorA,Contenedor _contenedorB,String _target){
		this.brazo =  new Brazo(_id,_num_p,_contenedorA,_contenedorB);
		this.NumBrazo = new String(_target);
	}

	//SETTER
	public void setBandera(boolean _bandera){
		this.bandera = _bandera;
	}

	public void cambioDeBandera(boolean _bandera){
		if(bandera){
			bandera = false;
		}else{
			bandera = true;
		}		
	}

	@Override
	public void run(){

		int size = (brazo.getNumP()*2);

		for (int i = 1;i <= (size+1) ;i++) {
			System.out.println(NumBrazo+"->"+i);
			if(!brazo.getCapacidadB()){
				System.out.println("continuo");

				brazo.Controlador(bandera,(i),NumBrazo);
				cambioDeBandera(bandera);

				try{
					Thread.sleep(300);
				}catch(InterruptedException e){;}

			}else{
				System.out.println("Termino");

				break;
				/*
				Terminamos las descargas porque 
				lguno de los contenedores, esta 
				completamente vacio
				*/
			}

		}
	}
}