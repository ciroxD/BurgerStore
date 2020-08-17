# BurgerStore
# Utilizando a aplicação.
#
# Modelo Dockerfile para utilizacao com container
#
# #######################################################################################################
# build da imagem:
# $ docker build -t ciroxd/tburguers:1.0.0 .
#
# Criando um database mysql local.
# $ docker run --name mysql -e MYSQL_ROOT_PASSWORD=12345 -e MYSQL_DATABASE=teste -d -p 13306:3306 mysql:5.7.10
#
# Criando o container com a api.
# $ docker run -d --name tburguers_api -e TZ=America/Sao_Paulo -v /var/data/:/var/data/ -p 8080:8080 --restart=always ciroxd/tburguers:1.0.0
#
# docker network create finch
# docker network connect finch tburguers_api
# docker network connect finch mysql 
#
# docker restart tburguers_api mysql
##########################################################################################################
#
# Acesse localhost:8080/swagger-ui.html
#
# Verifique o seed inicial para ver as opções de usuário.
#
#
#     //users
#			User u1 = new User("name 01", "user01@finch", "name001","123");
#			User u2 = new User("name 02", "user02@finch", "name002","123");
#			User u3 = new User("name 03", "user03@finch", "name003","123");
#
# Para ativar a segurança, remova o "/v1/**" na linha 59 em WebSecurityConfig.java, ativando assim o JWT.
