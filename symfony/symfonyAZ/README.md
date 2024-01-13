# Symfony A-Z

Coding along the Youtube tutorial "Un projet de A à Z avec SYMFONY 5" by YoanDev.
[Watch here](https://www.youtube.com/watch?v=HViLTaLQ1AQ&list=PLxEJ5uJLOPDys4MgOz78lci7e7g5GoolQ)

## Usage

### Requirements

- PHP 8.0
- Composer
- Symfony CLI
- Docker
- Docker-compose
- Nodejs & npm

Check with
```bash
symfony check:requirements
```

### Start dev environment

```bash
docker-compose up -d
npm install
npm run build
symfony serve -d
```

### Add fixtures data
```bash
symfony console doctrine:fixtures:load
```

### Launch test
```bash
php bin/phpunit --testdox
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
