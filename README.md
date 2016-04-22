## To move the examples to a MySQL database

* Ensure MySQL process is running
* Ensure the existence of the database to be used
* Update the following properties on db.properties for Spring4-ORM-JPA-AOP-Annotations, or applicationContext.xml for Spring4-ORM-AOP. The useSSL in the url depends on how the service is configured. Not always needed
```
db.driver=com.mysql.cj.jdbc.Driver
db.url=jdbc:mysql://localhost/<databaseName>?useSSL=true
db.username=root
db.password=
hibernate.dialect=org.hibernate.dialect.MySQLDialect
```
* Update maven pom.xml, replacing the postgresql artifact by this one
```
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>6.0.2</version>
</dependency>
```
* Update Eclipse project by running, and do a Refresh on Eclipse right after
```
mvn eclipse:eclipse
```
* Run AppTest, by right-clicking on it -> Run as JUnit

## AOP Pointcuts expressions reference

### 1) Matching Method Signature Patterns

Matching all methods within a class in another package
```
execution(* com.howtodoinjava.EmployeeManager.*(..))
```

Matching all methods within a class within same package
```
execution(* EmployeeManager.*(..))
```

Matching all public methods in EmployeeManager
```
execution(public * EmployeeManager.*(..))
```

Matching all public methods in EmployeeManager with return type EmployeeDTO
```
execution(public EmployeeDTO EmployeeManager.*(..))
```

Matching all public methods in EmployeeManager with return type EmployeeDTO and first parameter as EmployeeDTO
```
execution(public EmployeeDTO EmployeeManager.*(EmployeeDTO, ..))
```

Matching all public methods in EmployeeManager with return type EmployeeDTO and definite parameters
```
execution(public EmployeeDTO EmployeeManager.*(EmployeeDTO, Integer))
```

### 2) Matching Type Signature Patterns

Matching all methods defined in classes inside package com.howtodoinjava
```
within(com.howtodoinjava.*)
```

Matching all methods defined in classes inside package com.howtodoinjava and classes inside all sub-packages as well
```
within(com.howtodoinjava..*)
```

Match all methods with a class in another package
```
within(com.howtodoinjava.EmployeeManagerImpl)
```

Match all methods with a class in same package
```
within(EmployeeManagerImpl)
```

Match all methods within all all implementing classes of EmployeeManager interface
```
within(EmployeeManagerImpl+)
```

### 3) Matching Bean Name Patterns

Match all methods defined in beans whose name ends with ‘Manager’.
```
bean(*Manager)
```

### 4) Combining Pointcut Expressions

Match all methods with names ending with Manager and DAO
```
bean(*Manager) || bean(*DAO)
```
