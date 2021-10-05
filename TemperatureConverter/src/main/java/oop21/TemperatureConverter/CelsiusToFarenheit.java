package oop21.TemperatureConverter;

public class CelsiusToFarenheit {

	public static void main(String[] args) {
		float cls = Float.parseFloat(args[0]);
		float fnh = (cls * 9 / 5) + 32;
		System.out.println(cls + " degrees Celsius correspond to " + fnh + " Farenheit.");

	}
}
