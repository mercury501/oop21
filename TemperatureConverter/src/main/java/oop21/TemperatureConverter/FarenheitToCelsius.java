package oop21.TemperatureConverter;

public class FarenheitToCelsius {

	public static void fnhtocls(String[] args) {
		float fnh = Float.parseFloat(args[0]);
		float cls = (fnh - 32) * 5 / 9;
		System.out.println(fnh + " Farenheit correspond to " + cls + " degrees Celsius.");

	}
}
