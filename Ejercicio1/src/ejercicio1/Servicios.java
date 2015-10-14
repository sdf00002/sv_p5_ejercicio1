package ejercicio1;


public class Servicios {
	
	protected double ope1;
	protected double ope2;
	protected double res;
	Datos data = new Datos("usuario");
	Mensajes m=new Mensajes(null);
	
		
	public Servicios (double dato1,double dato2){
		this.ope1= dato1;
		this.ope2=dato2;	
	}
		
	
	
	public double Suma(){
		res=this.getOpe1()+this.getOpe2();
		return res;
	}
	
	public double Resta(){
		res=this.getOpe1()-this.getOpe2();
		return res;
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


}
