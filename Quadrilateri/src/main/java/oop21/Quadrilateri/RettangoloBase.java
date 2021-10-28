package oop21.Quadrilateri;

import static org.apache.commons.codec.digest.MessageDigestAlgorithms.SHA3_512;
import org.apache.commons.codec.digest.DigestUtils;

public class RettangoloBase {

		double Base;
		double Altezza;
		
		public RettangoloBase(double alt, double bas) {
			this.Altezza = alt;
			this.Base = bas;
		}
		
		public double getAltezza() {
			return Altezza;
		}
		
		public double getBase() {
			return Base;			
		}
		
		public void setAltezza(double alt) {
			this.Altezza = alt;
		}
		
		public void setBase(double bas) {
			this.Base = bas;
		}
		
		public double area() {
			return (this.Altezza * this.Base);
		}
		
		public double perimetro() {
			return ((this.Altezza * 2) + (this.Base * 2));
		}

		@Override
		public boolean equals(Object obj) {
			if (obj  instanceof RettangoloBase) {
				RettangoloBase t = (RettangoloBase) obj;
				if (this.Base == t.Base && this.Altezza == t.Altezza) {
					return true;
				}
				else if (this.Base == t.Altezza && this.Altezza == t.Altezza) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		
		@Override
		public String toString() {
			return "Sono un rettangolo di area:  " + this.area();
		}
		
		public String hashClass() {
			String hashed = new DigestUtils(SHA3_512).digestAsHex(this.toString().getBytes());
			return hashed;
		}
		
		public String serializza() {
			String srl = org.apache.commons.codec.binary.Base64.encodeBase64(this.toString().getBytes()).toString();
			return srl;
		}
}

