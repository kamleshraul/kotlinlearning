package  com.codekam.javaiterop;

import java.util.HashMap;
import java.util.Map;

public class JavaApplication{

    public static void callingKotlinFromJava(){
        User user = new User();
        user.setFirstName("Rohit");
        user.setLastName("Sharma");

        Address address= new Address("Borivili west",
                "Khau galli"
                ,"Mumbai"
                ,"Maharashtra"
                ,"400008"
                ,AddressType.Shipping
                );
        UserExtensions.addOrUpdateAddress(user,address);
        LabelPrinterKt.printLabelFor(user,AddressType.Shipping);

        Address.JSONKeys kesy= Address.JSONKeys.INSTANCE;

        Map<String,Object> addressJson= new HashMap<String,Object>();
        addressJson.put(kesy.streetline1,address.streetline1);
    }

    public static void main(String[] args) {
        callingKotlinFromJava();
    }
}