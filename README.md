## A starter program into J2EE and its various concepts.

#### The J2EE Stack
![J2EE](https://github.com/StillSomehowSane/javap1-beans-and-json/blob/main/J2EE.PNG)

#### Business Layer: POJO vs Beans

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
