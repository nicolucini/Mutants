Para ejecucion local:
requisitos previos:
- JAVA 8
- Mongo DB local en puerto por default (27027)

Pasos para ejecucion:
- Descargar proyecto en https://github.com/nicolucini/Mutants.git
- abrir consola
- ir al directorio donde se encuentra el proyecto
- ejecutar  mvnw spring-boot:run


urls servicos:
http://localhost:8080/stats/
http://localhost:8080/mutant/


Ejecucion remota:
metodo post: http://ec2-3-142-90-235.us-east-2.compute.amazonaws.com/mutant/
metodo get: http://ec2-3-142-90-235.us-east-2.compute.amazonaws.com/stats/