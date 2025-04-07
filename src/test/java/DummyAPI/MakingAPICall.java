package DummyAPI;

import java.util.*;
import java.util.HashMap;
import java.util.stream.Stream;

import javax.imageio.IIOException;

import java.util.Arrays;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequest.NewContextOptions;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.junit.UsePlaywright;

import base.BaseComponent;
import junit.framework.Assert;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
@UsePlaywright
public class MakingAPICall  {
	private static APIRequestContext requestContext;
	public static Playwright playwright=Playwright.create();
	public static APIResponse response;
	static String name;
	static double salary;
	public static JsonObject productJson;
	public static void SetupRequestContext() {
		requestContext=playwright.request().newContext(new NewContextOptions().setBaseURL("https://reqres.in")
				.setExtraHTTPHeaders(new HashMap<>() {{ put("Accept","application/json");
				}})
		
		);		
			
		}
	public static void getstatus() {
	    response=requestContext.get("/api/users?page=2");
		int status=response.status();
		System.out.println(status);
		Assert.assertEquals(status,200);
	}
	public static Stream<Object> getMessage() {
		JsonObject jsonObject=new Gson().fromJson(response.text(), JsonObject.class);
		int Messagestatus=jsonObject.get("page").getAsInt();
		Assert.assertEquals(2,Messagestatus);
		System.out.println(Messagestatus);
		JsonArray data=jsonObject.getAsJsonArray("data");
//		productJson=data.getAsJsonObject();
//		JsonObject propertiesJson = productJson.get(0);
//		String value = propertiesJson.getString("first_name");
		return data.asList().stream().
				map(jsonElement ->{
			 productJson=jsonElement.getAsJsonObject();
			 name=productJson.get("first_name").getAsString();
			 salary=productJson.get("id").getAsDouble();
//			 Assert.assertEquals("Tiger Nixon",name);
//			 Assert.assertEquals("320800",salary);
			return data;
		});
	}
	public static void nameandsalary() {
		System.out.println(name);
		 System.out.println(salary);
	}
}
