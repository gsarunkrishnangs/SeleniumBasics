package dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider (name = "InvalidUserCredentials")
	
	public Object[][] userCredentialsData() {
		
		Object[][] data = new Object[3][2];
		
		data[0][0] = "gsarunkrishnangs123456789@gmail.com";
		data[0][1] = "arun@123";
		
		data[1][0] = "gsarunkrishnangs12345678@gmail.com";
		data[1][1] = "arun@1234";
		
		data[2][0] = "gsarunkrishnangs123456789@gmail.com";
		data[2][1] = "arun@1234";
		
		return data;
	}
}
