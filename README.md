## Semainier

![](https://img.shields.io/badge/Apache%20Maven%3A%20Build-passing-success?logo=github) ![](https://img.shields.io/badge/Spring%20Boot%20Back--End%3A%20Build%20--%20Test%20--%20Deploy-passing-success?logo=github) ![](https://img.shields.io/badge/Bootstrap%20Frond--End%3A%20Deploy-passing-success?logo=github)

A weekly planner application that allows students work to be referenced by day of the week.

## Setup

To run this project, you need to do the following

### Prerequisites

- Install Xampp and setup a Web Server with Apache & MySQL
  - Set HTTP port to default (required for MySQL)  
  - Set MySQL port to default
  - Add the default database `semainierdb` with default parameters
    - Don't forget to change your local database name in the `application-dev.properties` file if you changed it
  - Run the application for the first time to create tables 
    - **For production only** : if `tblLocalite` is not filled automatically then you have to manually import the datas in `src/main/resources/commune.csv`

## Database

In the `./src/main/resources/application-dev.properties` files, look for theses lines

```
server.port=8888

spring.datasource.url=jdbc:mysql://localhost:3306/semainierdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowLoadLocalInfile=true
spring.datasource.username=root
spring.datasource.password=
```

- `datasource.url` is the database URL connection
- `datasource.username` is your database user (default is root)
- `datasource.password` is your database password (default is none)
- `server.port` default set is 8888, but you can change that


## Usage

Open your favorite browser [Must not be IE] and go to [localhost:8888](http://localhost:8888)

The Back-end (database) is available at [localhost/phpmyadmin](http://localhost/phpmyadmin)

The public instances hosted on Heroku is also available
- Front-End : https://semainier.herokuapp.com/
- Back-End : https://data.heroku.com/dataclips/hvnudbhcgztddgasidnrjlgpsvix

## Authors

- [Lucas](https://github.com/Heyimlulu) (Back-End)
- [Steve](https://github.com/NoizeKiller) (Front-End)

## Contributing

None as it is a personal project

## License

None (Copyright)
