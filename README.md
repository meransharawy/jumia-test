# jumia-test

how to run backend -->
run commands below:
docker build --tag=jumia-backend:latest .
docker run -p8181:8181 jumia-backend:latest

how to run frontend -->
run commands below:
docker build --tag=jumia-frontend:latest .
docker run -p8888:80/tcp jumia-frontend:latest
