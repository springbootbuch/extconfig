# Demo that demonstrated various ways of external configuration

[![Build Status](https://travis-ci.org/springbootbuch/extconfig.svg?branch=master)](https://travis-ci.org/springbootbuch/extconfig)

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

Validation of configuration and failure analysis

```java -jar target/extconfig.jar --spring.profiles.active=invalid```

Overwrite property with env variable (notice the double underscores, `.` not supported in zsh)

```
$ export EXAMPLE_THE_GREETING=test
java -jar target/extconfig.jar
```