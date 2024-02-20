package Complex;

public class Complex implements ComplexMathMethods{
	private double real;
	private double imag;
	
	public Complex(){
		real=0;
		imag=0;
	}
	public Complex(double Real, double Imag){
		real=Real;
		imag=Imag;
	}
	
	//math methods
	//base methods
	//debugged
	@Override
	public Complex add(Complex z){
		return new Complex(this.real+z.getReal(), this.imag+z.getImag());
	}
	public Complex sub(Complex z){
		return new Complex(this.real-z.getReal(), this.imag-z.getImag());
	}
	//debugged
	@Override
	public Complex mult(Complex z){
		return new Complex(this.real*z.getReal()-this.imag*z.getImag(), this.real*z.getImag()+this.imag*z.getReal());
	}
	//debugged
	@Override
	public Complex div(Complex z){
		double temp=z.getReal()*z.getReal()+z.getImag()*z.getImag();
		Complex temp1=this.mult(z.getConjugate());
		return new Complex(temp1.getReal()/temp, temp1.getImag()/temp);
	}
	//debugged
	@Override
	public Complex pow(double val){
		double tetta=this.getArg()*val;
		double module=Math.pow(this.module(), val);
		return new Complex(module*Math.cos(tetta), module*Math.sin(tetta));
	}
	//debugged
	@Override
	public Complex pow(Complex z){
		Complex w=(new Complex(Math.log(this.module()), this.getArg())).mult(z);
		double temp=Math.pow(Math.E, w.getReal());
		return new Complex(Math.cos(w.getImag())*temp, Math.sin(w.getImag())*temp);
	}
	
	//trigonometric methods
	@Override
	public Complex sin(){
		return new Complex(Math.sin(this.getReal())*Math.cosh(this.getImag()), Math.cos(this.getReal())*Math.sinh(this.getImag()));
	}
	@Override
	public Complex cos(){
		return new Complex(Math.cos(this.getReal())*Math.cosh(this.getImag()), (-1)*Math.sin(this.getReal())*Math.sinh(this.getImag()));
	}
	@Override
	public Complex sec(){
		return (new Complex(1, 0)).div(this.cos());
	}
	@Override
	public Complex csc(){
		return (new Complex(1, 0)).div(this.sin());
	}
	@Override
	public Complex tan(){
		return (this.sin()).div(this.cos());
	}
	@Override
	public Complex cot(){
		return (this.cos()).div(this.sin());
	}
	
	//hyperbolic Methods
	@Override
	public Complex sinh(){
		return new Complex(Math.sinh(this.getReal())*Math.cos(this.getImag()), Math.cosh(this.getReal())*Math.sin(this.getImag()));
	}
	@Override
	public Complex cosh(){
		return new Complex(Math.cosh(this.getReal())*Math.cos(this.getImag()), Math.sinh(this.getReal())*Math.sin(this.getImag()));
	}
	@Override
	public Complex sech(){
		return (new Complex(1, 0)).div(this.cosh());
	}
	@Override
	public Complex csch(){
		return (new Complex(1, 0)).div(this.sinh());
	}
	@Override
	public Complex tanh(){
		return (this.sinh()).div(this.cosh());
	}
	@Override
	public Complex coth(){
		return (this.cosh()).div(this.sinh());
	}
	
	//inverse trigonometric methods
	@Override
	public Complex asin(){
		Complex sqrOfZ2=((new Complex(1, 0)).sub(this.pow(2))).pow(0.5);
		Complex arcsin=(((this.mult(new Complex(0, 1))).add(sqrOfZ2)).log()).mult(new Complex(0, -1));
		return arcsin;
	}
	@Override
	public Complex acos(){
		Complex sqrOfZ2=(this.add((this.pow(2).sub(new Complex(1, 0)))).pow(0.5)).log();
		Complex arccos=(new Complex(0, -1)).mult(sqrOfZ2);
		return arccos;
	}
	@Override
	public Complex asec(){
		Complex sqrOfZ2=(((new Complex(1, 0)).sub(this.pow(2))).pow(0.5)).add(new Complex(1, 0));
		Complex temp=(sqrOfZ2.div(this)).log();
		return temp.mult(new Complex(0, -1));
	}
	@Override
	public Complex acsc(){
		Complex sqrOfZ2=((this.pow(2)).sub(new Complex(1, 0))).pow(0.5).add(new Complex(0, 1));
		Complex temp=(sqrOfZ2.div(this)).log();
		return temp.mult(new Complex(0, -1)); 
	}
	@Override
	public Complex atan(){
		Complex iz=this.mult(new Complex(0, 1));
		Complex temp=((iz.add(new Complex(1, 0))).div((new Complex(1, 0)).sub(iz))).log();
		return temp.mult(new Complex(0, -0.5));
	}
	@Override
	public Complex acot(){
		Complex iz=this.mult(new Complex(0, 1));
		Complex temp=((iz.sub(new Complex(1, 0))).div(iz.add(new Complex(1, 0)))).log();
		return temp.mult(new Complex(0, -0.5));
	}
	
