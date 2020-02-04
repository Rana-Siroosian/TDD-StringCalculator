
public class StringCalculator {
	Splitter splitter;
	public StringCalculator() {
		splitter = new Splitter();
	}
	 

	public int add(String string) {
		// TODO Auto-generated method stub
		if("".contentEquals(string))
			return 0;
		String[] values = splitter.split(string);
	
		checkNegatives(values);
		
		return addSum(values);
	}

	private void checkNegatives(String[] values) {
		String negative = "";
		for (String value: values) {
			if(value.contains("-"))
				negative += ","+value;
		}
		if(!"".equals(negative))
			throw new RuntimeException("negatives not allowed= " + 
					negative.substring(1));
	}


	private int addSum(String[] values) {
		int sum=0;
		for (String value : values) {
//			
			if(toInteger(value)>1000) {
				continue;
			}
			if(value.startsWith("[")|| value.contains("%")||value.endsWith("]")||
					value.contains("//[")) {
				sum+=toInteger(value);}
		sum+=toInteger(value);

		}
		return sum;
	}
	
	private int toInteger(String value) {
		return Integer.valueOf(value);
	}

}
