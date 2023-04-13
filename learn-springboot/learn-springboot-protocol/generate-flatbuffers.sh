#!/usr/bin/env bash
echo "delete files : src/main/java/com/a3fun/learn/sb/protocol/*"
rm -fr src/main/java/com/a3fun/learn/sb/protocol/*
echo "generate protocol code from schema into java code, flatc version is:"
chmod +x flatc
./flatc --version
./flatc -o src/main/java src/main/resources/schema/*.fbs --java