package com.glab30956.sp8;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class PathVariableController {

    /* Binding a URI template variable
    to a method parameter using 'name' or 'value'
    attribute of @PathVariable  */
    @GetMapping("/request1/{name}")
    @ResponseBody
    public String handler(
            @PathVariable(name = "name") String name){
        return "    <h1>Request 1</h1> <br> " + "   URL parameter name: " + name;
    }


    /* Binding URI template variables to method parameters
    without using 'name' or 'value' attribute of @PathVariable.   */
    @GetMapping("/request2/{firstName}/{lastName}")
    @ResponseBody
    public String handler(
            @PathVariable String firstName,
            @PathVariable String lastName){
        return "<h1>Request 2</h1> <br>" + "URL parameters - <br> " +
                " firstName = " + firstName + " <br>" +
                " lastName = " + lastName;
    }

    /*  If the method parameter type is not String then Spring automatically
    converts to the appropriate type such as int, long, float, etc.   */
    @GetMapping("/request3/{name}/{age}/{salary}/{active}")
    @ResponseBody
    public String handler(
            @PathVariable("name") String name,
            @PathVariable("age") int age,
            @PathVariable("salary") double salary,
            @PathVariable("active") boolean active){
        return "<h1>Request 3</h1> <br>" + " name = "+
        name + " <br>" + " age = " + age + " <br>" +
                " salary = " + salary + "<br>" + " active = " + active;
    }

    /* Binding all URI template variables to Map  */
    @GetMapping("/request4/{name}/{age}/{address}/{city}/{country}")
    @ResponseBody
    public String handler(
            @PathVariable Map<String , String> params){
        StringBuilder builder = new StringBuilder();
        builder.append("<h1>Request 4</h1>" + "URL paramters - <br>" );
        for (Map.Entry<String, String> entry : params.entrySet()){
            builder.append(entry.getKey() + " = " + entry.getValue() + " <br>");
        }
        return builder.toString();
    }


    /*Binding date and time URL template variable to LocalDate and LocalTime   */
    @GetMapping("/request5/{date}/{time}")
    @ResponseBody
    public String handler(
            @DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable("date") LocalDate date,
            @DateTimeFormat(pattern = "HH:mm:ss") @PathVariable("time") LocalTime time){
        return "<h1>Request 5</h1> <br>" + "URL parameters - <br>" +
                " date = " + date + " <br> " + " time = " + time;
    }

    /*Binding URI template variable to array and list  */
    @GetMapping("/request6/{country}/{city}")
    @ResponseBody
    public String handler(
            @PathVariable("country") String[] country,
            @PathVariable("city") List<String> city) {
                return "<h1>Request 6</h1> <br>" + "URL parameters - <br>" +
                        " country = " + Arrays.asList(country) + " <br>" + "city = "
                        + city;
    }

}
