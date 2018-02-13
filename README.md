# learningspring
A demo Spring Web project 

When creating a new project it’s probably a good idea to add web, lombok and security using Spring Initializr https://start.spring.io/
- After generating the demo project and download.
- Extract files to your project folder (if you are using CVS this would be a good moment to add the files to your clone empty repo folder).
- Open Intellij Idea
- Go to File
- Select New 
- Select Project From Existing Sources
- Select maven if that’s the build automation tool you are using
- And follow the the config steps only adding options that you need or removing options that you don’t need.
- Wait for the the project to generate you source files and presto congrats you now have your first Spring Boot Project 

Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run". We take an opinionated view of the Spring platform and third-party libraries so you can get started with minimum fuss. Most Spring Boot applications need very little Spring configuration.
- Spring reactive & servlet based apps on the JVM
- Lombok: Project Lombok is a java library that automatically plugs into your editor and build tools, spicing up your java.
Never write another getter or equals method again. Early access to future java features such as val, and much more.
-Apache Tomcat, is an open source web server and servlet container developed by the Apache Software Foundation. Basically, it implements the Java Servlet and the JavaServer Pages (JSP) specifications from Sun Microsystem, and provides a "pure Java" HTTP web server environment for Java code to run in. In the simplest configuration Tomcat runs in a single operating system process. The process runs a Java virtual machine (JVM) and every single HTTP request from a browser to Tomcat is processed in the Tomcat process in a separate thread. Apache Tomcat includes tools for configuration and management, but can also be configured by editing XML configuration files.
- Maven is basically a Project Management Tool. It simplifies and standardizes the project built process by allowing the developer to automate the process of creation of the initial folder structure for their Java Applications. Maven is considered to be an advanced built tool in the sense that it performs on its own the compilation, testing, packaging and deployment of the final product.
Maven reduces the efforts of the developer by providing developers ways to manage documentation, reporting, dependencies, building, testing and releasing.

Building an MVC Todo List APP with API requests to Google Calendar as a bonus
ControllerLayer Handles HTTP methods 
ServiceLayer Logic
DAO (data access object) Data Access
Folders created controller, entity, repository, services and dao

Use Lombok to generate getters and setters
Make sure you add your Lombok to your project POM 
Now to add a getter or a setter to  an object you have to add the annotations @Getter and @Setter above the object or before the class to ensure that all the variables in the class have getter and  setters generated for them 
E.g. 
@Getter
@Setter
public class User {

Usage
A Map is an object that maps keys to values. A map cannot contain duplicate keys: Each key can map to at most one value. 
private static Map<Integer, User> users;
E.g.
import java.util.*;
public class CollectionsDemo {


