#!/bin/bash
cd /home/kavia/workspace/code-generation/smarthome-tv-dashboard-41063-41085/smarthometv_frontend
./gradlew lint
LINT_EXIT_CODE=$?
if [ $LINT_EXIT_CODE -ne 0 ]; then
   exit 1
fi