	//inverse hyperbolic methods
	@Override
	public Complex arsin(){
		return ((((this.pow(2)).add(new Complex(1, 0))).pow(0.5)).add(this)).log();
	}
	@Override
	public Complex arcos(){
		return ((((this.pow(2)).sub(new Complex(1, 0))).pow(0.5)).add(this)).log();
	}
	@Override
	public Complex arsec(){
		Complex chisl=(((new Complex(1, 0)).sub(this.pow(2))).pow(0.5)).add(new Complex(1, 0));
		return ((chisl.div(this)).log()).mult(new Complex(-1, 0));
	}
	@Override
	public Complex arcsc(){
		Complex chisl=(((this.pow(2)).sub(new Complex(1, 0))).pow(0.5)).add(new Complex(0, 1));
		return ((chisl.div(this)).log()).mult(new Complex(-1, 0));
	}
	@Override
	public Complex artan(){
		Complex temp=((this.add(new Complex(1, 0))).div((new Complex(1, 0)).sub(this))).log();
		return temp.mult(new Complex(0.5, 0));
	}
	@Override
	public Complex arcot(){
		Complex temp=((this.add(new Complex(1, 0))).div(this.sub(new Complex(1, 0)))).log();
		return temp.mult(new Complex(0.5, 0)); 
	}
	
	//log base e
	@Override
	public Complex log(){
		return new Complex(Math.log(this.module()), this.getArg());
	}
	//debugged
	@Override
	public double module(){
		return Math.sqrt(this.real*this.real+this.imag*this.imag);
	}
	//debugged
	@Override
	public double getArg(){
		double tetta=Math.atan(this.imag/this.real);
		if(this.real>0)
			return tetta;
		else if(this.imag>0)
			return tetta+Math.PI;
		else
			return tetta-Math.PI;
	}
	@Override
	public Complex getConjugate(){
		return new Complex(this.real, this.imag*(-1));
	}
	
	//setters
	public void setReal(double val){
		this.real=val;
	}
	public void setImag(double val){
		this.imag=val;
	}
	//getters
	public double getReal(){
		return this.real;
	}
	public double getImag(){
		return this.imag;
	}
	
	//object methods
	@Override
	public String toString(){
		if(this.imag>0)return "("+this.real+"+"+this.imag+"i)";
		return "("+this.real+""+this.imag+"i)";
	}
	@Override
	public boolean equals(Object c){
		if(!(c instanceof Complex))throw new IllegalArgumentException("can't compare "+c.getClass()+" and Complex.Complex value");
		if(this.getReal()==((Complex)c).getReal() && this.getImag()==((Complex)c).getImag())return true;
		else return false;
	}
	//parser
	//debugged
	public static Complex parseComplex(String compl1){
		String compl=compl1.replace(" ", "").replace("i", "");
		int temp=compl.length()-compl.replace("-", "").length();
		double Real=0.0d;
		double Imag=0.0d;
		switch(temp){
			case 2:
				Real=Double.parseDouble(compl.substring(0, compl.indexOf('-', 1)));
				Imag=Double.parseDouble(compl.substring(compl.indexOf('-', 1)));
				break;
			case 1:
				if(compl.charAt(0)=='-'){
					Real=Double.parseDouble(compl.substring(0, compl.indexOf('+')));
					Imag=Double.parseDouble(compl.substring(compl.indexOf('+')));
				}
				else{
					Real=Double.parseDouble(compl.substring(0, compl.indexOf('-')));
					Imag=Double.parseDouble(compl.substring(compl.indexOf('-')));
				}
				break;
			case 0:
				Real=Double.parseDouble(compl.substring(0, compl.indexOf('+')));
				Imag=Double.parseDouble(compl.substring(compl.indexOf('+')));
				break;
		}
		return new Complex(Real, Imag);	
	}
}