package ejercicio1;

import java.io.*;

public class Mensajes {
	
	//public static final String CRLF="\r\n";
	public static final String OK="+OK";
	public static final String ERR="-ERR";
	public static final String QUIT="QUIT";
	//public static final String PET="PET";
	protected static String ID="";
	//static int OPERACION=1;
	//static int QUIT=2;
	protected int longitud,estado=0;
	protected long fecha;
	private boolean salida=false;
	private String mensaje = "";

	
	public Mensajes(Datos d){

		//Servicios s = new Servicios(String.valueOf(d.getOp1()),String.valueOf(d.getOp2()));
		
		do {
		//Dependiendo de la variable est, estariamos en un estado u otro
		if(estado==0){		
			//Comprobamos que se recibe un mensaje OK
			if(d.getComando().equals(Mensajes.OK)){
				//Comprobamos si el usuario cumple nuestras condiciones
				if(this.tieneNumero(d.getUsuario())==true && d.getUsuario().length()>=6){
			this.toByteArray(d, "Selecciona operacion");
			estado++;
				}
				else {
					Datos d1 = new Datos(Mensajes.ERR,d.getUsuario(),d.getOp1(),d.getOp2(),d.getSigno(),d.getRes());
					this.toByteArray(d1, "Usuario no valido");
				}
			}
			// Si el comando recibido no es OK mandamos un mensaje de error
			else {
				Datos d2 = new Datos(Mensajes.ERR,d.getUsuario(),d.getOp1(),d.getOp2(),d.getSigno(),d.getRes());
				this.toByteArray(d2,"Seleccion incorrecta");
			}
		} else 
			if(estado==1){
				//Si recibimos un OK
				if(d.getComando()==Mensajes.OK){
					//Si quiere realizar una suma
					if(d.getSigno().equals("+")){
						Servicios s = new Servicios(d.getOp1(),d.getOp2());
						Datos dat = new Datos(d.getComando(),d.getUsuario(),d.getOp1(),d.getOp2(),d.getSigno(),s.Suma());
						this.toByteArray(dat);
					}
					else 
					//Si quiere realizar una resta
					if(d.getSigno().equals("-")){
						Servicios s = new Servicios(d.getOp1(),d.getOp2());
						Datos dat = new Datos(d.getComando(),d.getUsuario(),d.getOp1(),d.getOp2(),d.getSigno(),s.Resta());
						this.toByteArray(dat);
					}
					//Si el signo es incorrecto enviamos mensaje de error
					else{
						Datos d3 = new Datos(Mensajes.ERR,d.getUsuario(),d.getOp1(),d.getOp2(),d.getSigno(),d.getRes());
						this.toByteArray(d3,"Signo incorrecto");					
						}	
				}
				//Si recibimos un quit, salimos
				else if (d.getComando().equals(Mensajes.QUIT)){
					estado=2;
				}
				
			}
			else
		if(estado==2){
		Datos d4 = new Datos(Mensajes.QUIT,d.getUsuario(),d.getOp1(),d.getOp2(),d.getSigno(),d.getRes());
		this.toByteArray(d4, "Has salido del servicio");
		salida=true;	
		}
		
		} while (salida=false);
	}
	
	
	
	public void toByteArray(Datos data)
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream(20);
		DataOutputStream dos = new DataOutputStream(bos);
		
		try {
			dos.writeUTF(data.getComando());
			dos.writeUTF(data.getUsuario());
			dos.writeDouble(data.getRes());
			dos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void toByteArray(Datos dat, String cad)
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream(20);
		DataOutputStream dos = new DataOutputStream(bos);
		
		try {
			dos.writeUTF(dat.getComando());
			dos.writeUTF(dat.getUsuario());
			dos.writeUTF(cad);
			dos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean tieneNumero(String word){
		if(word.contains("1"))
			return true;
		else if (word.contains("2"))
			return true;
		else if (word.contains("3"))
			return true;
		else if (word.contains("4"))
			return true;
		else if (word.contains("5"))
			return true;
		else if(word.contains("6"))
			return true;
		else if	(word.contains("7"))
			return true;
		else if	(word.contains("8"))
			return true;
		else if	(word.contains("9"))
			return true;
		else if	(word.contains("0"))
	return true;
else
	return false;
	
}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	

}
