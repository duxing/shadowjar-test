.DEFAULT_GOAL := gradle_build

GRADLE := docker run --rm -it -u root -v $(CUR_DIR):/app -w /app gradle:jdk8-alpine gradle

.PHONY: docker_gradle_build
docker_gradle_build:
	$(GRADLE) build

.PHONY: gradle_build
gradle_build:
	gradle build
