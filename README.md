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
