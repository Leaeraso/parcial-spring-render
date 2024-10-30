Proyecto Java API Rest con Spring Boot, H2 y JPA, utilizando Clean Architecture(Repositorio, Servicio, Controlador) y JMeter para las pruebas de estres y rendimiento.

#Instrucciones:
Para poder probar la api, utilizar swagger: https://mutant-api.onrender.com/swagger-ui/index.html.

Endpoint para probar el adn de un mutante: POST /personas/api/v1/mutant/

adn-no-mutante: 
{
  "adn": ["ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG"]
}

adn-mutante:
{
  "adn": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]
}

Endpoint para obtener las estadisticas: GET /personas/api/v1/stats

Alumno: Leandro Eraso 50006

