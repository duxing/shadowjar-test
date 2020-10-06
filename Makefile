.DEFAULT_GOAL := build

GRADLE := ./gradlew

.PHONY: build
build:
	$(GRADLE) clean shadowJar


.PHONY: run
run: build
	@docker-compose up --build



