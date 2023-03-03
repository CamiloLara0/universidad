package conversor;

public class Conversor {
private Moneda entrada=new Moneda();
private double convertido,temperatura;


public double ConvertirMoneda(String a, double cambio) {
	switch(a){
	case "pesos a dolar":
		convertido=cambio/entrada.getDolar();
		break;
	case "pesos a euro":
		convertido=cambio/entrada.getEuro();
		break;
	case "pesos a libras":
		convertido=cambio/entrada.getLibra();
		break;
	case "pesos a yen":
		convertido=cambio/entrada.getYen();
		break;
	case "pesos a won":
		convertido=cambio/entrada.getWon();
		break;
	case "dolar a pesos":
		convertido=entrada.getDolar()*cambio;
		break;	
	case "euro a pesos":
		convertido=entrada.getEuro()*cambio;
		break;	
	case "libras a pesos":
		convertido=entrada.getLibra()*cambio;
		break;	
	case "yen a pesos":
		convertido=entrada.getYen()*cambio;
		break;		
	case "won a pesos":
		convertido=entrada.getWon()*cambio;
		break;
	}
	convertido=Math.round(convertido*100.0)/100.0;
	return convertido;
}

public double convertirTemperatura(String a, double b) {
	switch(a) {
	case "Celsius a Fahrenheit":
		temperatura = (b  * 9/5) + 32;
		break;
	case "Celsius a Kelvin":
		temperatura = b+273.15;
		break;
	case "Fahrenheit a celsius":
		temperatura = (b-32)*(5/9);
		break;
	case "Fahrenheit a Kelvin":
		temperatura=((b-32)*(5/9))+273.15;
		break;
	case "Kelvin a Fahrenheit":
		temperatura=( b - 273.15) * 9/5 + 32 ;
		break;
	case "Kelvin a Celsius":
		temperatura = b-273.15 ;
		break;
	}
	return temperatura;
}


}
