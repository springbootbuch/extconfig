# Demo that demonstrated various ways of external configuration

## Examples

Merging of Java-Properties and YAML

```java -jar target/extconfig.jar --spring.profiles.active=merge```

Java-Properties and YAML compared

```java -jar target/extconfig.jar --spring.profiles.active=comparison-yml```

respectivly 

```java -jar target/extconfig.jar --spring.profiles.active=comparison-prop```

Multiprofile and priority

```java -jar target/extconfig.jar```

```java -jar target/extconfig.jar --spring.profiles.active=demo1```

```java -jar target/extconfig.jar --spring.profiles.active=demo2```

```java -jar target/extconfig.jar --spring.profiles.active=demo2,demo1```

```java -jar target/extconfig.jar --spring.profiles.active=demo1,demo2```