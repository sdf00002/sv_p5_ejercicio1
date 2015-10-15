package ejercicio1;


/**
 * @author Sergio
 *
 */
public class Servicios {
	
	protected double ope1;
	protected double ope2;
	protected double res;
	
	
	/**
	 * @param dato1 Recibe un dato1 que lo asignaremos al ope1
	 * @param dato2 Recibe un dato2 que lo asignaremos al ope2
	 */
	public Servicios (double dato1,double dato2){
		this.ope1= dato1;
		this.ope2=dato2;	
	}
		
	
	/**
	 * @return una variable con el resultado de la suma de los 
	 * operandos
	 */
	public double Suma(){
		res=this.getOpe1()+this.getOpe2();
		return res;
	}
	
	
	/**
	 * @return una variable con el resultado de la resta 
	 * de los operandos
	 */
	public double Resta(){
		res=this.getOpe1()-this.getOpe2();
		return res;
	}
		


	/**
	 * @return el operador 1
	 */
	public double getOpe1() {
		return ope1;
	}



	/**
	 * @param ope1 Asigna este valor al operador 1
	 */
	public void setOpe1(double ope1) {
		this.ope1 = ope1;
	}



	/**
	 * @return el operador 2
	 */
	public double getOpe2() {
		return ope2;
	}



	/**
	 * @param ope2 Asigna este valor al operador 2
	 */
	public void setOpe2(double ope2) {
		this.ope2 = ope2;
	}



	/**
	 * @return el valor de la variable res
	 */
	public double getRes() {
		return res;
	}



	/**
	 * @param res Asigna el valor dado a la variable resultado
	 */
	public void setRes(double res) {
		this.res = res;
	}


}
