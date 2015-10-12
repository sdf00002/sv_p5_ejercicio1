package ejercicio1;

import java.io.*;

public class Servicios {
	
	protected double ope1;
	protected double ope2;
	protected double res;
	protected String signoOperacion;
	protected String id="";
	public int estado=0;
	protected boolean aut=false;
	
		
	public Servicios (String dato1,String dato2){
		this.ope1= Double.parseDouble(dato1);
		this.ope2=Double.parseDouble(dato2);	
	}
	
	
	
	public void autenticacion(String usu,String pass){
			//Comprobamos si usuario y contraseña son validos
			//Si es así
			//Enviamos codigo de OK
			System.out.println(Mensajes.OK);
			aut=true;
			//Y si no, codigo de error y mensaje explicativo
			System.out.println(Mensajes.ERR);
			aut=false;
		}
	
	public void logout(){
		//Cerrar las conexiones
		//Cerrar los input/output streams		
	}
	
	
	public Servicios (DataInputStream dis){
		try {
			this.ope1= dis.readDouble();
			this.ope2=dis.readDouble();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			this.ope1=0.0;
			this.ope2=0.0;
			e.printStackTrace();
		}
		

		
	}
	
	public void toByteArray (DataOutputStream dos){
		try {
			dos.writeDouble(this.ope1);
			dos.writeDouble(this.ope2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	public double Suma(){
		signoOperacion="+";
		res=this.getOpe1()+this.getOpe2();
		return res;
	}
	
	public double Resta(){
		signoOperacion="-";
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


	public String toString(){
		String men;
		men=String.valueOf(getOpe1())+" "+signoOperacion+" "+String.valueOf(getOpe2())+" ="+String.valueOf(getRes());
		return men;
	}

}
