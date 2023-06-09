REM Assicurati di avere Gradle e Docker installati sul tuo sistema
gradle -b build

REM Crea l'immagine Docker
docker build -t pawtropolis_db_image .

REM Crea un container Docker con il tuo database
docker run -d --name pawtropolis_db -p 5432:5432 pawtropolis_db_image

REM Controlla lo stato del container
docker ps