FROM postgres

LABEL author="Gianluca Evangelista, Paolo Labriola"
LABEL description="Container image for Pawtropolis application"
LABEL version="1.0.0"

ENV POSTGRES_USER root
ENV POSTGRES_PASSWORD rootpassword
ENV POSTGRES_DB pawtropolisDB

COPY src/main/resources/sql/init.sql /docker-entrypoint-initdb.d/
COPY src/main/resources/sql/insert.sql /docker-entrypoint-initdb.d/

EXPOSE 5432