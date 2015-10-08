package ejercicio1;


public class Servicios {
	
	protected double ope1;
	protected double ope2;
	protected double res;
	//protected int id=0;
	
	public Servicios(double op1,double op2,double result){
		ope1=op1;
		ope2=op2;
		res=result;;
	}
	
	
	
	public void autenticacion(String usu,String pass){
			//Comprobamos si usuario y contraseña son validos
			//Si es así
			//Enviamos codigo de OK
			System.out.println(Mensajes.OK);
			//Y si no, codigo de error y mensaje explicativo
			System.out.println(Mensajes.ERR);
		}
	
	public void logout(){
		//Cerrar las conexiones
		//Cerrar los input/output streams		
	}
	
	//Nos devolvera el nombre del usuario
	public void peticion1(){
		
		
	}
	
	public void peticion2(){
		
		
	}



	public double getOpe1() {
		return ope1;
	}



	public void setOpe1(double ope1) {
		this.ope1 = ope1;
	}



	public double getOpe2() {
		return ope2;
	}



	public void setOpe2(double ope2) {
		this.ope2 = ope2;
	}



	public double getRes() {
		return res;
	}



	public void setRes(double res) {
		this.res = res;
	}


	public String toString(){
		String men;
		men=String.valueOf(getOpe1())+" signoOperacion "+String.valueOf(getOpe2())+" ="+String.valueOf(getRes());
		return men;
	}

}
