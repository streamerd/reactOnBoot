## A snack custom search app with Spring Boot and React. 

Up and Running 
```
$ git clone git@github.com:streamerd/reactOnBoot.git
$ cd reactOnBoot
```
Backend
```
$ mvn clean install
$ mvn spring-boot:run
or 
$ java -jar target/reactOnBoot-0.0.1-SNAPSHOT.jar
```
```
Swagger Url:
http://localhost:8080/swagger-ui.html
```

Frontend
```
$ cd src/main/script
$ npm install 
$ npm start                          - - starts the server on http://localhost:3000 with React app.
```

We need to link the build folder in script folder to static in Boot's resources folder
```
$ ln -s ../resources/static ./build 
```

In order to have a build for production, stop the current React app on port 3000, then
```
$ npm run build 
```
then

```
$ npm install -g serve
```


API calls are made through App.js file.
At this point, I can suggest you to add React extension to your browser's Developer Tools menu.


### Used for up and running:

```
jdk >= 1.8.x
maven >= 3.x
node v6.14.2
npm 3.10.10
springBoot 2.0.4

a unix machine.
```


```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring Boot](https://spring.io/projects/spring-boot/) - Java Framework for Web
* [Application Server](https://docs.spring.io/spring-boot/docs/current/reference/html/howto-embedded-web-servers.html) - Embedded/Apache Tomcat


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
