package ejercicio1;

import java.io.*;



public class Mensajes {
	//PDU formada por: Version+secuencia+tipo+comando+payload
	
	//Comandos utilizados en el protocolo
	public static final String CRLF="\r\n";
	public static final String OK="+OK";
	public static final String ERR="-ERR";
	public static final String QUIT="QUIT";
	//Tipos de mensajes
	public static final byte MSG_LOGIN=0x01; 
	public static final byte MSG_OPERACION=0x02;
	public static final byte MSG_FIN=0X04;
	
	protected int secuencia=0;
	protected static final byte version=1,tipo=0;
	private boolean salida=false;
	private String mensaje = "",cmd="";
	private byte v,type;
	private Datos data=null;

	
	/**
	 * @param d Datos que recibe el constructor por defecto
	 */
	public Mensajes(Datos d){
		data=d;
				
		do {
		//Si recibimos un mensaje del tipo login
		if(this.getType()==1){		
			//Comprobamos que se recibe un mensaje OK
			if(this.getCmd().equals(Mensajes.OK)){
				//Comprobamos si el usuario y la contraseña cumplen nuestras condiciones
				if(this.tieneNumero(data.getUsuario())==true && data.getUsuario().length()>=6 && data.getUsuario().length()<=12 && data.getContraseña().length()>=6){
			this.toByteArray(data, "Selecciona operacion");
			secuencia++;
				}
				else {
					Datos d1 = new Datos(data.getUsuario(),data.getContraseña());
					this.toByteArray(d1, "Usuario y/o contraseña no validos");
					secuencia++;
				}
			}
			// Si el comando recibido no es OK mandamos un mensaje de error
			else {
				Datos d2 = new Datos(data.getUsuario(),data.getContraseña());
				this.toByteArray(d2,"Error en el login");
				secuencia++;
			}
		} else 
			//Si recibimos un mensaje de tipo operacion
			if(this.getType()==2){
				//Si recibimos un OK
				if(this.getCmd()==Mensajes.OK){
					//Si quiere realizar una suma
					if(data.getSigno().equals("+")){
						Servicios s = new Servicios(data.getOp1(),data.getOp2());
						Datos dat = new Datos(data.getUsuario(),data.getOp1(),data.getOp2(),data.getSigno(),s.Suma());
						this.toByteArray(dat);
						secuencia++;
					}
					else 
					//Si quiere realizar una resta
					if(d.getSigno().equals("-")){
						Servicios s = new Servicios(data.getOp1(),data.getOp2());
						Datos dat = new Datos(data.getUsuario(),data.getOp1(),data.getOp2(),data.getSigno(),s.Resta());
						this.toByteArray(dat);
						secuencia++;
					}
					//Si el signo es incorrecto enviamos mensaje de error
					else{
						Datos d3 = new Datos(data.getUsuario());
						this.toByteArray(d3,"Signo incorrecto");
						secuencia++;
						}	
				}
				
			}
			else
				//Si recibimos mensaje de tipo fin salimos
		if(this.getType()==4){
		Datos d4 = new Datos(data.getUsuario());
		this.toByteArray(d4, "Has salido del servicio");
		salida=true;	
		}
		
		} while (salida=false);
	}
	
	
/**
 * @param datos bytes que se reciben
 * @throws ExcepcionDatos Excepcion que se lanza en caso de error
 */
public Mensajes (byte[] datos) throws ExcepcionDatos{
		
		ByteArrayInputStream bais = new ByteArrayInputStream(datos); 
		DataInputStream dis = new DataInputStream(bais);
		
		try {
			this.v=dis.readByte();
			this.secuencia=dis.readInt();
			this.type=dis.readByte();
			this.cmd=dis.readUTF();
			Datos dat=new Datos(dis,type);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ExcepcionDatos("Formato Invalido");
		}
		
	}
	
	
	/**
	 * @param data datos que queremos pasar a bytes
	 */
	public byte[] toByteArray(Datos data)
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream(29);
		DataOutputStream dos = new DataOutputStream(bos);
		
		try {
			dos.write(version);
			dos.writeInt(secuencia);
			dos.write(tipo);
			dos.writeUTF(cmd);
			dos.write(data.toByteArray(data));
			dos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
		byte[] bytes =  bos.toByteArray(); // devuelve byte[]
		return bytes;
	}
	
	/**
	 * @param dat datos que queremos pasar a bytes
	 * @param cad cadena de caracteres que complementa a los datos
	 */
	public byte[] toByteArray(Datos dat, String cad)
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream(41);
		DataOutputStream dos = new DataOutputStream(bos);
		
		try {
			dos.write(version);
			dos.writeInt(secuencia);
			dos.write(tipo);
			dos.writeUTF(cmd);
			dos.write(data.toByteArray(data));
			dos.writeUTF(cad);
			dos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
		byte[] bytes =  bos.toByteArray(); // devuelve byte[]
		return bytes;
	}
	
	
	
	
	
	/**
	 * @param word String que pasamos para comprobar si contiene algun numero
	 * @return True si contiene algun numero el String, False si no lo lleva
	 */
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
	
	/**
	 * @return devuelve el valor de la variable mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}
	
	
	/**
	 * @return el tipo de mensaje
	 */
	public byte getType() {
		return type;
	}


	/**
	 * @return el comando
	 */
	public String getCmd() {
		return cmd;
	}




}
