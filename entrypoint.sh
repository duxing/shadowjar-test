#!/bin/sh

set -ef

# command override. e.g. docker run -it <image> /bin/bash
cmd=${1:-}
if [ -z "$cmd" ]; then
  exec "$@"
fi

set -u

# launch the application
exec java -jar shadow-all.jar
