package train.model;



import train.exception.WagonPositionException;
import train.exception.WagonTypeException;

public class Train {
	
	private String locomotive;
	private StringBuilder locomotive2String;
	
	public Train(String locomotive){
		super();
		validate(locomotive);
		this.locomotive = locomotive.toUpperCase();
	}
	
	private void validate(String str) {
		str = str.toUpperCase();
		char c;
		
		for(int i=0; i<str.length(); i++) {
			c = str.charAt(i);
			if(c!='H' && c!='P' && c!='R' && c!='C' )
					throw new WagonTypeException("Type wagon not valid!");
			if(c == 'H' &&  i != 0 && i != str.length()-1)
				throw new WagonPositionException("error position type H in string");
		} 
	}
	
	public String print() {
		StringBuilder stringBuilder = new StringBuilder();
		char curr;
		boolean isHead = true;
		
		for(int i=0; i<this.locomotive.length(); i++) {
			curr = this.locomotive.charAt(i);
			if(i==this.locomotive.length()-1)
				isHead = false;	
			switch(curr) {
				case 'H':{
							if(isHead) stringBuilder.append("<HHHH::");
							if(!isHead) stringBuilder.append("HHHH>"); 
							break;
						 }
				case 'P':{ stringBuilder.append("|OOOO|::"); break; } 
				case 'R':{ stringBuilder.append("|hThT|::"); break; } 
				case 'C':{ stringBuilder.append("|____|::"); break; }
				case 'N':{ stringBuilder.append("|^^^^|::"); break;}
			}	
		}
		
		String s = stringBuilder.substring(stringBuilder.length()-2, stringBuilder.length()).toString();
		if(s.equals("::"))
			stringBuilder.delete(stringBuilder.length()-2, stringBuilder.length());
		
		this.locomotive2String = stringBuilder;
		return stringBuilder.toString();
	}
	
	public boolean fill() {
		if(this.locomotive.contains("C")) {
			this.locomotive = this.locomotive.replaceFirst("C", "N");
			return true;
		}
		return false;
	}

	public void detachEnd() {
		if(this.locomotive.length() > 0) {
			this.locomotive = this.locomotive.substring(0, this.locomotive.length()-1);
		}
			
	}

	public void detachFront() {
		if(this.locomotive.length() > 0)
			this.locomotive = this.locomotive.substring(1);
		
	}
	
	public static void main(String[]args) throws WagonTypeException, WagonPositionException {
		Train t = new Train("HCPPCPCPCPH");
		System.out.println(t.print());
		t.detachEnd();
		System.out.println(t.print());
		t.detachFront();
		t.fill();
		System.out.println(t.print());
		t.fill();
		System.out.println(t.print());
		t.fill();
		System.out.println(t.print());
		
	}
}
