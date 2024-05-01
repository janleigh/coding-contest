#!/bin/bash

# Clean app/build folder within the subdirectories from where this script is executed at.
find . -name "app" -type d -exec rm -rf {}/build \;