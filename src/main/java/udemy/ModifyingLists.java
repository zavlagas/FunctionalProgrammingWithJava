package udemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ModifyingLists {

    public static void main(String[] args) {
        List<String> courses =
                List.of("Spring","SpringBoot", "API" , "Microservices"
                        , "AWS" , "PCF" , "Azure" , "DockerSpring" ,"Kubernetes" );


//        ReplaceAll

        List<String> modifiedList = new ArrayList<>(courses);

        modifiedList.replaceAll( str -> str.toUpperCase());

        System.out.println(modifiedList);

//        RemoveIf

        modifiedList.removeIf( course -> course.length() < 6);

        System.out.println(modifiedList);

    }
}
