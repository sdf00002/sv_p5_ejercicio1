package ejercicio1;

import java.io.*;

public class Datos {
	
	private double op1,op2;

	

	public Datos(double ope1, double ope2)
	{
		this.op1=ope1;
		this.op2=ope2;
		
	}
	
	public Datos (String dato1,String dato2){
		this.op1= Double.parseDouble(dato1);
		this.op2=Double.parseDouble(dato2);	
	}
	
	public Datos (DataInputStream dis){
		try {
			this.op1= dis.readDouble();
			this.op2=dis.readDouble();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			this.op1=0.0;
			this.op2=0.0;
			e.printStackTrace();
		}
		

		
	}
	
	public void toByteArray (DataOutputStream dos){
		try {
			dos.writeDouble(this.op1);
			dos.writeDouble(this.op2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	public String toString()
	{
		return  op1+" "+op2;
		
	}

	public double getOp1() {
		return op1;
	}

	public void setOp1(double op1) {
		this.op1 = op1;
	}

	public double getOp2() {
		return op2;
	}

	public void setOp2(double op2) {
		this.op2 = op2;
	}

}
