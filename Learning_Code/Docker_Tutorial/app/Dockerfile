FROM node:13-alpine

#Specific Node Image
#Every Docker Image should be built as own Docker File.

ENV MONGO_DB_USERNAME=admin \
    MONGO_DB_PwD=password

RUN mkdir -p /home/app

#Copy command, executes on the host.
#soruce and target.
#you are copying everything from Host to Container
#To copy the code and everything needed to run a Dockerfile
COPY . /home/app

CMD ["node", "/home/app/server.js"]