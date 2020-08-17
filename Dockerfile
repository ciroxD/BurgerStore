# --- DOC ----
#
# Modelo Dockerfile para utilizacao com container
#
# (conferir conexao com o banco antes do build)
# build da imagem:
# $ docker build -t ciroxd/tburguers:1.0.0 .

# Criando um database mysql local.
# $ docker run --name mysql -e MYSQL_ROOT_PASSWORD=12345 -e MYSQL_DATABASE=teste -d -p 13306:3306 mysql:5.7.10

# Criando o container com a api.
# $ docker run -d --name tburguers_api -e TZ=America/Sao_Paulo -v /var/data/:/var/data/ -p 8080:8080 --restart=always ciroxd/tburguers:1.0.0

# docker network create finch
# docker network connect finch tburguers_api
# docker network connect finch mysql 

# docker restart tburguers_api mysql

FROM maven:3.6.0-jdk-8-slim

LABEL version="1.0"
LABEL description="Tasty Burguers"
LABEL maintainer="Ciro Souza <ciro.eng@hotmail.com>"

RUN mkdir -p /var/tburguers
RUN chmod +x /var/tburguers

WORKDIR /var/tburguers

COPY ./ /var/tburguers

RUN ["mvn", "clean", "-Dmaven.test.skip=true", "install", "-X"]

EXPOSE 8080

ENTRYPOINT [ "mvn", "spring-boot:run", "-Dmaven.test.skip=true"]
#, "-Dspring.profiles.active=localhost", "-X" ]
# "-Dmaven.test.skip=true"



