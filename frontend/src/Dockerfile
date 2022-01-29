FROM openjdk:11
FROM node:16.13

COPY . front



RUN npm install -g npm@8.4.0 
RUN npm install -g @angular/cli 
RUN yarn install

CMD cd front & yarn run start
