## Semainier

A weekly planner application that allows students work to be referenced by day of the week.

## Setup

To run this project, you need to do the following

### Prerequisites

> Windows
- Install Xampp and setup a Web Server with Apache & MySQL
  - Set HTTP port to default (required for MySQL)  
  - Set MySQL port to default
  - Add the default database `semainierdb` with default parameters
    - Don't forget to change your local database name in the `application-dev.properties` file if you changed it
  - Run the application for the first time to create tables 
    - **For production only** : if `tblLocalite` is not filled automatically then you have to manually import the datas in `src/main/resources/commune.csv`

## Usage

Open your favorite browser [Must not be IE] and go to [localhost:8888](http://localhost:8888)

The Back-end (database) is available at [localhost/phpmyadmin](http://localhost/phpmyadmin)

## Authors

- [Heyimlulu](https://github.com/Heyimlulu)
- [NoizeKiller](https://github.com/NoizeKiller)

## Contributing

None as it is a personal project

## License

None (Copyright)
