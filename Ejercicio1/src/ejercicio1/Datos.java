package ejercicio1;

import java.io.*;

/**
 * @author Sergio
 *
 */
public class Datos {
	
	private double op1,op2,result;
	private String comando,signo,usuario;

	
	//Constructor para inicializar los datos
	public Datos(String cmd,String usu,double ope1, double ope2, String sig, double res)
	{
		this.op1=ope1;
		this.op2=ope2;
		this.comando=cmd;
		this.signo=sig;
		this.usuario=usu;
		result=res;
	}
		
	
	//Constructor para recibir los datos
	public Datos (byte[] datos) throws ExcepcionDatos{
		
		ByteArrayInputStream bais = new ByteArrayInputStream(datos); 
		DataInputStream dis = new DataInputStream(bais);
		
		try {
			this.comando=dis.readUTF();
			this.op1= dis.readDouble();
			this.signo=dis.readUTF();
			this.op2=dis.readDouble();			
			this.usuario=dis.readUTF();
			this.result=dis.readDouble();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ExcepcionDatos("Formato Invalido");
		}
			Datos d= new Datos(comando,usuario,op1,op2,signo,result);
			Mensajes m =new Mensajes(d);
	}
	
	
	public byte[] toByteArray (Datos data){
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream(20);
		DataOutputStream dos = new DataOutputStream(bos);
		
		try {
			dos.writeUTF(comando);
			dos.writeDouble(this.op1);
			dos.writeUTF(signo);
			dos.writeDouble(this.op2);	
			dos.writeUTF(usuario);
			dos.writeDouble(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] bytes =  bos.toByteArray(); // devuelve byte[]
		return bytes;
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

	public String getComando() {
		return comando;
	}
	

	public String getUsuario() {
		return usuario;
	}
	
	public String getSigno() {
		return signo;
	}
	
	public double getRes() {
		return result;
	}



}
