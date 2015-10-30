package ejercicio1;

import java.io.*;


public class Datos {
	
	private double op1,op2,result;
	private String signo,usuario,contraseña;
	

	
	//Constructor para inicializar los datos en caso de ser mensaje de operacion
	public Datos(String usu,double ope1, double ope2, String sig, double res)
	{
		this.usuario=usu;
		this.op1=ope1;
		this.op2=ope2;
		this.signo=sig;
		result=res;
	}
	
	//Constructor en caso de usuario y contraseña correctos
	public Datos(String usu,String pass)
	{
		this.usuario=usu;
		this.contraseña=pass;
	}
	

	public Datos(String usu)
	{
		this.usuario=usu;
	}
		
	
	//Constructor para recibir los datos
	public Datos (DataInputStream dis, byte tipo) throws ExcepcionDatos{
			
		try {
			this.usuario=dis.readUTF();
			//Dependiendo del tipo que recibimos, leemos unos datos u otros
			if(tipo==2){
			this.op1= dis.readDouble();
			this.signo=dis.readUTF();
			this.op2=dis.readDouble();						
			this.result=dis.readDouble();
			Datos d= new Datos(usuario,op1,op2,signo,result);
			Mensajes m =new Mensajes(d);
			} else if(tipo==1){
				this.contraseña=dis.readUTF();
				Datos d1 = new Datos(usuario,contraseña);
				Mensajes m1 = new Mensajes(d1);
			}
			else {
				Datos d2 = new Datos(usuario);
				Mensajes m2 = new Mensajes(d2);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ExcepcionDatos("Formato Invalido");
		}
			
	}
	
	
	/**
	 * @param data datos que queremos pasar a bytes
	 * @return datos en bytes
	 */
	public byte[] toByteArray (Datos data){
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream(41);
		DataOutputStream dos = new DataOutputStream(bos);
		
		try {
			dos.writeUTF(usuario);
			//Comprobamos que el resto de datos estén inicializados
			//Si no lo están no los enviamos
			if(this.signo!=null){
			dos.writeDouble(this.op1);
			dos.writeUTF(signo);
			dos.writeDouble(this.op2);				
			dos.writeDouble(result);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] bytes =  bos.toByteArray(); // devuelve byte[]
		return bytes;
	}


	/**
	 * @return el operador 1
	 */
	public double getOp1() {
		return op1;
	}


	/**
	 * @return el operador 2
	 */
	public double getOp2() {
		return op2;
	}


	/**
	 * @return usuario introducido por cliente
	 */
	public String getUsuario() {
		return usuario;
	}
	
	/**
	 * @return signo de la operacion
	 */
	public String getSigno() {
		return signo;
	}
	
	/**
	 * @return resultado de la operacion
	 */
	public double getRes() {
		return result;
	}

	/**
	 * @return contraseña introducida por el usuario
	 */
	public String getContraseña() {
		return contraseña;
	}



}
