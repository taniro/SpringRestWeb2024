# Projeto base para aplicação no estilo arquitetural REST

## Criação de chaves que serão utilizadas para criação do token.

## create rsa key pair
openssl genrsa -out keypair.pem 2048

## extract public key
openssl rsa -in keypair.pem -pubout -out public.pem

## create private key in PKCS#8 format
openssl pkcs8 -topk8 -inform PEM -outform PEM -nocrypt -in keypair.pem -out private.pem


##Documentação da API
http://localhost:8080/swagger-ui/index.html#/
