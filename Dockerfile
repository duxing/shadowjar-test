FROM openjdk:11.0.5-slim-buster

WORKDIR /app

COPY ./build/libs/shadow-all.jar entrypoint.sh ./

RUN chown -R nobody /app

USER nobody

ENTRYPOINT ["./entrypoint.sh"]
