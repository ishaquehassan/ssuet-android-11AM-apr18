### Deploy your containerized SpringBoot App to heroku

# Links
- Complete Guide : [Medium Article](https://medium.com/@urbanswati/deploying-spring-boot-restapi-using-docker-maven-heroku-and-accessing-it-using-your-custom-aa04798c0112)
- Heroku : [heroku.com](http://heroku.com)
- Heroku Command Line Tool : [Heroku CLI](https://devcenter.heroku.com/articles/heroku-cli#windows)
- Spring Boot Initializr : [start.spring.io](http://start.spring.io)
- Docker HUB : [hub.docker.com](http://hub.docker.com)
- OpenJDK image that we'd used : [dock9/oraclejdk8:slim](https://hub.docker.com/r/dock9/oraclejdk8)
- Docker EBook (Docker Deep Dive) : [Google Drive](https://drive.google.com/file/d/1M1Es2xI1XfZfZCTq5Uh9Ya4DSaScvIhz/view?usp=sharing)

# Required Step for all Below Commands

Open cmd anywhere and run `heroku login` and provide your heroku account credentials.

# Create and Deploy Docker Containerized Spring App
- Since heroku assigns dynamic (not fixed) port to your application, so you have to add `server.port=${PORT}` in your `src/main/resources/application.properties` file to make your app work with heroku container registry.
- Open `cmd` or `terminal` in project root folder. Like this project root folder is **springBootApp**
- Run `mvnw package` to create ``jar`` file of your app
- Now point your `cmd` to target folder of your app by running `cd target`
- Create `Dockerfile` like below
```Dockerfile
#First we need to use alpine's JDK image as out base image
FROM dock9/oraclejdk8:slim

#Now we have to create a directory in our container so our app can be copied inside it
RUN mkdir /myApp

#Now we are setting our working directory to newly created /app folder which will execute all future commands inside that directory
WORKDIR /myApp

#Now we need to add our jar file to container.  demo-0.0.1-SNAPSHOT.jar is the jar file name in our target folder and app.jar is the new file name which will be copied inside /app folder. Note the space between
ADD demo-0.0.1-SNAPSHOT.jar app.jar

#Now finally we need to run our jar file using java runtime. Normally this command is written as java -jar app.jar but here we need to seperate each command with spaces like an array ["java","-jar","app.jar"] and CMD is used to run that command
CMD ["java","-jar","app.jar"]
```
- Now save your file as `Dockerfile` **(Without any Extension)** 
- Now Run `heroku create` then you will get a app name like `dry-cliffs-62493`
- Run `heroku container:login` to login to heroku container Registery.
- Now push it to heroku by running `heroku container:push web -a ` **`app-name`** (should be replaced with your **heroku app name**)
- Finally deploy it with `heroku container:release web -a ` **`app-name`** (should be replaced with your **heroku app name**)
- Now your open your app with `heroku open` or open the url as `https://app-name.herokuapp.com` and yes **`app-name`** should be replaced with your **heroku app name**


# Deploy Spring Boot Application to Heroku (Without Docker)

- Open `cmd` in project root folder. Like this project root folder is **springBootApp**
- Run `git init`
- Run `git add .`
- Run `git commit -m "My Deploy-able App"`
- Run `heroku create`
- Run `git push heroku master`
- Finally view your live app with `heroku open`