## A starter program into J2EE and its various concepts.

#### The J2EE Stack
![The J2EE Stack](https://github.com/StillSomehowSane/javap1-beans-and-json/blob/main/images/J2EE.PNG)

### Business Layer: POJO vs Beans

**Example of a POJO**
``` java
public class TypicalPOJOPerson {

	public String name;
	
	private Integer id;

	public TypicalPOJOPerson(String name, Integer id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String name() {
		return name;
	}
	
	public Integer getIdentity() {
		return id;
	}
}
```

**Example of a Bean**
``` java
public class TypicalBeanPerson implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
```
##### Links
- https://www.baeldung.com/java-pojo-class  

- https://www.geeksforgeeks.org/pojo-vs-java-beans/

### Business Layer: The Maven Build System

**Example of a pom.xml**
``` xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" 
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  		xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.asint</groupId>
  <artifactId>javap1-beans</artifactId>
  <version>0.0.1-SNAPSHOT</version>

  <name>javap1-beans</name>
  <!-- FIXME change it to the project's website -->
  <url>http://www.example.com</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.7</maven.compiler.source>
    <maven.compiler.target>1.7</maven.compiler.target>
  </properties>

  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
    
    <dependency>
    	<groupId>com.fasterxml.jackson.core</groupId>
    	<artifactId>jackson-databind</artifactId>
    	<version>2.13.1</version>
    </dependency>
    
    <dependency>
	    <groupId>commons-beanutils</groupId>
	    <artifactId>commons-beanutils</artifactId>
	    <version>1.9.4</version>
	</dependency>
  </dependencies>

  <build>
    <pluginManagement>
	<!-- lock down plugins versions to avoid using Maven defaults (may be
	moved to parent pom) -->
      <plugins>
        <!-- clean lifecycle, see https://maven.apache.org/ref/current
		maven-core/lifecycles.html#clean_Lifecycle -->
        <plugin>
          <artifactId>maven-clean-plugin</artifactId>
          <version>3.1.0</version>
        </plugin>
        <!-- default lifecycle, jar packaging: see https://maven.apache.org
		ref/current/maven-core/default-bindings
		html#Plugin_bindings_for_jar_packaging -->
        <plugin>
          <artifactId>maven-resources-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.8.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>2.22.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-jar-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-install-plugin</artifactId>
          <version>2.5.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-deploy-plugin</artifactId>
          <version>2.8.2</version>
        </plugin>
        <!-- site lifecycle, see https://maven.apache.org/ref/current
		maven-core/lifecycles.html#site_Lifecycle -->
        <plugin>
          <artifactId>maven-site-plugin</artifactId>
          <version>3.7.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-project-info-reports-plugin</artifactId>
          <version>3.0.0</version>
        </plugin>
      </plugins>
    </pluginManagement>
  </build>
</project>
```

### Typical Maven Project Structure
We prefer to use the Maven Quickstart Archetype from 

**org.apache.maven.archetypes** **maven-archetype-quickstart**

![A Typical Maven Project Structure](https://github.com/StillSomehowSane/javap1-beans-and-json/blob/main/images/TypicalMaven.PNG)

The image shows a typical maven project structure with the following notable folders:
- src/main/java : Folder that contains all the Java Classes
- src/test/java : Folder that contains all the test Classes
- target        : Our build files are placed under the target folder
- pom.xml       : Main Project Configuration is placed in the pom.xml file

Further the JRE System Libraries and Maven Dependencies will have the source jar and .class files for all the dependencieds and libraries defined in pom.xml 

##### Links
- https://www.baeldung.com/maven
- https://mvnrepository.com/search?q=spring+boot

### Business Layer: Manipulating JSON using the Jackson Library

Pull Jackson-Databind in as a dependency in our pom.xml file

``` xml
<dependency>
  <groupId>com.fasterxml.jackson.core</groupId>
  <artifactId>jackson-databind</artifactId>
  <version>2.13.1</version>
</dependency>
```

Basic Usage of the Object Mapper

``` java
public class Animal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String name;
	
	private String breed;
	
	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
```

``` java
public class App {
	public static void main(String[] args) {

		Animal doggie = new Animal();

		doggie.setId(1);
		doggie.setName("Pupper");
		doggie.setBreed("Husky");
		doggie.setAge(2);

		ObjectMapper mapper = new ObjectMapper();

		try {
			String animalJsonified = mapper.writeValueAsString(doggie);

			System.out.println(animalJsonified);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
```

Creating a json array with Jackson

``` java
public class App 
{
    public static void main(String[] args)
    {
        
        Animal doggie = new Animal();
        
        doggie.setId(1);
        doggie.setName("Pupper");
        doggie.setBreed("Husky");
        doggie.setAge(2);
        
        Animal doggo = new Animal();
        
        doggo.setId(2);
        doggo.setName("Missy");
        doggo.setBreed("Golden Retriever");
        doggo.setAge(1);
        
        ObjectMapper mapper = new ObjectMapper();
        
        Animal[] animals = { doggie, doggo };
        
        try {
			String animalsJsonified = mapper.writeValueAsString(animals);
			
			System.out.println(animalsJsonified);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }
}
```