   public static void main(String[] args) {
       Map m1 = new HashMap();
       m1.put("Zara", "8");
       m1.put("Mahnaz", "31");
       m1.put("Ayan", "12");
       m1.put("Daisy", "14");


       System.out.println();
       System.out.println(" Map Elements");
       System.out.print("\t" + m1);
   }
}









Appendix

A JavaBean is just a standard (http://www.oracle.com/technetwork/java/javase/documentation/spec-136004.html)                                                                                        All properties private (use getters/setters)
A public no-argument constructor
Implements Serializable.
That's it. It's just a convention. Lots of libraries depend on it though....

With respect to Serializable, from the API documentation:

Serializability of a class is enabled by the class implementing the java.io.Serializable interface. Classes that do not implement this interface will not have any of their state serialized or deserialized. All subtypes of a serializable class are themselves serializable. The serialization interface has no methods or fields and serves only to identify the semantics of being serializable.

In other words, serializable objects can be written to streams, and hence files, object databases, anything really.

Also, there is no syntactic difference between a JavaBean and another class -- a class defines a JavaBean if it follows the standards.

There is a term for it because the standard allows libraries to programmatically do things with class instances you define in a predefined way. For example, if a library wants to stream any object you pass into it, it knows it can because your object is serializable (assuming the lib requires your objects be proper JavaBeans).
















An interface is a special form of an abstract class which does not implement any methods. In Java, you create an interface like this:

interface Interface
{
    void interfaceMethod();
}
Since the interface can't implement any methods, it's implied that the entire thing, including all the methods, are both public and abstract (abstract in Java terms means "not implemented by this class"). So the interface above is identical to the interface below:

public interface Interface
{
    abstract public void interfaceMethod();
}
To use this interface, you simply need to implement the interface. Many classes can implement an interface, and a class can implement many interfaces:

interface InterfaceA
{
     void interfaceMethodA();
}

interface InterfaceB
{
    void interfaceMethodB();
}


Simple Logging Facade for Java (SLF4J) : The Simple Logging Facade for Java (SLF4J) serves as a simple facade or abstraction for various logging frameworks (e.g. java.util.logging, logback, log4j) allowing the end user to plug in the desired logging framework at deployment time (@Slf4j) 


Spring 
Dependency injection - Basically, instead of having your objects creating a dependency or asking a factory object to make one for them, you pass the needed dependencies in to the object externally, and you make it somebody else's problem. This "someone" is either an object further up the dependency graph, or a dependency injector (framework) that builds the dependency graph. A dependency as I'm using it here is any other object the current object needs to hold a reference to. As of Spring 2.5 it is possible to configure the dependency injection via annotations. If you structure your code as suggested above (locating your application class in a root package), you can add @ComponentScan without any arguments. All of your application components (@Component, @Service, @Repository, @Controller etc.) will be automatically registered as Spring Beans.
@Value will be a reference to a property made reference to in application.properties
 e.g. @Value("${navigation.id.top-level}")
	private Long topNavigationParentId;
@Controller
Indicates that an annotated class is a "Controller" (e.g. a web controller).
This annotation serves as a specialization of @Component, allowing for implementation classes to be autodetected through classpath scanning. It is typically used in combination with annotated handler methods based on the RequestMapping annotation. 
E.g. @Controller
@RequestMapping
Annotation for mapping web requests onto methods in request-handling classes with flexible method signatures.
Both Spring MVC and Spring WebFlux support this annotation through a RequestMappingHandlerMapping and RequestMappingHandlerAdapter in their respective modules and package structure. For the exact list of supported handler method arguments and return types in each, please use the reference documentation links below:
Spring MVC Method Arguments and Return Values
Spring WebFlux Method Arguments and Return Values
Note: This annotation can be used both at the class and at the method level. In most cases, at the method level applications will prefer to use one of the HTTP method specific variants @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, or @PatchMapping.
NOTE: When using controller interfaces (e.g. for AOP proxying), make sure to consistently put all your mapping annotations - such as @RequestMapping and @SessionAttributes - on the controller interface rather than on the implementation class.
@Autowired
Marks a constructor, field, setter method or config method as to be autowired by Spring's dependency injection facilities.
Only one constructor (at max) of any given bean class may carry this annotation, indicating the constructor to autowire when used as a Spring bean. Such a constructor does not have to be public.
@PathVariable
Annotation which indicates that a method parameter should be bound to a URI template variable. Supported for RequestMapping annotated handler methods in Servlet environments.
If the method parameter is Map<String, String> or MultiValueMap<String, String> then the map is populated with all path variable names and values
@Repository
Indicates that an annotated class is a "Repository", originally defined by Domain-Driven Design (Evans, 2003) as "a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects".
The goal of Spring Data repository abstraction is to significantly reduce the amount of boilerplate code required to implement data access layers for various persistence stores.
Connecting to an H2 internal database using Spring and JPA
http://javasampleapproach.com/spring-framework/spring-boot/integrate-h2-database-springboot-spring-jpa-embedded-mode
From What's this "serialization" thing all about?:
It lets you take an object or group of objects, put them on a disk or send them through a wire or wireless transport mechanism, then later, perhaps on another computer, reverse the process: resurrect the original object(s). The basic mechanisms are to flatten object(s) into a one-dimensional stream of bits, and to turn that stream of bits back into the original object(s).
Like the Transporter on Star Trek, it's all about taking something complicated and turning it into a flat sequence of 1s and 0s, then taking that sequence of 1s and 0s (possibly at another place, possibly at another time) and reconstructing the original complicated "something.
Creating a Simple Web App With Java 8, SpringBoot, and Angular
https://dzone.com/articles/java-8-springboot-angularjs-bootstrap-springdata-j
Web App Architecture - the Spring MVC - AngularJs stack
https://blog.angular-university.io/developing-a-modern-java-8-web-app-with-spring-mvc-and-angularjs/
Use Angular4

Glossary
Routing 
Routing ties into:
How people see your site.
How search engines see your site.
with server-side routing you download an entire new webpage whenever you click on a link,
with client-side routing the webapp downloads, processes and displays new data for you.
Imagine the user clicking on a simple link:  <a href="/hello">Hello!</a>
On a webapp that uses server side routing:
The browser detects that the user has clicked on an anchor element.
It makes an HTTP GET request to the URL found in the href tag
The server processes the request, and sends a new document (usually HTML) as a response.
The browser discards the old webpage altogether, and displays the newly downloaded one.
If the webapp uses client side routing:
The browser detects that the user has clicked on an anchor element, just like before.
A client side code (usually the routing library) catches this event, detects that the URL is not an external link, and then prevents the browser from making the HTTP GET request.
The routing library then manually changes the URL displayed in the browser (using the HTML5 history API, or maybe URL hashbangs on older browsers)
The routing library then changes the state of the client app. For example, it can change the root React/Angular/etc component according to the route rules.
The app (particularly the MVC library, like React) then processes state changes. It renders the new components, and if necessary, it requests new data from the server. But this time the response isn't necessarily an entire webpage, it may also be "raw" data, in which case the client-side code turns it into HTML elements.
Client-side routing sound more complicated, because it is. But some libraries really make it easy these days.

There are several upsides of client-side routing: you download less data to display new content, you can reuse DOM elements, display loading notifications to user etc. However, webapps that generate the DOM on server side are much easier to crawl (by search engines), thereby making SEO optimization easier. Combining these two approaches is also possible, the excellent Flow Router SSR is a good example for that.
Endpoint is the URL where your service can be accessed by a client application. The same web service can have multiple endpoints, for example in order to make it available using different protocols.



References
https://www.youtube.com/watch?v=Ke7Tr4RgRTs&t=281s
https://stackoverflow.com/questions/1321122/what-is-an-interface-in-java
https://stackoverflow.com/questions/3295496/what-is-a-javabean-exactly
https://stackoverflow.com/questions/23975199/when-to-use-client-side-routing-or-server-side-routing

